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
import net.minecraft.entity.Entity;

public class ModelHammer extends ModelBase
{
	// fields
	ModelRenderer tete;
	ModelRenderer manche;

	public ModelHammer()
	{
		textureWidth = 32;
		textureHeight = 32;

		tete = new ModelRenderer(this, 0, 0);
		tete.addBox(-4F, -2F, -2F, 8, 4, 4);
		tete.setRotationPoint(0F, 0F, 0F);
		tete.setTextureSize(32, 32);
		tete.mirror = true;
		setRotation(tete, 0F, 0F, 0F);
		manche = new ModelRenderer(this, 7, 8);
		manche.addBox(-1F, -11F, -1F, 2, 12, 2);
		manche.setRotationPoint(0F, 13F, 0F);
		manche.setTextureSize(32, 32);
		manche.mirror = true;
		setRotation(manche, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		tete.render(f5);
		manche.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}
