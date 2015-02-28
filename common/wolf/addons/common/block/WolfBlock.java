/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wolf.addons.common.creativestabs.WolfCT;

public class WolfBlock extends Block
{
    private static String name;

    public WolfBlock(Material material, String name, float hardness, float resistance, SoundType soundType)
    {
        super(material);
        this.name = name;
        this.setUnlocalizedName(name);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setCreativeTab(WolfCT.creativeTabsBlocks);
        this.setStepSound(soundType);
        GameRegistry.registerBlock(this, name);
    }
}