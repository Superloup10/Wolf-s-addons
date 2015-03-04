/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package fr.wolf.addons.common.block;

import fr.wolf.addons.common.item.WolfItemList;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SilverReedBlock extends Block implements IPlantable
{
    public static final PropertyInteger age = PropertyInteger.create("age", 0, 15);

    protected SilverReedBlock()
    {
        super(Material.plants);
        this.setDefaultState(this.blockState.getBaseState().withProperty(age, Integer.valueOf(0)));
        float f = 0.375F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
        this.setTickRandomly(true);
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if(world.getBlockState(pos.down()).getBlock() == this || this.checkBlockCoordValid(world, pos, state))
        {
            if(world.isAirBlock(pos.up()))
            {
                int l;

                for(l = 1; world.getBlockState(pos.down(l)).getBlock() == this; ++l)
                {
                    ;
                }

                if(l < 3)
                {
                    int i1 = ((Integer)state.getValue(age)).intValue();

                    if(i1 == 15)
                    {
                        world.setBlockState(pos.up(), this.getDefaultState());
                        world.setBlockState(pos, state.withProperty(age, Integer.valueOf(0)), 4);
                    }
                    else
                    {
                        world.setBlockState(pos, state.withProperty(age, Integer.valueOf(l + 1)), 4);
                    }
                }
            }
        }
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos)
    {
        Block block = world.getBlockState(pos.down()).getBlock();
        if(block.canSustainPlant(world, pos, EnumFacing.UP, this))
            return true;

        if(block == this)
        {
            return true;
        }
        else if(block != WolfBlockList.SPReedBooster)
        {
            return false;
        }
        else
        {
            Iterator iterator = EnumFacing.Plane.HORIZONTAL.iterator();
            EnumFacing enumfacing;

            do
            {
                if(!iterator.hasNext())
                {
                    return false;
                }

                enumfacing = (EnumFacing)iterator.next();
            }
            while(world.getBlockState(pos.offset(enumfacing).down()).getBlock().getMaterial() != Material.water);

            return true;
        }
    }

    @Override
    public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block block)
    {
        this.checkBlockCoordValid(world, pos, state);
    }

    protected final boolean checkBlockCoordValid(World world, BlockPos pos, IBlockState state)
    {
        if(this.canBlockStay(world, pos))
        {
            return true;
        }
        else
        {
            this.dropBlockAsItem(world, pos, state, 0);
            world.setBlockToAir(pos);
            return false;
        }
    }

    public boolean canBlockStay(World world, BlockPos pos)
    {
        return this.canPlaceBlockAt(world, pos);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world, BlockPos pos, IBlockState state)
    {
        return null;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int metadata)
    {
        return WolfItemList.silverReed;
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
    public int getRenderType()
    {
        return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, BlockPos pos)
    {
        return WolfItemList.silverReed;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos)
    {
        return this.getDefaultState();
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
    {
        return EnumPlantType.Beach;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(age, Integer.valueOf(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(age)).intValue();
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {age});
    }
}