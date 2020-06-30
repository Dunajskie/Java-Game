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
public class Antelope extends Animal{
    
    Antelope(int x, int y, World world)
    {
        super(4,4,x,y,world);
    }
    @Override
    String draw()
    {
        return "A";
    }
    @Override
    void action()
    {
        lastx=x;
        lasty=y;
        
      
        
    while((lastx==x)&&(lasty==y))
    {
    movement = ThreadLocalRandom.current().nextInt(0, 8);
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
    else if(movement==4)
    {
        if(y+2<10)
        {
        y=y+2;
        break;
        }
    }
    else if(movement==5)
    {
        if(y-2>=0)
        {
        y=y-2;
        break;
        }
    }
    else if(movement==6)
    {
        if(x+2<10)
        {
        x=x+2;
        break;
        }
    }
    else if(movement==7)
    {
        if(x-2>=0)
        {
        x=x-2;
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
