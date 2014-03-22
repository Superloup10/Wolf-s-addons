package wolf_addons.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import wolf_addons.common.creativestabs.WolfCT;

public class SilverOre extends Block
{
	protected SilverOre()
	{
		super(Material.rock);
		this.setHarvestLevel("pickaxe", 2);
		this.setCreativeTab(WolfCT.creativeTabsBlocks);
	}
}