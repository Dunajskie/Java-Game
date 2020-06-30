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
public class Sheep extends Animal {
    
    Sheep(int x, int y, World world)
    {
        super(4,4,x,y,world);
    }
    @Override
    String draw()
    {
        return "S";
    }
}
