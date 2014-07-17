/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.achievements;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;

import net.minecraftforge.common.AchievementPage;

import wolf.addons.common.block.WolfBlockList;
import wolf.addons.common.item.WolfItemList;

public class WolfAchievements
{
	// Ore Dropped
	public static Achievement silverDust, redstoneDust, lapisDust, emeraldDust;

	// Blocks Crafted
	public static Achievement craftCompressor;

	// Ore Crafted
	public static Achievement silverIngot, redstoneIngot, lapisIngot, emeraldIngot;

	// Page
	public static AchievementPage wolfPage;

	public static void loadAchievements()
	{
		silverDust = new Achievement("achievement.silverDust", "silverDust", -5, 3, WolfItemList.silverDust, AchievementList.acquireIron).registerStat();
		redstoneDust = new Achievement("achievement.redstoneDust", "redstoneDust", -2, 3, Items.redstone, AchievementList.acquireIron).registerStat();
		lapisDust = new Achievement("achievement.lapisDust", "lapisDust", 2, 3, new ItemStack(Items.dye, 1, 4), AchievementList.acquireIron).registerStat();
		emeraldDust = new Achievement("achievement.emeraldDust", "emeraldDust", 5, 3, Items.emerald, AchievementList.acquireIron).registerStat();

		craftCompressor = new Achievement("achievement.craftCompressor", "craftCompressor", 0, 0, WolfBlockList.compressor, redstoneDust).setSpecial().registerStat();

		silverIngot = new Achievement("achievement.silverIngot", "silverIngot", -5, 6, WolfItemList.silverIngot, silverDust).registerStat();
		redstoneIngot = new Achievement("achievement.redstoneIngot", "redstoneIngot", -2, 6, WolfItemList.redstoneIngot, redstoneDust).registerStat();
		lapisIngot = new Achievement("achievement.lapisIngot", "lapisIngot", 2, 6, WolfItemList.lapisIngot, lapisDust).registerStat();
		emeraldIngot = new Achievement("achievement.emeraldIngot", "emeraldIngot", 5, 6, WolfItemList.emeraldIngot, emeraldDust).registerStat();
		wolfPage = new AchievementPage("Wolf's Addons", craftCompressor, silverDust, redstoneDust, lapisDust, emeraldDust, silverIngot, redstoneIngot, lapisIngot, emeraldIngot);
		AchievementPage.registerAchievementPage(wolfPage);
	}
}
