import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor implements ShipSubject
{
 
    private IslandInterface island;
    private final int SHIP_STEP  = 3;
    private String playerName = "";
    
     
    private ArrayList<ShipObserver> observers = new ArrayList<ShipObserver>();
    
    public static final int INITAL_FUEL_LEFT = 5000;
    public static final int LOW_FUEL_MARK = (int)(0.20*INITAL_FUEL_LEFT);
    public static final int MEDIUM_FUEL_MARK = (int)(0.50*INITAL_FUEL_LEFT);
    private int fuelLeft = INITAL_FUEL_LEFT;
    
    ShipState onOtherIslandState;
    ShipState onTreasureIslandState;
    ShipState travellingState;
    ShipState shipState;
    
    public List<IslandInterface> getObjectsInRangeFromShip(){
        List<IslandInterface> islandList = null;
        islandList = getObjectsInRange(5,IslandInterface.class);
        return islandList;
    }
    
    public Ship() {
        this.getImage().mirrorHorizontally();
        onOtherIslandState = new OnOtherIslandState(this);
        onTreasureIslandState = new OnTreasureIslandState(this);
        travellingState = new TravellingState(this);
        shipState = onOtherIslandState;
    }
    
    public void setShipState(ShipState shipState)
    {
        this.shipState = shipState;
        if(shipState == onTreasureIslandState)
        {
            notifyObservers();
        }
    }
    public ShipState getShipState()
    {
        return shipState;
    }
    public ShipState getOnOtherIslandState()
    {
        return onOtherIslandState;
    }
    public ShipState getOnTreasureIslandState()
    {
        return onTreasureIslandState;
    }
    public ShipState getTravellingState()
    {
        return travellingState;
    }
      
    public void attach(ShipObserver obj)
    {
        observers.add(obj);
    }
    public void moveToIsland(IslandInterface destinationIsland,Route route)
    {
        if(shipState == null)
        {
            //System.out.println("null");
        }
        else
        {
            shipState.moveToIsland(destinationIsland,route);
        }
    }
    public void notifyReached()
    {
        shipState.notifyReached();
    }
    public void updateScoreboard()
    {
        shipState.updateScoreboard();    
    }
    public IslandInterface getIsland()
    {
        return island;        
    }
    public void setIsland(IslandInterface island)
    {
        this.island = island;    
    }
    public String getPlayerName()
    {
        return playerName;    
    }
    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;    
    }
    public int getFuelLeft()
    {
        return fuelLeft;    
    }
    public void setFuelLeft(int fuelLeft)
    {
        this.fuelLeft = fuelLeft;    
    }
    public World getWorld()
    {
        TreasureHuntWorld treasureHuntWorld = (TreasureHuntWorld) getWorld();
        return treasureHuntWorld;
    }
    public void notifyObservers()
    {   
        for(ShipObserver obj : observers)
        {
            obj.update();
        }
    }
}
