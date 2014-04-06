package wolf_addons.common.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import wolf_addons.common.block.WolfBlockList;
import wolf_addons.common.item.WolfItemList;
import cpw.mods.fml.common.registry.GameRegistry;

public class WolfRecipe
{
	public static void loadRecipe()
	{
		//TODO Possible changements
		GameRegistry.addRecipe(new ItemStack(WolfBlockList.compressor), new Object[]{"XXX", "YYY", "XZX", 'X', Blocks.stone, 'Y', Blocks.iron_block, 'Z', Blocks.redstone_block});
		//TODO RECIPES TEMP
		GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneHelmet, 1), new Object[]{"XXX", "X X", 'X', WolfItemList.redstoneIngot});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneChestplate, 1), new Object[]{"X X", "XXX", "XXX", 'X', WolfItemList.redstoneIngot});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneLeggings, 1), new Object[]{"XXX", "X X", "X X", 'X', WolfItemList.redstoneIngot});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneBoots, 1), new Object[]{"X X", "X X", 'X', WolfItemList.redstoneIngot});
		
		GameRegistry.addRecipe(new ItemStack(WolfItemList.silverHelmet, 1), new Object[]{"XXX", "X X", 'X', WolfItemList.silverIngot});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.silverChestplate, 1), new Object[]{"X X", "XXX", "XXX", 'X', WolfItemList.silverIngot});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.silverLeggings, 1), new Object[]{"XXX", "X X", "X X", 'X', WolfItemList.silverIngot});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.silverBoots, 1), new Object[]{"X X", "X X", 'X', WolfItemList.silverIngot});
		
		GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisHelmet, 1), new Object[]{"XXX", "X X", 'X', WolfItemList.lapisIngot});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisChestplate, 1), new Object[]{"X X", "XXX", "XXX", 'X', WolfItemList.lapisIngot});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisLeggings, 1), new Object[]{"XXX", "X X", "X X", 'X', WolfItemList.lapisIngot});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisBoots, 1), new Object[]{"X X", "X X", 'X', WolfItemList.lapisIngot});
		
		GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldHelmet, 1), new Object[]{"XXX", "X X", 'X', WolfItemList.emeraldIngot});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldChestplate, 1), new Object[]{"X X", "XXX", "XXX", 'X', WolfItemList.emeraldIngot});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldLeggings, 1), new Object[]{"XXX", "X X", "X X", 'X', WolfItemList.emeraldIngot});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldBoots, 1), new Object[]{"X X", "X X", 'X', WolfItemList.emeraldIngot});
		
		GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneSword, 1), new Object[]{"X", "X", "Y", 'X', WolfItemList.redstoneIngot, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.redstonePickaxe, 1), new Object[]{"XXX", " Y ", " Y ", 'X', WolfItemList.redstoneIngot, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneAxe, 1), new Object[]{"XX ", "XY ", " Y ", 'X', WolfItemList.redstoneIngot, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneShovel, 1), new Object[]{"X", "Y", "Y",'X', WolfItemList.redstoneIngot, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneHoe, 1), new Object[]{"XX", "Y", "Y", 'X', WolfItemList.redstoneIngot, 'Y', Items.stick});

		GameRegistry.addRecipe(new ItemStack(WolfItemList.silverSword, 1), new Object[]{"X", "X", "Y", 'X', WolfItemList.silverIngot, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.silverPickaxe, 1), new Object[]{"XXX", " Y ", " Y ", 'X', WolfItemList.silverIngot, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.silverAxe, 1), new Object[]{"XX ", "XY ", " Y ", 'X', WolfItemList.silverIngot, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.silverShovel, 1), new Object[]{"X", "Y", "Y", 'X', WolfItemList.silverIngot, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.silverHoe, 1), new Object[]{"XX", "Y", "Y", 'X', WolfItemList.silverIngot, 'Y', Items.stick});

		GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisSword, 1), new Object[]{"X", "X", "Y", 'X', WolfItemList.lapisIngot, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisPickaxe, 1), new Object[]{"XXX", " Y ", " Y ", 'X', WolfItemList.lapisIngot, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisAxe, 1), new Object[]{"XX ", "XY ", " Y ", 'X', WolfItemList.lapisIngot, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisShovel, 1), new Object[]{"X", "Y", "Y", 'X', WolfItemList.lapisIngot, 'Y', Items.stick});		
		GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisHoe, 1), new Object[]{"XX", "Y", "Y", 'X', WolfItemList.lapisIngot, 'Y', Items.stick});

		GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldSword, 1), new Object[]{"X", "X", "Y", 'X', WolfItemList.emeraldIngot, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldPickaxe, 1), new Object[]{"XXX", " Y ", " Y ", 'X', WolfItemList.emeraldIngot, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldAxe, 1), new Object[]{"XX ", "XY ", " Y ", 'X', WolfItemList.emeraldIngot, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldShovel, 1), new Object[]{"X", "Y", "Y", 'X', WolfItemList.emeraldIngot, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldHoe, 1), new Object[]{"XX", "Y", "Y", 'X', WolfItemList.emeraldIngot, 'Y', Items.stick});
	}
	
	public static void loadSmelting()
	{
		
	}
}