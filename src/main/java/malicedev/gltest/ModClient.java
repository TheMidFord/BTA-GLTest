package malicedev.gltest;


import malicedev.gltest.renderers.ItemBoxTileEntityRenderer;
import malicedev.gltest.tileentities.ItemBoxTileEntity;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;


import static malicedev.gltest.Main.MOD_ID;

public class ModClient implements ModelEntrypoint {
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void initBlockModels(BlockModelDispatcher dispatcher) {

	}

	@Override
	public void initItemModels(ItemModelDispatcher dispatcher) {

	}

	@Override
	public void initEntityModels(EntityRenderDispatcher dispatcher) {

	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {
		ModelHelper.setTileEntityModel(ItemBoxTileEntity.class,() -> new ItemBoxTileEntityRenderer());
	}

	@Override
	public void initBlockColors(BlockColorDispatcher dispatcher) {

	}
}
