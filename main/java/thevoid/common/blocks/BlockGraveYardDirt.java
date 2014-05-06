package thevoid.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockGraveYardDirt extends Block {
	
	public BlockGraveYardDirt(int par1) {
		super(Material.ground);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	

}
