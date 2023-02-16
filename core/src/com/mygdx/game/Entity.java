package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class Entity{
    private float x, y; //X and Y coordinates for position
    private boolean hidden; //draws entity on render if hidden is false
    private static List<Entity> entityList = new ArrayList<>(); //list of entities created

    public Entity()
    {
        
    }
    //Constructor will add created entity into entityList
    public Entity(float x, float y){
        this.x = x;
        this.y = y;
        entityList.add(this);
    }

    //Removes entity
    public void deleteEntity(Entity e){
        entityList.remove(e);
    }

    //Call to toggle hide
    public void toggleHide(){
        hidden = !hidden;
    }

    //Call render to draw all entities except hidden ones
    public void render(){
        for (Entity e: entityList) {
            if(!e.hidden)
                e.drawEntity();
        }
    }

    //To be overriden by child classes, can call this if only want to show one entity
    public void drawEntity(){}


    //Getters and Setters
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean isHidden() {
        return hidden;
    }

    public static List<Entity> getEntityList() {
        return entityList;
    }
}
