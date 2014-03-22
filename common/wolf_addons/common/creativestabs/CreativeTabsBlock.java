package wolf_addons.common.creativestabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import wolf_addons.common.block.WolfBlockList;

public class CreativeTabsBlock extends CreativeTabs
{
	public CreativeTabsBlock(String lable)
	{
		super(lable);
	}

	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(WolfBlockList.compressor);
	}
}