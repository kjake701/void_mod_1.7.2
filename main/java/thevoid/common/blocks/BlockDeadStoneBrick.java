package thevoid.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;





import thevoid.common.TheVoid;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockDeadStoneBrick extends Block
{
    public static final String[] field_150142_a = new String[] {"Dead"};
    public static final String[] field_150141_b = new String[] {"Dead"};
	
    @SideOnly(Side.CLIENT)
    private IIcon[] field_150143_M;

    private static final String DSB = "void:DeadStoneBrick";
    
    public BlockDeadStoneBrick(int par1)
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
              if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = par2 + par5Random.nextInt(3) - 1;
                    int j1 = par3 + par5Random.nextInt(5) - 3;
                    int k1 = par4 + par5Random.nextInt(3) - 1;
                    int l1 = par1World.getBlockMetadata(i1, j1 + 1, k1);

                    if (par1World.getBlock(i1, j1, k1) == Blocks.stonebrick  && par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4 && par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                        par1World.setBlock(i1, j1, k1, TheVoid.deadStoneBrick);
                    }
                    
                }
            }
        }
    }



    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        if (p_149691_2_ < 0 || p_149691_2_ >= field_150141_b.length)
        {
            p_149691_2_ = 0;
        }

        return this.field_150143_M[p_149691_2_];
    }
    


    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.field_150143_M = new IIcon[field_150141_b.length];

        for (int i = 0; i < this.field_150143_M.length; ++i)
        {
            String s = this.getTextureName();

            if (field_150141_b[i] != null)
            {
                s = s + "_" + field_150141_b[i];
            }

            this.field_150143_M[i] = p_149651_1_.registerIcon(s);
        }
    }


    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return par1;
    }
}
