package net.minecraft.src;

import java.util.Map;

public class mod_Experimental extends BaseMod
{
	public static final Block Tonneau= (new BlockTonneau(150, net.minecraft.src.TileEntityTonneau.class)).setHardness(1F).setResistance(1F).setBlockName("Tonneau");
	public static final Item ItemTonneau= (new ItemReed(500, Tonneau)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/item/tonneau.png")).setItemName("Tonneau");
	public static final Block PressurePlateTest= (new BlockPressurePlateTest(151, 4, EnumMobType.mobs, Material.rock)).setHardness(1F).setResistance(1F).setBlockName("Test");
	public static final Block SpawnerGolem= (new BlockSpawnerGolem(152, 4)).setHardness(1F).setResistance(1F).setBlockName("Test");
	
	public void load()
        {
		RenderTonneau render_tonneau = new RenderTonneau();

		ModLoader.registerTileEntity(net.minecraft.src.TileEntityTonneau.class, "TileEntityTonneau", render_tonneau);

		ModLoader.addName(ItemTonneau, "Tonneau");

		ModLoader.addRecipe(new ItemStack(ItemTonneau, 1), new Object[]
		                {
		            "###",
		            "///", 
		            "###",
		Character.valueOf('#'), Block.planks, Character.valueOf('/'), Item.ingotIron,
		                });
		
		ModLoader.registerBlock(PressurePlateTest);
		ModLoader.addName(PressurePlateTest, "Pressure Plate Test");
		ModLoader.registerBlock(SpawnerGolem);
		ModLoader.addName(SpawnerGolem, "Spawner de Golem");
        } 
	
	public void addRenderer(Map map)
	{
		map.put(EntityCreeper.class, new RenderVie(new ModelCreeper(), 0.0F));
		map.put(EntityEnderman.class, new RenderVieEnderman(new ModelEnderman(), 0.0F));
		map.put(EntitySkeleton.class, new RenderVieSkeleton(new ModelSkeleton(), 0.0F));
		map.put(EntityPig.class, new RenderViePig(new ModelPig(), 0.0F));
		map.put(EntitySheep.class, new RenderVieSheep(new ModelSheep2(), 0.0F));
	//	map.put(EntityZombie.class, new RenderVieZombie(new ModelZombie(), 0.0F));
	}
    
   public String getVersion()
   {
      return "Phase de test 'Icule'...";
   }
}