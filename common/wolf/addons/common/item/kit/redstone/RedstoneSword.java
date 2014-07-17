/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.item.kit.redstone;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import wolf.addons.common.item.WolfItemList;

public class RedstoneSword extends ItemSword
{
	@SideOnly(Side.CLIENT)
	private IIcon[] textures = new IIcon[2];

	public RedstoneSword(ToolMaterial material)
	{
		super(material);
	}

	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair)
	{
		if (repair.getItem().equals(WolfItemList.redstoneIngot))
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

		if (helmet != null && helmet.getItem() == WolfItemList.redstoneHelmet && chestplate != null && chestplate.getItem() == WolfItemList.redstoneChestplate && leggings != null && leggings.getItem() == WolfItemList.redstoneLeggings && boots != null && boots.getItem() == WolfItemList.redstoneBoots)
		{
			if (player.isSneaking())
			{
				if (!itemStack.hasTagCompound())
				{
					itemStack.setTagCompound(new NBTTagCompound());
				}
				if (!helmet.hasTagCompound())
				{
					helmet.setTagCompound(new NBTTagCompound());
				}
				byte mode = itemStack.getTagCompound().getByte("Mode");
				mode++;
				if (mode == 2)
				{
					mode = 0;
				}
				itemStack.getTagCompound().setByte("Mode", mode);
				helmet.getTagCompound().setByte("Mode", mode);
				chestplate.getTagCompound().setByte("Mode", mode);
				leggings.getTagCompound().setByte("Mode", mode);
				boots.getTagCompound().setByte("Mode", mode);

				if (world.isRemote)
				{
					player.addChatMessage(new ChatComponentTranslation("sword.mode.message." + mode));
				}
			}
			else
			{
				super.onItemRightClick(itemStack, world, player);
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
		if (!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
		}

		if (stack.getTagCompound().getByte("Mode") == 0)
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
	public IIcon getIcon(ItemStack stack, int pass)
	{
		if (!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
		}

		if (stack.getTagCompound().getByte("Mode") == 0)
		{
			return textures[0];
		}
		else
		{
			return textures[1];
		}
	}

	@Override
	public IIcon getIconIndex(ItemStack itemStack)
	{
		if (!itemStack.hasTagCompound())
		{
			itemStack.setTagCompound(new NBTTagCompound());
		}

		if (itemStack.getTagCompound().getByte("Mode") == 0)
		{
			return textures[0];
		}
		else
		{
			return textures[1];
		}
	}

	@Override
	public void registerIcons(IIconRegister register)
	{
		textures[0] = register.registerIcon("wolf_addons:redstone_sword_off");
		textures[1] = register.registerIcon("wolf_addons:redstone_sword_on");
	}
}
