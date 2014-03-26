package wolf_addons.common.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class WolfBlockList
{
	public static Block compressor;
	
	public static Block silverOre;
	
	public static void loadBlock()
	{
		silverOre = new SilverOre().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockTextureName("").setBlockName("silverOre");
		
		compressor = new Compressor().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockTextureName("").setBlockName("compressor");
		
		GameRegistry.registerBlock(silverOre, "silverOre");
		
		GameRegistry.registerBlock(compressor, "compressor");
	}
}