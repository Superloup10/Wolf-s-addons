package wolf.addons.common.item;

import net.minecraft.item.ItemArmor;

import wolf.addons.common.creativestabs.WolfCT;

public class WolfArmor extends ItemArmor
{
    public WolfArmor(/* ArmorMaterial material, */int renderIndex, int armorType, String name)
    {
        super(ArmorMaterial.IRON, 0, armorType);
        this.setUnlocalizedName(name);
        this.setCreativeTab(WolfCT.creativeTabsArmors);

        // TODO attendre le fix
        // GameRegistry.registerItem(this, name);
    }
}