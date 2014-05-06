package thevoid.common.util;

import org.lwjgl.input.Keyboard;

import thevoid.common.mob.EntityKitty;
import thevoid.common.mob.ModelKitty;
import thevoid.common.mob.RenderKitty;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyBlackDiamond extends CommonProxyBlackDiamond
{
 @Override
  public void registerRenderThings()
 {
   RenderingRegistry.registerEntityRenderingHandler(EntityKitty.class, new RenderKitty(new ModelKitty(), 0.3F));
 }
}