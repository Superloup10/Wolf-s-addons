package wolf_addons.common.item.kit.emerald;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import wolf_addons.common.item.WolfItemList;

public class EmeraldSword extends ItemSword
{
	public EmeraldSword(ToolMaterial material)
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