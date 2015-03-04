/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package fr.wolf.addons.common.item.kit.lapis;

import fr.wolf.addons.common.Wolf_Addons;
import fr.wolf.addons.common.item.WolfItemList;
import fr.wolf.addons.common.item.util.WolfArmor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class LapisArmor extends WolfArmor
{
    public LapisArmor(int type, String name)
    {
        super(WolfItemList.lapisArmor, 0, type, name);
    }

    @Override
    public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type)
    {
        if(slot == 2)
        {
            return Wolf_Addons.MODID + ":textures/models/armor/lapis_layer_2.png";
        }
        return Wolf_Addons.MODID + ":textures/models/armor/lapis_layer_1.png";
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