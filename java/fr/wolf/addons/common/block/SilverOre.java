/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package fr.wolf.addons.common.block;

import fr.wolf.addons.common.item.WolfItemList;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class SilverOre extends WolfBlock
{
    protected SilverOre()
    {
        super(Material.rock, "silver_ore", 3.0F, 5.0F, soundTypeStone);
        this.setHarvestLevel("pickaxe", 2);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return WolfItemList.silverDust;
    }

    @Override
    public int quantityDropped(Random rand)
    {
        return 1;
    }

    // @SideOnly(Side.CLIENT)
    // @Override
    // public IIcon getIcon(int side, int metadata)
    // {
    // if(FMLClientHandler.instance().getWorldClient().provider.dimensionId == -1)
    // {
    // return this.textures[1];
    // }
    // else if(FMLClientHandler.instance().getWorldClient().provider.dimensionId == 1)
    // {
    // return this.textures[2];
    // }
    // else
    // {
    // return this.textures[0];
    // }
    // }

    // @Override
    // public void registerBlockIcons(IIconRegister register)
    // {
    // textures[1] = register.registerIcon("wolf_addons:silver_ore_nether");
    // textures[0] = register.registerIcon("wolf_addons:silver_ore_overworld");
    // textures[2] = register.registerIcon("wolf_addons:silver_ore_end");
    // }
}