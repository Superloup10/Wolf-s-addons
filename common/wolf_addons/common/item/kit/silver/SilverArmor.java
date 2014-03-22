package wolf_addons.common.item.kit.silver;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import wolf_addons.common.creativestabs.WolfCT;
import wolf_addons.common.item.WolfItemList;

public class SilverArmor extends ItemArmor
{
	public SilverArmor(ArmorMaterial material, int type)
	{
		super(material, 0, type);
		this.setCreativeTab(WolfCT.creativeTabsArmors);
	}
	
	public String getArmorTextures(ItemStack itemStack, Entity entity, int slot, String layer)
	{
		if(slot == 2)
		{
			return "wolf_addons:textures/armor/silver_layer_2.png";
		}
		return "wolf_addons:textures/armor/silver_layer_1.png";
	}
	
	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair)
	{
		if(repair.getItem().equals(WolfItemList.silverIngot))
		{
			return true;
		}
		return false;
	}
}