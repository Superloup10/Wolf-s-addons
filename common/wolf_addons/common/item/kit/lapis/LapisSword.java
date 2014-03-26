package wolf_addons.common.item.kit.lapis;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import wolf_addons.common.item.WolfItemList;

public class LapisSword extends ItemSword
{
	public LapisSword(ToolMaterial material)
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