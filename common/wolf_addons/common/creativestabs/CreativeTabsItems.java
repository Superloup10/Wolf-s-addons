package wolf_addons.common.creativestabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import wolf_addons.common.item.WolfItemList;

public class CreativeTabsItems extends CreativeTabs
{
	public CreativeTabsItems(String lable)
	{
		super(lable);
	}

	@Override
	public Item getTabIconItem()
	{
		return WolfItemList.redstoneIngot;
	}
}