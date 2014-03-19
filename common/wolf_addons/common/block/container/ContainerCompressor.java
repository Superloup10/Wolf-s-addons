package wolf_addons.common.block.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wolf_addons.common.block.container.slot.SlotCompressor;
import wolf_addons.common.recipe.RecipesCompressor;
import wolf_addons.common.tileentity.TileEntityCompressor;

public class ContainerCompressor extends Container
{
	private InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
	
	private InventoryCraftResult craftResult = new InventoryCraftResult();
	
	private TileEntityCompressor compressor;

	private World worldObj;
	
	public ContainerCompressor(InventoryPlayer inventory, TileEntityCompressor te)
	{
		compressor = te;
		this.addSlotToContainer(new SlotCompressor(inventory.player, this.craftMatrix, this.craftResult, 0, 124, 35));
		int l, i;
		
		for (l = 0; l < 3; ++l)
        {
            for (i = 0; i < 3; ++i)
            {
                this.addSlotToContainer(new Slot(this.craftMatrix, i + l * 3, 30 + i * 18, 17 + l * 18));
            }
        }

        for (l = 0; l < 3; ++l)
        {
            for (i = 0; i < 9; ++i)
            {
                this.addSlotToContainer(new Slot(inventory, i + l * 9 + 9, 8 + i * 18, 84 + l * 18));
            }
        }

        for (l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new Slot(inventory, l, 8 + l * 18, 142));
        }

        this.onCraftMatrixChanged(this.craftMatrix);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return compressor.isUseableByPlayer(player);
	}
	
	@Override
	public void onCraftMatrixChanged(IInventory par1IInventory)
    {
    	this.craftResult.setInventorySlotContents(0, RecipesCompressor.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    }
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotContainer)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotContainer);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotContainer == 0)
            {
                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (slotContainer >= 10 && slotContainer < 36)
            {
                if (!this.mergeItemStack(itemstack1, 37, 46, false))
                {
                    return null;
                }
            }
            else if (slotContainer >= 37 && slotContainer < 46)
            {
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }
            slot.onPickupFromSlot(player, itemstack1);
        }
        return itemstack;
    }
}