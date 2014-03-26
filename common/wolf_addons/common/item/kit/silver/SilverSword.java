package wolf_addons.common.item.kit.silver;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import wolf_addons.common.item.WolfItemList;

public class SilverSword extends ItemSword
{
	public SilverSword(ToolMaterial material)
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