/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.creativestabs;

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