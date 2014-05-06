package thevoid.common.gen;

import java.util.Random;





import thevoid.common.TheVoid;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class DeadBrickGraveGen implements IWorldGenerator 
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
}

private void generateSurface(World world, Random random, int blockX, int blockZ) 
{
int Xcoord = blockX + random.nextInt(16);
int Ycoord = random.nextInt(60);
int Zcoord = blockZ + random.nextInt(16);

(new WorldGenMinable(TheVoid.graveYardGrass, 10)).generate(world, random, Xcoord, Ycoord, Zcoord);

int Xcoord1 = blockX + random.nextInt(16);
int Ycoord1 = random.nextInt(80);
int Zcoord1 = blockZ + random.nextInt(16);

(new DeadBrickGrave()).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
}

private void generateNether(World world, Random random, int blockX, int blockZ) 
{
int Xcoord = blockX + random.nextInt(16);
int Ycoord = random.nextInt(60);
int Zcoord = blockZ + random.nextInt(16);

}




}