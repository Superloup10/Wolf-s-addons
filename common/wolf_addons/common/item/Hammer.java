/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf_addons.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import wolf_addons.common.creativestabs.WolfCT;

public class Hammer extends Item
{
	private String texture;

	public Hammer(int damage, String textureName)
	{
		this.maxStackSize = 1;
		this.texture = textureName;
		this.setMaxDamage(damage);
		this.setCreativeTab(WolfCT.creativeTabsTools);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean isFull3D()
	{
		return true;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemStack)
	{
		return 72000;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack itemStack)
	{
		return EnumAction.block;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		itemIcon = register.registerIcon("wolf_addons:" + texture);
	}
}