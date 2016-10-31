import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Ship here.
 * 
 * @author (Tanmay) 
 */
public class Ship extends Actor
{
   
    private Island island;
    private final int SHIP_STEP = 3;
    private String playerName = "";
    public static final int INITAL_FUEL_LEFT = 10000;
    public static final int LOW_FUEL_MARK = 1000;
    public static final int MEDIUM_FUEL_MARK = 2000;
    private int fuelLeft = INITAL_FUEL_LEFT;
    public void act() 
    {
        // Add your action code here.
    }
    
    public void moveToIsland(Island destinationIsland){
        Island sourceIsland = this.getIsland();
        List<Island> islandList = null;
        int sourceIslandX = sourceIsland.getX();
        int sourceIslandY = sourceIsland.getY();
        
        int destinationIslandX = destinationIsland.getX();
        int destinationIslandY = destinationIsland.getY();
        
        //calculating the distance between islands
        int distance = (int)Math.sqrt(Math.pow(destinationIslandX - sourceIslandX, 2) + Math.pow(destinationIslandY - sourceIslandY, 2));
         
        for(int i=0;i<distance;i= i + SHIP_STEP){
            
            //logic for breaking the loop when ship is in vicinity of destination island
            islandList = getObjectsInRange(5,Island.class);
            if(!islandList.isEmpty() && islandList.get(0).getX() == destinationIsland.getX() && islandList.get(0).getY() == destinationIsland.getY()){
            	 this.setRotation(0);
                 break;
            }
           
            //constantly adjust the path ship
            this.setRotation(0);
            this.turnTowards(destinationIslandX,destinationIslandY);
            //move ship by mentioned number of steps
            move(SHIP_STEP);
            //add delay of 1 timestep after each move
            Greenfoot.delay(1);
        }
        islandList.get(0).setHasShip(true);
        this.island = destinationIsland;
    }
    
    public Island getIsland(){
        return this.island;
    }
    
    public void setIsland(Island island){
        this.island = island;
    }
}
