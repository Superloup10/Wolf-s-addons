package wolf.addons.client.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import wolf.addons.client.model.ModelCable;
import wolf.addons.common.tileentity.TileEntityCable;

public class TESRCable extends TileEntitySpecialRenderer
{
    private static final ModelCable model = new ModelCable();
    private static final ResourceLocation texture = new ResourceLocation("wolf_addons:textures/blocks/cable.png");

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float p_180535_8_, int p_180535_9_)
    {
        this.render((TileEntityCable)te, x, y, z, p_180535_8_, p_180535_9_);
    }

    public void render(TileEntityCable te, double x, double y, double z, float p_180535_8_, int p_180535_9_)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5D, y + 1.5D, z + 0.5D);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        this.bindTexture(texture);
        model.renderAll();
        GL11.glPopMatrix();
    }
}