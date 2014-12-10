/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.block;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class WolfBlockList
{
    public static Block SPReedBooster;

    public static Block compressor;
    public static Block forge;

    public static WolfBlock silverOre;
    public static WolfBlock silverBlock;
    public static Block silverReedBlock;

    public static void loadBlock()
    {
        // Blocks normaux
        silverOre = new SilverOre();
        silverBlock = new SilverBlock();

        // Blocks avec tileEntity, container, gui, etc...
        compressor = new Compressor().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("compressor");
        forge = new Forge().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("forge");

        // GameRegistry.registerBlock(silverOre, "silver_ore");
        // GameRegistry.registerBlock(silverBlock, "silver_block");
        OreDictionary.registerOre("silver_ore", silverOre);
        OreDictionary.registerOre("silver_block", silverBlock);

        // GameRegistry.registerBlock(compressor, "compressor");
        // GameRegistry.registerBlock(forge, "forge");
    }

    public static void loadIntegration()
    {
        if(Loader.isModLoaded("sevenno_addons"))
        {
            try
            {
                silverReedBlock = new SilverReedBlock().setStepSound(Block.soundTypeGrass).setUnlocalizedName("silver_reed_block");
                SPReedBooster = (Block)Class.forName("sevenno_addons.common.block.SABlockList").getField("SPReedBooster").get(null);

                GameRegistry.registerBlock(silverReedBlock, "silver_reed_block");
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}