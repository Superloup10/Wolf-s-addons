/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf_addons.common.item.kit.redstone;

import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

import wolf_addons.common.item.WolfItemList;

public class RedstoneHoe extends ItemHoe
{
	public RedstoneHoe(ToolMaterial material)
	{
		super(material);
	}

	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair)
	{
		if (repair.getItem().equals(WolfItemList.redstoneIngot))
		{
			return true;
		}
		return false;
	}
}
