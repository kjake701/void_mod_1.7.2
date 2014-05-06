package thevoid.common.blocks;

import java.util.Random;

import thevoid.common.TheVoid;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class BlockBlackDiamondOre extends Block
{
	
	private static final String BDO = "rs:BlackDiamondOre";
	
    public BlockBlackDiamondOre(int par1, int par2)
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return this == TheVoid.blackDiamondOre ? TheVoid.blackDiamond : Item.getItemFromBlock(this);
    }
    
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon((this.BDO));
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
   
    public int quantityDropped(Random p_149745_1_)
    {
        return this == Blocks.lapis_ore ? 4 + p_149745_1_.nextInt(5) : 1;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        if (par1 > 0 && this.blockIcon != this.getItemDropped(0, par2Random, par1))
        {
            int var3 = par2Random.nextInt(par1 + 2) - 1;

            if (var3 < 0)
            {
                var3 = 0;
            }

            return this.quantityDropped(par2Random) * (var3 + 1);
        }
        else
        {
            return this.quantityDropped(par2Random);
        }
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);

        if (this.getItemDropped(par5, par1World.rand, par7) != this.blockIcon)
        {
           int var8 = 0;
     
            if (this.blockIcon == TheVoid.blackDiamondOre)
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
            }
            
            this.dropXpOnBlockBreak(par1World, par2, par3, par4, var8);
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    
    
}
