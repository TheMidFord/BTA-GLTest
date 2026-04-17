package malicedev.gltest.blocklogic;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.material.Material;

public class BlockLogicItemBox extends BlockLogic {
	public BlockLogicItemBox(Block<?> block, Material material) {
		super(block, material);
	}
	
	@Override
	public boolean isSolidRender() {
		return false;
	}
}
