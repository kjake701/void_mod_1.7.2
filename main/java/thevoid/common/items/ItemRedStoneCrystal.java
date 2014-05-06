
package thevoid.common.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemRedStoneCrystal extends Item
{
	private static final String RSC = "void:RedStoneCrystal";
public ItemRedStoneCrystal(int id, int texture)
{
super();
this.setCreativeTab(CreativeTabs.tabMaterials);
}

public void registerIcons(IIconRegister par1IconRegister)
{
    this.itemIcon = par1IconRegister.registerIcon((this.RSC));
}

public String getTextureFile()
    {
            return "/RedWood/MainTexture.png";
    }
}