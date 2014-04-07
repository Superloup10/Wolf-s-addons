package wolf_addons.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import wolf_addons.common.creativestabs.WolfCT;
import wolf_addons.common.item.WolfItemList;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SilverOre extends Block
{
	@SideOnly(Side.CLIENT)
	private IIcon[] textures = new IIcon[3];
	
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
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if(FMLClientHandler.instance().getWorldClient().provider.dimensionId == -1)
		{
			return this.textures[1];
		}
		else if(FMLClientHandler.instance().getWorldClient().provider.dimensionId == 1)
		{
			return this.textures[2];
		}
		else
		{
			return this.textures[0];
		}
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		textures[1] = register.registerIcon("wolf_addons:silver_ore_nether");
		textures[0] = register.registerIcon("wolf_addons:silver_ore_overworld");
		textures[2] = register.registerIcon("wolf_addons:silver_ore_end");
	}
}