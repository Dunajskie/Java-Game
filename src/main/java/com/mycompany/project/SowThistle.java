/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author michal
 */
public class SowThistle extends Plant{
    
    SowThistle(int x, int y, World world)
    {
        super(0,x,y,world);
    }
    @Override
    String draw()
    {
        return ".";
    }
    //@Override
   // void action()
   // {
   //     int d = ThreadLocalRandom.current().nextInt(0, 4);
        
   //     if((d!=0)&&(x-1>=0))
    //    {
    //        if(world.space[x-1][y]==null)
    //        {
   //          Organism sow_thistle= new SowThistle(x-1,y,world);
   //          world.space[x-1][y]=sow_thistle;
   //          world.Organisms.add(sow_thistle);
   //         }
   //     }
   //     if((d!=1)&&(x+1<10))
   //     {
   //         if(world.space[x+1][y]==null)
   //         {
   //         Organism sow_thistle= new SowThistle(x+1,y,world);
   //         world.space[x+1][y]=sow_thistle;
    //        world.Organisms.add(sow_thistle);
            
    //        }
     //   }
    //    if((d!=2)&&(y-1>=0))
    //    {
    //        if(world.space[x][y-1]==null)
    //        {
    //        Organism sow_thistle= new SowThistle(x,y-1,world);
    //        world.space[x][y-1]=sow_thistle;
    //        world.Organisms.add(sow_thistle);
           
    //        }
    //    }
    //    if((d!=3)&&(y+1<10))
    //    {
    //        if(world.space[x][y+1]==null)
    //        {
    //        Organism sow_thistle= new SowThistle(x,y+1,world);
    //        world.space[x][y+1]=sow_thistle;
    //        world.Organisms.add(sow_thistle);
            
    //       }
    //   }
    
   // }
}
