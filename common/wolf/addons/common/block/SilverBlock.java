/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import wolf.addons.common.creativestabs.WolfCT;

public class SilverBlock extends Block
{
	protected SilverBlock()
	{
		super(Material.iron);
		this.setCreativeTab(WolfCT.creativeTabsBlocks);
	}
}
