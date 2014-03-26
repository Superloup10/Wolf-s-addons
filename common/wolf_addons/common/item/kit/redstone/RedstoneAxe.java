package wolf_addons.common.item.kit.redstone;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import wolf_addons.common.item.WolfItemList;

public class RedstoneAxe extends ItemAxe
{
	public RedstoneAxe(ToolMaterial material)
	{
		super(material);
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