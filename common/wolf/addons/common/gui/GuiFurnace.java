/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.common.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wolf.addons.common.block.container.ContainerFurnace;
import wolf.addons.common.tileentity.TileEntityFurnace;

@SideOnly(Side.CLIENT)
public class GuiFurnace extends GuiContainer
{
    private static ResourceLocation texture = new ResourceLocation("wolf_addons:textures/gui/gui_furnace.png");

    private InventoryPlayer inventoryPlayer;

    private IInventory furnace;

    public GuiFurnace(InventoryPlayer inventory, IInventory te)
    {
        super(new ContainerFurnace(inventory, te));
        this.inventoryPlayer = inventory;
        this.furnace = te;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = this.furnace.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(this.inventoryPlayer.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;

        if(TileEntityFurnace.isBurning(this.furnace))
        {
            i1 = this.func_175382_i(13);
            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
        }

        i1 = this.func_175381_h(24);
        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
    }

    private int func_175381_h(int p_175381_1_)
    {
        int j = this.furnace.getField(2);
        int k = this.furnace.getField(3);
        return k != 0 && j != 0 ? j * p_175381_1_ / k : 0;
    }

    private int func_175382_i(int p_175382_1_)
    {
        int j = this.furnace.getField(1);

        if(j == 0)
        {
            j = 200;
        }

        return this.furnace.getField(0) * p_175382_1_ / j;
    }
}