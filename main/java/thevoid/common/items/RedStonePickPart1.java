package thevoid.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RedStonePickPart1 extends Item
{
	private static final String RSPP1 = "void:RedStonePickPart1";
	public static final String[][] field_82804_b = new String[][] {{"RedStonePickPart1"}};
    public RedStonePickPart1(int par1)
    {
        super();
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    /**
     * Checks isDamagable and if it cannot be stacked
     */
    public boolean isItemTool(ItemStack par1ItemStack)
    {
        return par1ItemStack.stackSize == 1;
    }
    
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon((this.RSPP1));
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }
}
