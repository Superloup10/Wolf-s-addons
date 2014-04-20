package wolf_addons.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import wolf_addons.client.model.ModelHammer;
import wolf_addons.common.item.WolfItemList;

public class RenderHammer implements IItemRenderer
{
	protected ModelHammer model;
	protected static final ResourceLocation texture0 = new ResourceLocation("wolf_addons:textures/items/wood_hammer.png");
	protected static final ResourceLocation texture1 = new ResourceLocation("wolf_addons:textures/items/stone_hammer.png");
	protected static final ResourceLocation texture2 = new ResourceLocation("wolf_addons:textures/items/iron_hammer.png");
	protected static final ResourceLocation texture3 = new ResourceLocation("wolf_addons:textures/items/gold_hammer.png");
	protected static final ResourceLocation texture4 = new ResourceLocation("wolf_addons:textures/items/diamond_hammer.png");
	protected static final ResourceLocation texture5 = new ResourceLocation("wolf_addons:textures/items/silver_hammer.png");
	protected static final ResourceLocation texture6 = new ResourceLocation("wolf_addons:textures/items/redstone_hammer.png");
	protected static final ResourceLocation texture7 = new ResourceLocation("wolf_addons:textures/items/lapis_hammer.png");
	protected static final ResourceLocation texture8 = new ResourceLocation("wolf_addons:textures/items/emerald_hammer.png");

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
		switch(type)
		{
		case EQUIPPED:
		{
			if(item.getItem().equals(WolfItemList.woodHammer))
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture0);
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			else if(item.getItem().equals(WolfItemList.stoneHammer))
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture1);
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			else if(item.getItem().equals(WolfItemList.ironHammer))
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture2);
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			else if(item.getItem().equals(WolfItemList.goldHammer))
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture3);
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			else if(item.getItem().equals(WolfItemList.diamondHammer))
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture4);
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			else if(item.getItem().equals(WolfItemList.silverHammer))
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture5);
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			else if(item.getItem().equals(WolfItemList.redstoneHammer))
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture6);
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			else if(item.getItem().equals(WolfItemList.lapisHammer))
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture7);
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			else
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture8);
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