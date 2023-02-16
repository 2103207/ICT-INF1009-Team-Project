/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

/**
 *
 * @author lyz
 */
public class Collidable <C> extends Entity implements iCollidable <C>{
    private C cobj; // Generic collidable object
    private float w; // Width
    private float h; // Height
    
    public Collidable()
    {
        // Blank Constructor
    }
    
    public Collidable(float posx, float posy, C newc, float w, float h)
    {
        this.cobj = newc;
        ((Entity)this.cobj).setX(posx);
        ((Entity)this.cobj).setY(posy);
        this.w = w;
        this.h = h;
    }
    
    public float getW()
    {
        return w;
    }
    
    public float getH()
    {
        return h;
    }
    
    // Returns true if object is colliding and false if not colliding
    public boolean collided(C c)
    {
        // Checks the right of the right corner of c
        boolean check1 = (((Collidable)this.cobj).getX() < (((Collidable)c).getX() + ((Collidable)c).getW()));
        // Checks the top of c
        boolean check2 = (((Collidable)this.cobj).getY() < (((Collidable)c).getY() + ((Collidable)c).getH()));
        // Checksthe left of the left corner of c
        boolean check3 = ((((Collidable)this.cobj).getX() + ((Collidable)this.cobj).getW()) > ((Collidable)c).getX());
        // Checks the bottom of c
        boolean check4 = ((((Collidable)this.cobj).getY() + ((Collidable)this.cobj).getH()) > ((Collidable)c).getY());
        
        return check1 && check2 && check3 && check4;
    }
    
    public void handleCollision()
    {
        // Collision code here
    }
    
    public void reactToCollision()
    {
        // Reacting code here
    }
    
    public void movement()
    {
        // Any other subclasses might need movement
    }
}
