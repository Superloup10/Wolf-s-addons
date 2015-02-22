/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.proxy;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import wolf.addons.client.render.RenderHammer;
import wolf.addons.client.render.TESRCable;
import wolf.addons.common.block.WolfBlockList;
import wolf.addons.common.item.WolfItemList;
import wolf.addons.common.tileentity.TileEntityCable;

public class WolfClientProxy extends WolfCommonProxy
{
    // public static int tesrRenderId;

    @Override
    public void registerRender()
    {
        MinecraftForgeClient.registerItemRenderer(WolfItemList.woodHammer, new RenderHammer());
        MinecraftForgeClient.registerItemRenderer(WolfItemList.stoneHammer, new RenderHammer());
        MinecraftForgeClient.registerItemRenderer(WolfItemList.ironHammer, new RenderHammer());
        MinecraftForgeClient.registerItemRenderer(WolfItemList.goldHammer, new RenderHammer());
        MinecraftForgeClient.registerItemRenderer(WolfItemList.diamondHammer, new RenderHammer());
        MinecraftForgeClient.registerItemRenderer(WolfItemList.silverHammer, new RenderHammer());
        MinecraftForgeClient.registerItemRenderer(WolfItemList.redstoneHammer, new RenderHammer());
        MinecraftForgeClient.registerItemRenderer(WolfItemList.lapisHammer, new RenderHammer());
        MinecraftForgeClient.registerItemRenderer(WolfItemList.emeraldHammer, new RenderHammer());
    }

    @Override
    public void registerTESR()
    {
        // RenderCore.registerTESRCallForBlock(WolfBlockList.cable, new TileEntityCable());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCable.class, new TESRCable());
    }

    @Override
    public void registerTexture()
    {
        // Blocks
        ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        mesher.register(Item.getItemFromBlock(WolfBlockList.silverOre), new ItemMeshDefinition()
        {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack)
            {
                if(FMLClientHandler.instance().getWorldClient().provider.getDimensionId() == -1)
                {
                    ModelBakery.addVariantName(Item.getItemFromBlock(WolfBlockList.silverOre), "silver_ore" + "_nether");
                    return new ModelResourceLocation("wolf_addons:" + "silver_ore" + "_nether", "inventory");
                }
                else if(FMLClientHandler.instance().getWorldClient().provider.getDimensionId() == 1)
                {
                    ModelBakery.addVariantName(Item.getItemFromBlock(WolfBlockList.silverOre), "silver_ore" + "_end");
                    return new ModelResourceLocation("wolf_addons:" + "silver_ore" + "_end", "inventory");
                }
                ModelBakery.addVariantName(Item.getItemFromBlock(WolfBlockList.silverOre), "silver_ore");
                return new ModelResourceLocation("wolf_addons:" + "silver_ore", "inventory");
            }
        });

        registerBlockTexture(WolfBlockList.silverBlock, "silver_block");
        registerBlockTexture(WolfBlockList.furnace, "furnace");
        registerBlockTexture(WolfBlockList.cable, "cable");

        // Items
        registerItemTexture(WolfItemList.emeraldIngot, "emerald_ingot");
        registerItemTexture(WolfItemList.redstoneIngot, "redstone_ingot");
        registerItemTexture(WolfItemList.lapisIngot, "lapis_ingot");
        registerItemTexture(WolfItemList.silverIngot, "silver_ingot");
        registerItemTexture(WolfItemList.silverDust, "silver_dust");

        // Tools
        registerItemTexture(WolfItemList.emeraldPickaxe, "emerald_pickaxe");
        registerItemTexture(WolfItemList.emeraldAxe, "emerald_axe");
        registerItemTexture(WolfItemList.emeraldShovel, "emerald_shovel");
        registerItemTexture(WolfItemList.emeraldHoe, "emerald_hoe");

        registerItemTexture(WolfItemList.redstonePickaxe, "redstone_pickaxe");
        registerItemTexture(WolfItemList.redstoneAxe, "redstone_axe");
        registerItemTexture(WolfItemList.redstoneShovel, "redstone_shovel");
        registerItemTexture(WolfItemList.redstoneHoe, "redstone_hoe");

        registerItemTexture(WolfItemList.lapisPickaxe, "lapis_pickaxe");
        registerItemTexture(WolfItemList.lapisAxe, "lapis_axe");
        registerItemTexture(WolfItemList.lapisShovel, "lapis_shovel");
        registerItemTexture(WolfItemList.lapisHoe, "lapis_hoe");

        registerItemTexture(WolfItemList.silverPickaxe, "silver_pickaxe");
        registerItemTexture(WolfItemList.silverAxe, "silver_axe");
        registerItemTexture(WolfItemList.silverShovel, "silver_shovel");
        registerItemTexture(WolfItemList.silverHoe, "silver_hoe");

        // Weapons
        registerItemTexture(WolfItemList.redstoneSword, "redstone_sword");
        registerItemTexture(WolfItemList.emeraldSword, "emerald_sword");
        registerItemTexture(WolfItemList.lapisSword, "lapis_sword");
        registerItemTexture(WolfItemList.silverSword, "silver_sword");

        // Armors
        registerItemTexture(WolfItemList.redstoneHelmet, "redstone_helmet");
        registerItemTexture(WolfItemList.redstoneChestplate, "redstone_chestplate");
        registerItemTexture(WolfItemList.redstoneLeggings, "redstone_leggings");
        registerItemTexture(WolfItemList.redstoneBoots, "redstone_boots");

        registerItemTexture(WolfItemList.emeraldHelmet, "emerald_helmet");
        registerItemTexture(WolfItemList.emeraldChestplate, "emerald_chestplate");
        registerItemTexture(WolfItemList.emeraldLeggings, "emerald_leggings");
        registerItemTexture(WolfItemList.emeraldBoots, "emerald_boots");

        registerItemTexture(WolfItemList.silverHelmet, "silver_helmet");
        registerItemTexture(WolfItemList.silverChestplate, "silver_chestplate");
        registerItemTexture(WolfItemList.silverLeggings, "silver_leggings");
        registerItemTexture(WolfItemList.silverBoots, "silver_boots");

        registerItemTexture(WolfItemList.lapisHelmet, "lapis_helmet");
        registerItemTexture(WolfItemList.lapisChestplate, "lapis_chestplate");
        registerItemTexture(WolfItemList.lapisLeggings, "lapis_leggings");
        registerItemTexture(WolfItemList.lapisBoots, "lapis_boots");
    }

    public static void registerItemTexture(Item item, int metadata, String name)
    {
        ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        mesher.register(item, metadata, new ModelResourceLocation("wolf_addons:" + name, "inventory"));
    }

    public static void registerItemTexture(Item item, String name)
    {
        registerItemTexture(item, 0, name);
    }

    public static void registerBlockTexture(Block block, int metadata, String name)
    {
        registerItemTexture(Item.getItemFromBlock(block), metadata, name);
    }

    public static void registerBlockTexture(Block block, String name)
    {
        registerBlockTexture(block, 0, name);
    }
}