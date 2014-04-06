package wolf_addons.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import wolf_addons.common.creativestabs.WolfCT;
import wolf_addons.common.item.WolfItemList;

public class SilverOre extends Block
{
	private World world;
	
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
	
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		switch(world.provider.dimensionId)
		{
		case -1:blockIcon = register.registerIcon("wolf_addons:silver_ore_nether");
		case 0:blockIcon = register.registerIcon("wolf_addons:silver_ore_overworld");
		case 1:blockIcon = register.registerIcon("wolf_addons:silver_ore_end");
		}
	}
}