package wolf_addons.common.item.kit.lapis;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import wolf_addons.common.item.WolfItemList;

public class LapisPickaxe extends ItemPickaxe
{
	public LapisPickaxe(ToolMaterial material)
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