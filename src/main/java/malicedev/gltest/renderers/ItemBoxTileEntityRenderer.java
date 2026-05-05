package malicedev.gltest.renderers;

import malicedev.gltest.tileentities.ItemBoxTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.LightmapHelper;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.client.render.tileentity.TileEntityRenderer;
import net.minecraft.core.util.helper.MathHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL45;

import static net.minecraft.client.render.customatlas.CustomAtlasHandler.mc;

public class ItemBoxTileEntityRenderer extends TileEntityRenderer<ItemBoxTileEntity> {

	@Override
	public void doRender(Tessellator tessellator, ItemBoxTileEntity itemBoxTileEntity, double x, double y, double z, float partialTick) {
		float progress = itemBoxTileEntity.ticks + partialTick;

		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y + MathHelper.sin(progress / 10f) / 8f, (float) z);

		GL11.glTranslatef(0.5f, 0.5f, 0.5f);
		GL11.glRotatef(MathHelper.toDegrees(progress / 8f), 0, 1, 0);
		GL11.glTranslatef(-0.5f, -0.5f, -0.5f);

		GL11.glDisable(GL11.GL_LIGHTING);
		renderQuestion(tessellator);
		renderOctahedron(tessellator);
		GL11.glEnable(GL11.GL_LIGHTING);

		GL11.glPopMatrix();
	}

	public void renderOctahedron(Tessellator tessellator) {
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glShadeModel(GL11.GL_SMOOTH);
//		GL11.glDepthMask(false);
		tessellator.startDrawing(GL11.GL_TRIANGLES);
		tessellator.setLightmapCoord(LightmapHelper.getLightmapCoord(15, 15));


		float halfWidth = 2.5f / 4f;
		float halfHeight = 2.5f / 3f;
		{
			//Bottom
			{
				tessellator.setColorRGBA(255, 0, 0, 200);
				tessellator.addVertex(0.5, 0.5 - halfHeight, 0.5);

				tessellator.setColorRGBA(0, 255, 0, 200);
				tessellator.addVertex(0.5 - halfWidth, 0.5, 0.5 - halfWidth);

				tessellator.setColorRGBA(0, 0, 255, 200);
				tessellator.addVertex(0.5 + halfWidth, 0.5, 0.5 - halfWidth);
			}
			{
				tessellator.setColorRGBA(255, 0, 0, 200);
				tessellator.addVertex(0.5, 0.5 - halfHeight, 0.5);

				tessellator.setColorRGBA(255, 0, 255, 200);
				tessellator.addVertex(0.5 - halfWidth, 0.5, 0.5 + halfWidth);

				tessellator.setColorRGBA(0, 255, 0, 200);
				tessellator.addVertex(0.5 - halfWidth, 0.5, 0.5 - halfWidth);
			}
			{
				tessellator.setColorRGBA(255, 0, 0, 200);
				tessellator.addVertex(0.5, 0.5 - halfHeight, 0.5);

				tessellator.setColorRGBA(0, 255, 255, 200);
				tessellator.addVertex(0.5 + halfWidth, 0.5, 0.5 + halfWidth);

				tessellator.setColorRGBA(255, 0, 255, 200);
				tessellator.addVertex(0.5 - halfWidth, 0.5, 0.5 + halfWidth);
			}

			{
				tessellator.setColorRGBA(255, 0, 0, 200);
				tessellator.addVertex(0.5, 0.5 - halfHeight, 0.5);

				tessellator.setColorRGBA(0, 0, 255, 200);
				tessellator.addVertex(0.5 + halfWidth, 0.5, 0.5 - halfWidth);

				tessellator.setColorRGBA(0, 255, 255, 200);
				tessellator.addVertex(0.5 + halfWidth, 0.5, 0.5 + halfWidth);
			}

		}

		{
			// Top
			{
				tessellator.setColorRGBA(255, 255, 0, 200);
				tessellator.addVertex(0.5, 0.5 + halfHeight, 0.5);

				tessellator.setColorRGBA(0, 0, 255, 200);
				tessellator.addVertex(0.5 + halfWidth, 0.5, 0.5 - halfWidth);

				tessellator.setColorRGBA(0, 255, 0, 200);
				tessellator.addVertex(0.5 - halfWidth, 0.5, 0.5 - halfWidth);
			}

			{
				tessellator.setColorRGBA(255, 255, 0, 200);
				tessellator.addVertex(0.5, 0.5 + halfHeight, 0.5);

				tessellator.setColorRGBA(0, 255, 0, 200);
				tessellator.addVertex(0.5 - halfWidth, 0.5, 0.5 - halfWidth);

				tessellator.setColorRGBA(255, 0, 255, 200);
				tessellator.addVertex(0.5 - halfWidth, 0.5, 0.5 + halfWidth);
			}

			{
				tessellator.setColorRGBA(255, 255, 0, 200);
				tessellator.addVertex(0.5, 0.5 + halfHeight, 0.5);

				tessellator.setColorRGBA(255, 0, 255, 200);
				tessellator.addVertex(0.5 - halfWidth, 0.5, 0.5 + halfWidth);

				tessellator.setColorRGBA(0, 255, 255, 200);
				tessellator.addVertex(0.5 + halfWidth, 0.5, 0.5 + halfWidth);
			}

			{
				tessellator.setColorRGBA(255, 255, 0, 200);
				tessellator.addVertex(0.5, 0.5 + halfHeight, 0.5);

				tessellator.setColorRGBA(0, 255, 255, 200);
				tessellator.addVertex(0.5 + halfWidth, 0.5, 0.5 + halfWidth);

				tessellator.setColorRGBA(0, 0, 255, 200);
				tessellator.addVertex(0.5 + halfWidth, 0.5, 0.5 - halfWidth);
			}
		}
		GL11.glScalef(0.8f,0.8f,0.8f);
		tessellator.draw();

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glShadeModel(GL11.GL_FLAT);
//		GL11.glDepthMask(true);
	}

	public void renderQuestion(Tessellator tessellator) {

		GL11.glDisable(GL11.GL_CULL_FACE);
		tessellator.startDrawing(GL11.GL_QUADS);
		Minecraft.getMinecraft().textureManager.bindTexture(mc.textureManager.loadTexture("/assets/gltest/textures/block/itembox_questionmark.png"));
		tessellator.setLightmapCoord(LightmapHelper.getLightmapCoord(15, 15));

//		{
//			tessellator.addVertexWithUV(1, 1, 0,0,0);
//			tessellator.addVertexWithUV(0, 1, 0,1,0);
//			tessellator.addVertexWithUV(0, 0, 0,1,1);
//			tessellator.addVertexWithUV(1, 0, 0,0,1);
//
//		}
		{
			tessellator.addVertexWithUV(0, 1, 0.5,0,0);
			tessellator.addVertexWithUV(0, 0, 0.5,0,1);
			tessellator.addVertexWithUV(1, 0, 0.5,1,1);
			tessellator.addVertexWithUV(1, 1, 0.5,1,0);
			GL11.glScalef(0.8f,0.8f,0.8f);


		}
		tessellator.draw();
		GL11.glEnable(GL11.GL_CULL_FACE);
	}
}
