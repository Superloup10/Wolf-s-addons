package wolf.addons.common.block.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import wolf.addons.common.tileentity.TileEntityFurnace;

public class ContainerFurnace extends Container
{
    private final IInventory furnace;
    private int index2;
    private int index0;
    private int index1;
    private int index3;

    public ContainerFurnace(InventoryPlayer inventory, IInventory te)
    {
        this.furnace = te;
        this.addSlotToContainer(new Slot(te, 0, 56, 17));
        this.addSlotToContainer(new SlotFurnaceFuel(te, 1, 56, 53));
        this.addSlotToContainer(new SlotFurnaceOutput(inventory.player, te, 2, 116, 35));
        int i;

        for(i = 0; i < 3; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(i = 0; i < 9; i++)
        {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public void onCraftGuiOpened(ICrafting listener)
    {
        super.onCraftGuiOpened(listener);
        listener.func_175173_a(this, this.furnace);
    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for(int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting crafting = (ICrafting)this.crafters.get(i);

            if(this.index2 != this.furnace.getField(2))
            {
                crafting.sendProgressBarUpdate(this, 2, this.furnace.getField(2));
            }

            if(this.index0 != this.furnace.getField(0))
            {
                crafting.sendProgressBarUpdate(this, 0, this.furnace.getField(0));
            }

            if(this.index1 != this.furnace.getField(1))
            {
                crafting.sendProgressBarUpdate(this, 1, this.furnace.getField(1));
            }

            if(this.index3 != this.furnace.getField(3))
            {
                crafting.sendProgressBarUpdate(this, 3, this.furnace.getField(3));
            }
        }

        this.index2 = this.furnace.getField(2);
        this.index0 = this.furnace.getField(0);
        this.index1 = this.furnace.getField(1);
        this.index3 = this.furnace.getField(3);
    }

    @Override
    public void updateProgressBar(int id, int data)
    {
        this.furnace.setField(id, data);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return this.furnace.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if(slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if(index == 2)
            {
                if(!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if(index != 1 && index != 0)
            {
                if(FurnaceRecipes.instance().getSmeltingResult(itemstack1) != null)
                {
                    if(!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if(TileEntityFurnace.isItemFuel(itemstack1))
                {
                    if(!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if(index >= 3 && index < 30)
                {
                    if(!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if(index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if(!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if(itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if(itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
}