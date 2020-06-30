/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project;

/**
 *
 * @author michal
 */
public class SosnowskyWeed extends Plant{
    SosnowskyWeed(int x, int y, World world)
    {
        super(99,x,y,world);
    }
    @Override
    String draw()
    {
        return "w";
    }
    @Override
    void action()
    {
        if(x+1<10)
        {
        if(world.space[x+1][y]!=null)
        {
        if((world.space[x+1][y].strength<90)&&(world.space[x+1][y] instanceof Animal)&&(!(world.space[x+1][y] instanceof CyberSheep)))
                {
                    Organism other=world.space[x+1][y];
                    if(other instanceof Human)
                    {
                        world.man.alive=false;
                        world.addComment("you died!!!");
       
                         world.addComment("\n");
                    }
                    world.addComment(this.getName());
        world.addComment("was killed by Weed");
        world.addComment("\n");
                    for(int i=0;i<world.Organisms.size();i++)
                 {
            
            if(world.Organisms.get(i)==other)
            {
                world.Organisms.removeElement(other);
                break;
            }
               }
                    world.space[x+1][y]=null;
                }
        }
        }
        if(x-1>=0)
        {
        if(world.space[x-1][y]!=null)
        {
        if((world.space[x-1][y].strength<90)&&(world.space[x-1][y] instanceof Animal)&&(!(world.space[x-1][y] instanceof CyberSheep)))
                {
                    Organism other=world.space[x-1][y];
                    if(other instanceof Human)
                    {
                        world.man.alive=false;
                        world.addComment("you died!!!");
       
                         world.addComment("\n");
                    }
                    world.addComment(this.getName());
        world.addComment("was killed by Weed");
        world.addComment("\n");
                    for(int i=0;i<world.Organisms.size();i++)
                 {
            
            if(world.Organisms.get(i)==other)
            {
                world.Organisms.removeElement(other);
                break;
            }
               }
                    world.space[x-1][y]=null;
                }
        }
        }
        if(y-1>=0)
        {
        if(world.space[x][y-1]!=null)
        {
        if((world.space[x][y-1].strength<90)&&(world.space[x][y-1] instanceof Animal)&&(!(world.space[x][y-1] instanceof CyberSheep)))
                {
                    Organism other=world.space[x][y-1];
                    if(other instanceof Human)
                    {
                        world.man.alive=false;
                        world.addComment("you died!!!");
       
                         world.addComment("\n");
                    }
                    world.addComment(this.getName());
        world.addComment("was killed by Weed");
        world.addComment("\n");
                    for(int i=0;i<world.Organisms.size();i++)
                 {
            
            if(world.Organisms.get(i)==other)
            {
                world.Organisms.removeElement(other);
                break;
            }
               }
                    world.space[x][y-1]=null;
                }
        }
        }
        if(y+1<10)
        {
        if(world.space[x][y+1]!=null)
        {
        if((world.space[x][y+1].strength<90)&&(world.space[x][y+1] instanceof Animal)&&(!(world.space[x][y+1] instanceof CyberSheep)))
                {
                    Organism other=world.space[x][y+1];
                    if(other instanceof Human)
                    {
                        world.addComment("you died!!!");
       
                         world.addComment("\n");
                        world.man.alive=false;
                    }
                    world.addComment(this.getName());
        world.addComment("was killed by Weed");
        world.addComment("\n");
                    for(int i=0;i<world.Organisms.size();i++)
                 {
            
            if(world.Organisms.get(i)==other)
            {
                world.Organisms.removeElement(other);
                break;
            }
               }
                    world.space[x][y+1]=null;
                }
        }
        }
    }
}
