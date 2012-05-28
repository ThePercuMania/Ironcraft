package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class EntityFeuilleFX extends EntityFX
{
    float smokeParticleScale;

    public EntityFeuilleFX(World var1, double var2, double var4, double var6, double var8, double var10, double var12)
    {
        this(var1, var2, var4, var6, var8, var10, var12, 1.0F);
    }

    public EntityFeuilleFX(World var1, double var2, double var4, double var6, double var8, double var10, double var12, float var14)
    {
        super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
        this.motionX = 0.0D;
        this.motionY -= 0.05D;
        this.motionZ = 0.0D;
        this.particleRed = this.particleGreen = 0.0F;
        this.particleGreen = 100.0F;
        this.particleScale *= 0.75F;
        this.smokeParticleScale = this.particleScale;
        this.particleMaxAge = (int)(100.0D / (Math.random() * 0.8D + 0.2D));
        this.particleMaxAge = (int)((float)this.particleMaxAge * var14);
        this.noClip = false;
    }

    public void renderParticle(Tessellator par1Tessellator, float f, float f1, float f2, float f3, float f4, float f5)
    {
       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        Tessellator tessellator1 = new Tessellator(0x200000);
        tessellator1.startDrawingQuads();
        tessellator1.setBrightness(getBrightnessForRender(f));
        float f6 = (((float)particleAge + f) / (float)particleMaxAge) * 32F;

        if (f6 < 0.0F)
        {
            f6 = 0.0F;
        }

        if (f6 > 1.0F)
        {
            f6 = 1.0F;
        }

        particleScale = smokeParticleScale * f6;
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, ModLoader.getMinecraftInstance().renderEngine.getTexture("/gui/Feuilles.png"));
        float f7 = (float)(getParticleTextureIndex() % 16) / 16F;
        float f8 = f7 + 0.0624375F;
        float f9 = (float)(getParticleTextureIndex() / 16) / 16F;
        float f10 = f9 + 0.0624375F;
        float f11 = 0.1F * particleScale;
        float f12 = (float)((prevPosX + (posX - prevPosX) * (double)f) - interpPosX);
        float f13 = (float)((prevPosY + (posY - prevPosY) * (double)f) - interpPosY);
        float f14 = (float)((prevPosZ + (posZ - prevPosZ) * (double)f) - interpPosZ);
        float f15 = 1.0F;
        tessellator1.setColorOpaque_F(particleRed * f15, particleGreen * f15, particleBlue * f15);
        tessellator1.addVertexWithUV(f12 - f1 * f11 - f4 * f11, f13 - f2 * f11, f14 - f3 * f11 - f5 * f11, f8, f10);
        tessellator1.addVertexWithUV((f12 - f1 * f11) + f4 * f11, f13 + f2 * f11, (f14 - f3 * f11) + f5 * f11, f8, f9);
        tessellator1.addVertexWithUV(f12 + f1 * f11 + f4 * f11, f13 + f2 * f11, f14 + f3 * f11 + f5 * f11, f7, f9);
        tessellator1.addVertexWithUV((f12 + f1 * f11) - f4 * f11, f13 - f2 * f11, (f14 + f3 * f11) - f5 * f11, f7, f10);
        tessellator1.draw();
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, ModLoader.getMinecraftInstance().renderEngine.getTexture("/particles.png"));
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }

        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.motionY -= 0.004D;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);

        if (this.posY == this.prevPosY)
        {
            this.motionX *= 1.1D;
            this.motionZ *= 1.1D;
        }

        this.motionX *= 0.9599999785423279D;
        this.motionY *= 0.9599999785423279D;
        this.motionZ *= 0.9599999785423279D;

        if (this.onGround)
        {
            this.setDead();
        }
    }
}