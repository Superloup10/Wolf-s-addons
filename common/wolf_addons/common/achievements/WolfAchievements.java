package wolf_addons.common.achievements;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import wolf_addons.common.block.WolfBlockList;
import wolf_addons.common.item.WolfItemList;

public class WolfAchievements
{
	//Ore Dropped
	public static Achievement silverDust, redstoneDust, lapisDust, emeraldDust;
	
	//Blocks Crafted
	public static Achievement craftCompressor;
	
	//Ore Crafted
	public static Achievement silverIngot, redstoneIngot, lapisIngot, emeraldIngot;
	
	//Page
	public static AchievementPage wolfPage;
	
	public static void loadAchievements()
	{
		silverDust = new Achievement("achievement.silverDust", "silverDust", 3, -3, WolfItemList.silverDust, (Achievement)null).registerStat();
		redstoneDust = new Achievement("achievement.redstoneDust", "redstoneDust", 6, -3, Items.redstone, (Achievement)null).registerStat();
		lapisDust = new Achievement("achievement.lapisDust", "lapisDust", 10, -3, new ItemStack(Items.dye, 1, 4), (Achievement)null).registerStat();
		emeraldDust = new Achievement("achievement.emeraldDust", "emeraldDust", 13, -3, Items.emerald, (Achievement)null).registerStat();

		craftCompressor = new Achievement("achievement.craftCompressor", "craftCompressor", 8, 0, WolfBlockList.compressor, (Achievement)null).initIndependentStat().setSpecial().registerStat();
		
		silverIngot = new Achievement("achievement.silverIngot", "silverIngot", 3, 3, WolfItemList.silverIngot, craftCompressor).registerStat();
		redstoneIngot = new Achievement("achievement.redstoneIngot", "redstoneIngot", 6, 3, WolfItemList.redstoneIngot, craftCompressor).registerStat();
		lapisIngot = new Achievement("achievement.lapisIngot", "lapisIngot", 10, 3, WolfItemList.lapisIngot, craftCompressor).registerStat();
		emeraldIngot = new Achievement("achievement.emeraldIngot", "emeraldIngot", 13, 3, WolfItemList.emeraldIngot, craftCompressor).registerStat();
		wolfPage = new AchievementPage("Wolf's Addons", craftCompressor, silverDust, redstoneDust, lapisDust, emeraldDust, silverIngot, redstoneIngot, lapisIngot, emeraldIngot);
		AchievementPage.registerAchievementPage(wolfPage);
	}
}