/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import wolf.addons.client.model.ModelHammer;
import wolf.addons.common.item.WolfItemList;

public class RenderHammer implements IItemRenderer
{
	protected static final ResourceLocation texture0 = new ResourceLocation("wolf_addons:textures/items/render/wood_hammer.png");
	protected static final ResourceLocation texture1 = new ResourceLocation("wolf_addons:textures/items/render/stone_hammer.png");
	protected static final ResourceLocation texture2 = new ResourceLocation("wolf_addons:textures/items/render/iron_hammer.png");
	protected static final ResourceLocation texture3 = new ResourceLocation("wolf_addons:textures/items/render/gold_hammer.png");
	protected static final ResourceLocation texture4 = new ResourceLocation("wolf_addons:textures/items/render/diamond_hammer.png");
	protected static final ResourceLocation texture5 = new ResourceLocation("wolf_addons:textures/items/render/silver_hammer.png");
	protected static final ResourceLocation texture6 = new ResourceLocation("wolf_addons:textures/items/render/redstone_hammer.png");
	protected static final ResourceLocation texture7 = new ResourceLocation("wolf_addons:textures/items/render/lapis_hammer.png");
	protected static final ResourceLocation texture8 = new ResourceLocation("wolf_addons:textures/items/render/emerald_hammer.png");
	protected ModelHammer model;

	public RenderHammer()
	{
		model = new ModelHammer();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch (type)
		{
		case EQUIPPED:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		switch (type)
		{
		case EQUIPPED:
		{
			if (item.getItem().equals(WolfItemList.woodHammer))
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture0);
				GL11.glRotatef(-105F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(-0.4F, 0.0F, 0.0F);
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			else if (item.getItem().equals(WolfItemList.stoneHammer))
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture1);
				GL11.glRotatef(-105F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(-0.4F, 0.0F, 0.0F);
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			else if (item.getItem().equals(WolfItemList.ironHammer))
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture2);
				GL11.glRotatef(-105F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(-0.4F, 0.0F, 0.0F);
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			else if (item.getItem().equals(WolfItemList.goldHammer))
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture3);
				GL11.glRotatef(-105F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(-0.4F, 0.0F, 0.0F);
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			else if (item.getItem().equals(WolfItemList.diamondHammer))
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture4);
				GL11.glRotatef(-105F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(-0.4F, 0.0F, 0.0F);
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			else if (item.getItem().equals(WolfItemList.silverHammer))
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture5);
				GL11.glRotatef(-105F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(-0.4F, 0.0F, 0.0F);
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			else if (item.getItem().equals(WolfItemList.redstoneHammer))
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture6);
				GL11.glRotatef(-105F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(-0.4F, 0.0F, 0.0F);
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			else if (item.getItem().equals(WolfItemList.lapisHammer))
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture7);
				GL11.glRotatef(-105F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(-0.4F, 0.0F, 0.0F);
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			else
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture8);
				GL11.glRotatef(-105F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(-0.4F, 0.0F, 0.0F);
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			break;
		}
		default:
			break;
		}
	}
}
