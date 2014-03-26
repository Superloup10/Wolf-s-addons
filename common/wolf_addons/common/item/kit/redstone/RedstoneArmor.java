package wolf_addons.common.item.kit.redstone;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import wolf_addons.common.creativestabs.WolfCT;
import wolf_addons.common.item.WolfItemList;

public class RedstoneArmor extends ItemArmor
{
	public RedstoneArmor(ArmorMaterial material, int type)
	{
		super(material, 0, type);
		this.setCreativeTab(WolfCT.creativeTabsArmors);
	}
	
	public String getArmorTextures(ItemStack itemStack, Entity entity, int slot, String layer)
	{
		if(slot == 2)
		{
			return "wolf_addons:textures/armor/redstone_layer_2.png";
		}
		return "wolf_addons:textures/armor/redstone_layer_1.png";
	}
	
	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair)
	{
		if(repair.getItem().equals(WolfItemList.redstoneIngot))
		{
			return true;
		}
		return false;
	}
}