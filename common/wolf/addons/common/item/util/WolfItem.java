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