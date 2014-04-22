package wolf_addons.common.block;

import wolf_addons.common.creativestabs.WolfCT;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SilverBlock extends Block
{
	protected SilverBlock()
	{
		super(Material.iron);
		this.setCreativeTab(WolfCT.creativeTabsBlocks);
	}
}