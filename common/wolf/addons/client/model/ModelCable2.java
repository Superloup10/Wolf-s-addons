/*******************************************************************************
 * Copyright (c) 2015, Superloup10
 * 
 * Wolf's Addons is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://www.dropbox.com/s/6l16rc7b1aks211/MMPL-1.0.txt
 ******************************************************************************/
package wolf.addons.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelCable2 extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;

    public ModelCable2()
    {
        textureWidth = 32;
        textureHeight = 32;

        Shape1 = new ModelRenderer(this, 0, 0);
        Shape1.mirror = true;
        Shape1.addBox(-2.5F, -2.5F, -7.5F, 5, 1, 1);
        Shape1.setRotationPoint(0F, 21.5F, 0F);
        Shape1.setTextureSize(32, 32);
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 0, 0);
        Shape2.mirror = true;
        Shape2.addBox(-2.5F, 1.5F, -7.5F, 5, 1, 1);
        Shape2.setRotationPoint(0F, 21.5F, 0F);
        Shape2.setTextureSize(32, 32);
        setRotation(Shape2, 0F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 0, 0);
        Shape3.mirror = true;
        Shape3.addBox(-2.5F, -2.5F, 1.5F, 5, 1, 1);
        Shape3.setRotationPoint(0F, 21.5F, 0F);
        Shape3.setTextureSize(32, 32);
        setRotation(Shape3, 0F, 0F, 0F);
        Shape4 = new ModelRenderer(this, 0, 0);
        Shape4.mirror = true;
        Shape4.addBox(-2.5F, 1.5F, 1.5F, 5, 1, 1);
        Shape4.setRotationPoint(0F, 21.5F, 0F);
        Shape4.setTextureSize(32, 32);
        setRotation(Shape4, 0F, 0F, 0F);
        Shape5 = new ModelRenderer(this, 0, 0);
        Shape5.mirror = true;
        Shape5.addBox(-1.5F, -2.5F, -2.5F, 8, 1, 1);
        Shape5.setRotationPoint(0F, 21.5F, 0F);
        Shape5.setTextureSize(32, 32);
        setRotation(Shape5, 0F, 1.570796F, 0F);
        Shape6 = new ModelRenderer(this, 0, 0);
        Shape6.mirror = true;
        Shape6.addBox(-1.5F, -2.5F, 1.5F, 8, 1, 1);
        Shape6.setRotationPoint(0F, 21.5F, 0F);
        Shape6.setTextureSize(32, 32);
        setRotation(Shape6, 0F, 1.570796F, 0F);
        Shape7 = new ModelRenderer(this, 0, 0);
        Shape7.mirror = true;
        Shape7.addBox(-1.5F, 1.5F, -2.5F, 8, 1, 1);
        Shape7.setRotationPoint(0F, 21.5F, 0F);
        Shape7.setTextureSize(32, 32);
        setRotation(Shape7, 0F, 1.570796F, 0F);
        Shape8 = new ModelRenderer(this, 0, 0);
        Shape8.mirror = true;
        Shape8.addBox(-1.5F, 1.5F, 1.5F, 8, 1, 1);
        Shape8.setRotationPoint(0F, 21.5F, 0F);
        Shape8.setTextureSize(32, 32);
        setRotation(Shape8, 0F, 1.570796F, 0F);
        Shape9 = new ModelRenderer(this, 0, 0);
        Shape9.mirror = true;
        Shape9.addBox(-1.5F, -2.5F, -7.5F, 3, 1, 1);
        Shape9.setRotationPoint(0F, 21.5F, 0F);
        Shape9.setTextureSize(32, 32);
        setRotation(Shape9, 0F, 0F, 1.570796F);
        Shape10 = new ModelRenderer(this, 0, 0);
        Shape10.mirror = true;
        Shape10.addBox(-1.5F, -2.5F, 1.5F, 3, 1, 1);
        Shape10.setRotationPoint(0F, 21.5F, 0F);
        Shape10.setTextureSize(32, 32);
        setRotation(Shape10, 0F, 0F, 1.570796F);
        Shape11 = new ModelRenderer(this, 0, 0);
        Shape11.mirror = true;
        Shape11.addBox(-1.5F, 1.5F, -7.5F, 3, 1, 1);
        Shape11.setRotationPoint(0F, 21.5F, 0F);
        Shape11.setTextureSize(32, 32);
        setRotation(Shape11, 0F, 0F, 1.570796F);
        Shape12 = new ModelRenderer(this, 0, 0);
        Shape12.mirror = true;
        Shape12.addBox(-1.5F, 1.5F, 1.5F, 3, 1, 1);
        Shape12.setRotationPoint(0F, 21.5F, 0F);
        Shape12.setTextureSize(32, 32);
        setRotation(Shape12, 0F, 0F, 1.570796F);
    }

    public void renderAll()
    {
        Shape1.render(0.0625F);
        Shape2.render(0.0625F);
        Shape3.render(0.0625F);
        Shape4.render(0.0625F);
        Shape5.render(0.0625F);
        Shape6.render(0.0625F);
        Shape7.render(0.0625F);
        Shape8.render(0.0625F);
        Shape9.render(0.0625F);
        Shape10.render(0.0625F);
        Shape11.render(0.0625F);
        Shape12.render(0.0625F);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}