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
public class CyberSheep extends Animal{
    
    CyberSheep(int x, int y,World world)
    {
        super(11,4,x,y,world);
    }
    @Override
    String draw()
    {
        return "C";
    }
    @Override
    void action()
    {
        lastx=x;
        lasty=y;
        boolean weed=false;
        for(int i=0;i<world.Organisms.size();i++)
        {
            if(world.Organisms.get(i) instanceof SosnowskyWeed)
            {
                if(world.Organisms.get(i).x>this.x)
                {
                    this.x++;
                    weed=true;
                }
                else if(world.Organisms.get(i).x<this.x)
                {
                    this.x--;
                    weed=true;
                }
                else if(world.Organisms.get(i).y<this.y)
                {
                    this.y--;
                    weed=true;
                }
                else if(world.Organisms.get(i).y>this.y)
                {
                    this.y++;
                    weed=true;
                }
                
                if(weed==true)
                {
                    if(world.space[x][y]!=null)
                    {
                       collision();
                    }
    
                         else
                      {
        
                          world.space[x][y]=this;
                          world.space[lastx][lasty]=null;
                          world.addComment(this.getName());
        world.addComment("moved");
        world.addComment("\n");
                       }
                }
                 break;   
            }
            
            
        }
        if(!weed)
        {
            
        while((lastx==x)&&(lasty==y))
    {
    movement = ThreadLocalRandom.current().nextInt(0, 4);
    if(movement==0)
    {
        if(x-1>=0)
        {
        x--;
        break;
        }
    }
    else if(movement==1)
    {
        if(x+1<10)
        {
        x++;
        break;
        }
    }
    else if(movement==2)
    {
        if(y-1>=0)
        {
        y--;
        break;
        }
    }
    else if(movement==3)
    {
        if(y+1<10)
        {
        y++;
        break;
        }
    }
    }
    
    if(world.space[x][y]!=null)
    {
        collision();
    }
    
    else
    {
        
        world.space[x][y]=this;
        world.space[lastx][lasty]=null;
        world.addComment(this.getName());
        world.addComment("moved");
        world.addComment("\n");
    }
    }
        
        
    }
}
