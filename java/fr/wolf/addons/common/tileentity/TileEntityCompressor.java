/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package fr.wolf.addons.common.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.common.util.Constants;

public class TileEntityCompressor extends TileEntity implements IInventory, ISidedInventory
{
    public InventoryCrafting craftMatrix = new LocalInventoryCrafting();
    public static final int SLOT_RESULT = 0;
    private ItemStack[] compressorInventory = new ItemStack[9];
    private InventoryCraftResult craftResult = new InventoryCraftResult();

    public class LocalInventoryCrafting extends InventoryCrafting
    {
        public LocalInventoryCrafting()
        {
            super(new Container()
            {
                @Override
                public boolean canInteractWith(EntityPlayer var1)
                {
                    return false;
                }
            }, 3, 3);
        }
    }

    private String customName;

    @Override
    public int getSizeInventory()
    {
        return this.compressorInventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return this.compressorInventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int maxStack)
    {
        if(this.compressorInventory[slot] != null)
        {
            ItemStack itemStack;
            if(this.compressorInventory[slot].stackSize <= maxStack)
            {
                itemStack = this.compressorInventory[slot];
                this.compressorInventory[slot] = null;
                this.markDirty();
                return itemStack;
            }
            else
            {
                itemStack = this.compressorInventory[slot].splitStack(maxStack);
                if(this.compressorInventory[slot].stackSize == 0)
                {
                    this.compressorInventory[slot] = null;
                }
                this.markDirty();
                return itemStack;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        if(this.compressorInventory[slot] != null)
        {
            ItemStack itemstack = this.compressorInventory[slot];
            this.compressorInventory[slot] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack)
    {
        this.compressorInventory[slot] = itemStack;

        if(itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
        {
            itemStack.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);

        NBTTagList nbtTag = nbtTagCompound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
        this.compressorInventory = new ItemStack[this.getSizeInventory()];

        if(nbtTagCompound.hasKey("CustomName"))
        {
            this.customName = nbtTagCompound.getString("CustomName");
        }

        for(int i = 0; i < nbtTag.tagCount(); i++)
        {
            NBTTagCompound tagCompound = nbtTag.getCompoundTagAt(i);
            int slot = tagCompound.getByte("Slot") & 255;

            if(slot >= 0 && slot < this.compressorInventory.length)
            {
                this.compressorInventory[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);

        NBTTagList nbtTag = new NBTTagList();

        for(int j = 0; j < this.compressorInventory.length; j++)
        {
            // ItemStack itemStack = this.compressorInventory[j];
            System.out.println("Taille de l'inventaire : " + Boolean.valueOf(compressorInventory[j] == null));
            // TODO Cette condition est toujours null
            if(this.compressorInventory[j] != null)
            {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte)j);
                this.compressorInventory[j].writeToNBT(tagCompound);
                nbtTag.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag("Items", nbtTag);

        if(this.hasCustomName())
        {
            nbtTagCompound.setString("CustomName", this.customName);
        }
    }

    /*
     * @Override public Packet getDescriptionPacket() { NBTTagCompound nbttagcompound = new NBTTagCompound(); this.writeToNBT(nbttagcompound); return new S35PacketUpdateTileEntity(this.pos, 3, nbttagcompound); }
     * @Override public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity updateTileEntity) { this.readFromNBT(updateTileEntity.func_148857_g()); }
     */

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq(this.pos) <= 64.0D;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack)
    {
        return false;
    }

    @Override
    public String getCommandSenderName()
    {
        return this.hasCustomName() ? this.customName : "container.compressor";
    }

    @Override
    public boolean hasCustomName()
    {
        return this.customName != null && this.customName.length() > 0;
    }

    @Override
    public IChatComponent getDisplayName()
    {
        return null;
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side)
    {
        return null;
    }

    @Override
    public boolean canInsertItem(int slotIn, ItemStack itemStackIn, EnumFacing direction)
    {
        return true;
    }

    @Override
    public boolean canExtractItem(int slotId, ItemStack stack, EnumFacing direction)
    {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer playerIn)
    {}

    @Override
    public void closeInventory(EntityPlayer playerIn)
    {}

    @Override
    public int getField(int id)
    {
        return 0;
    }

    @Override
    public void setField(int id, int value)
    {

    }

    @Override
    public int getFieldCount()
    {
        return 0;
    }

    @Override
    public void clear()
    {}
}