package net.minecraft.src;

import java.util.Random;

public class BlockTonneau extends BlockContainer{

   private Class BlockTonneauEntityClass;
   
   protected BlockTonneau(int i, Class tClass)
   
   {
      super(i, Material.wood);
      BlockTonneauEntityClass = tClass;
   }
   
    public TileEntity getBlockEntity()

   {   
      try
         {
         return (TileEntity)BlockTonneauEntityClass.newInstance();
         }

      catch(Exception exception)
         {
         throw new RuntimeException(exception);
         }   
   }
   
   public int idDropped(int i, Random random, int j)
   {
      return mod_Experimental.ItemTonneau.shiftedIndex;
   }
       
   public int quantityDropped(Random random)
   {
      return 1;
   }
   
   public int getRenderType()
   {
      return -1;
   }

   public boolean isOpaqueCube()
   {
      return false;
   }
   
   public boolean renderAsNormalBlock()
   {
      return false;
   }
}