package wolf_addons.common.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import wolf_addons.common.creativestabs.WolfCT;

public class LapisArmor extends ItemArmor
{
	public LapisArmor(ArmorMaterial material, int type)
	{
		super(material, 0, type);
		this.setCreativeTab(WolfCT.creativeTabsArmors);
	}
	
	public String getArmorTextures(ItemStack itemStack, Entity entity, int slot, String layer)
	{
		if(slot == 2)
		{
			return "wolf_addons:textures/armor/lapis_layer_2.png";
		}
		return "wolf_addons:textures/armor/lapis_layer_1.png";
	}
	
	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair)
	{
		if(repair.getItem().equals(WolfItemList.lapisIngot))
		{
			return true;
		}
		return false;
	}
}