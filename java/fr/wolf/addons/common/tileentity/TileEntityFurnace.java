/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package fr.wolf.addons.common.tileentity;

import fr.wolf.addons.common.Wolf_Addons;
import fr.wolf.addons.common.block.Furnace;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityFurnace extends TileEntityLockable implements ISidedInventory, IUpdatePlayerListBox
{
    private ItemStack[] furnaceItemStack = new ItemStack[3];
    private int totalCookTime;
    private int cookTime;
    private String furnaceCustomName;
    private int furnaceBurnTime;
    private int currentItemBurnTime;
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsSides = new int[] {1};

    @Override
    public int getSizeInventory()
    {
        return this.furnaceItemStack.length;
    }

    @Override
    public ItemStack getStackInSlot(int index)
    {
        return this.furnaceItemStack[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        if(this.furnaceItemStack[index] != null)
        {
            ItemStack itemStack;
            if(this.furnaceItemStack[index].stackSize <= count)
            {
                itemStack = this.furnaceItemStack[index];
                this.furnaceItemStack[index] = null;
                return itemStack;
            }
            else
            {
                itemStack = this.furnaceItemStack[index].splitStack(count);
                if(this.furnaceItemStack[index].stackSize == 0)
                {
                    this.furnaceItemStack[index] = null;
                }
                return itemStack;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index)
    {
        if(this.furnaceItemStack[index] != null)
        {
            ItemStack itemStack = this.furnaceItemStack[index];
            this.furnaceItemStack[index] = null;
            return itemStack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        boolean flag = stack != null && stack.isItemEqual(this.furnaceItemStack[index]) && ItemStack.areItemStackTagsEqual(stack, this.furnaceItemStack[index]);
        this.furnaceItemStack[index] = stack;

        if(stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }

        if(index == 0 && !flag)
        {
            this.totalCookTime = this.func_174904_a(stack);
            this.cookTime = 0;
            this.markDirty();
        }
    }

    @Override
    public String getCommandSenderName()
    {
        return this.hasCustomName() ? this.furnaceCustomName : "container.furnace";
    }

    @Override
    public boolean hasCustomName()
    {
        return this.furnaceCustomName != null && this.furnaceCustomName.length() > 0;
    }

    public void setCustomInventoryName(String name)
    {
        this.furnaceCustomName = name;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        NBTTagList nbtTagList = compound.getTagList("Items", 10);

        this.furnaceItemStack = new ItemStack[this.getSizeInventory()];

        for(int i = 0; i < nbtTagList.tagCount(); ++i)
        {
            NBTTagCompound compound2 = nbtTagList.getCompoundTagAt(i);
            byte b0 = compound2.getByte("Slot");

            if(b0 > 0 && b0 > this.furnaceItemStack.length)
            {
                this.furnaceItemStack[b0] = ItemStack.loadItemStackFromNBT(compound2);
            }
        }

        this.furnaceBurnTime = compound.getShort("BurnTime");
        this.cookTime = compound.getShort("CookTime");
        this.totalCookTime = compound.getShort("CookTimeTotal");
        this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStack[1]);

        if(compound.hasKey("CustomName", 8))
        {
            this.furnaceCustomName = compound.getString("CustomName");
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setShort("BurnTime", (short)this.furnaceBurnTime);
        compound.setShort("CookTime", (short)this.cookTime);
        compound.setShort("CookTimeTotal", (short)this.totalCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for(int i = 0; i < this.furnaceItemStack.length; ++i)
        {
            if(this.furnaceItemStack[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.furnaceItemStack[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        compound.setTag("Items", nbttaglist);

        if(this.hasCustomName())
        {
            compound.setString("CustomName", this.furnaceCustomName);
        }
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    public boolean isBurning()
    {
        return this.furnaceBurnTime > 0;
    }

    @SideOnly(Side.CLIENT)
    public static boolean isBurning(IInventory inventory)
    {
        return inventory.getField(0) > 0;
    }

    @Override
    public void update()
    {
        boolean flag = this.isBurning();
        boolean flag1 = false;

        if(this.isBurning())
        {
            --this.furnaceBurnTime;
        }

        if(!this.worldObj.isRemote)
        {
            if(!this.isBurning() && (this.furnaceItemStack[1] == null || this.furnaceItemStack[0] == null))
            {
                if(!this.isBurning() && this.cookTime > 0)
                {
                    this.cookTime = MathHelper.clamp_int(this.cookTime - 2, 0, this.totalCookTime);
                }
            }
            else
            {
                if(!this.isBurning() && this.canSmelt())
                {
                    this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStack[1]);

                    if(this.isBurning())
                    {
                        flag1 = true;

                        if(this.furnaceItemStack[1] != null)
                        {
                            --this.furnaceItemStack[1].stackSize;

                            if(this.furnaceItemStack[1].stackSize == 0)
                            {
                                this.furnaceItemStack[1] = furnaceItemStack[1].getItem().getContainerItem(furnaceItemStack[1]);
                            }
                        }
                    }
                }

                if(this.isBurning() && this.canSmelt())
                {
                    ++this.cookTime;

                    if(this.cookTime == this.totalCookTime)
                    {
                        this.cookTime = 0;
                        this.totalCookTime = this.func_174904_a(this.furnaceItemStack[0]);
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.cookTime = 0;
                }
            }

            if(flag != this.isBurning())
            {
                flag1 = true;
                Furnace.setState(this.isBurning(), this.worldObj, this.pos);
            }
        }

        if(flag1)
        {
            this.markDirty();
        }
    }

    public int func_174904_a(ItemStack p_174904_1_)
    {
        return 200;
    }

    private void smeltItem()
    {
        if(this.canSmelt())
        {
            ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.furnaceItemStack[0]);

            if(this.furnaceItemStack[2] == null)
            {
                this.furnaceItemStack[2] = itemstack.copy();
            }
            else if(this.furnaceItemStack[2].getItem() == itemstack.getItem())
            {
                this.furnaceItemStack[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            if(this.furnaceItemStack[0].getItem() == Item.getItemFromBlock(Blocks.sponge) && this.furnaceItemStack[0].getMetadata() == 1 && this.furnaceItemStack[1] != null && this.furnaceItemStack[1].getItem() == Items.bucket)
            {
                this.furnaceItemStack[1] = new ItemStack(Items.water_bucket);
            }

            --this.furnaceItemStack[0].stackSize;

            if(this.furnaceItemStack[0].stackSize <= 0)
            {
                this.furnaceItemStack[0] = null;
            }
        }
    }

    private boolean canSmelt()
    {
        if(this.furnaceItemStack[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.furnaceItemStack[0]);
            if(itemstack == null)
                return false;
            if(this.furnaceItemStack[2] == null)
                return true;
            if(!this.furnaceItemStack[2].isItemEqual(itemstack))
                return false;
            int result = furnaceItemStack[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.furnaceItemStack[2].getMaxStackSize(); // Forge BugFix: Make it respect stack sizes properly.
        }
    }

    public static int getItemBurnTime(ItemStack itemStack)
    {
        if(itemStack == null)
        {
            return 0;
        }
        else
        {
            Item item = itemStack.getItem();

            if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
            {
                Block block = Block.getBlockFromItem(item);

                if(block == Blocks.wooden_slab)
                {
                    return 150;
                }

                if(block.getMaterial() == Material.wood)
                {
                    return 300;
                }

                if(block == Blocks.coal_block)
                {
                    return 16000;
                }
            }

            if(item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD"))
                return 200;
            if(item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD"))
                return 200;
            if(item instanceof ItemHoe && ((ItemHoe)item).getMaterialName().equals("WOOD"))
                return 200;
            if(item == Items.stick)
                return 100;
            if(item == Items.coal)
                return 1600;
            if(item == Items.lava_bucket)
                return 20000;
            if(item == Item.getItemFromBlock(Blocks.sapling))
                return 100;
            if(item == Items.blaze_rod)
                return 2400;
            return GameRegistry.getFuelValue(itemStack);
        }
    }

    public static boolean isItemFuel(ItemStack p_145954_0_)
    {
        return getItemBurnTime(p_145954_0_) > 0;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory(EntityPlayer player)
    {}

    @Override
    public void closeInventory(EntityPlayer player)
    {}

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        return index == 2 ? false : (index != 1 ? true : isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack));
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side)
    {
        return side == EnumFacing.DOWN ? slotsBottom : (side == EnumFacing.UP ? slotsTop : slotsSides);
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
    {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
    {
        if(direction == EnumFacing.DOWN && index == 1)
        {
            Item item = stack.getItem();

            if(item != Items.water_bucket && item != Items.bucket)
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getGuiID()
    {
        return Wolf_Addons.MODID + ":furnace";
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new ContainerFurnace(playerInventory, this);
    }

    @Override
    public int getField(int id)
    {
        switch(id)
        {
        case 0:
            return this.furnaceBurnTime;
        case 1:
            return this.currentItemBurnTime;
        case 2:
            return this.cookTime;
        case 3:
            return this.totalCookTime;
        default:
            return 0;
        }
    }

    @Override
    public void setField(int id, int value)
    {
        switch(id)
        {
        case 0:
            this.furnaceBurnTime = value;
            break;
        case 1:
            this.currentItemBurnTime = value;
            break;
        case 2:
            this.cookTime = value;
            break;
        case 3:
            this.totalCookTime = value;
        }
    }

    @Override
    public int getFieldCount()
    {
        return 4;
    }

    @Override
    public void clear()
    {
        for(int i = 0; i < this.furnaceItemStack.length; ++i)
        {
            this.furnaceItemStack[i] = null;
        }
    }
}