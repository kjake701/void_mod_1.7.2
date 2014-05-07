package thevoid.common.dimension;

import org.lwjgl.opengl.GL11;

import thevoid.common.TheVoid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vec3Pool;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;
import thevoid.common.dimension.ChunkProviderVoid;

public class WorldProviderVoid extends WorldProvider
{
	private float[] colorsSunriseSunset = new float[4];
	private static final String SR = new String("void:DarkDay.png");
	private static final String MO = new String("void:BloodMoon.png");
    protected IRenderHandler skyRendererVoid = null;

	public void registerWorldChunkManager()
{
this.worldChunkMgr = new WorldChunkManagerHell(TheVoid.biomeGraveYard, this.dimensionId);
this.dimensionId = TheVoid.dimensionId;
this.hasNoSky = true;
}

    @SideOnly(Side.CLIENT)
    public IRenderHandler getSkyRenderer()
    {
        return this.skyRendererVoid;
    }
    
    @SideOnly(Side.CLIENT)

    /**
* Returns true if the given X,Z coordinate should show environmental fog.
*/
    public boolean doesXZShowFog(int par1, int par2)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void setSkyRenderer(IRenderHandler skyRenderer)
    {
        this.skyRendererVoid = skyRenderer;
    }

public IChunkProvider createChunkGenerator()
{
return new ChunkProviderVoid(this.worldObj, this.worldObj.getSeed(), false);
}

public int getAverageGroundLevel()
{
return 0;
}

public String getDimensionName()
{
return "The Void";
}

public boolean renderStars()
{
return true;
}

public float getStarBrightness(World world, float f)
{
return 10.0F;
}

public boolean renderClouds()
{
return true;
}

public boolean renderVoidFog()
{
return false;
}

    @SideOnly(Side.CLIENT)
    public boolean isSkyColored()
    {
        return false;
    }

public boolean canRespawnHere()
{
return false;
}

    public float calculateCelestialAngle(long par1, float par3)
    {
        return 0.0F;
    }

    @SideOnly(Side.CLIENT)

    /**
* Returns array with sunrise/sunset colors
*/
    public float[] calcSunriseSunsetColors(float par1, float par2)
    {
        return null;
    }

@SideOnly(Side.CLIENT)
public float getCloudHeight()
{
return 128.0F;
}

@SideOnly(Side.CLIENT)
public String getSunTexture()
{
return SR;
}

@SideOnly(Side.CLIENT)
public String getMoonTexture()
{
return MO;	
}
public boolean canCoordinateBeSpawn(int par1, int par2)
{
return false;
}

public ChunkCoordinates getEntrancePortalLocation()
{
return new ChunkCoordinates(50, 5, 0);
}

public boolean isSurfaceWorld()
{
return false;
}

@SideOnly(Side.CLIENT)
@Override
public String getWelcomeMessage()
{
if ((this instanceof WorldProviderVoid))
{
return "Entering The Void";
}
return null;
}



    /**
* Return Vec3D with biome specific fog color
*/
    public Vec3 getFogColor(float par1, float par2)
    {
        int i = 10518688;
        float f2 = MathHelper.cos(par1 * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

        if (f2 < 0.0F)
        {
            f2 = 0.0F;
        }

        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }

        float f3 = 0.0529412F;
        float f4 = 0.0705883F;
        float f5 = 0.01F;
        f3 *= f2 * 0.0F + 0.15F;
        f4 *= f2 * 0.0F + 0.15F;
        f5 *= f2 * 0.0F + 0.15F;
        return this.worldObj.getWorldVec3Pool().getVecFromPool((double)f3, (double)f4, (double)f5);
    }


}