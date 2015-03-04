/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package fr.wolf.addons.common.block;

import fr.wolf.addons.common.Wolf_Addons;
import fr.wolf.addons.common.creativestabs.WolfCT;
import fr.wolf.addons.common.tileentity.TileEntityFurnace;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Plane;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Furnace extends BlockContainer
{
    public static final PropertyDirection FACING = PropertyDirection.create("facing", Plane.HORIZONTAL);
    private static boolean keepInventory;
    private final boolean isBurning;

    protected Furnace()
    {
        super(Material.iron);
        this.isBurning = false;
        this.setCreativeTab(WolfCT.creativeTabsBlocks);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
        this.setDefaultFacing(world, pos, state);
    }

    private void setDefaultFacing(World world, BlockPos pos, IBlockState state)
    {
        if(!world.isRemote)
        {
            Block block_north = world.getBlockState(pos.north()).getBlock();
            Block block_south = world.getBlockState(pos.south()).getBlock();
            Block block_west = world.getBlockState(pos.west()).getBlock();
            Block block_east = world.getBlockState(pos.east()).getBlock();
            EnumFacing facing = (EnumFacing)state.getValue(FACING);

            if(facing == EnumFacing.NORTH && block_north.isFullBlock() && !block_south.isFullBlock())
            {
                facing = EnumFacing.SOUTH;
            }
            else if(facing == EnumFacing.SOUTH && block_south.isFullBlock() && !block_north.isFullBlock())
            {
                facing = EnumFacing.NORTH;
            }
            else if(facing == EnumFacing.WEST && block_west.isFullBlock() && !block_east.isFullBlock())
            {
                facing = EnumFacing.EAST;
            }
            else if(facing == EnumFacing.EAST && block_east.isFullBlock() && !block_west.isFullBlock())
            {
                facing = EnumFacing.WEST;
            }

            world.setBlockState(pos, state.withProperty(FACING, facing), 2);
        }
    }

    @Override
    public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if(this.isBurning)
        {
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
            double x = pos.getX() + 0.5D;
            double y = pos.getY() + rand.nextDouble() * 6.0D / 16.0D;
            double z = pos.getZ() + 0.5D;
            double d3 = 0.52D;
            double d4 = rand.nextDouble() * 0.6D - 0.3D;

            switch(Furnace.SwitchEnumFacing.FACING_LOOKUP[enumfacing.ordinal()])
            {
            case 1:
                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x - d3, y, z + d4, 0.0D, 0.0D, 0.0D, new int[0]);
                world.spawnParticle(EnumParticleTypes.FLAME, x - d3, y, z + d4, 0.0D, 0.0D, 0.0D, new int[0]);
                break;
            case 2:
                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + d3, y, z + d4, 0.0D, 0.0D, 0.0D, new int[0]);
                world.spawnParticle(EnumParticleTypes.FLAME, x + d3, y, z + d4, 0.0D, 0.0D, 0.0D, new int[0]);
                break;
            case 3:
                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + d4, y, z - d3, 0.0D, 0.0D, 0.0D, new int[0]);
                world.spawnParticle(EnumParticleTypes.FLAME, x + d4, y, z - d3, 0.0D, 0.0D, 0.0D, new int[0]);
                break;
            case 4:
                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + d4, y, z + d3, 0.0D, 0.0D, 0.0D, new int[0]);
                world.spawnParticle(EnumParticleTypes.FLAME, x + d4, y, z + d3, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        }
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
            TileEntity tileEntity = world.getTileEntity(pos);
            if(tileEntity instanceof TileEntityFurnace)
            {
                player.openGui(Wolf_Addons.instance, 2, world, pos.getX(), pos.getY(), pos.getZ());
            }
            return true;
        }
    }

    public static void setState(boolean active, World world, BlockPos pos)
    {
        IBlockState iblockstate = world.getBlockState(pos);
        TileEntity tileentity = world.getTileEntity(pos);
        keepInventory = true;

        if(active)
        {
            world.setBlockState(pos, WolfBlockList.furnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            world.setBlockState(pos, WolfBlockList.furnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }
        else
        {
            world.setBlockState(pos, WolfBlockList.furnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            world.setBlockState(pos, WolfBlockList.furnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }

        keepInventory = false;

        if(tileentity != null)
        {
            tileentity.validate();
            world.setTileEntity(pos, tileentity);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityFurnace();
    }

    @Override
    public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);

        if(stack.hasDisplayName())
        {
            TileEntity tileentity = world.getTileEntity(pos);

            if(tileentity instanceof TileEntityFurnace)
            {
                ((TileEntityFurnace)tileentity).setCustomInventoryName(stack.getDisplayName());
            }
        }
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        if(!keepInventory)
        {
            TileEntity tileentity = world.getTileEntity(pos);

            if(tileentity instanceof TileEntityFurnace)
            {
                InventoryHelper.dropInventoryItems(world, pos, (TileEntityFurnace)tileentity);
                world.updateComparatorOutputLevel(pos, this);
            }
        }

        super.breakBlock(world, pos, state);
    }

    @Override
    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world, BlockPos pos)
    {
        return Container.calcRedstone(world.getTileEntity(pos));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, BlockPos pos)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public int getRenderType()
    {
        return 3;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IBlockState getStateForEntityRender(IBlockState state)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if(enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING});
    }

    @SideOnly(Side.CLIENT)
    static final class SwitchEnumFacing
    {
        static final int[] FACING_LOOKUP = new int[EnumFacing.values().length];

        static
        {
            try
            {
                FACING_LOOKUP[EnumFacing.WEST.ordinal()] = 1;
            }
            catch(NoSuchFieldError var4)
            {
                ;
            }

            try
            {
                FACING_LOOKUP[EnumFacing.EAST.ordinal()] = 2;
            }
            catch(NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                FACING_LOOKUP[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch(NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                FACING_LOOKUP[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch(NoSuchFieldError var1)
            {
                ;
            }
        }
    }
}