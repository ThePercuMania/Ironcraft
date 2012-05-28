package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderVieZombie extends RenderLiving
{

    public RenderVieZombie(ModelZombie modelZombie, float f)
    {
        super(modelZombie, f);
    }

    public void renderZombie(EntityZombie entity, double d, double d1, double d2, float f, float f1)
    {
        super.doRenderLiving(entity, d, d1, d2, f, f1);
                
        if(entity.getHealth() > 0)
        {
            renderLivingLabel(entity, "" + entity.getHealth() + "/" + entity.getMaxHealth() + " HP", d, d1, d2, 64);
            renderLivingLabel(entity, "Zombie", d, d1 + 0.25D, d2, 64);
        }    
    }
    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
    {
        super.doRenderLiving((EntityZombie) entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
    {
        renderZombie((EntityZombie)entity, d, d1, d2, f, f1);
    }
    
     
    protected void preRenderScale(EntityZombie entity, float f)
    {
        GL11.glScalef(1.0F, 1.0F, 1.0F);
    }

    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        preRenderScale((EntityZombie)entityliving, f);
    }
}