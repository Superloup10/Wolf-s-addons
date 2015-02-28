/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.item.util;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wolf.addons.common.creativestabs.WolfCT;

public class WolfItem extends Item
{
    private static String name;

    public WolfItem(String name)
    {
        this.name = name;
        this.setUnlocalizedName(name);
        this.setCreativeTab(WolfCT.creativeTabsItems);
        GameRegistry.registerItem(this, name);
    }
}