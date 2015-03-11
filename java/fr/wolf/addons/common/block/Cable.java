/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package fr.wolf.addons.common.block;

import fr.wolf.addons.common.tileentity.TileEntityCable;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class Cable extends BlockContainer
{
    private float pixel = 1F / 16F;

    protected Cable()
    {
        super(Material.ground);
        this.useNeighborBrightness = true;

        this.setBlockBounds(11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(World world, BlockPos pos)
    {
        TileEntityCable cable = (TileEntityCable)world.getTileEntity(pos);
        if(cable != null)
        {
            float minY = 11 * pixel / 2 - (cable.direction[0] != null ? (11 * pixel / 2) : 0);
            float maxY = 1 - 11 * pixel / 2 + (cable.direction[1] != null ? (11 * pixel / 2) : 0);
            float minZ = 11 * pixel / 2 - (cable.direction[2] != null ? (11 * pixel / 2) : 0);
            float maxZ = 1 - 11 * pixel / 2 + (cable.direction[3] != null ? (11 * pixel / 2) : 0);
            float minX = 11 * pixel / 2 - (cable.direction[4] != null ? (11 * pixel / 2) : 0);
            float maxX = 1 - 11 * pixel / 2 + (cable.direction[5] != null ? (11 * pixel / 2) : 0);

            this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
        }
        return AxisAlignedBB.fromBounds(pos.getX() + minX, pos.getY() + minY, pos.getZ() + minZ, pos.getX() + maxX, pos.getY() + maxY, pos.getZ() + maxZ);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world, BlockPos pos, IBlockState state)
    {
        TileEntityCable cable = (TileEntityCable)world.getTileEntity(pos);
        if(cable != null)
        {
            float minY = 11 * pixel / 2 - (cable.direction[0] != null ? (11 * pixel / 2) : 0);
            float maxY = 1 - 11 * pixel / 2 + (cable.direction[1] != null ? (11 * pixel / 2) : 0);
            float minZ = 11 * pixel / 2 - (cable.direction[2] != null ? (11 * pixel / 2) : 0);
            float maxZ = 1 - 11 * pixel / 2 + (cable.direction[3] != null ? (11 * pixel / 2) : 0);
            float minX = 11 * pixel / 2 - (cable.direction[4] != null ? (11 * pixel / 2) : 0);
            float maxX = 1 - 11 * pixel / 2 + (cable.direction[5] != null ? (11 * pixel / 2) : 0);

            this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
        }
        return AxisAlignedBB.fromBounds(pos.getX() + minX, pos.getY() + minY, pos.getZ() + minZ, pos.getX() + maxX, pos.getY() + maxY, pos.getZ() + maxZ);
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean isFullCube()
    {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityCable();
    }
}