package wolf.addons.common.item;

import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry;

import wolf.addons.common.creativestabs.WolfCT;

public class WolfSword extends ItemSword
{
    public WolfSword(String name, ToolMaterial material)
    {
        super(material);
        this.setUnlocalizedName(name);
        this.setCreativeTab(WolfCT.creativeTabsTools);
        GameRegistry.registerItem(this, name);
    }
}