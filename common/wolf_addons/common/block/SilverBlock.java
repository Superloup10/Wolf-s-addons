/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf_addons.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import wolf_addons.common.creativestabs.WolfCT;

public class SilverBlock extends Block
{
	protected SilverBlock()
	{
		super(Material.iron);
		this.setCreativeTab(WolfCT.creativeTabsBlocks);
	}
}