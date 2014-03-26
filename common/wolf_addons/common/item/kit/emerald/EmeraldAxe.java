package wolf_addons.common.item.kit.emerald;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import wolf_addons.common.item.WolfItemList;

public class EmeraldAxe extends ItemAxe
{
	public EmeraldAxe(ToolMaterial material)
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