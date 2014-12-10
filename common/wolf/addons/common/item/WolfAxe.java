package wolf.addons.common.item;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraftforge.fml.common.registry.GameRegistry;

import wolf.addons.common.creativestabs.WolfCT;

public class WolfAxe extends ItemAxe
{
    public WolfAxe(String name, ToolMaterial material)
    {
        super(material);
        this.setUnlocalizedName(name);
        this.setCreativeTab(WolfCT.creativeTabsTools);
        GameRegistry.registerItem(this, name);
    }
}