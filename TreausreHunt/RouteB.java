import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class RouteB extends Route
{
    private Island islandRouteBelongsTo;
    private int fuelNeeded = 0;
    
    public void act() 
    {
       if(Greenfoot.mouseClicked(this)){
           if(this.islandRouteBelongsTo.getHasShip()){
               TreasureHuntWorld treasureHuntWorld = (TreasureHuntWorld) getWorld();
               treasureHuntWorld.getShip().moveToIsland(islandRouteBelongsTo.getNextIslandB(),this);
               this.islandRouteBelongsTo.setHasShip(false);
           }
       }
    } 
    
    public void setIslandRouteBelongsTo(Island islandRouteBelongsTo){
        this.islandRouteBelongsTo = islandRouteBelongsTo;
    }
    
    public Island getIslandRouteBelongsTo(){
        return this.islandRouteBelongsTo;
    }  
    
    public void setFuelNeeded(int fuelNeeded){
        this.fuelNeeded = fuelNeeded;
    }
    
    public int getFuelNeeded(){
        return this.fuelNeeded;
    }
}
