package wolf_addons.common.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class WolfBlockList
{
	public static Block compressor;
	public static Block forge;
	public static Block generator;
	
	public static Block silverOre;
	
	public static void loadBlock()
	{
		//Blocks normaux
		silverOre = new SilverOre().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockTextureName("").setBlockName("silverOre");
		
		//Blocks avec tileEntity, container, gui, etc...
		compressor = new Compressor().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockTextureName("").setBlockName("compressor");
		forge = new Forge().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockTextureName("").setBlockName("forge");
		//generator = new Generator().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockTextureName("").setBlockName("generator");
		
		GameRegistry.registerBlock(silverOre, "silverOre");
		
		GameRegistry.registerBlock(compressor, "compressor");
		GameRegistry.registerBlock(forge, "forge");
		//GameRegistry.registerBlock(generator, "generator");
	}
}