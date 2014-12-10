/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import wolf.addons.common.creativestabs.WolfCT;

public class SilverReed extends Item
{
    private Block block;

    public SilverReed(Block block)
    {
        this.block = block;
        this.setCreativeTab(WolfCT.creativeTabsItems);
    }

    // @Override
    // public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    // {
    // Block block = world.getBlock(x, y, z);
    //
    // if(block == Blocks.snow_layer && (world.getBlockMetadata(x, y, z) & 7) < 1)
    // {
    // par7 = 1;
    // }
    // else if(block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush)
    // {
    // if(par7 == 0)
    // {
    // --y;
    // }
    //
    // if(par7 == 1)
    // {
    // ++y;
    // }
    //
    // if(par7 == 2)
    // {
    // --z;
    // }
    //
    // if(par7 == 3)
    // {
    // ++z;
    // }
    //
    // if(par7 == 4)
    // {
    // --x;
    // }
    //
    // if(par7 == 5)
    // {
    // ++x;
    // }
    // }
    //
    // if(!player.canPlayerEdit(x, y, z, par7, itemStack))
    // {
    // return false;
    // }
    // else if(itemStack.stackSize == 0)
    // {
    // return false;
    // }
    // else
    // {
    // if(world.canPlaceEntityOnSide(this.block, x, y, z, false, par7, (Entity)null, itemStack))
    // {
    // int i1 = this.block.onBlockPlaced(world, x, y, z, par7, par8, par9, par10, 0);
    //
    // if(world.setBlock(x, y, z, this.block, i1, 3))
    // {
    // if(world.getBlock(x, y, z) == this.block)
    // {
    // this.block.onBlockPlacedBy(world, x, y, z, player, itemStack);
    // this.block.onPostBlockPlaced(world, x, y, z, i1);
    // }
    //
    // world.playSoundEffect((double)(x + 0.5F), (double)(y + 0.5F), (double)(z + 0.5F), this.block.stepSound.func_150496_b(), (this.block.stepSound.getVolume() + 1.0F) / 2.0F, this.block.stepSound.getPitch() * 0.8F);
    // --itemStack.stackSize;
    // }
    // }
    //
    // return true;
    // }
    // }
}