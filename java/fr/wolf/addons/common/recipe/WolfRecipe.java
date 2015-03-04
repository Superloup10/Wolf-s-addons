/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package fr.wolf.addons.common.recipe;

import fr.wolf.addons.common.block.WolfBlockList;
import fr.wolf.addons.common.item.WolfItemList;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WolfRecipe
{
    public static void loadRecipe()
    {
        // TODO Possible changements
        // GameRegistry.addRecipe(new ItemStack(WolfBlockList.compressor), new
        // Object[] {"XXX", "YYY", "XZX", 'X', Blocks.stone, 'Y',
        // Blocks.iron_block, 'Z', Blocks.redstone_block});

        // Blocks
        GameRegistry.addRecipe(new ItemStack(WolfBlockList.silverBlock), new Object[] {"XXX", "XXX", "XXX", 'X', WolfItemList.silverIngot});
        // TODO RECIPES TEMP
        // Items
        GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneIngot, 1), new Object[] {"XXX", 'X', Items.redstone});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisIngot, 1), new Object[] {"XXX", 'X', new ItemStack(Items.dye, 1, 4)});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldIngot, 1), new Object[] {"XXX", 'X', Items.emerald});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.silverIngot, 1), new Object[] {"XXX", 'X', WolfItemList.silverDust});

        GameRegistry.addRecipe(new ItemStack(WolfItemList.stoneBow, 1), new Object[] {" XY", "X Y", " XY", 'X', Blocks.cobblestone, 'Y', Items.string});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.ironBow, 1), new Object[] {" XY", "X Y", " XY", 'X', Items.iron_ingot, 'Y', Items.string});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.goldBow, 1), new Object[] {" XY", "X Y", " XY", 'X', Items.gold_ingot, 'Y', Items.string});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.diamondBow, 1), new Object[] {" XY", "X Y", " XY", 'X', Items.diamond, 'Y', Items.string});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.silverBow, 1), new Object[] {" XY", "X Y", " XY", 'X', WolfItemList.silverIngot, 'Y', Items.string});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneBow, 1), new Object[] {" XY", "X Y", " XY", 'X', WolfItemList.redstoneIngot, 'Y', Items.string});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisBow, 1), new Object[] {" XY", "X Y", " XY", 'X', WolfItemList.lapisIngot, 'Y', Items.string});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldBow, 1), new Object[] {" XY", "X Y", " XY", 'X', WolfItemList.emeraldIngot, 'Y', Items.string});

        /*
         * GameRegistry.addRecipe(new ItemStack(WolfItemList.woodHammer, 1), new Object[] {"XXX", "XYX", " Y ", 'X', Blocks.planks, 'Y', Items.stick}); GameRegistry.addRecipe(new ItemStack(WolfItemList.stoneHammer, 1), new Object[] {"XXX", "XYX", " Y ", 'X', Blocks.cobblestone, 'Y', Items.stick}); GameRegistry.addRecipe(new ItemStack(WolfItemList.ironHammer, 1), new Object[] {"XXX", "XYX", " Y ",
         * 'X', Items.iron_ingot, 'Y', Items.stick}); GameRegistry.addRecipe(new ItemStack(WolfItemList.goldHammer, 1), new Object[] {"XXX", "XYX", " Y ", 'X', Items.gold_ingot, 'Y', Items.stick}); GameRegistry.addRecipe(new ItemStack(WolfItemList.diamondHammer, 1), new Object[] {"XXX", "XYX", " Y ", 'X', Items.diamond, 'Y', Items.stick}); GameRegistry.addRecipe(new
         * ItemStack(WolfItemList.silverHammer, 1), new Object[] {"XXX", "XYX", " Y ", 'X', WolfItemList.silverIngot, 'Y', Items.stick}); GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneHammer, 1), new Object[] {"XXX", "XYX", " Y ", 'X', WolfItemList.redstoneIngot, 'Y', Items.stick}); GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisHammer, 1), new Object[] {"XXX", "XYX", " Y ",
         * 'X', WolfItemList.lapisIngot, 'Y', Items.stick}); GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldHammer, 1), new Object[] {"XXX", "XYX", " Y ", 'X', WolfItemList.emeraldIngot, 'Y', Items.stick});
         */

        GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneHelmet, 1), new Object[] {"XXX", "X X", 'X', WolfItemList.redstoneIngot});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneChestplate, 1), new Object[] {"X X", "XXX", "XXX", 'X', WolfItemList.redstoneIngot});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneLeggings, 1), new Object[] {"XXX", "X X", "X X", 'X', WolfItemList.redstoneIngot});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneBoots, 1), new Object[] {"X X", "X X", 'X', WolfItemList.redstoneIngot});

        GameRegistry.addRecipe(new ItemStack(WolfItemList.silverHelmet, 1), new Object[] {"XXX", "X X", 'X', WolfItemList.silverIngot});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.silverChestplate, 1), new Object[] {"X X", "XXX", "XXX", 'X', WolfItemList.silverIngot});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.silverLeggings, 1), new Object[] {"XXX", "X X", "X X", 'X', WolfItemList.silverIngot});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.silverBoots, 1), new Object[] {"X X", "X X", 'X', WolfItemList.silverIngot});

        GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisHelmet, 1), new Object[] {"XXX", "X X", 'X', WolfItemList.lapisIngot});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisChestplate, 1), new Object[] {"X X", "XXX", "XXX", 'X', WolfItemList.lapisIngot});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisLeggings, 1), new Object[] {"XXX", "X X", "X X", 'X', WolfItemList.lapisIngot});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisBoots, 1), new Object[] {"X X", "X X", 'X', WolfItemList.lapisIngot});

        GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldHelmet, 1), new Object[] {"XXX", "X X", 'X', WolfItemList.emeraldIngot});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldChestplate, 1), new Object[] {"X X", "XXX", "XXX", 'X', WolfItemList.emeraldIngot});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldLeggings, 1), new Object[] {"XXX", "X X", "X X", 'X', WolfItemList.emeraldIngot});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldBoots, 1), new Object[] {"X X", "X X", 'X', WolfItemList.emeraldIngot});

        GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneSword, 1), new Object[] {"X", "X", "Y", 'X', WolfItemList.redstoneIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.redstonePickaxe, 1), new Object[] {"XXX", " Y ", " Y ", 'X', WolfItemList.redstoneIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneAxe, 1), new Object[] {"XX ", "XY ", " Y ", 'X', WolfItemList.redstoneIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneShovel, 1), new Object[] {"X", "Y", "Y", 'X', WolfItemList.redstoneIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.redstoneHoe, 1), new Object[] {"XX ", " Y ", " Y ", 'X', WolfItemList.redstoneIngot, 'Y', Items.stick});

        GameRegistry.addRecipe(new ItemStack(WolfItemList.silverSword, 1), new Object[] {"X", "X", "Y", 'X', WolfItemList.silverIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.silverPickaxe, 1), new Object[] {"XXX", " Y ", " Y ", 'X', WolfItemList.silverIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.silverAxe, 1), new Object[] {"XX ", "XY ", " Y ", 'X', WolfItemList.silverIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.silverShovel, 1), new Object[] {"X", "Y", "Y", 'X', WolfItemList.silverIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.silverHoe, 1), new Object[] {"XX ", " Y ", " Y ", 'X', WolfItemList.silverIngot, 'Y', Items.stick});

        GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisSword, 1), new Object[] {"X", "X", "Y", 'X', WolfItemList.lapisIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisPickaxe, 1), new Object[] {"XXX", " Y ", " Y ", 'X', WolfItemList.lapisIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisAxe, 1), new Object[] {"XX ", "XY ", " Y ", 'X', WolfItemList.lapisIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisShovel, 1), new Object[] {"X", "Y", "Y", 'X', WolfItemList.lapisIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.lapisHoe, 1), new Object[] {"XX ", " Y ", " Y ", 'X', WolfItemList.lapisIngot, 'Y', Items.stick});

        GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldSword, 1), new Object[] {"X", "X", "Y", 'X', WolfItemList.emeraldIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldPickaxe, 1), new Object[] {"XXX", " Y ", " Y ", 'X', WolfItemList.emeraldIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldAxe, 1), new Object[] {"XX ", "XY ", " Y ", 'X', WolfItemList.emeraldIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldShovel, 1), new Object[] {"X", "Y", "Y", 'X', WolfItemList.emeraldIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(WolfItemList.emeraldHoe, 1), new Object[] {"XX ", " Y ", " Y ", 'X', WolfItemList.emeraldIngot, 'Y', Items.stick});

        if(Loader.isModLoaded("sevenno_addons"))
        {
            GameRegistry.addShapelessRecipe(new ItemStack(WolfItemList.silverDust, 1), new ItemStack(WolfItemList.silverReed));
        }
    }

    public static void loadSmelting()
    {
        GameRegistry.addSmelting(WolfBlockList.silverOre, new ItemStack(WolfItemList.silverDust, 1), 1.0F);
    }
}