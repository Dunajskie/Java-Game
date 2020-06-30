/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project;
import java.util.*; 
/**
 *
 * @author michal
 */
public class Organism {
    protected int initiative;
    public int x;
    public int y;
    protected World world;
    protected int strength;
    
    Organism(int strength,int initiative,int x,int y, World world)
    {
        
    }
    String getName()
    {
        return this.getClass().getSimpleName();
    }
    boolean defense(Organism attacker)
    {
        if(this.strength>attacker.strength)
        {
            return true;
        }
        else       
         return false;
    }
    String draw()
    {
       return "s";
    }
    void action()
    {
    }
    void collision()
    {
        
    }
    
}
