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

    public static String getName()
    {
        return name;
    }
}