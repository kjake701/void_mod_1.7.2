package thevoid.common.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RedStonePickPart2 extends Item
{
	private static final String RSPP2 = "void:RedStonePickPart2";
	public static final String[][] field_82804_b = new String[][] {{"RedStonePickPart2"}};
    public RedStonePickPart2(int par1)
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
        this.itemIcon = par1IconRegister.registerIcon((this.RSPP2));
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }
}
