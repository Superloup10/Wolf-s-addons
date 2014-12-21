package wolf.addons.common.item.util;

import net.minecraft.item.ItemAxe;
import net.minecraftforge.fml.common.registry.GameRegistry;

import wolf.addons.common.creativestabs.WolfCT;

public class WolfAxe extends ItemAxe
{
    private static String name;

    public WolfAxe(String name, ToolMaterial material)
    {
        super(material);
        this.name = name;
        this.setUnlocalizedName(name);
        this.setCreativeTab(WolfCT.creativeTabsTools);
        GameRegistry.registerItem(this, name);
    }

    public static String getName()
    {
        return name;
    }
}