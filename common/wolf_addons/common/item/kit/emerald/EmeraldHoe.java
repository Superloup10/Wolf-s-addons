package wolf_addons.common.item.kit.emerald;

import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import wolf_addons.common.item.WolfItemList;

public class EmeraldHoe extends ItemHoe
{
	public EmeraldHoe(ToolMaterial material)
	{
		super(material);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair)
	{
		if(repair.getItem().equals(WolfItemList.emeraldIngot))
		{
			return true;
		}
		return false;
	}
}