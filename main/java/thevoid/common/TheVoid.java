package thevoid.common;

import java.util.Random;

import org.apache.logging.log4j.EventLogger;

import thevoid.common.blocks.BlockBlackDiamondOre;
import thevoid.common.blocks.BlockDeadCobblestone;
import thevoid.common.blocks.BlockDeadStone;
import thevoid.common.blocks.BlockDeadStoneBrick;
import thevoid.common.blocks.BlockGraveYardDirt;
import thevoid.common.blocks.BlockGraveYardGrass;
import thevoid.common.blocks.BlockRLog;
import thevoid.common.blocks.BlockRedStoneCrystal;
import thevoid.common.blocks.BlockRedStoneCrystalGlowing;
import thevoid.common.blocks.BlockRedWoodSapling;
import thevoid.common.blocks.BlockSpoooooky;
import thevoid.common.blocks.BlockVoidPortal;
import thevoid.common.blocks.RedWoodLeaves;
import thevoid.common.blocks.RedWoodPlanks;
import thevoid.common.blocks.VoidMineralBlock;
import thevoid.common.blocks.VoidMineralGlowingBlock;
import thevoid.common.blocks.blockVoidFire;
import thevoid.common.dimension.WorldProviderVoid;
import thevoid.common.dimension.biome.BiomeGraveyard;
import thevoid.common.gen.BDWorldGen;
import thevoid.common.gen.DeadBrickGraveGen;
import thevoid.common.gen.DeadTreeGen;
import thevoid.common.gen.OreGeneration;
import thevoid.common.gen.RedStoneCrystalGen;
import thevoid.common.gen.VoidMineralGen;
import thevoid.common.gen.WorldGenRedWood;
import thevoid.common.items.ItemBlackDiamond;
import thevoid.common.items.ItemRedStoneCrystal;
import thevoid.common.items.ItemRedStonePick;
import thevoid.common.items.ItemRedStoneStick;
import thevoid.common.items.ItemRedStoneSword;
import thevoid.common.items.RedStonePickPart1;
import thevoid.common.items.RedStonePickPart2;
import thevoid.common.items.RedStonePickPart3;
import thevoid.common.items.SuspiciousMinerals;
import thevoid.common.items.VoidPortalStaff;
import thevoid.common.mob.EntityKitty;
import thevoid.common.util.BID;
import thevoid.common.util.CommonProxyBlackDiamond;
import thevoid.common.util.ToolMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.BlockWood;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBoat;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenDesert;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.biome.BiomeGenHills;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.biome.BiomeGenSwamp;
import net.minecraft.world.biome.BiomeGenTaiga;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.EntityEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = TheVoid.modid, name = "Tutorial Mod", version = "1.0")

public class TheVoid
{
	public static final String modid = "the_void";
	
	public IIcon iconGrassSideOverlay;
	
	//Biomes
	public static final BiomeGraveyard biomeGraveYard = new BiomeGraveyard(BID.BiomeID_1);
	
	//More Blocks
	
	public static Block voidFire;
	
	public static Block voidPortal;

	public static Block deadCobbleStone;
	
	public static Block graveYardGrass;
	
	public static Block deadStone;
	
	public static Block deadStoneBrick;
	
	public static Block spoooooky;
	
	public static Block spoooookyLantern;
	
	public static Block graveYardDirt;
	
	public static Block rLog;
	
	public static Block redWoodLeaves;
	
	public static Block voidMineralBlock;
	
	public static Block voidMineralGlowingBlock;
	
	public static Block redStoneCrystalOre;
	
	public static Block redStoneCrystalGlowingOre;
		
	public static Block blockRedStoneCrystalGlowing;
	
	public static Block blockRedStoneCrystal;
	
	public static Block blockBlackDiamondOre;
	
	public static Block redWoodPlanks;
	
	public static Block redWoodSapling;
	
	public static Block blackDiamondOre;
	    //Block ints
	    public static int blackDiamondOreInt;
	
	//Other
	static int startEntityId = 300;
	
	//Dimension
	
    public static int dimensionId = 5;
	
	//Items
	public static int RedStoneSword;
    
	public static Item itemTiller;
	
	public static Item redStoneCrystal;
	
	public static Item redStoneSword;
	
	public static Item redStonePickPart1;
	
	public static Item redStonePickPart2;
	
	public static Item redStonePickPart3;
	
	public static Item redStoneStick;
	
	public static Item redStonePick;
	
	public static Item suspiciousMinerals;
	
	public static Item voidPortalStaff;
	
	public static Item blackDiamond;
	    //Item ints
	    public static int blackDiamondInt;

	//Proxy
	@SidedProxy(clientSide = "thevoid.common.util.ClientProxyBlackDiamond", serverSide = "thevoid.common.util.CommonProxyBlackDiamond")
	public static CommonProxyBlackDiamond proxy;

	//Events
	@EventHandler
	public void preinit(FMLPreInitializationEvent event){
		
		
		//Blocks
		
		voidFire = (blockVoidFire)new blockVoidFire().setBlockName("Void_Fire").setLightLevel(0.8F).setBlockTextureName("void:void_fire");
		
		voidPortal = (BlockVoidPortal)new BlockVoidPortal().setHardness(15).setBlockUnbreakable().setBlockTextureName("VOID:").setBlockName("Block Void Portal");

		deadCobbleStone = new BlockDeadCobblestone(5056).setHardness(1.0F).setBlockName("Dead Cobblestone").setBlockTextureName("VOID:deadcobblestone2");
		
		graveYardGrass = new BlockGraveYardGrass(160).setStepSound(Block.soundTypeGrass).setHardness(0.5F).setBlockName("graveYardGrass").setBlockTextureName("void:GYG");
		
		deadStone = new BlockDeadStone(161).setStepSound(Block.soundTypeStone).setHardness(1.5F).setBlockName("Dead Stone").setBlockTextureName("VOID:DeadStone2");
		
		deadStoneBrick = new BlockDeadStoneBrick(165).setStepSound(Block.soundTypeStone).setHardness(1.5F).setBlockName("Dead Stone Brick").setBlockTextureName("VOID:StoneBrick");
		
		spoooooky = new BlockSpoooooky(2078, false).setStepSound(Block.soundTypeWood).setHardness(1.0F).setBlockName("Spoooooky").setBlockTextureName("VOID:");
		
		spoooookyLantern = new BlockSpoooooky(2080, true).setHardness(1.0F).setStepSound(Block.soundTypeWood).setLightLevel(1.5F).setBlockName("Spoooooky").setBlockTextureName("VOID:");
		
		graveYardDirt = new BlockGraveYardDirt(212).setHardness(0.6f).setStepSound(Block.soundTypeGravel).setBlockName("Grave Yard Dirt").setBlockTextureName("VOID:GraveYardDirt");
		
	    rLog = new BlockRLog().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("Dead Wood Log").setBlockTextureName("void:");
		
		redWoodLeaves = new RedWoodLeaves(1000).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("Dead Wood Leaves").setBlockTextureName("VOID:BoneLeaves2");
		
		voidMineralBlock = new VoidMineralBlock(2081, 12, false).setHardness(1.0F).setStepSound(Block.soundTypeStone).setBlockName("Suspicious Looking Block").setBlockTextureName("VOID:SuspiciousBlock");
		
		voidMineralGlowingBlock = new VoidMineralGlowingBlock(2082, 12, true).setHardness(1.0F).setStepSound(Block.soundTypeStone).setLightLevel(1.0F).setBlockName("Suspicious Glowing Block").setBlockTextureName("VOID:SuspiciousBlockLit");
				
		redStoneCrystalOre = new BlockRedStoneCrystal(573, 11, false).setHardness(12.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("Red Stone Crystal Ore").setBlockTextureName("void:RedStoneCrystalOre");
		
		redStoneCrystalGlowingOre = new BlockRedStoneCrystalGlowing(575, 11, true).setHardness(12.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setLightLevel(1.0F).setBlockName("Glowing Red Stone Crystal Ore").setBlockTextureName("VOID:RedStoneCrystalOre");
		
		blackDiamondOre = new BlockBlackDiamondOre(544, 9).setHardness(15.0F).setResistance(12.5F).setStepSound(Block.soundTypeStone).setBlockName("Black Diamond Ore").setBlockTextureName("VOID:BlackDiamondOre");
				 
		redWoodPlanks = new RedWoodPlanks(250, 2).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockTextureName("void:DeadWoodPlanks");
				
		redWoodSapling = new BlockRedWoodSapling().setHardness(0.3F).setBlockName("Red Wood Sapling").setBlockTextureName("VOID:");
		
		//Items
        redStoneStick = (new ItemRedStoneStick(634)).setUnlocalizedName("RedStoneStick");
        redStonePick = (new ItemRedStonePick(625, 12, 1, ToolMaterials.BlackDiamond, null)).setUnlocalizedName("RedStonePick");
        redStonePickPart3 = (new RedStonePickPart3(636)).setUnlocalizedName("RedStonePickPart3");
        redStonePickPart2 = (new RedStonePickPart2(638)).setUnlocalizedName("RedStonePickPart2");
        redStonePickPart1 = (new RedStonePickPart1(635)).setUnlocalizedName("RedStonePickPart1");
		redStoneSword = (new ItemRedStoneSword(543, 7, ToolMaterials.BlackDiamond)).setUnlocalizedName("RS:RedStoneSword");
		blackDiamond = (new ItemBlackDiamond(565, 8).setUnlocalizedName("RS:BlackDiamond"));
		redStoneCrystal = (new ItemRedStoneCrystal(568, 10).setUnlocalizedName("RS:RedStoneCrystal"));
		suspiciousMinerals = (new SuspiciousMinerals(789));
		voidPortalStaff = (new VoidPortalStaff(780));
		
	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	config.load();

	blackDiamondOreInt = config.get("Blocks", "Black Diamond Ore", 544).getInt();
	blackDiamondInt = config.get("Items", "Black Diamond", 565).getInt();

	config.save();
	
	//Print
	System.out.println("[The Void] Activating The Void Version 0.1.7");

	
	//Items

	
	//ores gen
	
	GameRegistry.registerWorldGenerator(new DeadBrickGraveGen(), 0);
	GameRegistry.registerWorldGenerator(new VoidMineralGen(), 0);
	GameRegistry.registerWorldGenerator(new BDWorldGen(), 0);
	GameRegistry.registerWorldGenerator(new OreGeneration(), 0);
	GameRegistry.registerWorldGenerator(new RedStoneCrystalGen(), 0);
	
	proxy.registerRenderThings();
			
	//Registry
	
	//Dimensions
	DimensionManager.registerProviderType(TheVoid.dimensionId, WorldProviderVoid.class, false);
	DimensionManager.registerDimension(TheVoid.dimensionId, TheVoid.dimensionId);
	
	//Blocks
	GameRegistry.registerBlock(voidPortal, "Void Portal");
	GameRegistry.registerBlock(voidFire, "Void Fire");
	GameRegistry.registerBlock(voidMineralBlock, "Void Mineral Block");
	GameRegistry.registerBlock(voidMineralGlowingBlock, "Void Mineral Block Glowing");
	GameRegistry.registerBlock(spoooookyLantern, "Spooooooky");
	GameRegistry.registerBlock(spoooooky, "Spoooooky");
	GameRegistry.registerBlock(deadCobbleStone, "Dead Cobblestone");
	GameRegistry.registerBlock(deadStoneBrick, "Dead Stone Brick");
	GameRegistry.registerBlock(deadStone, "Dead Stone");
	GameRegistry.registerBlock(graveYardDirt, "Grave Yard Dirt");
	GameRegistry.registerBlock(redStoneCrystalOre, "Red Stone Crystal Ore");
    GameRegistry.registerBlock(rLog, "Dead Wood Log");
	GameRegistry.registerBlock(redWoodLeaves, "Dead Wood Leaves");
	GameRegistry.registerBlock(redWoodSapling, "Dead Wood Sapling");
	GameRegistry.registerBlock(redWoodPlanks, "Dead Wood Planks");
	GameRegistry.registerBlock(blackDiamondOre, "Black Diamond Ore");
	GameRegistry.registerBlock(graveYardGrass, modid + (graveYardGrass.getUnlocalizedName().substring(5)));
	
	//Items
	GameRegistry.registerItem(voidPortalStaff, "Void Portal Staff");
	GameRegistry.registerItem(suspiciousMinerals, "Suspicious Minerals");
	GameRegistry.registerItem(redStonePickPart3, "Red Stone Pick Part Three");
	GameRegistry.registerItem(redStonePickPart2, "Red Stone Pick Part Two");
	GameRegistry.registerItem(redStonePickPart1, "Red Stone Pick Part One");
	GameRegistry.registerItem(redStoneSword, "Red Stone Sword");
	GameRegistry.registerItem(redStoneStick, "Red Stone Stick");
	GameRegistry.registerItem(redStonePick, "Red Stone Pick");
	GameRegistry.registerItem(redStoneCrystal, "Red Stone Crystal");
	GameRegistry.registerItem(blackDiamond, "Black Diamond");
	

	
	//Recipes
	
	GameRegistry.addShapelessRecipe(new ItemStack(TheVoid.deadStoneBrick, 4), new Object[] { TheVoid.deadStone, TheVoid.deadStone, TheVoid.deadStone, TheVoid.deadStone });
	
	GameRegistry.addRecipe(new ItemStack(TheVoid.deadStoneBrick, 4), new Object[]{
        "ABC",
		" D ",
        " D ",
        'A', TheVoid.redStonePickPart1,  'B', TheVoid.redStonePickPart2, 'C', TheVoid.redStonePickPart3, 'D', TheVoid.redStoneStick
 });
	
	GameRegistry.addRecipe(new ItemStack(TheVoid.spoooookyLantern, 1), new Object[]{
        " B ",
		" A ",
        "   ",
        'A', Items.bone,  'B', TheVoid.spoooooky
 });
	
	GameRegistry.addRecipe(new ItemStack(TheVoid.redStonePick, 1), new Object[]{
        "ABC",
		" D ",
        " D ",
        'A', TheVoid.redStonePickPart1,  'B', TheVoid.redStonePickPart2, 'C', TheVoid.redStonePickPart3, 'D', TheVoid.redStoneStick
 });
	
	GameRegistry.addRecipe(new ItemStack(TheVoid.voidPortalStaff, 1), new Object[]{
        "ABA",
		" D ",
        " D ",
        'A', TheVoid.blackDiamond,  'B', TheVoid.suspiciousMinerals, 'D', TheVoid.redStoneStick
 });
	
	GameRegistry.addShapedRecipe(new ItemStack(TheVoid.redStonePickPart3, 1), new Object[]{
        " YY",
        " XX",
        'X', TheVoid.blackDiamond,  'Y', TheVoid.redStoneCrystal
 });
	
	GameRegistry.addRecipe(new ItemStack(TheVoid.redStonePickPart2, 1), new Object[]{
        " Y ",
        " X ",
        'X', TheVoid.blackDiamond,  'Y', TheVoid.redStoneCrystal
 });
	
	GameRegistry.addShapedRecipe(new ItemStack(TheVoid.redStonePickPart1, 1), new Object[]{
        "XX ",
        "YY ",
        'X', TheVoid.blackDiamond,  'Y', TheVoid.redStoneCrystal
 });
	
	GameRegistry.addRecipe(new ItemStack(TheVoid.redStoneStick, 2), new Object[]{
        "XZY",
        "XZY",
        "XZY",
        'X', TheVoid.blackDiamond,  'Y', TheVoid.redStoneCrystal, 'Z', Items.stick
 });
	
	GameRegistry.addRecipe(new ItemStack(TheVoid.redWoodPlanks, 4), new Object[]{
        "X",
        'X', TheVoid.rLog,  'X', TheVoid.rLog, 'Z', new ItemStack(TheVoid.rLog, 251, 1)
 });
	
	GameRegistry.addRecipe(new ItemStack(Items.stick, 4), new Object[]{
        "X",
        "X",
        'X', TheVoid.redWoodPlanks, 'Z', new ItemStack(TheVoid.redWoodPlanks, 250, 2)
 });
	
	GameRegistry.addRecipe(new ItemStack(Blocks.crafting_table, 1), new Object[]{
        "XX",
        "XX",
        'X', TheVoid.redWoodPlanks,  'X', TheVoid.redWoodPlanks, 'Z', new ItemStack(TheVoid.redWoodPlanks, 250, 2)
 });
	
	GameRegistry.addRecipe(new ItemStack(TheVoid.redStoneSword, 1), new Object[]{"SGS", "SGS", " O ", 'G', TheVoid.blackDiamond, 'S', TheVoid.redStoneCrystal, 'O', Items.stick});
	//Entities
	
	 EntityRegistry.registerModEntity(EntityKitty.class, "Kitty", 1, this, 80, 3, true);
	 
	 
	 EntityRegistry.addSpawn(EntityKitty.class, 10, 2, 4, EnumCreatureType.creature, BiomeGenBase.beach,
				BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills,
				BiomeGenBase.jungle,              BiomeGenBase.jungleHills,               BiomeGenBase.mushroomIsland,
				BiomeGenBase.mushroomIslandShore,    BiomeGenBase.ocean,     BiomeGenBase.plains, BiomeGenBase.river,
				BiomeGenBase.swampland);
	 
	 LanguageRegistry.instance().addStringLocalization("entity.kjake701_RandomStuff.Kitty.name", "Kitty");
	 
	 registerEntityEgg(EntityKitty.class, 0xffffff, 0x000000);
	
}

public static int getUniqueEntityId()
{
 do
 {
  startEntityId++;
 }
 while (EntityList.getStringFromID(startEntityId) != null);

 return startEntityId;
}

public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor)
{
 int id = getUniqueEntityId();
 EntityList.IDtoClassMapping.put(id, entity);
 EntityList.addMapping(EntityKitty.class, "Kitty", 5, 113213, 3523523);
}
	
	
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{	
	}


	
}
