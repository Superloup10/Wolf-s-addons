package wolf_addons.common.item.kit.redstone;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import wolf_addons.common.item.WolfItemList;

public class RedstoneSword extends ItemSword
{
	private static ItemStack itemStack;
	
	public RedstoneSword(ToolMaterial material)
	{
		super(material);
		this.setTextureName("wolf_addons:redstone_sword");
	}
	
	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair)
	{
		if(repair.getItem().equals(WolfItemList.redstoneIngot))
		{
			return true;
		}
		return false;
	}
	
	@Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
		ItemStack helmet = player.getEquipmentInSlot(4);
		ItemStack chestplate = player.getEquipmentInSlot(3);
		ItemStack leggings = player.getEquipmentInSlot(2);
		ItemStack boots = player.getEquipmentInSlot(1);
		
		if(helmet != null && helmet.getItem() == WolfItemList.redstoneHelmet && chestplate != null &&  chestplate.getItem() == WolfItemList.redstoneChestplate && leggings != null && leggings.getItem() == WolfItemList.redstoneLeggings && boots != null && boots.getItem() == WolfItemList.redstoneBoots)
		{
			if(player.isSneaking())
			{
				if(!itemStack.hasTagCompound())
				{
					itemStack.setTagCompound(new NBTTagCompound());
				}
				byte mode = itemStack.getTagCompound().getByte("Mode");
				mode++;
				if(mode == 2)
				{
					mode = 0;
				}
				itemStack.getTagCompound().setByte("Mode", mode);
				if(world.isRemote)
				{
					player.addChatMessage(new ChatComponentTranslation("sword.mode.message." + mode));
				}
			}
		}
		else
		{
			super.onItemRightClick(itemStack, world, player);
		}
		return itemStack;
    }
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase attackedLiving, EntityLivingBase attackerLiving)
	{
		if(!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
		}
		
		if(stack.getTagCompound().getByte("Mode") == 0)
		{
			return super.hitEntity(stack, attackedLiving, attackerLiving);
		}
		else
		{
			attackedLiving.setFire(4);
		}
		return super.hitEntity(stack, attackedLiving, attackerLiving);
	}
	
	@Override
	public void registerIcons(IIconRegister register)
	{
		if(!itemStack.hasTagCompound())
		{
			itemStack.setTagCompound(new NBTTagCompound());
		}
		
		if(itemStack.getTagCompound().getByte("Mode") == 0)
		{
			itemIcon = register.registerIcon("wolf_addons:redstone_sword_off");
		}
		else
		{
			itemIcon = register.registerIcon("wolf_addons:redstone_sword_on");
		}
	}
}