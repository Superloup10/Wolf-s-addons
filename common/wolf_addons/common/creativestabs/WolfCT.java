package wolf_addons.common.creativestabs;

import net.minecraft.creativetab.CreativeTabs;

public class WolfCT
{
	public static CreativeTabs creativeTabsArmors;
	
	public static void loadCreativeTabs()
	{
		creativeTabsArmors = new CreativeTabsArmors("Armors");
	}
}