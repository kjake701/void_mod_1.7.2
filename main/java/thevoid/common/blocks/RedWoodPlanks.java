
package thevoid.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class RedWoodPlanks extends Block 
{
private static final String RedWoodPlanks = "rs:RedWoodPlanks";
public RedWoodPlanks(int id, int texture)
 {
 super(Material.wood);
 this.setCreativeTab(CreativeTabs.tabBlock);
 }

public void registerIcons(IIconRegister par1IconRegister)
{
    this.blockIcon = par1IconRegister.registerIcon((this.RedWoodPlanks));
}

public String getTextureFile()
 {
	return "/RedWood/green.png";
 }
}