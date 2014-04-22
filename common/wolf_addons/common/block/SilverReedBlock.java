package wolf_addons.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import wolf_addons.common.item.WolfItemList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SilverReedBlock extends Block implements IPlantable
{
	protected SilverReedBlock()
	{
		super(Material.plants);
		float f = 0.375F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
        this.setTickRandomly(true);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
    {
        if (world.getBlock(x, y - 1, z) == this || this.checkBlockCoordValid(world, x, y, z))
        {
            if (world.isAirBlock(x, y + 1, z))
            {
                int l;

                for (l = 1; world.getBlock(x, y - l, z) == this; ++l)
                {
                    ;
                }

                if (l < 3)
                {
                    int i1 = world.getBlockMetadata(x, y, z);

                    if (i1 == 15)
                    {
                    	world.setBlock(x, y + 1, z, this);
                    	world.setBlockMetadataWithNotify(x, y, z, 0, 4);
                    }
                    else
                    {
                    	world.setBlockMetadataWithNotify(x, y, z, i1 + 1, 4);
                    }
                }
            }
        }
    }

	@Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        Block block = world.getBlock(x, y - 1, z);
    	if (block == this)
    	{
    		return block == this;
    	}
    	return block == WolfBlockList.SPReedBooster;
    }

	@Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        this.checkBlockCoordValid(world, x, y, z);
    }

    protected final boolean checkBlockCoordValid(World world, int x, int y, int z)
    {
        if (!this.canBlockStay(world, x, y, z))
        {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public boolean canBlockStay(World world, int x, int y, int z)
    {
        return this.canPlaceBlockAt(world, x, y, z);
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return null;
    }
    
    @Override
    public Item getItemDropped(int item, Random random, int metadata)
    {
        return WolfItemList.silverReed;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
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
	public Item getItem(World world, int x, int y, int z)
	{
		return WolfItemList.silverReed;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z)
	{
		return this;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
	{
		return EnumPlantType.Beach;
	}
}