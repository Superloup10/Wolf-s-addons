package wolf_addons.common.item.kit.emerald;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import wolf_addons.common.item.WolfItemList;

public class EmeraldPickaxe extends ItemPickaxe
{
	public EmeraldPickaxe(ToolMaterial material)
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