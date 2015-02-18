package wolf.addons.common.item.util;

import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wolf.addons.common.creativestabs.WolfCT;

public class WolfSword extends ItemSword
{
    private static String name;

    public WolfSword(String name, ToolMaterial material)
    {
        super(material);
        this.name = name;
        this.setUnlocalizedName(name);
        this.setCreativeTab(WolfCT.creativeTabsTools);
        GameRegistry.registerItem(this, name);
    }
}