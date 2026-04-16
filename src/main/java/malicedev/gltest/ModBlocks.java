package malicedev.gltest;
import malicedev.gltest.tileentities.ItemBoxTileEntity;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.util.collection.NamespaceID;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;

import static malicedev.gltest.Main.MOD_ID;
import static malicedev.gltest.Main.blockId;
public class ModBlocks {
	private ModBlocks(){}

	public static Block<?> ItemBox;

	public static void init() {

		EntityHelper.createTileEntity(ItemBoxTileEntity.class, NamespaceID.getPermanent(MOD_ID,"itembox"));


		ItemBox = new BlockBuilder(MOD_ID)
			.setTileEntity(ItemBoxTileEntity::new)
			.build("itembox","itembox",blockId++,(block) -> new BlockLogic(block, Material.glass));

	}
}
