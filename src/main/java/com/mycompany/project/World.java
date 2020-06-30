/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.project;
import java.util.Random;
import java.util.*; 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Collections;
import java.util.Vector;
/**
 *
 * @author michal
 */

public class World {
    
     Vector<Organism> Organisms = new Vector<Organism>(0);
     Organism[][] space = new Organism[10][10];
     Human man;
     StringBuilder com = new StringBuilder("-");
     int turn=0;
     int round=0;
     
    void GenerateWorld()
    {
        int pair[] = NewPosition();
        Organism wolf = new Wolf(pair[0],pair[1],this);
        space[pair[0]][pair[1]]=wolf;
        System.out.println("wolf" + pair[0] +pair[1]);
        Organisms.add(wolf);
        pair=NewPosition();
        Organism fox = new Fox(pair[0],pair[1],this);
        space[pair[0]][pair[1]]=fox;
        System.out.println("fox" + pair[0] +pair[1]);
        Organisms.add(fox);
        pair=NewPosition();
        man = new Human(pair[0],pair[1],this);
        space[pair[0]][pair[1]]=man;
        System.out.println("man"+ pair[0] +pair[1]);
        Organisms.add(man);
        pair=NewPosition();
        Organism sheep = new Sheep(pair[0],pair[1],this);
        space[pair[0]][pair[1]]=sheep;
        Organisms.add(sheep);
        System.out.println("sheep"+ pair[0] +pair[1]);
        pair=NewPosition();
        Organism antelope = new Antelope(pair[0],pair[1],this);
        space[pair[0]][pair[1]]=antelope;
        Organisms.add(antelope);
        System.out.println("antelope"+ pair[0] +pair[1]);
        pair=NewPosition();
        Organism cyber = new CyberSheep(pair[0],pair[1],this);
        space[pair[0]][pair[1]]=cyber;
        Organisms.add(cyber);
        System.out.println("antelope"+ pair[0] +pair[1]);
        pair=NewPosition();
        Organism turtle = new Turtle(pair[0],pair[1],this);
        space[pair[0]][pair[1]]=turtle;
        Organisms.add(turtle);
        System.out.println("turtle"+ pair[0] +pair[1]);
        pair=NewPosition();
        Organism grass = new Grass(pair[0],pair[1],this);
        space[pair[0]][pair[1]]=grass;
        Organisms.add(grass);
        System.out.println("grass"+ pair[0] +pair[1]);
        pair=NewPosition();
        Organism guarana = new Guarana(pair[0],pair[1],this);
        space[pair[0]][pair[1]]=guarana;
        Organisms.add(guarana);
        System.out.println("Guarana"+ pair[0] +pair[1]);
        pair=NewPosition();
        Organism bella = new Belladona(pair[0],pair[1],this);
        space[pair[0]][pair[1]]=bella;
        Organisms.add(bella);
        System.out.println("Belladona"+ pair[0] +pair[1]);
        pair=NewPosition();
        Organism sow = new SowThistle(pair[0],pair[1],this);
        space[pair[0]][pair[1]]=sow;
        Organisms.add(sow);
        System.out.println("Sow"+ pair[0] +pair[1]);
        pair=NewPosition();
        Organism weed = new SosnowskyWeed(pair[0],pair[1],this);
        space[pair[0]][pair[1]]=weed;
        Organisms.add(weed);
        System.out.println("weed"+ pair[0] +pair[1]);
        
    }
    public World()
    {
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                space[i][j]=null;
            }
        }
       GenerateWorld();
    }
     public int[] NewPosition()
    {
        int position[]= new int[2];
        int x = ThreadLocalRandom.current().nextInt(0, 10);
        int y = ThreadLocalRandom.current().nextInt(0, 10);

        while(space[x][y]!=null)
        {
        x = ThreadLocalRandom.current().nextInt(0, 10);
        y = ThreadLocalRandom.current().nextInt(0, 10);
        }
        position[0]=x;
        position[1]=y;
        return position;
    }
     void HumanDirection(int direction)
    {
        man.direction(direction);
    }
     boolean Maketurn()
    {
        if(man.ability==false)
        {
            round++;
        }
        else
        {
            specialAbility();
        }
        turn++;
        
        
        if(man.alive==true)
        {
            //int h=Organisms.size();
            for(int t=0;t<Organisms.size();t++)
            {
               Organisms.get(t).action();
               
            }
          return true;
        }
        
         
        else
           return false;
    }
     StringBuilder drawWorld()
    {
        StringBuilder sb = new StringBuilder();
        
        
       for(int i=0;i<10;i++)
    {
        
        for (int j=0;j<10;j++)
        {
         
            sb.append("|");
            if(space[i][j]!=null)
            {
                sb.append(space[i][j].draw());
            }
            else
            {
                sb.append(" ");
            }
            
        }
        sb.append("|");
        sb.append("\n");
    }
       return sb;
    }
     void addComment(String comment)
     {
         com.append(comment);
     }
     void specialAbility()
     {
         if(man.strength>5)
         {
         man.strength=10-(turn-round);
         com.append("Human strength = ");
        com.append(man.strength);
        com.append("\n");
         }
         else
         {
             man.strength=5;
         }
         
         
     }
     void makeNew(int xa, int ya, int sa, World world,String line)
     {
         if(line.equals("Wolf"))
         {
             Organism wolf = new Wolf(xa,ya,this);
             wolf.strength=sa;
             space[xa][ya]=wolf;                   
             Organisms.add(wolf);
         }
         if(line.equals("Sheep"))
         {
             Organism sheep = new Sheep(xa,ya,this);
             sheep.strength=sa;
             space[xa][ya]=sheep;                   
             Organisms.add(sheep);
         }
         if(line.equals("Antelope"))
         {
             Organism antelope = new Antelope(xa,ya,this);
             antelope.strength=sa;
             space[xa][ya]=antelope;                   
             Organisms.add(antelope);
         }
         if(line.equals("CyberSheep"))
         {
             Organism cyber = new CyberSheep(xa,ya,this);
             cyber.strength=sa;
             space[xa][ya]=cyber;                   
             Organisms.add(cyber);
         }
         if(line.equals("Fox"))
         {
             Organism fox = new Fox(xa,ya,this);
             fox.strength=sa;
             space[xa][ya]=fox;                   
             Organisms.add(fox);
         }
         if(line.equals("Human"))
         {
             Organism human = new Human(xa,ya,this);
             human.strength=sa;
             space[xa][ya]=human;                   
             Organisms.add(human);
         }
         if(line.equals("Turtle"))
         {
             Organism turtle = new Turtle(xa,ya,this);
             turtle.strength=sa;
             space[xa][ya]=turtle;                   
             Organisms.add(turtle);
         }
         if(line.equals("Belladona"))
         {
             Organism bella = new Belladona(xa,ya,this);
             
             space[xa][ya]=bella;                   
             Organisms.add(bella);
         }
         if(line.equals("Grass"))
         {
             Organism grass = new Grass(xa,ya,this);
             
             space[xa][ya]=grass;                   
             Organisms.add(grass);
         }
         if(line.equals("Guarana"))
         {
             Organism guarana = new Guarana(xa,ya,this);
             
             space[xa][ya]=guarana;                   
             Organisms.add(guarana);
         }
         if(line.equals("SosnowskyWeed"))
         {
             Organism weed = new SosnowskyWeed(xa,ya,this);
             
             space[xa][ya]=weed;                   
             Organisms.add(weed);
         }
         if(line.equals("SowThistle"))
         {
             Organism sow = new SowThistle(xa,ya,this);
             
             space[xa][ya]=sow;                   
             Organisms.add(sow);
         }
         
         Organism temp;
         for(int i=0;i<Organisms.size()-1;i++)
         {
             for(int j=0;j<Organisms.size()-1;j++)
             {
                 if(Organisms.get(i).initiative>Organisms.get(i+1).initiative)
                 {
                     Collections.swap(Organisms, i, i+1);
                 }
             }
         }
     }
    
}
