/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.client.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import wolf.addons.common.tileentity.TileEntityCable;

public class TESRCable extends TileEntitySpecialRenderer
{
    private static final ResourceLocation texture = new ResourceLocation("wolf_addons:textures/blocks/cable1.png");
    private final boolean drawInside = true;
    private final float pixel = 1F / 16F;
    private final float pixel_texture = 1F / 32F;

    public TESRCable()
    {
        this.setRendererDispatcher(TileEntityRendererDispatcher.instance);
    }

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale, int p_180535_9_)
    {
        GL11.glTranslated(x, y, z);
        GL11.glDisable(GL11.GL_LIGHTING);
        this.bindTexture(texture);
        {
            this.renderCore((TileEntityCable)te);

            TileEntityCable cable = (TileEntityCable)te;
            for(int i = 0; i < cable.direction.length; i++)
            {
                if(cable.direction[i] != null)
                {
                    System.out.println("direction : " + cable.direction[i]);
                    this.renderDirectional(cable.direction[i]);
                }
            }
        }
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glTranslated(-x, -y, -z);
    }

    private void renderDirectional(EnumFacing direction)
    {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.startDrawingQuads();
        {
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            switch(direction)
            {
            case NORTH:
                GL11.glRotatef(270F, 1F, 0F, 0F);
                break;
            case SOUTH:
                GL11.glRotatef(90F, 1F, 0F, 0F);
                break;
            case WEST:
                GL11.glRotatef(90F, 0F, 0F, 1F);
                break;
            case EAST:
                GL11.glRotatef(270F, 0F, 0F, 1F);
                break;
            case UP:
                break;
            case DOWN:
                GL11.glRotatef(180F, 1F, 0F, 0F);
                break;
            }
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * pixel_texture, 5 * pixel_texture);
            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * pixel_texture, 5 * pixel_texture);
            worldrenderer.addVertexWithUV(11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * pixel_texture, 0 * pixel_texture);
            worldrenderer.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * pixel_texture, 0 * pixel_texture);

            worldrenderer.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * pixel_texture, 5 * pixel_texture);
            worldrenderer.addVertexWithUV(11 * pixel / 2, 1, 11 * pixel / 2, 10 * pixel_texture, 5 * pixel_texture);
            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1, 11 * pixel / 2, 10 * pixel_texture, 0 * pixel_texture);
            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * pixel_texture, 0 * pixel_texture);

            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * pixel_texture, 5 * pixel_texture);
            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1, 11 * pixel / 2, 10 * pixel_texture, 5 * pixel_texture);
            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * pixel_texture, 0 * pixel_texture);
            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * pixel_texture, 0 * pixel_texture);

            worldrenderer.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * pixel_texture, 5 * pixel_texture);
            worldrenderer.addVertexWithUV(11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * pixel_texture, 5 * pixel_texture);
            worldrenderer.addVertexWithUV(11 * pixel / 2, 1, 11 * pixel / 2, 10 * pixel_texture, 0 * pixel_texture);
            worldrenderer.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * pixel_texture, 0 * pixel_texture);
        }
        tessellator.draw();

        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        switch(direction)
        {
        case NORTH:
            GL11.glRotatef(-270F, 1F, 0F, 0F);
            break;
        case SOUTH:
            GL11.glRotatef(-90F, 1F, 0F, 0F);
            break;
        case WEST:
            GL11.glRotatef(-90F, 0F, 0F, 1F);
            break;
        case EAST:
            GL11.glRotatef(-270F, 0F, 0F, 1F);
            break;
        case UP:
            break;
        case DOWN:
            GL11.glRotatef(-180F, 1F, 0F, 0F);
            break;
        }
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
    }

    private void renderCore(TileEntityCable te)
    {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.startDrawingQuads();
        {
            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * pixel_texture, 5 * pixel_texture);
            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * pixel_texture, 0 * pixel_texture);
            worldrenderer.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * pixel_texture, 0 * pixel_texture);
            worldrenderer.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * pixel_texture, 5 * pixel_texture);

            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 5 * pixel_texture, 5 * pixel_texture);
            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * pixel_texture, 0 * pixel_texture);
            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * pixel_texture, 0 * pixel_texture);
            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * pixel_texture, 5 * pixel_texture);

            worldrenderer.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 5 * pixel_texture, 5 * pixel_texture);
            worldrenderer.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * pixel_texture, 0 * pixel_texture);
            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 0 * pixel_texture, 0 * pixel_texture);
            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 0 * pixel_texture, 5 * pixel_texture);

            worldrenderer.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * pixel_texture, 5 * pixel_texture);
            worldrenderer.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * pixel_texture, 0 * pixel_texture);
            worldrenderer.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 0 * pixel_texture, 0 * pixel_texture);
            worldrenderer.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 0 * pixel_texture, 5 * pixel_texture);

            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * pixel_texture, 5 * pixel_texture);
            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * pixel_texture, 0 * pixel_texture);
            worldrenderer.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 0 * pixel_texture, 0 * pixel_texture);
            worldrenderer.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * pixel_texture, 5 * pixel_texture);

            worldrenderer.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * pixel_texture, 5 * pixel_texture);
            worldrenderer.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 5 * pixel_texture, 0 * pixel_texture);
            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 0 * pixel_texture, 0 * pixel_texture);
            worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * pixel_texture, 5 * pixel_texture);

            if(drawInside)
            {
                worldrenderer.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * pixel_texture, 5 * pixel_texture);
                worldrenderer.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * pixel_texture, 0 * pixel_texture);
                worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * pixel_texture, 5 * pixel_texture);
                worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * pixel_texture, 0 * pixel_texture);

                worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * pixel_texture, 5 * pixel_texture);
                worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * pixel_texture, 0 * pixel_texture);
                worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * pixel_texture, 0 * pixel_texture);
                worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 5 * pixel_texture, 5 * pixel_texture);

                worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 0 * pixel_texture, 5 * pixel_texture);
                worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 0 * pixel_texture, 0 * pixel_texture);
                worldrenderer.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * pixel_texture, 0 * pixel_texture);
                worldrenderer.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 5 * pixel_texture, 5 * pixel_texture);

                worldrenderer.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * pixel_texture, 5 * pixel_texture);
                worldrenderer.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * pixel_texture, 0 * pixel_texture);
                worldrenderer.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 0 * pixel_texture, 0 * pixel_texture);
                worldrenderer.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 0 * pixel_texture, 5 * pixel_texture);

                worldrenderer.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * pixel_texture, 5 * pixel_texture);
                worldrenderer.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 0 * pixel_texture, 0 * pixel_texture);
                worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * pixel_texture, 0 * pixel_texture);
                worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * pixel_texture, 5 * pixel_texture);

                worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * pixel_texture, 5 * pixel_texture);
                worldrenderer.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 0 * pixel_texture, 0 * pixel_texture);
                worldrenderer.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 5 * pixel_texture, 0 * pixel_texture);
                worldrenderer.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 5 * pixel_texture, 5 * pixel_texture);
            }
        }
        tessellator.draw();
    }
}