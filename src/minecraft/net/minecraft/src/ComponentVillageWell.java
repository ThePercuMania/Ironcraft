package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class ComponentVillageWell extends ComponentVillage
{
    private final boolean field_35104_a = true;
    private int averageGroundLevel;

    public ComponentVillageWell(int par1, Random par2Random, int par3, int par4)
    {
        super(par1);
        averageGroundLevel = -1;
        coordBaseMode = par2Random.nextInt(4);

        switch (coordBaseMode)
        {
            case 0:
            case 2:
                boundingBox = new StructureBoundingBox(par3, 64, par4, (par3 + 6) - 1, 78, (par4 + 6) - 1);
                break;

            default:
                boundingBox = new StructureBoundingBox(par3, 64, par4, (par3 + 6) - 1, 78, (par4 + 6) - 1);
                break;
        }
    }

    /**
     * Initiates construction of the Structure Component picked, at the current Location of StructGen
     */
    public void buildComponent(StructureComponent par1StructureComponent, List par2List, Random par3Random)
    {
        StructureVillagePieces.getNextStructureComponentVillagePath((ComponentVillageStartPiece)par1StructureComponent, par2List, par3Random, boundingBox.minX - 1, boundingBox.maxY - 4, boundingBox.minZ + 1, 1, getComponentType());
        StructureVillagePieces.getNextStructureComponentVillagePath((ComponentVillageStartPiece)par1StructureComponent, par2List, par3Random, boundingBox.maxX + 1, boundingBox.maxY - 4, boundingBox.minZ + 1, 3, getComponentType());
        StructureVillagePieces.getNextStructureComponentVillagePath((ComponentVillageStartPiece)par1StructureComponent, par2List, par3Random, boundingBox.minX + 1, boundingBox.maxY - 4, boundingBox.minZ - 1, 2, getComponentType());
        StructureVillagePieces.getNextStructureComponentVillagePath((ComponentVillageStartPiece)par1StructureComponent, par2List, par3Random, boundingBox.minX + 1, boundingBox.maxY - 4, boundingBox.maxZ + 1, 0, getComponentType());
    }

    /**
     * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at
     * the end, it adds Fences...
     */
    public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox)
    {
        if (averageGroundLevel < 0)
        {
            averageGroundLevel = getAverageGroundLevel(par1World, par3StructureBoundingBox);

            if (averageGroundLevel < 0)
            {
                return true;
            }

            boundingBox.offset(0, (averageGroundLevel - boundingBox.maxY) + 3, 0);
        }

        if (!field_35104_a);

        fillWithBlocks(par1World, par3StructureBoundingBox, 1, 0, 1, 4, 12, 4, Block.cobblestone.blockID, Block.waterMoving.blockID, false);
        placeBlockAtCurrentPosition(par1World, 0, 0, 2, 12, 2, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, 0, 0, 3, 12, 2, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, 0, 0, 2, 12, 3, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, 0, 0, 3, 12, 3, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.fence.blockID, 0, 1, 13, 1, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.fence.blockID, 0, 1, 14, 1, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.fence.blockID, 0, 4, 13, 1, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.fence.blockID, 0, 4, 14, 1, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.fence.blockID, 0, 1, 13, 4, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.fence.blockID, 0, 1, 14, 4, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.fence.blockID, 0, 4, 13, 4, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.fence.blockID, 0, 4, 14, 4, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.fenceGate.blockID, 1, 2, 0, 2, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.fenceGate.blockID, 1, 2, 0, 3, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.fenceGate.blockID, 1, 3, 0, 3, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.fenceGate.blockID, 1, 3, 0, 2, par3StructureBoundingBox); 
        
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 2, 1, 0, 2, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 1, 0, 3, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 1, -1, 3, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 2, 1, -1, 2, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 1, -2, 3, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 1, 1, -2, 2, par3StructureBoundingBox); 
        
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 4, 0, 2, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 4, 0, 3, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 1, 4, -1, 3, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 1, 4, -1, 2, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 4, -2, 3, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 4, -2, 2, par3StructureBoundingBox); 
        
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 2, 0, 1, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 3, 0, 1, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 1, 2, -1, 1, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 3, -1, 1, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 2, -2, 1, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 3, -2, 1, par3StructureBoundingBox); 
        
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 2, -3, 2, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 1, 2, -3, 3, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 3, -3, 2, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 2, 3, -3, 3, par3StructureBoundingBox); 
        
        placeBlockAtCurrentPosition(par1World, Block.fenceIron.blockID, 0, 0, -2, 4, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, Block.fenceIron.blockID, 0, 0, -1, 4, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, Block.fenceIron.blockID, 0, 0, 0, 4, par3StructureBoundingBox); 
        
        placeBlockAtCurrentPosition(par1World, mod_Experimental.SpawnerGolem.blockID, 0, 1, -2, 6, par3StructureBoundingBox); 
        
        for(int d = 2; d < 4; d++)
        {
        	placeBlockAtCurrentPosition(par1World, 0, 0, d, -1, d, par3StructureBoundingBox); 
        	placeBlockAtCurrentPosition(par1World, 0, 0, 3, -1, 2, par3StructureBoundingBox); 
        	placeBlockAtCurrentPosition(par1World, 0, 0, 2, -1, 3, par3StructureBoundingBox); 
        	placeBlockAtCurrentPosition(par1World, 0, 0, d, -2, d, par3StructureBoundingBox); 
        	placeBlockAtCurrentPosition(par1World, 0, 0, 3, -2, 2, par3StructureBoundingBox); 
        	placeBlockAtCurrentPosition(par1World, 0, 0, 2, -2, 3, par3StructureBoundingBox); 
        }
        
        for(int t = 4; t < 10; t++)
        {
        placeBlockAtCurrentPosition(par1World, 0, 0, 3, -1, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, 0, 0, 3, -2, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, 0, 0, 3, 0, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, 0, 0, 2, -1, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, 0, 0, 2, -2, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, 0, 0, 2, 0, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, 0, 0, 1, -1, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, 0, 0, 1, -2, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, 0, 0, 1, 0, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, 0, 0, 4, -1, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, 0, 0, 4, -2, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, 0, 0, 4, 0, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 1, 1, t, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 2, 1, t, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 3, 1, t, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 4, 1, t, par3StructureBoundingBox);
        
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, -2, 0, t, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, -2, -1, t, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, -2, -2, t, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 7, 0, t, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 7, -1, t, par3StructureBoundingBox);
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 7, -2, t, par3StructureBoundingBox);
        
        placeBlockAtCurrentPosition(par1World, Block.pressurePlateStone.blockID, 0, 3, -2, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, Block.pressurePlateStone.blockID, 0, 2, -2, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 3, -3, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 2, -3, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, Block.redstoneLampIdle.blockID, 0, 1, -3, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, Block.redstoneLampIdle.blockID, 0, 4, -3, t, par3StructureBoundingBox); 
        
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 0, -3, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 5, -3, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, -1, -3, t, par3StructureBoundingBox); 
        placeBlockAtCurrentPosition(par1World, Block.stoneBrick.blockID, 0, 6, -3, t, par3StructureBoundingBox); 
        }
        
        for(int t = 4; t < 10; t++)
        {
        
        }
        
        fillWithBlocks(par1World, par3StructureBoundingBox, 1, 15, 1, 4, 15, 4, Block.cobblestone.blockID, Block.cobblestone.blockID, false);

        for (int i = 0; i <= 5; i++)
        {
            for (int j = 0; j <= 5; j++)
            {
                if (j == 0 || j == 5 || i == 0 || i == 5)
                {
                    placeBlockAtCurrentPosition(par1World, Block.gravel.blockID, 0, j, 11, i, par3StructureBoundingBox);
                    clearCurrentPositionBlocksUpwards(par1World, j, 12, i, par3StructureBoundingBox);
                }
            }
        }

        return true;
    }
}
