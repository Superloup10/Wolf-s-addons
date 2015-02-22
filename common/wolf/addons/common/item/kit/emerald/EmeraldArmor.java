/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.item.kit.emerald;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

import wolf.addons.common.item.WolfItemList;
import wolf.addons.common.item.util.WolfArmor;

public class EmeraldArmor extends WolfArmor
{
    public EmeraldArmor(int type, String name)
    {
        super(WolfItemList.emeraldArmor, 0, type, name);
    }

    @Override
    public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type)
    {
        if(slot == 2)
        {
            return "wolf_addons:textures/models/armor/emerald_layer_2.png";
        }
        return "wolf_addons:textures/models/armor/emerald_layer_1.png";
    }

    @Override
    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(repair.getItem().equals(WolfItemList.emeraldIngot))
        {
            return true;
        }
        return false;
    }
}