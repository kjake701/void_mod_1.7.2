package thevoid.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBlackDiamond extends Block 
{
public BlockBlackDiamond(int id, int texture)
 {
 super(Material.wood);
 this.setCreativeTab(CreativeTabs.tabBlock);
 }

}