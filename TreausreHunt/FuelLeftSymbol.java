import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.Color;
import java.awt.Color.*;
import java.awt.Font;

public class FuelLeftSymbol extends Actor
{
    FuelLeftSymbolMaker fuelLeftSymbolMaker;
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
           fuelLeftSymbolMaker.drawLowFuelLeftSymbol(this, fuelLeft);
       }else if(fuelLeft <= Ship.MEDIUM_FUEL_MARK){
           fuelLeftSymbolMaker.drawMediumFuelLeftSymbol(this, fuelLeft);
       }else{
           fuelLeftSymbolMaker.drawSufficientFuelLeftSymbol(this, fuelLeft);
       }
    } 
    
    public FuelLeftSymbol(){
        //setImage(new GreenfootImage("Fuel Left: " + Ship.INITAL_FUEL_LEFT , 36, Color.black, Color.GREEN));
        this.getImage().clear();
        fuelLeftSymbolMaker = new FuelLeftSymbolMaker();
    }
}
