package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderViePig extends RenderLiving
{

    public RenderViePig(ModelPig modelPig, float f)
    {
        super(modelPig, f);
    }

    public void renderPig(EntityPig entity, double d, double d1, double d2, float f, float f1)
    {
        super.doRenderLiving(entity, d, d1, d2, f, f1);
                
        if(entity.getHealth() > 0)
        {
            renderLivingLabel(entity, "" + entity.getHealth() + "/" + entity.getMaxHealth() + " HP", d, d1  - 0.75D, d2, 64);
            renderLivingLabel(entity, "Pig", d, d1 - 0.5D, d2, 64);
        }    
    }
    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
    {
        super.doRenderLiving((EntityPig) entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
    {
        renderPig((EntityPig)entity, d, d1, d2, f, f1);
    }
    
     
    protected void preRenderScale(EntityPig entity, float f)
    {
        GL11.glScalef(1.0F, 1.0F, 1.0F);
    }

    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        preRenderScale((EntityPig)entityliving, f);
    }
}