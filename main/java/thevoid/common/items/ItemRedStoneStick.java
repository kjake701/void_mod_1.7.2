package thevoid.common.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemRedStoneStick extends Item
{
	private static final String RSST = "void:RedStoneStick";
	public static final String[][] field_82804_b = new String[][] {{"RedStoneStick"}};
    public ItemRedStoneStick(int par1)
    {
        super();
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
    
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon((this.RSST));
    }

    /**
     * Checks isDamagable and if it cannot be stacked
     */
    public boolean isItemTool(ItemStack par1ItemStack)
    {
        return par1ItemStack.stackSize == 1;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }
}
