package thevoid.common.gen;

import java.util.Random;

import thevoid.common.dimension.biome.BiomeGraveyard;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenDesert;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.biome.BiomeGenHills;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.biome.BiomeGenSnow;
import net.minecraft.world.biome.BiomeGenSwamp;
import net.minecraft.world.biome.BiomeGenTaiga;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import cpw.mods.fml.common.IWorldGenerator;

public class BDWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		switch(world.provider.dimensionId){
			
		case 5: generateVoid(world, random, chunkX * 16, chunkZ * 16);
		}
	}
	
	private void generateVoid(World world, Random random, int BlockX, int BlockZ) {
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(BlockX, BlockZ); 
		if((biome instanceof BiomeGenPlains))
		{
	// TODO Auto-generated method stub
			for(int i = 0; i < 20; i++){
				int Xcoord1 = BlockX + random.nextInt(16);
				int Ycoord1 = random.nextInt(90);
				int Zcoord1 = BlockZ + random.nextInt(16);
				(new WorldGenRedWood(false, 6, 0, 0, false)).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
			}
		}
	}

}