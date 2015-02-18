package wolf.addons.common.item.util;

import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wolf.addons.common.creativestabs.WolfCT;

public class WolfPickaxe extends ItemPickaxe
{
    private static String name;

    public WolfPickaxe(String name, ToolMaterial material)
    {
        super(material);
        this.name = name;
        this.setUnlocalizedName(name);
        this.setCreativeTab(WolfCT.creativeTabsTools);
        GameRegistry.registerItem(this, name);
    }
}