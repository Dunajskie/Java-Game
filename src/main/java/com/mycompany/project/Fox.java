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
public class Fox extends Animal {
    
    Fox(int x, int y, World world)
    {
        super(3,7,x,y,world);
    }
     @Override
    String draw()
    {
        return "F";
    }
    @Override
    void action()
    {
        lastx=x;
        lasty=y;
        
        
    while((lastx==x)&&(lasty==y))
    {
    movement = ThreadLocalRandom.current().nextInt(0, 4);
    if(movement==0)
    {
        if((x-1>=0)&&((world.space[x-1][y]==null)||(world.space[x-1][y].strength<=3)))
        {
        x--;
        break;
        }
    }
    else if(movement==1)
    {
        if((x+1<10)&&((world.space[x+1][y]==null)||(world.space[x+1][y].strength<=3)))
        {
        x++;
        break;
        }
    }
    else if(movement==2)
    {
        if((y-1>=0)&&((world.space[x][y-1]==null)||(world.space[x][y-1].strength<=3)))
        {
        y--;
        break;
        }
    }
    else if(movement==3)
    {
        if((y+1<10)&&((world.space[x][y+1]==null)||(world.space[x][y+1].strength<=3)))
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
       world.addComment(" moved");
       world.addComment("\n");
    }
    }
}
