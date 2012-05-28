package net.minecraft.src;

import java.util.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class GuiInfo extends GuiContainer
{
    /**
     * x size of the inventory window in pixels. Defined as float, passed as int
     */
    private float xSize_lo;
    public EntityPlayer player;    



    /**
     * y size of the inventory window in pixels. Defined as float, passed as int.
     */
    private float ySize_lo;

    public GuiInfo(EntityPlayer par1EntityPlayer)
    {
        super(par1EntityPlayer.inventorySlots);
        allowUserInput = true;
        par1EntityPlayer.addStat(AchievementList.openInventory, 1);
        player = par1EntityPlayer;
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        if (mc.playerController.isInCreativeMode())
        {
            mc.displayGuiScreen(new GuiContainerCreative(mc.thePlayer));
        }
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        controlList.clear();
        xSize = 256;
        ySize = 166;
        int i = (width - xSize) / 2;
        int j = (height - ySize) / 2;

        if (mc.playerController.isInCreativeMode())
        {
            mc.displayGuiScreen(new GuiContainerCreative(mc.thePlayer));
        }
        
        super.initGui();
    }

    /**
     * Draw the foreground layer for the GuiContainer (everythin in front of the items)
     */
    protected void drawGuiContainerForegroundLayer()
    {
        fontRenderer.drawString(StatCollector.translateToLocal("container.crafting"), 104, 6, 0x404040);
        fontRenderer.drawString((new StringBuilder()).append("\2476").append(player.username).toString(), 190, 5, 0xffffff);    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        super.drawScreen(par1, par2, par3);
        xSize_lo = par1;
        ySize_lo = par2;
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        int i = mc.renderEngine.getTexture("/gui/inventory.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(i);
        int j = guiLeft;
        int k = guiTop;
        drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
        displayDebuffEffects();
        EntityLiving entity = new EntityCreeper(mc.theWorld); //on prend l'entité Creeper)

        GL11.glEnable(GL12.GL_RESCALE_NORMAL); //on déclare qu'on fait un rendu en 3D
        GL11.glEnable(GL11.GL_COLOR_MATERIAL); // Pareil
        GL11.glPushMatrix();  //On démarre le rendu
        GL11.glTranslatef(j + 51, k + 75, 50F); //on positionne le centre sur l'écran
        float f = 30F; //le facteur de zoom sur le modèle 3D
        GL11.glScalef(-f, f, f); //zoom
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);  //Rotation pour avoir un modèle dans le bon sens
        float f1 = entity.renderYawOffset; //on change la direction du corps de la bête
        float f2 = entity.rotationYaw; //on change la direction de la tête de la bête
        float f3 = entity.rotationPitch;
        float f4 = (float)(j + 51) - xSize_lo;
        float f5 = (float)((k + 75) - 50) - ySize_lo;
        GL11.glRotatef(135F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();//on active le rendu de la lumière
        GL11.glRotatef(-135F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-(float)Math.atan(f5 / 40F) * 20F, 1.0F, 0.0F, 0.0F);
        entity.renderYawOffset = (float)Math.atan(f4 / 40F) * 20F;
        entity.rotationYaw = (float)Math.atan(f4 / 40F) * 40F;
        entity.rotationPitch = -(float)Math.atan(f5 / 40F) * 20F;
        entity.rotationYawHead = entity.rotationYaw;
        GL11.glTranslatef(0.0F, entity.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180F;
        RenderManager.instance.renderEntityWithPosYaw(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);//on fait le rendu
        entity.renderYawOffset = f1;
        entity.rotationYaw = f2;
        entity.rotationPitch = f3;
        GL11.glPopMatrix();//on dit qu'on a fini le rendu
        RenderHelper.disableStandardItemLighting();//on désactive la lumière
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);//on annule la fonction 3D
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.id == 0)
        {
            mc.displayGuiScreen(new GuiAchievements(mc.statFileWriter));
        }

        if (par1GuiButton.id == 1)
        {
            mc.displayGuiScreen(new GuiStats(this, mc.statFileWriter));
        }

        if (par1GuiButton.id == 10)
        {
            mc.displayGuiScreen(new _GuiTuto(mc, player));
        }
        
//        if (par1GuiButton.id == 11)
//        {
//            mc.displayGuiScreen(new GuiCIadModo(mc, player));
//        }       
        
        if (par1GuiButton.id == 12)
        {
            mc.displayGuiScreen(new GuiSelectWorld(this));
        }
        
        if (par1GuiButton.id == 13)
        {
            mc.displayGuiScreen(new GuiLanguage(this, mc.gameSettings));
        }
        
        if (par1GuiButton.id == 14)
        {
            mc.displayGuiScreen(new GuiTexturePacks(this));

        }
        
        if (par1GuiButton.id == 15)
        {
            mc.displayGuiScreen(new _GuiTuto(mc, player));

        }


    }

    /**
     * Displays debuff/potion effects that are currently being applied to the player
     */
    private void displayDebuffEffects()
    {
        int i = guiLeft - 124;
        int j = guiTop;
        int k = mc.renderEngine.getTexture("/gui/inventory.png");
        Collection collection = mc.thePlayer.getActivePotionEffects();

        if (collection.isEmpty())
        {
            return;
        }

        int l = 33;

        if (collection.size() > 5)
        {
            l = 132 / (collection.size() - 1);
        }

        for (Iterator iterator = mc.thePlayer.getActivePotionEffects().iterator(); iterator.hasNext();)
        {
            PotionEffect potioneffect = (PotionEffect)iterator.next();
            Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            mc.renderEngine.bindTexture(k);
            drawTexturedModalRect(i, j, 0, ySize, 140, 32);

            if (potion.hasStatusIcon())
            {
                int i1 = potion.getStatusIconIndex();
                drawTexturedModalRect(i + 6, j + 7, 0 + (i1 % 8) * 18, ySize + 32 + (i1 / 8) * 18, 18, 18);
            }

            String s = StatCollector.translateToLocal(potion.getName());

            if (potioneffect.getAmplifier() == 1)
            {
                s = (new StringBuilder()).append(s).append(" II").toString();
            }
            else if (potioneffect.getAmplifier() == 2)
            {
                s = (new StringBuilder()).append(s).append(" III").toString();
            }
            else if (potioneffect.getAmplifier() == 3)
            {
                s = (new StringBuilder()).append(s).append(" IV").toString();
            }

            fontRenderer.drawStringWithShadow(s, i + 10 + 18, j + 6, 0xffffff);
            String s1 = Potion.getDurationString(potioneffect);
            fontRenderer.drawStringWithShadow(s1, i + 10 + 18, j + 6 + 10, 0x7f7f7f);
            j += l;
        }
    }
}
