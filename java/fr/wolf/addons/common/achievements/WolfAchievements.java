/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package fr.wolf.addons.common.achievements;

import fr.wolf.addons.common.block.WolfBlockList;
import fr.wolf.addons.common.item.WolfItemList;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

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
        silverDust = new Achievement("achievement.silverDust", "silverDust", -5, 3, WolfItemList.silverDust, AchievementList.acquireIron).registerAchievement();
        redstoneDust = new Achievement("achievement.redstoneDust", "redstoneDust", -2, 3, Items.redstone, AchievementList.acquireIron).registerAchievement();
        lapisDust = new Achievement("achievement.lapisDust", "lapisDust", 2, 3, new ItemStack(Items.dye, 1, 4), AchievementList.acquireIron).registerAchievement();
        emeraldDust = new Achievement("achievement.emeraldDust", "emeraldDust", 5, 3, Items.emerald, AchievementList.acquireIron).registerAchievement();

        craftCompressor = new Achievement("achievement.craftCompressor", "craftCompressor", 0, 0, WolfBlockList.compressor, redstoneDust).setSpecial().registerAchievement();

        silverIngot = new Achievement("achievement.silverIngot", "silverIngot", -5, 6, WolfItemList.silverIngot, silverDust).registerAchievement();
        redstoneIngot = new Achievement("achievement.redstoneIngot", "redstoneIngot", -2, 6, WolfItemList.redstoneIngot, redstoneDust).registerAchievement();
        lapisIngot = new Achievement("achievement.lapisIngot", "lapisIngot", 2, 6, WolfItemList.lapisIngot, lapisDust).registerAchievement();
        emeraldIngot = new Achievement("achievement.emeraldIngot", "emeraldIngot", 5, 6, WolfItemList.emeraldIngot, emeraldDust).registerAchievement();
        wolfPage = new AchievementPage("Wolf's Addons", craftCompressor, silverDust, redstoneDust, lapisDust, emeraldDust, silverIngot, redstoneIngot, lapisIngot, emeraldIngot);
        AchievementPage.registerAchievementPage(wolfPage);
    }
}