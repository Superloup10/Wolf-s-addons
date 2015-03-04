/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.item.kit.emerald;

import net.minecraft.item.ItemStack;
import wolf.addons.common.item.WolfItemList;
import wolf.addons.common.item.util.WolfPickaxe;

public class EmeraldPickaxe extends WolfPickaxe
{
    public EmeraldPickaxe()
    {
        super("emerald_pickaxe", WolfItemList.emeraldTools);
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