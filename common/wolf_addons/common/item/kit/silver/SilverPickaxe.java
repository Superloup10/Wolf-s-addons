package wolf_addons.common.item.kit.silver;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import wolf_addons.common.item.WolfItemList;

public class SilverPickaxe extends ItemPickaxe
{
	public SilverPickaxe(ToolMaterial material)
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