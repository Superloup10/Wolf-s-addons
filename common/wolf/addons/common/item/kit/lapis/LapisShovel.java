/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.item.kit.lapis;

import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

import wolf.addons.common.item.WolfItemList;

public class LapisShovel extends ItemSpade
{
	public LapisShovel(ToolMaterial material)
	{
		super(material);
	}

	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair)
	{
		if (repair.getItem().equals(WolfItemList.lapisIngot))
		{
			return true;
		}
		return false;
	}
}
