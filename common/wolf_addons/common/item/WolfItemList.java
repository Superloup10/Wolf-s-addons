package wolf_addons.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class WolfItemList
{
	public static Item redstoneIngot, lapisIngot, emeraldIngot;
	
	public static Item redstoneHelmet, redstoneChestplate, redstoneLeggings, redstoneBoots;
	public static Item lapisHelmet, lapisChestplate, lapisLeggings, lapisBoots;
	public static Item emeraldHelmet, emeraldChestplate, emeraldLeggings, emeraldBoots;
	
	public static Item redstoneSword, redstonePickaxe, redstoneAxe, redstoneShovel, redstoneHoe;
	public static Item lapisSword, lapisPickaxe, lapisAxe, lapisShovel, lapisHoe;
	public static Item emeraldSword, emeraldPickaxe, emeraldAxe, emeraldShovel, emeraldHoe;
	
	public static ArmorMaterial redstoneArmor = EnumHelper.addArmorMaterial("RedstoneArmor", 33, new int[]{3, 8, 6, 3}, 25);
	public static ArmorMaterial lapisArmor = EnumHelper.addArmorMaterial("LapisArmor", 20, new int[]{2, 5, 3, 1}, 10);
	public static ArmorMaterial emeraldArmor = EnumHelper.addArmorMaterial("EmeraldArmor", 40, new int[]{4, 9, 7, 4}, 5);
	public static ToolMaterial redstoneTools = EnumHelper.addToolMaterial("RedstoneTools", 3, 1600, 8.0F, 3.0F, 22);
	public static ToolMaterial lapisTools = EnumHelper.addToolMaterial("LapisTools", 2, 300, 12.0F, 0.0F, 10);
	public static ToolMaterial emeraldTools = EnumHelper.addToolMaterial("EmeraldTools", 4, 2000, 16.0F, 6.0F, 5);
	
	public static void loadItem()
	{
		redstoneIngot = new RedstoneIngot().setTextureName("wolf_addons:redstone_ingot").setUnlocalizedName("redstoneIngot");
		lapisIngot = new LapisIngot().setTextureName("wolf_addons:lapis_ingot").setUnlocalizedName("lapisIngot");
		emeraldIngot = new EmeraldIngot().setTextureName("wolf_addons:emerald_ingot").setUnlocalizedName("emeraldIngot");

		redstoneHelmet = new RedstoneArmor(redstoneArmor, 0).setTextureName("wolf_addons:redstone_helmet").setUnlocalizedName("redstoneHelmet");
		redstoneChestplate = new RedstoneArmor(redstoneArmor, 1).setTextureName("wolf_addons:redstone_chestplate").setUnlocalizedName("redstoneChestplate");
		redstoneLeggings = new RedstoneArmor(redstoneArmor, 2).setTextureName("wolf_addons:redstone_leggings").setUnlocalizedName("redstoneLeggings");
		redstoneBoots = new RedstoneArmor(redstoneArmor, 3).setTextureName("wolf_addons:redstone_boots").setUnlocalizedName("redstoneBoots");
		
		lapisHelmet = new LapisArmor(lapisArmor, 0).setTextureName("wolf_addons:lapis_helmet").setUnlocalizedName("lapisHelmet");
		lapisChestplate = new LapisArmor(lapisArmor, 1).setTextureName("wolf_addons:lapis_chestplate").setUnlocalizedName("lapisChestplate");
		lapisLeggings = new LapisArmor(lapisArmor, 2).setTextureName("wolf_addons:lapis_leggings").setUnlocalizedName("lapisLeggings");
		lapisBoots = new LapisArmor(lapisArmor, 3).setTextureName("wolf_addons:lapis_boots").setUnlocalizedName("lapisBoots");
		
		emeraldHelmet = new EmeraldArmor(emeraldArmor, 0).setTextureName("wolf_addons:emerald_helmet").setUnlocalizedName("emeraldHelmet");
		emeraldChestplate = new EmeraldArmor(emeraldArmor, 1).setTextureName("wolf_addons:emerald_chestplate").setUnlocalizedName("emeraldChestplate");
		emeraldLeggings = new EmeraldArmor(emeraldArmor, 2).setTextureName("wolf_addons:emerald_leggings").setUnlocalizedName("emeraldLeggings");
		emeraldBoots = new EmeraldArmor(emeraldArmor, 3).setTextureName("wolf_addons:emerald_boots").setUnlocalizedName("emeraldBoots");
		
		redstoneSword = new RedstoneSword(redstoneTools).setTextureName("wolf_addons:redstone_sword").setUnlocalizedName("redstoneSword");
		redstonePickaxe = new RedstonePickaxe(redstoneTools).setTextureName("wolf_addons:redstone_pickaxe").setUnlocalizedName("redstonePickaxe");
		redstoneAxe = new RedstoneAxe(redstoneTools).setTextureName("wolf_addons:redstone_axe").setUnlocalizedName("redstoneAxe");
		redstoneShovel = new RedstoneShovel(redstoneTools).setTextureName("wolf_addons:redstone_shovel").setUnlocalizedName("redstoneShovel");
		redstoneHoe = new RedstoneHoe(redstoneTools).setTextureName("wolf_addons:redstone_hoe").setUnlocalizedName("redstoneHoe");
		
		lapisSword = new LapisSword(lapisTools).setTextureName("wolf_addons:lapis_sword").setUnlocalizedName("lapisSword");
		lapisPickaxe = new LapisPickaxe(lapisTools).setTextureName("wolf_addons:lapis_pickaxe").setUnlocalizedName("lapisPickaxe");
		lapisAxe = new LapisAxe(lapisTools).setTextureName("wolf_addons:lapis_axe").setUnlocalizedName("lapisAxe");
		lapisShovel = new LapisShovel(lapisTools).setTextureName("wolf_addons:lapis_shovel").setUnlocalizedName("lapisShovel");
		lapisHoe = new LapisHoe(lapisTools).setTextureName("wolf_addons:lapis_hoe").setUnlocalizedName("lapisHoe");
		
		emeraldSword = new EmeraldSword(emeraldTools).setTextureName("wolf_addons:emerald_sword").setUnlocalizedName("emeraldSword");
		emeraldPickaxe = new EmeraldPickaxe(emeraldTools).setTextureName("wolf_addons:emerald_pickaxe").setUnlocalizedName("emeraldPickaxe");
		emeraldAxe = new EmeraldAxe(emeraldTools).setTextureName("wolf_addons:emerald_axe").setUnlocalizedName("emeraldAxe");
		emeraldShovel = new EmeraldShovel(emeraldTools).setTextureName("wolf_addons:emerald_shovel").setUnlocalizedName("emeraldShovel");
		emeraldHoe = new EmeraldHoe(emeraldTools).setTextureName("wolf_addons:emerald_hoe").setUnlocalizedName("emeraldHoe");
		
		GameRegistry.registerItem(redstoneIngot, "redstoneIngot");
		GameRegistry.registerItem(lapisIngot, "lapisIngot");
		GameRegistry.registerItem(emeraldIngot, "emeraldIngot");
		
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
}