package thevoid.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import thevoid.common.TheVoid;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockGraveYardGrass extends Block
{
	
    @SideOnly(Side.CLIENT)
    private IIcon theIcon;
    @SideOnly(Side.CLIENT)
    private IIcon field_149991_b;
    @SideOnly(Side.CLIENT)
    private IIcon field_149993_M;
    @SideOnly(Side.CLIENT)
    private IIcon field_149994_N;
    
    public BlockGraveYardGrass(int par1)
    {
        super(Material.grass);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setTickRandomly(true);
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2)
            {
                par1World.setBlock(par2, par3, par4, TheVoid.graveYardDirt);
            }
            else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = par2 + par5Random.nextInt(3) - 1;
                    int j1 = par3 + par5Random.nextInt(5) - 3;
                    int k1 = par4 + par5Random.nextInt(3) - 1;
                    int l1 = par1World.getBlockMetadata(i1, j1 + 1, k1);

                    if (par1World.getBlock(i1, j1, k1) == TheVoid.graveYardDirt  && par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4 && par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                        par1World.setBlock(i1, j1, k1, TheVoid.graveYardGrass);
                    }
                    
                    if (par1World.getBlock(i1, j1, k1) == Blocks.dirt && par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4 && par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                        par1World.setBlock(i1, j1, k1, TheVoid.graveYardGrass);
                    }
                    
                    if (par1World.getBlock(i1, j1, k1) == Blocks.grass && par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4 && par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                        par1World.setBlock(i1, j1, k1, TheVoid.graveYardGrass);
                    }
                    
                }
            }
        }
    }
    
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(TheVoid.graveYardGrass);
    }
    
    protected boolean canSilkHarvest()
    {
        return true;
    }
    
    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.field_149991_b : (p_149691_1_ == 0 ? Blocks.dirt.getBlockTextureFromSide(p_149691_1_) : this.blockIcon);
    }


    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(this.getTextureName() + "_side");
        this.field_149991_b = p_149651_1_.registerIcon(this.getTextureName() + "_top");
    }
    
    
    
}
