package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderTonneau extends TileEntitySpecialRenderer{

   public RenderTonneau()
   {
      Tonneau = new ModelTonneau();
   }
   
   public void renderAModelAt(TileEntityTonneau tileentity1, double d, double d1, double d2, float f)
   {
      mod_Experimental.Tonneau.setBlockBounds(0, 0, 0, 1F, 1F, 1F);
      GL11.glPushMatrix(); //(
      GL11.glTranslatef((float) d + 0.5F, (float) d1 +1.5F, (float) d2 +0.5F );
      GL11.glRotatef(180, 0F, 0F, 1F);
      bindTextureByName("/item/modeltonneau.png");
      GL11.glPushMatrix();  //)
      Tonneau.renderModel(0.0625F);
      GL11.glPopMatrix();
      GL11.glPopMatrix();
      
   }
   
   public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f)
   {
      renderAModelAt((TileEntityTonneau)tileentity, d, d1, d2, f);
   }
   
   private ModelTonneau Tonneau ;
}