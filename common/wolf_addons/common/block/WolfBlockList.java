package wolf_addons.common.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class WolfBlockList
{
	public static Block compressor;
	
	public static void loadBlock()
	{
		compressor = new Compressor().setBlockTextureName("").setBlockName("compressor");
		
		GameRegistry.registerBlock(compressor, "compressor");
	}
}