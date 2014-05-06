package thevoid.common.gen;

import java.util.Random;







import thevoid.common.TheVoid;
import thevoid.common.dimension.biome.BiomeGraveyard;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class DeadTreeGen implements IWorldGenerator 
{
public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
{
switch (world.provider.dimensionId)
{
case 5: generateTheVoid(world, random, chunkX*16, chunkZ*16);
}
}

private void generateTheVoid(World world, Random random, int blockX, int blockZ) {
	int Xcoord2 = blockX + random.nextInt(16);
	int Ycoord2 = random.nextInt(80);
	int Zcoord2 = blockZ + random.nextInt(16);
	(new SpoooookyGen()).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	
	//treegen
	
	BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(blockX, blockZ); 
    WorldGenRedWood tree = new WorldGenRedWood(true, 20, 40, 50, true); 
		
     if((biome instanceof BiomeGraveyard));
     { 
     	for(int x = 0; x < 2; x++)
     	{
     		int Xcoord = blockX + random.nextInt(16); 
     		int Zcoord = blockZ + random.nextInt(16); 
     		int i = world.getHeightValue(Xcoord, Zcoord); 
     		tree.generate(world, random, Xcoord, i, Zcoord); 
     	}
     	
     } 
}






}