package wolf.addons.common.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import wolf.addons.common.creativestabs.WolfCT;

public class WolfItem extends Item
{
    public WolfItem(String name)
    {
        this.setUnlocalizedName(name);
        this.setCreativeTab(WolfCT.creativeTabsItems);
        GameRegistry.registerItem(this, name);
    }
}