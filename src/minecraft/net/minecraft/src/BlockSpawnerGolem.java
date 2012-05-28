package net.minecraft.src;

public class BlockSpawnerGolem extends Block
{
    protected BlockSpawnerGolem(int par1, int par2)
    {
        super(par1, par2, Material.rock);
    }
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
    	super.onBlockAdded(par1World, par2, par3, par4);
    	
    EntityIronGolem entityirongolem = new EntityIronGolem(par1World);
    entityirongolem.func_48115_b(true);
    entityirongolem.setLocationAndAngles((double)par2 + 0.5D, (double)par3, (double)par4 + 0.5D, 0.0F, 0.0F);
    par1World.spawnEntityInWorld(entityirongolem);
    par1World.setBlock(par2, par3, par4, 0);
    }
}
