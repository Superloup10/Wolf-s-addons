package wolf_addons.common.creativestabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class WolfCT
{
	public static CreativeTabs creativeTabsArmors, creativeTabsBlocks, creativeTabsTools, creativeTabsItems;
	
	public static void loadCreativeTabs()
	{
		creativeTabsArmors = new CreativeTabsArmors("Armors");
		creativeTabsBlocks = new CreativeTabsBlock("Blocks");
		creativeTabsTools = new CreativeTabsTools("Tools");
		creativeTabsItems = new CreativeTabsItems("Items");
	}
}