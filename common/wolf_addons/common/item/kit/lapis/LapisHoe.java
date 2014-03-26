package wolf_addons.common.item.kit.lapis;

import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import wolf_addons.common.item.WolfItemList;

public class LapisHoe extends ItemHoe
{
	public LapisHoe(ToolMaterial material)
	{
		super(material);
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