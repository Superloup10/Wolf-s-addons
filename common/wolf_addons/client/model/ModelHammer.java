package wolf_addons.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHammer extends ModelBase
{
  //fields
    ModelRenderer Tete;
    ModelRenderer Manche;
  
  public ModelHammer()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Tete = new ModelRenderer(this, 0, 0);
      Tete.addBox(-4F, -2F, -2F, 8, 4, 4);
      Tete.setRotationPoint(0F, 0F, 0F);
      Tete.setTextureSize(32, 32);
      Tete.mirror = true;
      setRotation(Tete, 0F, 0F, 0F);
      Manche = new ModelRenderer(this, 7, 8);
      Manche.addBox(-1F, -11F, -1F, 2, 12, 2);
      Manche.setRotationPoint(0F, 13F, 0F);
      Manche.setTextureSize(32, 32);
      Manche.mirror = true;
      setRotation(Manche, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Tete.render(f5);
    Manche.render(f5);
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