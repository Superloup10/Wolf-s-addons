package wolf_addons.common.item.kit.redstone;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import wolf_addons.common.item.WolfItemList;

public class RedstoneSword extends ItemSword
{
	public RedstoneSword(ToolMaterial material)
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