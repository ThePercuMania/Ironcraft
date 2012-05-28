package net.minecraft.src;

   /** Import */
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class _GuiTuto extends GuiScreen
{
    
    /** Variable */
    private Minecraft mc;
    private EntityPlayer player;
    private int xSize;
    private int ySize;
    
    private GuiTextField Champs;

    public _GuiTuto(Minecraft minecraft, EntityPlayer entityplayer)
    {
        xSize = 256;   // xSize vaut ici 256
        ySize = 202;    // ySize vaut ici 202
        mc = minecraft;   // mc remplace minecraft.
        player = entityplayer;   //player remplace entityplayer
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     * Ajoute les boutons (et autre controls) à la gui en question.
     */
    
    public void initGui()
    {
        controlList.clear();
        int i = (width - xSize) / 2;
        int j = (height - ySize) / 2;

        
        /** Champs */  
        controlList.add(new GuiSmallButton(02, i + 4, j + 39, 248, 20, "Changer le nom de ma Map"));   //02 c'est l'id du bouton     
        Champs = new GuiTextField(fontRenderer, i + 4, j + 15, 248, 20);   //Crée le champs de text.
        Champs.setText("Nouveau nom ?");   //Définie le texte de Champs

    }

    protected void actionPerformed(GuiButton guibutton)
    { 
       
              if (guibutton.id == 02)
              {
                      mc.theWorld.worldInfo.setWorldName(Champs.getText());   //Modifie le nom de la map avec le texte inscrit dans Champs.
                      mc.thePlayer.closeScreen();      //Ferme la gui
              }
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int i, int j, float f)
    {
        int k = (width - xSize) / 2;
        int l = (height - ySize) / 2;
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
        BackgroundImage();      // On appel la fonction BackgroundImage() qui se trouve sur ce fichier.
        drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
        super.drawScreen(i, j, f);
        Champs.drawTextBox();      
    }

    protected void BackgroundImage()
    {
        int i = (width - xSize) / 2;
        int j = (height - ySize) / 2;
        int k = mc.renderEngine.getTexture("/gui/inventory.png");      //k prend la texture FondGui.png qui se trouve dans .minecraft.jar/gui/FondGui.png.
        mc.renderEngine.bindTexture(k);
        drawTexturedModalRect(i, j, 0, 0, xSize, ySize);
    }


    /**
     * Called when the mouse is clicked.
     * Appelé lorsque l'utilisateur clique.
     */
    protected void mouseClicked(int i, int j, int k)
    {
        super.mouseClicked(i, j, k);
        Champs.mouseClicked(i, j, k);   //Utilisé lorsque l'utilisateur clique dans le champs.
    }
    
    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     * Déclenché lorsque une touche est tapé. C'est l'équivalent de KeyListener.keyTyped (KeyEvent e).
     */
    protected void keyTyped(char c, int i)
    {
        super.keyTyped(c, i);
    }

    /**
     * Called from the main game loop to update the screen.
     * Appelé à partir de la boucle de jeu principale ce qui permet de mettre à jour l'écran.
     */
    public void updateScreen()
    {
        super.updateScreen();

        if (!mc.thePlayer.isEntityAlive() || mc.thePlayer.isDead)
        {
            mc.thePlayer.closeScreen();
        }
    }
}