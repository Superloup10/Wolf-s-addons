/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
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

import wolf.addons.client.render.RenderHammer;
import wolf.addons.common.block.WolfBlockList;
import wolf.addons.common.item.WolfItemList;

public class WolfClientProxy extends WolfCommonProxy
{
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
                    ModelBakery.addVariantName(Item.getItemFromBlock(WolfBlockList.silverOre), WolfBlockList.silverOre.getName() + "_nether");
                    return new ModelResourceLocation("wolf_addons:" + WolfBlockList.silverOre.getName() + "_nether", "inventory");
                }
                else if(FMLClientHandler.instance().getWorldClient().provider.getDimensionId() == 1)
                {
                    ModelBakery.addVariantName(Item.getItemFromBlock(WolfBlockList.silverOre), WolfBlockList.silverOre.getName() + "_end");
                    return new ModelResourceLocation("wolf_addons:" + WolfBlockList.silverOre.getName() + "_end", "inventory");
                }
                ModelBakery.addVariantName(Item.getItemFromBlock(WolfBlockList.silverOre), WolfBlockList.silverOre.getName());
                return new ModelResourceLocation("wolf_addons:" + WolfBlockList.silverOre.getName(), "inventory");
            }
        });
        registerBlockTexture(WolfBlockList.silverOre, WolfBlockList.silverOre.getName());
        registerBlockTexture(WolfBlockList.silverBlock, WolfBlockList.silverBlock.getName());

        // Items
        registerItemTexture(WolfItemList.emeraldIngot, WolfItemList.emeraldIngot.getName());
        registerItemTexture(WolfItemList.redstoneIngot, WolfItemList.redstoneIngot.getName());
        registerItemTexture(WolfItemList.lapisIngot, WolfItemList.lapisIngot.getName());
        registerItemTexture(WolfItemList.silverIngot, WolfItemList.silverIngot.getName());
        registerItemTexture(WolfItemList.silverDust, WolfItemList.silverDust.getName());

        // Tools
        registerItemTexture(WolfItemList.emeraldPickaxe, WolfItemList.emeraldPickaxe.getName());
        registerItemTexture(WolfItemList.emeraldAxe, WolfItemList.emeraldAxe.getName());
        registerItemTexture(WolfItemList.emeraldShovel, WolfItemList.emeraldShovel.getName());
        registerItemTexture(WolfItemList.emeraldHoe, WolfItemList.emeraldHoe.getName());

        // Weapons
        registerItemTexture(WolfItemList.redstoneSword, WolfItemList.redstoneSword.getName());
        registerItemTexture(WolfItemList.emeraldSword, WolfItemList.emeraldSword.getName());

        // Armors
        registerItemTexture(WolfItemList.redstoneHelmet, WolfItemList.redstoneSword.getName());
        registerItemTexture(WolfItemList.redstoneChestplate, WolfItemList.redstoneChestplate.getName());
        registerItemTexture(WolfItemList.redstoneLeggings, WolfItemList.redstoneLeggings.getName());
        registerItemTexture(WolfItemList.redstoneBoots, WolfItemList.redstoneBoots.getName());
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