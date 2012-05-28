package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class EntityBoneMeal extends Entity
{
    private int xTile;
    private int yTile;
    private int zTile;
    private int inTile;
    private int inData;
    private boolean inGround;
    public boolean doesBoneMealBelongToPlayer;

    /** Seems to be some sort of timer for animating an BoneMeal. */
    public int BoneMealShake;

    /** The owner of this BoneMeal. */
    public Entity shootingEntity;
    private int ticksInGround;
    private int ticksInAir;
    private double damage;
    private int field_46027_au;

    /** Is this BoneMeal a critical hit? (Controls particles and damage) */
    public boolean BoneMealCritical;

    public EntityBoneMeal(World par1World)
    {
        super(par1World);
        xTile = -1;
        yTile = -1;
        zTile = -1;
        inTile = 0;
        inData = 0;
        inGround = false;
        doesBoneMealBelongToPlayer = false;
        BoneMealShake = 0;
        ticksInAir = 0;
        damage = 2D;
        BoneMealCritical = false;
        setSize(0.5F, 0.5F);
    }

    public EntityBoneMeal(World par1World, double par2, double par4, double par6)
    {
        super(par1World);
        xTile = -1;
        yTile = -1;
        zTile = -1;
        inTile = 0;
        inData = 0;
        inGround = false;
        doesBoneMealBelongToPlayer = false;
        BoneMealShake = 0;
        ticksInAir = 0;
        damage = 2D;
        BoneMealCritical = false;
        setSize(0.5F, 0.5F);
        setPosition(par2, par4, par6);
        yOffset = 0.0F;
    }

    public EntityBoneMeal(World par1World, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving, float par4, float par5)
    {
        super(par1World);
        xTile = -1;
        yTile = -1;
        zTile = -1;
        inTile = 0;
        inData = 0;
        inGround = false;
        doesBoneMealBelongToPlayer = false;
        BoneMealShake = 0;
        ticksInAir = 0;
        damage = 2D;
        BoneMealCritical = false;
        shootingEntity = par2EntityLiving;
        doesBoneMealBelongToPlayer = par2EntityLiving instanceof EntityPlayer;
        posY = (par2EntityLiving.posY + (double)par2EntityLiving.getEyeHeight()) - 0.10000000149011612D;
        double d = par3EntityLiving.posX - par2EntityLiving.posX;
        double d1 = (par3EntityLiving.posY + (double)par3EntityLiving.getEyeHeight()) - 0.69999998807907104D - posY;
        double d2 = par3EntityLiving.posZ - par2EntityLiving.posZ;
        double d3 = MathHelper.sqrt_double(d * d + d2 * d2);

        if (d3 < 9.9999999999999995E-008D)
        {
            return;
        }
        else
        {
            float f = (float)((Math.atan2(d2, d) * 180D) / Math.PI) - 90F;
            float f1 = (float)(-((Math.atan2(d1, d3) * 180D) / Math.PI));
            double d4 = d / d3;
            double d5 = d2 / d3;
            setLocationAndAngles(par2EntityLiving.posX + d4, posY, par2EntityLiving.posZ + d5, f, f1);
            yOffset = 0.0F;
            float f2 = (float)d3 * 0.2F;
            setBoneMealHeading(d, d1 + (double)f2, d2, par4, par5);
            return;
        }
    }

    public EntityBoneMeal(World par1World, EntityLiving par2EntityLiving, float par3)
    {
        super(par1World);
        xTile = -1;
        yTile = -1;
        zTile = -1;
        inTile = 0;
        inData = 0;
        inGround = false;
        doesBoneMealBelongToPlayer = false;
        BoneMealShake = 0;
        ticksInAir = 0;
        damage = 2D;
        BoneMealCritical = false;
        shootingEntity = par2EntityLiving;
        doesBoneMealBelongToPlayer = par2EntityLiving instanceof EntityPlayer;
        setSize(0.5F, 0.5F);
        setLocationAndAngles(par2EntityLiving.posX, par2EntityLiving.posY + (double)par2EntityLiving.getEyeHeight(), par2EntityLiving.posZ, par2EntityLiving.rotationYaw, par2EntityLiving.rotationPitch);
        posX -= MathHelper.cos((rotationYaw / 180F) * (float)Math.PI) * 0.16F;
        posY -= 0.10000000149011612D;
        posZ -= MathHelper.sin((rotationYaw / 180F) * (float)Math.PI) * 0.16F;
        setPosition(posX, posY, posZ);
        yOffset = 0.0F;
        motionX = -MathHelper.sin((rotationYaw / 180F) * (float)Math.PI) * MathHelper.cos((rotationPitch / 180F) * (float)Math.PI);
        motionZ = MathHelper.cos((rotationYaw / 180F) * (float)Math.PI) * MathHelper.cos((rotationPitch / 180F) * (float)Math.PI);
        motionY = -MathHelper.sin((rotationPitch / 180F) * (float)Math.PI);
        setBoneMealHeading(motionX, motionY, motionZ, par3 * 1.5F, 1.0F);
    }

    protected void entityInit()
    {
    }

    /**
     * Uses the provided coordinates as a heading and determines the velocity from it with the set force and random
     * variance. Args: x, y, z, force, forceVariation
     */
    public void setBoneMealHeading(double par1, double par3, double par5, float par7, float par8)
    {
        float f = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
        par1 /= f;
        par3 /= f;
        par5 /= f;
        par1 += rand.nextGaussian() * 0.0074999998323619366D * (double)par8;
        par3 += rand.nextGaussian() * 0.0074999998323619366D * (double)par8;
        par5 += rand.nextGaussian() * 0.0074999998323619366D * (double)par8;
        par1 *= par7;
        par3 *= par7;
        par5 *= par7;
        motionX = par1;
        motionY = par3;
        motionZ = par5;
        float f1 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
        prevRotationYaw = rotationYaw = (float)((Math.atan2(par1, par5) * 180D) / Math.PI);
        prevRotationPitch = rotationPitch = (float)((Math.atan2(par3, f1) * 180D) / Math.PI);
        ticksInGround = 0;
    }

    /**
     * Sets the velocity to the args. Args: x, y, z
     */
    public void setVelocity(double par1, double par3, double par5)
    {
        motionX = par1;
        motionY = par3;
        motionZ = par5;

        if (prevRotationPitch == 0.0F && prevRotationYaw == 0.0F)
        {
            float f = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
            prevRotationYaw = rotationYaw = (float)((Math.atan2(par1, par5) * 180D) / Math.PI);
            prevRotationPitch = rotationPitch = (float)((Math.atan2(par3, f) * 180D) / Math.PI);
            prevRotationPitch = rotationPitch;
            prevRotationYaw = rotationYaw;
            setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
            ticksInGround = 0;
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        if (prevRotationPitch == 0.0F && prevRotationYaw == 0.0F)
        {
            float f = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
            prevRotationYaw = rotationYaw = (float)((Math.atan2(motionX, motionZ) * 180D) / Math.PI);
            prevRotationPitch = rotationPitch = (float)((Math.atan2(motionY, f) * 180D) / Math.PI);
        }

        int i = worldObj.getBlockId(xTile, yTile, zTile);

        if (i > 0)
        {
            Block.blocksList[i].setBlockBoundsBasedOnState(worldObj, xTile, yTile, zTile);
            AxisAlignedBB axisalignedbb = Block.blocksList[i].getCollisionBoundingBoxFromPool(worldObj, xTile, yTile, zTile);

            if (axisalignedbb != null && axisalignedbb.isVecInside(Vec3D.createVector(posX, posY, posZ)))
            {
                inGround = true;
            }
        }

        if (BoneMealShake > 0)
        {
            BoneMealShake--;
        }

        if (inGround)
        {
            int j = worldObj.getBlockId(xTile, yTile, zTile);
            int k = worldObj.getBlockMetadata(xTile, yTile, zTile);

            if (j != inTile || k != inData)
            {
                inGround = false;
                motionX *= rand.nextFloat() * 0.2F;
                motionY *= rand.nextFloat() * 0.2F;
                motionZ *= rand.nextFloat() * 0.2F;
                ticksInGround = 0;
                ticksInAir = 0;
                return;
            }

            ticksInGround++;

            if (ticksInGround == 1200)
            {
                setDead();
            }

            return;
        }

        ticksInAir++;
        Vec3D vec3d = Vec3D.createVector(posX, posY, posZ);
        Vec3D vec3d1 = Vec3D.createVector(posX + motionX, posY + motionY, posZ + motionZ);
        MovingObjectPosition movingobjectposition = worldObj.rayTraceBlocks_do_do(vec3d, vec3d1, false, true);
        vec3d = Vec3D.createVector(posX, posY, posZ);
        vec3d1 = Vec3D.createVector(posX + motionX, posY + motionY, posZ + motionZ);

        if (movingobjectposition != null)
        {
            vec3d1 = Vec3D.createVector(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
        }

        Entity entity = null;
        List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.addCoord(motionX, motionY, motionZ).expand(1.0D, 1.0D, 1.0D));
        double d = 0.0D;

        for (int l = 0; l < list.size(); l++)
        {
            Entity entity1 = (Entity)list.get(l);

            if (!entity1.canBeCollidedWith() || entity1 == shootingEntity && ticksInAir < 5)
            {
                continue;
            }

            float f5 = 0.3F;
            AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand(f5, f5, f5);
            MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec3d, vec3d1);

            if (movingobjectposition1 == null)
            {
                continue;
            }

            double d1 = vec3d.distanceTo(movingobjectposition1.hitVec);

            if (d1 < d || d == 0.0D)
            {
                entity = entity1;
                d = d1;
            }
        }

        if (entity != null)
        {
            movingobjectposition = new MovingObjectPosition(entity);
        }

        if (movingobjectposition != null)
        {
                xTile = movingobjectposition.blockX;
                yTile = movingobjectposition.blockY;
                zTile = movingobjectposition.blockZ;
            }
        }


    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        par1NBTTagCompound.setShort("xTile", (short)xTile);
        par1NBTTagCompound.setShort("yTile", (short)yTile);
        par1NBTTagCompound.setShort("zTile", (short)zTile);
        par1NBTTagCompound.setByte("inTile", (byte)inTile);
        par1NBTTagCompound.setByte("inData", (byte)inData);
        par1NBTTagCompound.setByte("shake", (byte)BoneMealShake);
        par1NBTTagCompound.setByte("inGround", (byte)(inGround ? 1 : 0));
        par1NBTTagCompound.setBoolean("player", doesBoneMealBelongToPlayer);
        par1NBTTagCompound.setDouble("damage", damage);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        xTile = par1NBTTagCompound.getShort("xTile");
        yTile = par1NBTTagCompound.getShort("yTile");
        zTile = par1NBTTagCompound.getShort("zTile");
        inTile = par1NBTTagCompound.getByte("inTile") & 0xff;
        inData = par1NBTTagCompound.getByte("inData") & 0xff;
        BoneMealShake = par1NBTTagCompound.getByte("shake") & 0xff;
        inGround = par1NBTTagCompound.getByte("inGround") == 1;
        doesBoneMealBelongToPlayer = par1NBTTagCompound.getBoolean("player");

        if (par1NBTTagCompound.hasKey("damage"))
        {
            damage = par1NBTTagCompound.getDouble("damage");
        }
    }

    /**
     * Called by a player entity when they collide with an entity
     */
    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
    {
        if (worldObj.isRemote)
        {
            return;
        }

        if (inGround && doesBoneMealBelongToPlayer && BoneMealShake <= 0 && par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.dyePowder, 1)))
        {
            worldObj.playSoundAtEntity(this, "random.pop", 0.2F, ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            par1EntityPlayer.onItemPickup(this, 1);
            setDead();
        }
    }

    public float getShadowSize()
    {
        return 0.0F;
    }

    public void setDamage(double par1)
    {
        damage = par1;
    }

    public double getDamage()
    {
        return damage;
    }

    public void func_46023_b(int par1)
    {
        field_46027_au = par1;
    }

    /**
     * If returns false, the item will not inflict any damage against entities.
     */
    public boolean canAttackWithItem()
    {
        return false;
    }
}
