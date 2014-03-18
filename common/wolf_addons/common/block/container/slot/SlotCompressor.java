package wolf_addons.common.block.container.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import cpw.mods.fml.common.FMLCommonHandler;

public class SlotCompressor extends Slot
{
	private final IInventory craftMatrix;
	
	private EntityPlayer thePlayer;
	
	private int amountCrafted;
	
	public SlotCompressor(EntityPlayer player, IInventory inventory, IInventory inventory2, int id, int x, int y)
	{
		super(inventory2, id, x, y);
		this.thePlayer = player;
		this.craftMatrix = inventory;
	}
	
	@Override
	public boolean isItemValid(ItemStack par1ItemStack)
    {
        return false;
    }
	
	@Override
	public ItemStack decrStackSize(int slot)
    {
        if (this.getHasStack())
        {
            this.amountCrafted += Math.min(slot, this.getStack().stackSize);
        }
        return super.decrStackSize(slot);
    }
	
	@Override
	protected void onCrafting(ItemStack par1ItemStack, int par2)
    {
        this.amountCrafted += par2;
        this.onCrafting(par1ItemStack);
    }
	
	@Override
	protected void onCrafting(ItemStack par1ItemStack)
    {
        par1ItemStack.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.amountCrafted);
        this.amountCrafted = 0;
    }

	@Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack par2ItemStack)
    {
        FMLCommonHandler.instance().firePlayerCraftingEvent(player, par2ItemStack, craftMatrix);
        this.onCrafting(par2ItemStack);

        for (int i = 0; i < this.craftMatrix.getSizeInventory(); ++i)
        {
            ItemStack itemstack1 = this.craftMatrix.getStackInSlot(i);

            if (itemstack1 != null)
            {
                this.craftMatrix.decrStackSize(i, 1);

                if (itemstack1.getItem().hasContainerItem(itemstack1))
                {
                    ItemStack itemstack2 = itemstack1.getItem().getContainerItem(itemstack1);

                    if (itemstack2 != null && itemstack2.isItemStackDamageable() && itemstack2.getItemDamage() > itemstack2.getMaxDamage())
                    {
                        MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(thePlayer, itemstack2));
                        continue;
                    }

                    if (!itemstack1.getItem().doesContainerItemLeaveCraftingGrid(itemstack1) || !this.thePlayer.inventory.addItemStackToInventory(itemstack2))
                    {
                        if (this.craftMatrix.getStackInSlot(i) == null)
                        {
                            this.craftMatrix.setInventorySlotContents(i, itemstack2);
                        }
                        else
                        {
                            this.thePlayer.dropPlayerItemWithRandomChoice(itemstack2, false);
                        }
                    }
                }
            }
        }
    }
}