package wolf_addons.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import wolf_addons.common.creativestabs.WolfCT;
import wolf_addons.common.item.WolfItemList;

public class SilverOre extends Block
{
	protected SilverOre()
	{
		super(Material.rock);
		this.setHarvestLevel("pickaxe", 2);
		this.setCreativeTab(WolfCT.creativeTabsBlocks);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune)
	{
		return WolfItemList.silverDust;
		
	}
	
	@Override
	public int quantityDropped(Random rand)
	{
		return 1;
	}
}