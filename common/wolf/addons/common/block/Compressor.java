/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import wolf.addons.common.Wolf_Addons;
import wolf.addons.common.creativestabs.WolfCT;
import wolf.addons.common.tileentity.TileEntityCompressor;

public class Compressor extends BlockContainer
{
    private static boolean keepCompressorInventory = false;
    private final Random rand = new Random();

    protected Compressor()
    {
        super(Material.iron);
        this.setCreativeTab(WolfCT.creativeTabsBlocks);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int metadata)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if(world.isRemote)
        {
            return true;
        }
        else
        {
            TileEntityCompressor compressor = (TileEntityCompressor)world.getTileEntity(pos);

            if(compressor != null)
            {
                player.openGui(Wolf_Addons.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
            }
            return true;
        }
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        if(!keepCompressorInventory)
        {
            TileEntityCompressor compressor = (TileEntityCompressor)world.getTileEntity(pos);

            if(compressor != null)
            {
                InventoryHelper.dropInventoryItems(world, pos, compressor);
                world.updateComparatorOutputLevel(pos, this);
            }
        }
        super.breakBlock(world, pos, state);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        return new TileEntityCompressor();
    }
}