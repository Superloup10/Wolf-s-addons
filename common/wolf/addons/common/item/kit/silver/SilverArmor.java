/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.item.kit.silver;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import wolf.addons.common.creativestabs.WolfCT;
import wolf.addons.common.item.WolfItemList;

public class SilverArmor extends ItemArmor
{
	public SilverArmor(ArmorMaterial material, int type)
	{
		super(material, 0, type);
		this.setCreativeTab(WolfCT.creativeTabsArmors);
	}

	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type)
	{
		if (slot == 2)
		{
			return "wolf_addons:textures/models/armor/silver_layer_2.png";
		}
		return "wolf_addons:textures/models/armor/silver_layer_1.png";
	}

	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair)
	{
		if (repair.getItem().equals(WolfItemList.silverIngot))
		{
			return true;
		}
		return false;
	}
}
