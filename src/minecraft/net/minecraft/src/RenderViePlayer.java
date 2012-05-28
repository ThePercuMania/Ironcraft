package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderViePlayer extends RenderLiving
{

    public RenderViePlayer(ModelBiped modelBiped, float f)
    {
        super(modelBiped, f);
    }

    public void renderBiped(EntityPlayer entity, double d, double d1, double d2, float f, float f1)
    {
        super.doRenderLiving(entity, d, d1, d2, f, f1);
                
        if(entity.getHealth() > 0)
        {
            renderLivingLabel(entity, "" + entity.getHealth() + "/" + entity.getMaxHealth() + " HP", d, d1 + 1.1D, d2, 64);
        }    
    }
    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
    {
        super.doRenderLiving((EntityPlayer) entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
    {
        renderBiped((EntityPlayer)entity, d, d1, d2, f, f1);
    }
    
     
    protected void preRenderScale(EntityPlayer entity, float f)
    {
        GL11.glScalef(1.0F, 1.0F, 1.0F);
    }

    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        preRenderScale((EntityPlayer)entityliving, f);
    }
}