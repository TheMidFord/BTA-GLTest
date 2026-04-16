package malicedev.gltest.tileentities;

import net.minecraft.core.block.entity.TileEntity;

public class ItemBoxTileEntity extends TileEntity {
	public int ticks;

	@Override
	public void tick() {
		 ticks++;
	}
}
