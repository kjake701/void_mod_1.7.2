package thevoid.common.blocks;

import java.util.Random;

import thevoid.common.TheVoid;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class BlockDeadCobblestone extends Block
{
	private static final String RedLogTop2 = "rs:DeadStone2";
	
    public BlockDeadCobblestone(int par1)
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setTickRandomly(true);
    }
    



    protected boolean canSilkHarvest()
    {
        return true;
    }
    
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon((this.RedLogTop2));
    }
}
