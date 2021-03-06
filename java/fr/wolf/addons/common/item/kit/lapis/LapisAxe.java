/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package fr.wolf.addons.common.item.kit.lapis;

import fr.wolf.addons.common.item.WolfItemList;
import fr.wolf.addons.common.item.util.WolfAxe;

import net.minecraft.item.ItemStack;

public class LapisAxe extends WolfAxe
{
    public LapisAxe()
    {
        super("lapis_axe", WolfItemList.lapisTools);
    }

    @Override
    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(repair.getItem().equals(WolfItemList.lapisIngot))
        {
            return true;
        }
        return false;
    }
}