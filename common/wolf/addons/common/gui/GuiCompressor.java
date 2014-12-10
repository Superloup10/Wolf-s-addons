/*******************************************************************************
 * Copyright (c) 2014, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://dl.dropboxusercontent.com/u/135157801/License/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import wolf.addons.common.block.container.ContainerCompressor;
import wolf.addons.common.tileentity.TileEntityCompressor;

public class GuiCompressor extends GuiContainer
{
    private static final ResourceLocation craftingTableGuiTextures = new ResourceLocation("textures/gui/container/crafting_table.png");

    private TileEntityCompressor compressor;

    public GuiCompressor(InventoryPlayer inventory, TileEntityCompressor te)
    {
        super(new ContainerCompressor(inventory, te));
        this.compressor = te;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        String s = this.compressor.hasCustomName() ? this.compressor.getName() : StatCollector.translateToLocal(this.compressor.getName());
        this.fontRendererObj.drawString(s, 28, 6, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(craftingTableGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}