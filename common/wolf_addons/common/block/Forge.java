package wolf_addons.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import wolf_addons.common.creativestabs.WolfCT;

public class Forge extends Block
{
	protected Forge()
	{
		super(Material.rock);
		this.setCreativeTab(WolfCT.creativeTabsBlocks);
	}
}