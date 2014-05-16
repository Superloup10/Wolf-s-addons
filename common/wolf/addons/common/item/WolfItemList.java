/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

import wolf.addons.common.block.WolfBlockList;
import wolf.addons.common.creativestabs.WolfCT;
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

public class WolfItemList
{
	// Intégration avec S.A.
	public static Item silverReed;

	public static Item silverDust;
	public static Item redstoneIngot, lapisIngot, emeraldIngot, silverIngot;

	public static Item woodHammer, stoneHammer, ironHammer, goldHammer, diamondHammer, silverHammer, redstoneHammer, lapisHammer, emeraldHammer;

	public static Item stoneBow, ironBow, goldBow, diamondBow, silverBow, redstoneBow, lapisBow, emeraldBow;

	public static Item silverHelmet, silverChestplate, silverLeggings, silverBoots;
	public static Item redstoneHelmet, redstoneChestplate, redstoneLeggings, redstoneBoots;
	public static Item lapisHelmet, lapisChestplate, lapisLeggings, lapisBoots;
	public static Item emeraldHelmet, emeraldChestplate, emeraldLeggings, emeraldBoots;

	public static Item silverSword, silverPickaxe, silverAxe, silverShovel, silverHoe;
	public static Item redstoneSword, redstonePickaxe, redstoneAxe, redstoneShovel, redstoneHoe;
	public static Item lapisSword, lapisPickaxe, lapisAxe, lapisShovel, lapisHoe;
	public static Item emeraldSword, emeraldPickaxe, emeraldAxe, emeraldShovel, emeraldHoe;

	public static ArmorMaterial silverArmor = EnumHelper.addArmorMaterial("SilverArmor", 35, new int[] {4, 9, 7, 4}, 15);
	public static ArmorMaterial redstoneArmor = EnumHelper.addArmorMaterial("RedstoneArmor", 33, new int[] {3, 8, 6, 3}, 25);
	public static ArmorMaterial lapisArmor = EnumHelper.addArmorMaterial("LapisArmor", 20, new int[] {2, 5, 3, 1}, 10);
	public static ArmorMaterial emeraldArmor = EnumHelper.addArmorMaterial("EmeraldArmor", 40, new int[] {4, 9, 7, 4}, 5);

	public static ToolMaterial silverTools = EnumHelper.addToolMaterial("SilverTools", 2, 1800, 16.0F, 4.0F, 15);
	public static ToolMaterial redstoneTools = EnumHelper.addToolMaterial("RedstoneTools", 3, 1600, 8.0F, 3.0F, 22);
	public static ToolMaterial lapisTools = EnumHelper.addToolMaterial("LapisTools", 2, 300, 12.0F, 0.0F, 10);
	public static ToolMaterial emeraldTools = EnumHelper.addToolMaterial("EmeraldTools", 4, 2000, 16.0F, 4.0F, 5);

	public static void loadItem()
	{
		silverDust = new SilverDust().setTextureName("wolf_addons:silver_dust").setUnlocalizedName("silverDust").setCreativeTab(WolfCT.creativeTabsItems);

		woodHammer = new Hammer(59, "wood_hammer").setUnlocalizedName("woodHammer");
		stoneHammer = new Hammer(131, "stone_hammer").setUnlocalizedName("stoneHammer");
		ironHammer = new Hammer(250, "iron_hammer").setUnlocalizedName("ironHammer");
		goldHammer = new Hammer(32, "gold_hammer").setUnlocalizedName("goldHammer");
		diamondHammer = new Hammer(1561, "diamond_hammer").setUnlocalizedName("diamondHammer");
		silverHammer = new Hammer(1800, "silver_hammer").setUnlocalizedName("silverHammer");
		redstoneHammer = new Hammer(1600, "redstone_hammer").setUnlocalizedName("redstoneHammer");
		lapisHammer = new Hammer(300, "lapis_hammer").setUnlocalizedName("lapisHammer");
		emeraldHammer = new Hammer(2000, "emerald_hammer").setUnlocalizedName("emeraldHammer");

		stoneBow = new Bow(484).setUnlocalizedName("stoneBow").setTextureName("wolf_addons:stone_bow");
		ironBow = new Bow(584).setUnlocalizedName("ironBow").setTextureName("wolf_addons:iron_bow");
		goldBow = new Bow(684).setUnlocalizedName("goldBow").setTextureName("wolf_addons:gold_bow");
		diamondBow = new Bow(784).setUnlocalizedName("diamondBow").setTextureName("wolf_addons:diamond_bow");
		silverBow = new Bow(884).setUnlocalizedName("silverBow").setTextureName("wolf_addons:silver_bow");
		redstoneBow = new Bow(984).setUnlocalizedName("redstoneBow").setTextureName("wolf_addons:redstone_bow");
		lapisBow = new Bow(1084).setUnlocalizedName("lapisBow").setTextureName("wolf_addons:lapis_bow");
		emeraldBow = new Bow(1184).setUnlocalizedName("emeraldBow").setTextureName("wolf_addons:emerald_bow");

		silverIngot = new SilverIngot().setTextureName("wolf_addons:silver_ingot").setUnlocalizedName("silverIngot").setCreativeTab(WolfCT.creativeTabsItems);
		redstoneIngot = new RedstoneIngot().setTextureName("wolf_addons:redstone_ingot").setUnlocalizedName("redstoneIngot").setCreativeTab(WolfCT.creativeTabsItems);
		lapisIngot = new LapisIngot().setTextureName("wolf_addons:lapis_ingot").setUnlocalizedName("lapisIngot").setCreativeTab(WolfCT.creativeTabsItems);
		emeraldIngot = new EmeraldIngot().setTextureName("wolf_addons:emerald_ingot").setUnlocalizedName("emeraldIngot").setCreativeTab(WolfCT.creativeTabsItems);

		silverHelmet = new SilverArmor(silverArmor, 0).setTextureName("wolf_addons:silver_helmet").setUnlocalizedName("silverHelmet");
		silverChestplate = new SilverArmor(silverArmor, 1).setTextureName("wolf_addons:silver_chestplate").setUnlocalizedName("silverChestplate");
		silverLeggings = new SilverArmor(silverArmor, 2).setTextureName("wolf_addons:silver_leggings").setUnlocalizedName("silverLeggings");
		silverBoots = new SilverArmor(silverArmor, 3).setTextureName("wolf_addons:silver_boots").setUnlocalizedName("silverBoots");

		redstoneHelmet = new RedstoneArmor(redstoneArmor, 0).setTextureName("wolf_addons:redstone_helmet_off").setUnlocalizedName("redstoneHelmet");
		redstoneChestplate = new RedstoneArmor(redstoneArmor, 1).setTextureName("wolf_addons:redstone_chestplate_off").setUnlocalizedName("redstoneChestplate");
		redstoneLeggings = new RedstoneArmor(redstoneArmor, 2).setTextureName("wolf_addons:redstone_leggings_off").setUnlocalizedName("redstoneLeggings");
		redstoneBoots = new RedstoneArmor(redstoneArmor, 3).setTextureName("wolf_addons:redstone_boots_off").setUnlocalizedName("redstoneBoots");

		lapisHelmet = new LapisArmor(lapisArmor, 0).setTextureName("wolf_addons:lapis_helmet").setUnlocalizedName("lapisHelmet");
		lapisChestplate = new LapisArmor(lapisArmor, 1).setTextureName("wolf_addons:lapis_chestplate").setUnlocalizedName("lapisChestplate");
		lapisLeggings = new LapisArmor(lapisArmor, 2).setTextureName("wolf_addons:lapis_leggings").setUnlocalizedName("lapisLeggings");
		lapisBoots = new LapisArmor(lapisArmor, 3).setTextureName("wolf_addons:lapis_boots").setUnlocalizedName("lapisBoots");

		emeraldHelmet = new EmeraldArmor(emeraldArmor, 0).setTextureName("wolf_addons:emerald_helmet").setUnlocalizedName("emeraldHelmet");
		emeraldChestplate = new EmeraldArmor(emeraldArmor, 1).setTextureName("wolf_addons:emerald_chestplate").setUnlocalizedName("emeraldChestplate");
		emeraldLeggings = new EmeraldArmor(emeraldArmor, 2).setTextureName("wolf_addons:emerald_leggings").setUnlocalizedName("emeraldLeggings");
		emeraldBoots = new EmeraldArmor(emeraldArmor, 3).setTextureName("wolf_addons:emerald_boots").setUnlocalizedName("emeraldBoots");

		silverSword = new SilverSword(silverTools).setTextureName("wolf_addons:silver_sword").setUnlocalizedName("silverSword").setCreativeTab(WolfCT.creativeTabsTools);
		silverPickaxe = new SilverPickaxe(silverTools).setTextureName("wolf_addons:silver_pickaxe").setUnlocalizedName("silverPickaxe").setCreativeTab(WolfCT.creativeTabsTools);
		silverAxe = new SilverAxe(silverTools).setTextureName("wolf_addons:silver_axe").setUnlocalizedName("silverAxe").setCreativeTab(WolfCT.creativeTabsTools);
		silverShovel = new SilverShovel(silverTools).setTextureName("wolf_addons:silver_shovel").setUnlocalizedName("silverShovel").setCreativeTab(WolfCT.creativeTabsTools);
		silverHoe = new SilverHoe(silverTools).setTextureName("wolf_addons:silver_hoe").setUnlocalizedName("silverHoe").setCreativeTab(WolfCT.creativeTabsTools);

		redstoneSword = new RedstoneSword(redstoneTools).setUnlocalizedName("redstoneSword").setCreativeTab(WolfCT.creativeTabsTools);
		redstonePickaxe = new RedstonePickaxe(redstoneTools).setTextureName("wolf_addons:redstone_pickaxe").setUnlocalizedName("redstonePickaxe").setCreativeTab(WolfCT.creativeTabsTools);
		redstoneAxe = new RedstoneAxe(redstoneTools).setTextureName("wolf_addons:redstone_axe").setUnlocalizedName("redstoneAxe").setCreativeTab(WolfCT.creativeTabsTools);
		redstoneShovel = new RedstoneShovel(redstoneTools).setTextureName("wolf_addons:redstone_shovel").setUnlocalizedName("redstoneShovel").setCreativeTab(WolfCT.creativeTabsTools);
		redstoneHoe = new RedstoneHoe(redstoneTools).setTextureName("wolf_addons:redstone_hoe").setUnlocalizedName("redstoneHoe").setCreativeTab(WolfCT.creativeTabsTools);

		lapisSword = new LapisSword(lapisTools).setTextureName("wolf_addons:lapis_sword").setUnlocalizedName("lapisSword").setCreativeTab(WolfCT.creativeTabsTools);
		lapisPickaxe = new LapisPickaxe(lapisTools).setTextureName("wolf_addons:lapis_pickaxe").setUnlocalizedName("lapisPickaxe").setCreativeTab(WolfCT.creativeTabsTools);
		lapisAxe = new LapisAxe(lapisTools).setTextureName("wolf_addons:lapis_axe").setUnlocalizedName("lapisAxe").setCreativeTab(WolfCT.creativeTabsTools);
		lapisShovel = new LapisShovel(lapisTools).setTextureName("wolf_addons:lapis_shovel").setUnlocalizedName("lapisShovel").setCreativeTab(WolfCT.creativeTabsTools);
		lapisHoe = new LapisHoe(lapisTools).setTextureName("wolf_addons:lapis_hoe").setUnlocalizedName("lapisHoe").setCreativeTab(WolfCT.creativeTabsTools);

		emeraldSword = new EmeraldSword(emeraldTools).setTextureName("wolf_addons:emerald_sword").setUnlocalizedName("emeraldSword").setCreativeTab(WolfCT.creativeTabsTools);
		emeraldPickaxe = new EmeraldPickaxe(emeraldTools).setTextureName("wolf_addons:emerald_pickaxe").setUnlocalizedName("emeraldPickaxe").setCreativeTab(WolfCT.creativeTabsTools);
		emeraldAxe = new EmeraldAxe(emeraldTools).setTextureName("wolf_addons:emerald_axe").setUnlocalizedName("emeraldAxe").setCreativeTab(WolfCT.creativeTabsTools);
		emeraldShovel = new EmeraldShovel(emeraldTools).setTextureName("wolf_addons:emerald_shovel").setUnlocalizedName("emeraldShovel").setCreativeTab(WolfCT.creativeTabsTools);
		emeraldHoe = new EmeraldHoe(emeraldTools).setTextureName("wolf_addons:emerald_hoe").setUnlocalizedName("emeraldHoe").setCreativeTab(WolfCT.creativeTabsTools);

		GameRegistry.registerItem(silverDust, "silverDust");
		OreDictionary.registerOre("silverDust", silverDust);
		/*
		 * GameRegistry.registerItem(woodHammer, "woodHammer");
		 * GameRegistry.registerItem(stoneHammer, "stoneHammer");
		 * GameRegistry.registerItem(ironHammer, "ironHammer");
		 * GameRegistry.registerItem(goldHammer, "goldHammer");
		 * GameRegistry.registerItem(diamondHammer, "diamondHammer");
		 * GameRegistry.registerItem(silverHammer, "silverHammer");
		 * GameRegistry.registerItem(redstoneHammer, "redstoneHammer");
		 * GameRegistry.registerItem(lapisHammer, "lapisHammer");
		 * GameRegistry.registerItem(emeraldHammer, "emeraldHammer");
		 */

		GameRegistry.registerItem(stoneBow, "stoneBow");
		GameRegistry.registerItem(ironBow, "ironBow");
		GameRegistry.registerItem(goldBow, "goldBow");
		GameRegistry.registerItem(diamondBow, "diamondBow");
		GameRegistry.registerItem(silverBow, "silverBow");
		GameRegistry.registerItem(redstoneBow, "redstoneBow");
		GameRegistry.registerItem(lapisBow, "lapisBow");
		GameRegistry.registerItem(emeraldBow, "emeraldBow");

		GameRegistry.registerItem(silverIngot, "silverIngot");
		GameRegistry.registerItem(redstoneIngot, "redstoneIngot");
		GameRegistry.registerItem(lapisIngot, "lapisIngot");
		GameRegistry.registerItem(emeraldIngot, "emeraldIngot");

		GameRegistry.registerItem(silverHelmet, "silverHelmet");
		GameRegistry.registerItem(silverChestplate, "silverChestplate");
		GameRegistry.registerItem(silverLeggings, "silverLeggings");
		GameRegistry.registerItem(silverBoots, "silverBoots");

		GameRegistry.registerItem(redstoneHelmet, "redstoneHelmet");
		GameRegistry.registerItem(redstoneChestplate, "redstoneChestplate");
		GameRegistry.registerItem(redstoneLeggings, "redstoneLeggings");
		GameRegistry.registerItem(redstoneBoots, "redstoneBoots");

		GameRegistry.registerItem(lapisHelmet, "lapisHelmet");
		GameRegistry.registerItem(lapisChestplate, "lapisChestplate");
		GameRegistry.registerItem(lapisLeggings, "lapisLeggings");
		GameRegistry.registerItem(lapisBoots, "lapisBoots");

		GameRegistry.registerItem(emeraldHelmet, "emeraldHelmet");
		GameRegistry.registerItem(emeraldChestplate, "emeraldChestplate");
		GameRegistry.registerItem(emeraldLeggings, "emeraldLeggings");
		GameRegistry.registerItem(emeraldBoots, "emeraldBoots");

		GameRegistry.registerItem(silverSword, "silverSword");
		GameRegistry.registerItem(silverPickaxe, "silverPickaxe");
		GameRegistry.registerItem(silverAxe, "silverAxe");
		GameRegistry.registerItem(silverShovel, "silverShovel");
		GameRegistry.registerItem(silverHoe, "silverHoe");

		GameRegistry.registerItem(redstoneSword, "redstoneSword");
		GameRegistry.registerItem(redstonePickaxe, "redstonePickaxe");
		GameRegistry.registerItem(redstoneAxe, "redstoneAxe");
		GameRegistry.registerItem(redstoneShovel, "redstoneShovel");
		GameRegistry.registerItem(redstoneHoe, "redstoneHoe");

		GameRegistry.registerItem(lapisSword, "lapisSword");
		GameRegistry.registerItem(lapisPickaxe, "lapisPickaxe");
		GameRegistry.registerItem(lapisAxe, "lapisAxe");
		GameRegistry.registerItem(lapisShovel, "lapisShovel");
		GameRegistry.registerItem(lapisHoe, "lapisHoe");

		GameRegistry.registerItem(emeraldSword, "emeraldSword");
		GameRegistry.registerItem(emeraldPickaxe, "emeraldPickaxe");
		GameRegistry.registerItem(emeraldAxe, "emeraldAxe");
		GameRegistry.registerItem(emeraldShovel, "emeraldShovel");
		GameRegistry.registerItem(emeraldHoe, "emeraldHoe");
	}

	public static void loadIntegration()
	{
		if (Loader.isModLoaded("sevenno_addons"))
		{
			silverReed = new SilverReed(WolfBlockList.silverReedBlock).setUnlocalizedName("silverReed").setTextureName("wolf_addons:silver_reed");
			GameRegistry.registerItem(silverReed, "silverReed");
		}
	}
}