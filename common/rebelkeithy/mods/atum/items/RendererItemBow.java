package rebelkeithy.mods.atum.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import rebelkeithy.mods.atum.Atum;

public class RendererItemBow implements IItemRenderer
{

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		if(type == ItemRenderType.EQUIPPED)
			return true;
		
		return false;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		if(type == ItemRenderType.EQUIPPED && item.itemID == Atum.itemBow.itemID)
			return true;
		
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		if(type == ItemRenderType.EQUIPPED)
		{
	        GL11.glPushMatrix();
	        Icon icon = item.getIconIndex();
	        //Icon icon = entity.getItemIcon(item, par3);


            Tessellator tessellator = Tessellator.instance;
            float f = icon.getMinU();
            float f1 = icon.getMaxU();
            float f2 = icon.getMinV();
            float f3 = icon.getMaxV();
            float f4 = 0.0F;
            float f5 = 0.3F;
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glTranslatef(-f4, -f5, 0.0F);
            float f6 = 2F;
            GL11.glScalef(f6, f6, f6);
            //GL11.glTranslatef(-0.6375F, -0.0625F, 0.0F);
            GL11.glRotatef(-60.0F, 0.5F, 1.0F, 1.5F);
            //GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
            

            GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
            //GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
            //GL11.glScalef(f2, -f2, f2);
            //GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            //GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            
            ItemRenderer.renderItemIn2D(tessellator, f1, f2, f, f3, icon.getSheetWidth(), icon.getSheetHeight(), 0.0625F);

            if (item != null && item.hasEffect())
            {
                
                GL11.glDepthFunc(GL11.GL_EQUAL);
                GL11.glDisable(GL11.GL_LIGHTING);
                Minecraft.getMinecraft().renderEngine.bindTexture("%blur%/misc/glint.png");
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
                float f7 = 0.76F;
                GL11.glColor4f(0.5F * f7, 0.25F * f7, 0.8F * f7, 1.0F);
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glPushMatrix();
                float f8 = 0.125F;
                GL11.glScalef(f8, f8, f8);
                float f9 = (float)(Minecraft.getSystemTime() % 3000L) / 3000.0F * 8.0F;
                GL11.glTranslatef(f9, 0.0F, 0.0F);
                GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
                ItemRenderer.renderItemIn2D(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef(f8, f8, f8);
                f9 = (float)(Minecraft.getSystemTime() % 4873L) / 4873.0F * 8.0F;
                GL11.glTranslatef(-f9, 0.0F, 0.0F);
                GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
                ItemRenderer. renderItemIn2D(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
                GL11.glPopMatrix();
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glDepthFunc(GL11.GL_LEQUAL);
            }
	        
	        GL11.glPopMatrix();
		}
	}

}