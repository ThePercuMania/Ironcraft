package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderVieEnderman extends RenderLiving
{

    public RenderVieEnderman(ModelEnderman modelEnderman, float f)
    {
        super(modelEnderman, f);
    }

    public void renderEnderman(EntityEnderman entity, double d, double d1, double d2, float f, float f1)
    {
        super.doRenderLiving(entity, d, d1, d2, f, f1);
                
        if(entity.getHealth() > 0)
        {
            renderLivingLabel(entity, "" + entity.getHealth() + "/" + entity.getMaxHealth() + " HP", d, d1 + 1.1D, d2, 64);
            renderLivingLabel(entity, "Enderman", d, d1 + 1.35D, d2, 64);
        }    
    }
    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
    {
        super.doRenderLiving((EntityEnderman) entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
    {
        renderEnderman((EntityEnderman)entity, d, d1, d2, f, f1);
    }
    
     
    protected void preRenderScale(EntityEnderman entity, float f)
    {
        GL11.glScalef(1.0F, 1.0F, 1.0F);
    }

    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        preRenderScale((EntityEnderman)entityliving, f);
    }
}