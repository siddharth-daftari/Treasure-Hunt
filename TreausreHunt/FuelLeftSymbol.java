import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.Color;
import java.awt.Color.*;

public class FuelLeftSymbol extends Actor
{
    /**
     * Act - do whatever the FuelLeftSymbol wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       TreasureHuntWorld treasureHuntWorld = (TreasureHuntWorld) getWorld();
       int fuelLeft = treasureHuntWorld.getShip().getFuelLeft();
       Ship s = treasureHuntWorld.getShip();
       this.getImage().clear();
       if(fuelLeft <= Ship.LOW_FUEL_MARK){
           this.setImage(new GreenfootImage("Fuel Left: " + fuelLeft , 36, Color.black, Color.RED));
       }else if(fuelLeft <= Ship.MEDIUM_FUEL_MARK){
           this.setImage(new GreenfootImage("Fuel Left: " + fuelLeft , 36, Color.black, Color.YELLOW));
       }else{
           this.setImage(new GreenfootImage("Fuel Left: " + fuelLeft , 36, Color.black, Color.GREEN));
       }
    } 
    
    public FuelLeftSymbol(){
        setImage(new GreenfootImage("Fuel Left: " + Ship.INITAL_FUEL_LEFT , 36, Color.black, Color.GREEN));
    }
}
