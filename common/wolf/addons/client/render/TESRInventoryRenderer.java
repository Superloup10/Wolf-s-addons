/*
 * package wolf.addons.client.render; import eu.thog92.isbrh.render.ISimpleBlockRenderingHandler; import eu.thog92.isbrh.render.TextureLoader; import net.minecraft.block.state.IBlockState; import net.minecraft.client.Minecraft; import net.minecraft.client.renderer.WorldRenderer; import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType; import
 * net.minecraft.client.renderer.texture.TextureAtlasSprite; import net.minecraft.item.ItemStack; import net.minecraft.util.BlockPos; import net.minecraft.util.EnumFacing; import net.minecraft.world.IBlockAccess; import org.lwjgl.opengl.GL11; import wolf.addons.common.block.WolfBlockList; import wolf.addons.proxy.WolfClientProxy; public class TESRInventoryRenderer implements
 * ISimpleBlockRenderingHandler {
 * @Override public int getRenderId() { return WolfClientProxy.tesrRenderId; }
 * @Override public TextureAtlasSprite getSidedTexture(EnumFacing arg0) { return null; }
 * @Override public void loadTextures(TextureLoader arg0) { }
 * @Override public void renderBlockBrightness(int arg0, IBlockState arg1, float arg2) { }
 * @Override public void renderInventoryBlock(ItemStack stack, TransformType type, int arg2) { if(stack.equals(new ItemStack(WolfBlockList.cable))) { GL11.glPushMatrix(); GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F); GL11.glTranslatef(0.0F, -1.0F, 0.0F); Minecraft.getMinecraft().getTextureManager().bindTexture(TESRCable.texture); TESRCable.model.renderAll(); GL11.glPopMatrix(); } }
 * @Override public boolean renderWorldBlock(IBlockAccess arg0, BlockPos arg1, IBlockState arg2, int arg3, WorldRenderer arg4) { return false; }
 * @Override public boolean shouldRender3DInInventory(int arg0) { return true; } }
 */