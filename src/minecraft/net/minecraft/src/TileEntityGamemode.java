package net.minecraft.src;

import java.util.Random;

import net.minecraft.client.Minecraft;

public class TileEntityGamemode extends TileEntity
{
    public static Minecraft mc;
    public static boolean gamemode;
    
    public TileEntityGamemode(Minecraft minecraft)
    {
        mc = minecraft;
    }
    
    public static void changeGamemode()
    {
    	gamemode = !gamemode;
    	refreshGamemode();
    }
    
    public static void refreshGamemode()
    {
    	if (gamemode)
    	{
            mc.thePlayer.capabilities.allowFlying = false;
            mc.thePlayer.capabilities.isCreativeMode = false;
            mc.thePlayer.capabilities.disableDamage = false;
    	}
    	else if (gamemode = false)
    	{
            mc.thePlayer.capabilities.allowFlying = true;
            mc.thePlayer.capabilities.isCreativeMode = true;
            mc.thePlayer.capabilities.disableDamage = true;
    	}
    }
    
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        gamemode = par1NBTTagCompound.getBoolean("gamemode");
    }
    
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
            par1NBTTagCompound.setBoolean("gamemode", gamemode);
    }
    
}
