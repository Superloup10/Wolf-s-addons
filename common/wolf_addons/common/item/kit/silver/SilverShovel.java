package wolf_addons.common.item.kit.silver;

import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import wolf_addons.common.item.WolfItemList;

public class SilverShovel extends ItemSpade
{
	public SilverShovel(ToolMaterial material)
	{
		super(material);
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