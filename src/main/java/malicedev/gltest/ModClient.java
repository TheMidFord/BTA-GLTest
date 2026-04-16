package malicedev.gltest;


import malicedev.gltest.renderers.ItemBoxTileEntityRenderer;
import malicedev.gltest.tileentities.ItemBoxTileEntity;
import net.minecraft.client.render.tileentity.TileEntityRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ClientStartEntrypoint;



import static malicedev.gltest.Main.MOD_ID;

public class ModClient implements ClientStartEntrypoint {
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void beforeClientStart() {
	}

	@Override
	public void afterClientStart() {
		ModelHelper.setTileEntityModel(ItemBoxTileEntity.class,() -> new ItemBoxTileEntityRenderer());
	}
}
