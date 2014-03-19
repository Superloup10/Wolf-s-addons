package wolf_addons.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import wolf_addons.common.Wolf_Addons;
import wolf_addons.common.tileentity.TileEntityCompressor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Compressor extends BlockContainer
{
	private static boolean keepCompressorInventory = false;
	private final Random rand = new Random();

	protected Compressor()
	{
		super(Material.iron);
	}
	
	@Override
	public Item getItemDropped(int item, Random rand, int metadata)
	{
		return Item.getItemFromBlock(this);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = register.registerIcon("wolf_addons:compressor");
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		if(world.isRemote)
		{
			return true;
		}
		else
		{
			TileEntityCompressor compressor = (TileEntityCompressor) world.getTileEntity(x, y, z);
			
			if(compressor != null || !player.isSneaking())
			{
				player.openGui(Wolf_Addons.instance, 0, world, x, y, z);
			}
			return true;
		}
	}
	
	public void breakBlock(World world, int x, int y, int z, Block block, int par6)
	 {
		 if (!keepCompressorInventory)
		 {
			 TileEntityCompressor compressor = (TileEntityCompressor)world.getTileEntity(x, y, z);

			 if (compressor != null)
			 {
				 for (int j1 = 0; j1 < compressor.getSizeInventory(); ++j1)
				 {
					 ItemStack itemstack = compressor.getStackInSlot(j1);

					 if (itemstack != null)
					 {
						 float f = this.rand.nextFloat() * 0.8F + 0.1F;
						 float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
						 float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

						 while (itemstack.stackSize > 0)
						 {
							 int k1 = this.rand.nextInt(21) + 10;

							 if (k1 > itemstack.stackSize)
							 {
								 k1 = itemstack.stackSize;
							 }

							 itemstack.stackSize -= k1;
							 EntityItem entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));

							 if (itemstack.hasTagCompound())
							 {
								 entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
							 }

							 float f3 = 0.05F;
							 entityitem.motionX = (double)((float)this.rand.nextGaussian() * f3);
							 entityitem.motionY = (double)((float)this.rand.nextGaussian() * f3 + 0.2F);
							 entityitem.motionZ = (double)((float)this.rand.nextGaussian() * f3);
							 world.spawnEntityInWorld(entityitem);
						 }
					 }
				 }
				 world.func_147453_f(x, y, z, block);
			 }
		 }
		 super.breakBlock(world, x, y, z, block, par6);
	 }

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityCompressor();
	}
}