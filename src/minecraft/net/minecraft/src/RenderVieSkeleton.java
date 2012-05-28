package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderVieSkeleton extends RenderLiving
{

    public RenderVieSkeleton(ModelSkeleton modelSkeleton, float f)
    {
        super(modelSkeleton, f);
    }

    public void renderSkeleton(EntitySkeleton entity, double d, double d1, double d2, float f, float f1)
    {
        super.doRenderLiving(entity, d, d1, d2, f, f1);
                
        if(entity.getHealth() > 0)
        {
            renderLivingLabel(entity, "" + entity.getHealth() + "/" + entity.getMaxHealth() + " HP", d, d1, d2, 64);
            renderLivingLabel(entity, "Skeleton", d, d1 + 0.25D, d2, 64);
        }    
    }
    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
    {
        super.doRenderLiving((EntitySkeleton) entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
    {
        renderSkeleton((EntitySkeleton)entity, d, d1, d2, f, f1);
    }
    
     
    protected void preRenderScale(EntitySkeleton entity, float f)
    {
        GL11.glScalef(1.0F, 1.0F, 1.0F);
    }

    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        preRenderScale((EntitySkeleton)entityliving, f);
    }
}