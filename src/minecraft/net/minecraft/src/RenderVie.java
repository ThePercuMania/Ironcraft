package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderVie extends RenderLiving
{

    public RenderVie(ModelCreeper modelCreeper, float f)
    {
        super(modelCreeper, f);
    }

    public void renderCreeper(EntityCreeper entity, double d, double d1, double d2, float f, float f1)
    {
        super.doRenderLiving(entity, d, d1, d2, f, f1);
                
        if(entity.getHealth() > 0)
        {
            renderLivingLabel(entity, entity.getHealth() + "/" + entity.getMaxHealth() + " HP", d, d1 - 0.2D, d2, 64);
            renderLivingLabel(entity, "Creeper", d, d1 + 0.05D, d2, 64);
        }    
    }
    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
    {
        super.doRenderLiving((EntityCreeper) entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
    {
        renderCreeper((EntityCreeper)entity, d, d1, d2, f, f1);
    }
    
     
    protected void preRenderScale(EntityCreeper entity, float f)
    {
        GL11.glScalef(1.0F, 1.0F, 1.0F);
    }

    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        preRenderScale((EntityCreeper)entityliving, f);
    }
}