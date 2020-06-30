/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project;
import java.util.Random;
import java.util.*; 
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author michal
 */
public class Animal extends Organism {
    protected int lastx;
    protected int lasty;
    protected int movement;
    
    public Animal(int strength,int initiative,int x,int y, World world)
    {  
        super(strength,initiative,x,y,world);
        this.world = world;
        this.strength = strength;
        this.initiative = initiative;
        this.x = x;
        this.y = y;
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
    
    
    
    
    @Override
    void collision()
    {
        Organism other=world.space[x][y];
        int rand = ThreadLocalRandom.current().nextInt(0, 2);
        if(other instanceof Guarana)
        {
            world.space[x][y]=this;
            int z=this.strength;
            this.strength=3*z;
           
            for(int i=0;i<world.Organisms.size();i++)
        {
            
            if(world.Organisms.get(i)==other)
            {
                world.Organisms.removeElement(other);
                break;
            }
        }
            world.space[lastx][lasty]=null;
           world.addComment(this.getName());
        world.com.append(" eated Guarana and gained 3x strength");
        world.com.append("\n");
            
        }
        else if((other instanceof SosnowskyWeed)&&(this instanceof CyberSheep))
        {
            world.space[x][y]=this;
            for(int i=0;i<world.Organisms.size();i++)
        {
            
            if(world.Organisms.get(i)==other)
            {
                world.Organisms.removeElement(other);
                break;
            }
        }
            world.space[lastx][lasty]=null;
            world.com.append(this.getName());
        world.com.append(" eated Sosnowsky's Hogweed");
        world.com.append("\n");
        }
        else if((other instanceof Antelope)&&(rand==1))
          {
              
              world.space[x][y]=null;
              world.space[x][y]=this;
              world.space[lastx][lasty]=other;  
              other.x=lastx;
              other.y=lasty;
              world.com.append(other.getName());
        world.com.append(" escaped");
        world.com.append("\n");
          }
        else if((other instanceof Turtle)&&(this.strength<5))
          {
                 y=lasty;
                 x=lastx;  
                 world.com.append(other.getName());
        world.com.append(" saved the position");
        world.com.append("\n");
          }
        else if(other.defense(this))
        {
            world.space[lastx][lasty]=null;
            for(int i=0;i<world.Organisms.size();i++)
        {
            
            if(world.Organisms.get(i)==this)
            {
                world.Organisms.removeElement(this);
                break;
            }
        }
            world.com.append(other.getName());
        world.com.append(" defended");
        world.com.append("\n");
            
        }
        
        else if(!other.defense(this))
        {
            if(other instanceof Human)
            {
                world.man.alive=false;
                
        world.com.append(" You died!!!");
        world.com.append("\n");
            }
            for(int i=0;i<world.Organisms.size();i++)
        {
            
            if(world.Organisms.get(i)==other)
            {
                world.Organisms.removeElement(other);
                break;
            }
        }
            world.space[x][y]=this;
            world.space[lastx][lasty]=null;
            world.com.append(this.getName());
        world.com.append(" eated");
        world.com.append("\n");
        }
    }
}
