/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.block.container.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCompressor extends Slot
{
	private EntityPlayer thePlayer;
	private int field_75228_b;

	public SlotCompressor(EntityPlayer player, IInventory iinventory, int slotIndex, int posX, int posY)
	{
		super(iinventory, slotIndex, posX, posY);
		this.thePlayer = player;
	}

	public boolean isItemValid(ItemStack par1ItemStack)
	{
		return false;
	}

	public ItemStack decrStackSize(int par1)
	{
		if (this.getHasStack())
		{
			this.field_75228_b += Math.min(par1, this.getStack().stackSize);
		}

		return super.decrStackSize(par1);
	}

	public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack)
	{
		this.onCrafting(par2ItemStack);
		super.onPickupFromSlot(par1EntityPlayer, par2ItemStack);
	}

	protected void onCrafting(ItemStack par1ItemStack, int par2)
	{
		this.field_75228_b += par2;
		this.onCrafting(par1ItemStack);
	}

	protected void onCrafting(ItemStack par1ItemStack)
	{
		par1ItemStack.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.field_75228_b);
	}
}
