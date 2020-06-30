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
public class Plant extends Organism{
    
    Plant(int strength,int x,int y, World world)
    {
        super(strength,0,x,y,world);
        this.world=world;
        this.strength = strength;
        this.x = x;
        this.y = y;
        
    }
    
}
