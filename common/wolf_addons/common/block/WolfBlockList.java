package wolf_addons.common.block;

import net.minecraft.block.Block;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class WolfBlockList
{
	public static Block SPReedBooster;
	
	public static Block compressor;
	public static Block forge;
	
	public static Block silverOre;
	public static Block silverBlock;
	public static Block silverReedBlock;
	
	public static void loadBlock()
	{
		//Blocks normaux
		silverOre = new SilverOre().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockName("silverOre");
		silverBlock = new SilverBlock().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeMetal).setBlockTextureName("wolf_addons:silver_block").setBlockName("silverBlock");
		
		//Blocks avec tileEntity, container, gui, etc...
		compressor = new Compressor().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockTextureName("").setBlockName("compressor");
		forge = new Forge().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockTextureName("").setBlockName("forge");
		
		GameRegistry.registerBlock(silverOre, "silverOre");
		GameRegistry.registerBlock(silverBlock, "silverBlock");
		
		GameRegistry.registerBlock(compressor, "compressor");
		GameRegistry.registerBlock(forge, "forge");
	}
	
	public static void loadIntegration()
	{
		if(Loader.isModLoaded("sevenno_addons"))
		{
			try
			{
				silverReedBlock = new SilverReedBlock().setStepSound(Block.soundTypeGrass).setBlockName("silverReedBlock").setBlockTextureName("wolf_addons:silver_reed_block");
				SPReedBooster = (Block)Class.forName("sevenno_addons.common.block.SABlockList").getField("SPReedBooster").get(null);
				
				GameRegistry.registerBlock(silverReedBlock, "silverReedBlock");
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}