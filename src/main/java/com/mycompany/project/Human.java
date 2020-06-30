/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project;
import java.util.*; 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author michal
 */
public class Human extends Animal{
    
    private int move;
    boolean alive=true;
    boolean ability=false;
     
    
    
    Human(int x,int y,World world)
    {
        super(5,4,x,y,world);
        this.world = world;
        //this.strength = strength;
       // this.initiative = initiative;
        this.x = x;
        this.y = y;
    }
    void direction(int m)
    {
        move=m;
    }
    @Override
    String draw()
    {
        return "H";
    }
    
    
    @Override
    void action()
    {
        lastx=x;
        lasty=y;
        boolean moved=false;
    if(move==1)
    {
        if(x-1>=0)
        {
        x=x-1;
        moved=true;
        }
    }
    else if(move==2)
    {
        if(x+1<10)
        {
        x=x+1;
        moved=true;
        }
    }
    else if(move==3)
    {
        if(y+1<10)
        {
        y=y+1;
        moved=true;
        }
    }
    else if(move==4)
    {
        if(y-1>=0)
        {
        y=y-1;
        moved=true;
        }
    }
    if(moved)
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
        world.addComment(" moved");
        world.addComment("\n");
    }
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
            System.out.println(this.getName());
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
        world.com.append(" eated Guarana and gained 3x strength");
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
        else if(other.strength<=this.strength)
        {
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
              world.com.append(other.getName());
        world.com.append(" defended");
        world.com.append("\n");
            
        }
        else
    {
        
        alive=false;
        world.space[lastx][lasty]=null;
         world.com.append(" You died!!!");
        world.com.append("\n");
    }
         
    }
}
 