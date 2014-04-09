package wolf_addons.common.item.kit.emerald;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import wolf_addons.common.creativestabs.WolfCT;
import wolf_addons.common.item.WolfItemList;

public class EmeraldArmor extends ItemArmor
{
	public EmeraldArmor(ArmorMaterial material, int type)
	{
		super(material, 0, type);
		this.setCreativeTab(WolfCT.creativeTabsArmors);
	}

	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type)
	{
		if (slot == 2)
		{
			return "wolf_addons:textures/models/armor/emerald_layer_2.png";
		}
		return "wolf_addons:textures/models/armor/emerald_layer_1.png";
	}

	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair)
	{
		if (repair.getItem().equals(WolfItemList.emeraldIngot))
		{
			return true;
		}
		return false;
	}
}