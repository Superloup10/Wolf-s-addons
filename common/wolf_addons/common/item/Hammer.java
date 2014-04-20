package wolf_addons.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Hammer extends Item
{
	private String texture; 
	
	public Hammer(int damage, String textureName)
	{
		this.maxStackSize = 1;
		this.texture = textureName;
		this.setMaxDamage(damage);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public boolean isFull3D()
	{
		return true;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack itemStack)
	{
		return 72000;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack itemStack)
	{
		return EnumAction.block;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		itemIcon = register.registerIcon("wolf_addons:" + texture);
	}
}