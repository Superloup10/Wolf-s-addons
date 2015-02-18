/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import wolf.addons.common.block.WolfBlockList;
import wolf.addons.common.item.kit.emerald.EmeraldArmor;
import wolf.addons.common.item.kit.emerald.EmeraldAxe;
import wolf.addons.common.item.kit.emerald.EmeraldHoe;
import wolf.addons.common.item.kit.emerald.EmeraldPickaxe;
import wolf.addons.common.item.kit.emerald.EmeraldShovel;
import wolf.addons.common.item.kit.emerald.EmeraldSword;
import wolf.addons.common.item.kit.lapis.LapisArmor;
import wolf.addons.common.item.kit.lapis.LapisAxe;
import wolf.addons.common.item.kit.lapis.LapisHoe;
import wolf.addons.common.item.kit.lapis.LapisPickaxe;
import wolf.addons.common.item.kit.lapis.LapisShovel;
import wolf.addons.common.item.kit.lapis.LapisSword;
import wolf.addons.common.item.kit.redstone.RedstoneArmor;
import wolf.addons.common.item.kit.redstone.RedstoneAxe;
import wolf.addons.common.item.kit.redstone.RedstoneHoe;
import wolf.addons.common.item.kit.redstone.RedstonePickaxe;
import wolf.addons.common.item.kit.redstone.RedstoneShovel;
import wolf.addons.common.item.kit.redstone.RedstoneSword;
import wolf.addons.common.item.kit.silver.SilverArmor;
import wolf.addons.common.item.kit.silver.SilverAxe;
import wolf.addons.common.item.kit.silver.SilverHoe;
import wolf.addons.common.item.kit.silver.SilverPickaxe;
import wolf.addons.common.item.kit.silver.SilverShovel;
import wolf.addons.common.item.kit.silver.SilverSword;
import wolf.addons.common.item.util.WolfArmor;
import wolf.addons.common.item.util.WolfAxe;
import wolf.addons.common.item.util.WolfHoe;
import wolf.addons.common.item.util.WolfItem;
import wolf.addons.common.item.util.WolfPickaxe;
import wolf.addons.common.item.util.WolfShovel;
import wolf.addons.common.item.util.WolfSword;

public class WolfItemList
{
    // Intégration avec S.A.
    public static Item silverReed;

    public static WolfItem silverDust;
    public static WolfItem redstoneIngot, lapisIngot, emeraldIngot, silverIngot;

    public static Item woodHammer, stoneHammer, ironHammer, goldHammer, diamondHammer, silverHammer, redstoneHammer, lapisHammer, emeraldHammer;

    public static Item stoneBow, ironBow, goldBow, diamondBow, silverBow, redstoneBow, lapisBow, emeraldBow;

    public static WolfArmor silverHelmet, silverChestplate, silverLeggings, silverBoots;
    public static WolfArmor redstoneHelmet, redstoneChestplate, redstoneLeggings, redstoneBoots;
    public static WolfArmor lapisHelmet, lapisChestplate, lapisLeggings, lapisBoots;
    public static WolfArmor emeraldHelmet, emeraldChestplate, emeraldLeggings, emeraldBoots;

    public static WolfSword silverSword, redstoneSword, lapisSword, emeraldSword;
    public static WolfPickaxe silverPickaxe, redstonePickaxe, lapisPickaxe, emeraldPickaxe;
    public static WolfAxe silverAxe, redstoneAxe, lapisAxe, emeraldAxe;
    public static WolfShovel silverShovel, redstoneShovel, lapisShovel, emeraldShovel;
    public static WolfHoe silverHoe, redstoneHoe, lapisHoe, emeraldHoe;

    public static ArmorMaterial silverArmor = EnumHelper.addArmorMaterial("SilverArmor", "silver_armor", 35, new int[] {4, 9, 7, 4}, 15);
    public static ArmorMaterial redstoneArmor = EnumHelper.addArmorMaterial("RedstoneArmor", "redstone_armor", 33, new int[] {3, 8, 6, 3}, 25);
    public static ArmorMaterial lapisArmor = EnumHelper.addArmorMaterial("LapisArmor", "lapis_armor", 20, new int[] {2, 5, 3, 1}, 10);
    public static ArmorMaterial emeraldArmor = EnumHelper.addArmorMaterial("EmeraldArmor", "emerald_armor", 40, new int[] {4, 9, 7, 4}, 5);

    public static ToolMaterial silverTools = EnumHelper.addToolMaterial("SilverTools", 2, 1800, 16.0F, 4.0F, 15);
    public static ToolMaterial redstoneTools = EnumHelper.addToolMaterial("RedstoneTools", 3, 1600, 8.0F, 3.0F, 22);
    public static ToolMaterial lapisTools = EnumHelper.addToolMaterial("LapisTools", 2, 300, 12.0F, 0.0F, 10);
    public static ToolMaterial emeraldTools = EnumHelper.addToolMaterial("EmeraldTools", 4, 2000, 16.0F, 4.0F, 5);

    public static void loadItem()
    {
        silverDust = new SilverDust();

        woodHammer = new Hammer(59, "wood_hammer");
        stoneHammer = new Hammer(131, "stone_hammer");
        ironHammer = new Hammer(250, "iron_hammer");
        goldHammer = new Hammer(32, "gold_hammer");
        diamondHammer = new Hammer(1561, "diamond_hammer");
        silverHammer = new Hammer(1800, "silver_hammer");
        redstoneHammer = new Hammer(1600, "redstone_hammer");
        lapisHammer = new Hammer(300, "lapis_hammer");
        emeraldHammer = new Hammer(2000, "emerald_hammer");

        stoneBow = new Bow(484, "stone_bow");
        ironBow = new Bow(584, "iron_bow");
        goldBow = new Bow(684, "gold_bow");
        diamondBow = new Bow(784, "diamond_bow");
        silverBow = new Bow(884, "silver_bow");
        redstoneBow = new Bow(984, "redstone_bow");
        lapisBow = new Bow(1084, "lapis_bow");
        emeraldBow = new Bow(1184, "emerald_bow");

        silverIngot = new SilverIngot();
        redstoneIngot = new RedstoneIngot();
        lapisIngot = new LapisIngot();
        emeraldIngot = new EmeraldIngot();

        silverHelmet = new SilverArmor(0, "silver_helmet");
        silverChestplate = new SilverArmor(1, "silver_chestplate");
        silverLeggings = new SilverArmor(2, "silver_leggings");
        silverBoots = new SilverArmor(3, "silver_boots");

        redstoneHelmet = new RedstoneArmor(0, "redstone_helmet");
        redstoneChestplate = new RedstoneArmor(1, "redstone_chestplate");
        redstoneLeggings = new RedstoneArmor(2, "redstone_leggings");
        redstoneBoots = new RedstoneArmor(3, "redstone_boots");

        lapisHelmet = new LapisArmor(0, "lapis_helmet");
        lapisChestplate = new LapisArmor(1, "lapis_chestplate");
        lapisLeggings = new LapisArmor(2, "lapis_leggings");
        lapisBoots = new LapisArmor(3, "lapis_boots");

        emeraldHelmet = new EmeraldArmor(0, "emerald_helmet");
        emeraldChestplate = new EmeraldArmor(1, "emerald_chestplate");
        emeraldLeggings = new EmeraldArmor(2, "emerald_leggings");
        emeraldBoots = new EmeraldArmor(3, "emerald_boots");

        silverSword = new SilverSword();
        silverPickaxe = new SilverPickaxe();
        silverAxe = new SilverAxe();
        silverShovel = new SilverShovel();
        silverHoe = new SilverHoe();

        redstoneSword = new RedstoneSword();
        redstonePickaxe = new RedstonePickaxe();
        redstoneAxe = new RedstoneAxe();
        redstoneShovel = new RedstoneShovel();
        redstoneHoe = new RedstoneHoe();

        lapisSword = new LapisSword();
        lapisPickaxe = new LapisPickaxe();
        lapisAxe = new LapisAxe();
        lapisShovel = new LapisShovel();
        lapisHoe = new LapisHoe();

        emeraldSword = new EmeraldSword();
        emeraldPickaxe = new EmeraldPickaxe();
        emeraldAxe = new EmeraldAxe();
        emeraldShovel = new EmeraldShovel();
        emeraldHoe = new EmeraldHoe();

        OreDictionary.registerOre("silver_dust", silverDust);
        OreDictionary.registerOre("silver_ingot", silverIngot);
        OreDictionary.registerOre("redstone_ingot", redstoneIngot);
        OreDictionary.registerOre("lapis_ingot", lapisIngot);
        OreDictionary.registerOre("emerald_ingot", emeraldIngot);
    }

    public static void loadIntegration()
    {
        if(Loader.isModLoaded("sevenno_addons"))
        {
            silverReed = new SilverReed(WolfBlockList.silverReedBlock).setUnlocalizedName("silver_reed");
            GameRegistry.registerItem(silverReed, "silver_reed");
        }
    }
}