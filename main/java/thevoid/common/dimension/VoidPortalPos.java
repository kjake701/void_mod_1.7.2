package thevoid.common.dimension;

import net.minecraft.util.ChunkCoordinates;

public class VoidPortalPos extends ChunkCoordinates
{
	public long field_85087_d;
	
	final TeleporterVoid field_85088_e;
	
	public VoidPortalPos(TeleporterVoid teleporterVoid, int par2, int par3, int par4, long par5)
	{
		super(par2, par3, par4);
		this.field_85088_e = teleporterVoid;
		this.field_85087_d = par5;
	}
}