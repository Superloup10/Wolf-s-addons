package wolf_addons.common.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class WolfBlockList
{
	public static Block compressor;
	
	public static Block silverOre;
	
	public static void loadBlock()
	{
		silverOre = new SilverOre().setBlockTextureName("").setBlockName("silverOre");
		
		compressor = new Compressor().setBlockTextureName("").setBlockName("compressor");
		
		GameRegistry.registerBlock(silverOre, "silverOre");
		
		GameRegistry.registerBlock(compressor, "compressor");
	}
}