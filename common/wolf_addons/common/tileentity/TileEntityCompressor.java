package wolf_addons.common.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCompressor extends TileEntity implements ISidedInventory
{
	private ItemStack[] compressorInventory = new ItemStack[10];
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
				return itemStack;
			}
			else
			{
				itemStack = this.compressorInventory[slot].splitStack(maxStack);
				if(this.compressorInventory[slot].stackSize == 0)
				{
					this.compressorInventory[slot] = null;
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
	public ItemStack getStackInSlotOnClosing(int slot)
	{
		if (this.compressorInventory[slot] != null)
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

		if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
		{
			itemStack.stackSize = this.getInventoryStackLimit();
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);
		
		NBTTagList nbtTag = nbtTagCompound.getTagList("Inventory", 10);
		this.compressorInventory = new ItemStack[this.getSizeInventory()];
		
		if(nbtTagCompound.hasKey("CustomName"))
		{
			this.customName = nbtTagCompound.getString("CustomName");
		}
		
		for(int i = 0; i < nbtTag.tagCount(); i++)
		{
			NBTTagCompound tagCompound = nbtTag.getCompoundTagAt(i);
			byte slot = tagCompound.getByte("Slot");
			
			if(slot >= 0 && slot < compressorInventory.length)
			{
				compressorInventory[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);
		
		NBTTagList nbtTag = new NBTTagList();
		
		for(int j = 0; j < compressorInventory.length; j++)
		{
			ItemStack itemStack = compressorInventory[j];
			
			if(itemStack != null)
			{
				NBTTagCompound tagCompound = new NBTTagCompound();
				tagCompound.setByte("Slot", (byte)j);
				itemStack.writeToNBT(tagCompound);
				nbtTag.appendTag(tagCompound);
			}
		}
		nbtTagCompound.setTag("Inventory", nbtTag);
		
		if(this.hasCustomInventoryName())
		{
			nbtTagCompound.setString("CustomName", this.customName);
		}
	}

	@Override
	public String getInventoryName()
	{
		return this.hasCustomInventoryName() ? this.customName : "container.compressor";
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		return this.customName != null && this.customName.length() > 0;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemStack)
	{
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side)
	{
		return null;
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack item, int side)
	{
		return false;
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack item, int side)
	{
		return false;
	}
}