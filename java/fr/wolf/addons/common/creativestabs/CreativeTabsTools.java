/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package fr.wolf.addons.common.creativestabs;

import fr.wolf.addons.common.item.WolfItemList;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsTools extends CreativeTabs
{
    public CreativeTabsTools(String lable)
    {
        super(lable);
    }

    @Override
    public Item getTabIconItem()
    {
        return WolfItemList.redstonePickaxe;
    }
}