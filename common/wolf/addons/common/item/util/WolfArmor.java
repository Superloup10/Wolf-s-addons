/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.item.util;

import net.minecraft.item.ItemArmor;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wolf.addons.common.creativestabs.WolfCT;

public class WolfArmor extends ItemArmor
{
    private static String name;

    public WolfArmor(ArmorMaterial material, int renderIndex, int armorType, String name)
    {
        super(material, 0, armorType);
        this.name = name;
        this.setUnlocalizedName(name);
        this.setCreativeTab(WolfCT.creativeTabsArmors);
        GameRegistry.registerItem(this, name);
    }
}