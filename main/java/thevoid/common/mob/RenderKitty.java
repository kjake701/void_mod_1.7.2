package thevoid.common.mob;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelBase;


public class RenderKitty extends RenderLiving
{
 private static final ResourceLocation KittyTexture = new ResourceLocation("void:MobKitty/Kitty.png");
 protected ModelKitty model;
 
public RenderKitty (ModelKitty modelKitty, float f)
 {
	 super(modelKitty, f);
	 model = ((ModelKitty)mainModel);
 }
 
 public void renderKitty(EntityKitty entity, double par2, double par4, double par6, float par8, float par9)
 {
	 super.doRender(entity, par2, par4, par6, par8, par9);
 }
 
 public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
 {
	 renderKitty((EntityKitty)par1EntityLiving, par2, par4, par6, par8, par9);
 }
 
 public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
 {
	 renderKitty((EntityKitty)par1Entity, par2, par4, par6, par8, par9);
 }

@Override
protected ResourceLocation getEntityTexture(Entity entity) {
	return KittyTexture;
}
}