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
public class Belladona extends Plant{
    
    Belladona(int x , int y, World world)
    {
        super(99,x,y,world);
    }
    @Override
    String draw()
    {
        return "Y";
    }
}
