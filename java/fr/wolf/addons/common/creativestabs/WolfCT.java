/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package fr.wolf.addons.common.creativestabs;

import net.minecraft.creativetab.CreativeTabs;

public class WolfCT
{
    public static CreativeTabs creativeTabsArmors, creativeTabsBlocks, creativeTabsTools, creativeTabsItems;

    public static void loadCreativeTabs()
    {
        creativeTabsArmors = new CreativeTabsArmors("wolf_armors");
        creativeTabsBlocks = new CreativeTabsBlock("wolf_blocks");
        creativeTabsTools = new CreativeTabsTools("wolf_tools");
        creativeTabsItems = new CreativeTabsItems("wolf_items");
    }
}