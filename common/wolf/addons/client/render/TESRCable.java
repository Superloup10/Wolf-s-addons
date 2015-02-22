/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.client.render;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import wolf.addons.client.model.ModelCable;
import wolf.addons.client.model.ModelCable2;
import wolf.addons.common.tileentity.TileEntityCable;

public class TESRCable extends TileEntitySpecialRenderer
{
    protected static final ModelCable model = new ModelCable();
    protected static final ModelCable2 model2 = new ModelCable2();
    protected static final ResourceLocation texture = new ResourceLocation("wolf_addons:textures/blocks/cable.png");
    protected static final ResourceLocation texture2 = new ResourceLocation("wolf_addons:textures/blocks/cable2.png");

    public TESRCable()
    {
        this.setRendererDispatcher(TileEntityRendererDispatcher.instance);
    }

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float p_180535_8_, int p_180535_9_)
    {
        TileEntityCable tileEntity = (TileEntityCable)te;
        if(tileEntity.render[0])
            this.renderDirectional((TileEntityCable)te, x, y, z, p_180535_8_, 0F);
        if(tileEntity.render[1])
            this.renderDirectional((TileEntityCable)te, x, y, z, p_180535_8_, 180F);
        if(tileEntity.render[2])
            this.renderDirectional((TileEntityCable)te, x, y, z, p_180535_8_, 270F);
        if(tileEntity.render[3])
            this.renderDirectional((TileEntityCable)te, x, y, z, p_180535_8_, 90F);
        if(tileEntity.render[4])
            this.renderDirectionalAxeNegY((TileEntityCable)te, x, y, z, p_180535_8_);
        if(tileEntity.render[5])
            this.renderDirectionalAxePosY((TileEntityCable)te, x, y, z, p_180535_8_);
        this.renderCore((TileEntityCable)te, x, y, z, p_180535_8_, p_180535_9_);
    }

    private void renderDirectionalAxePosY(TileEntityCable te, double x, double y, double z, float p_180535_8_)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5D, y + 1.5D, z + 0.5D);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
        GL11.glTranslatef(0.0F, -1.313F, -0.69F);
        this.bindTexture(texture2);
        model2.renderAll();
        GL11.glPopMatrix();
    }

    private void renderDirectionalAxeNegY(TileEntityCable te, double x, double y, double z, float p_180535_8_)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5D, y + 1.5D, z + 0.5D);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(1.0F, 1.0F, 1.05F);
        GL11.glTranslatef(0.0F, -1.313F, -1.24F);
        this.bindTexture(texture2);
        model2.renderAll();
        GL11.glPopMatrix();
    }

    private void renderDirectional(TileEntityCable te, double x, double y, double z, float p_180535_8_, float angle)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5D, y + 1.5D, z + 0.5D);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(angle, 0.0F, 1.0F, 0.0F);
        this.bindTexture(texture2);
        model2.renderAll();
        GL11.glPopMatrix();
    }

    public void renderCore(TileEntityCable te, double x, double y, double z, float p_180535_8_, int p_180535_9_)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5D, y + 1.5D, z + 0.5D);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(0F, 0.0F, 1.0F, 1.0F);
        this.bindTexture(texture);
        model.renderAll();
        GL11.glPopMatrix();
    }
}