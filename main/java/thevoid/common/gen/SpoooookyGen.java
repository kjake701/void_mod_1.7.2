
package thevoid.common.gen;

import java.util.Random;

import thevoid.common.TheVoid;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;


public class SpoooookyGen extends WorldGenerator
{
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        while (par1World.isAirBlock(par3, par4, par5) && par4 > 2)
        {
            --par4;
        }
        
        par1World.setBlock(par3, ++par4, par5, TheVoid.spoooookyLantern);
        return true;
    }
}