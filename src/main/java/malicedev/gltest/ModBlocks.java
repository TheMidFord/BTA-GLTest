package malicedev.gltest;
import malicedev.gltest.blocklogic.BlockLogicItemBox;
import malicedev.gltest.tileentities.ItemBoxTileEntity;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.sound.BlockSounds;
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
			.setBlockSound(BlockSounds.GLASS)
			.build("itembox","itembox",blockId++,(block) -> new BlockLogicItemBox(block, Material.glass));

	}
}
