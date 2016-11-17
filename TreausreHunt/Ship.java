import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
import java.awt.Color.*;

import org.json.* ;
import org.restlet.resource.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.restlet.Uniform;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.data.* ;
import java.net.*;

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
    
    public void moveToIsland(Island destinationIsland,Route route){
        
        //fuel deduction and calculation
        int fuelTempVar = fuelLeft - route.getFuelNeeded();
        if(fuelTempVar > 0){
            
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
                this.turnTowards(destinationIslandX,destinationIslandY);
                //move ship by mentioned number of steps
                move(SHIP_STEP);
                //add delay of 1 timestep after each move
                Greenfoot.delay(1);
            }
            islandList.get(0).setHasShip(true);
            this.island = destinationIsland;
            fuelLeft = fuelTempVar;
            
            //U
            updateScoreboard();
        
            //check if reached treaureIsland
            if(this.island.getClass().getName().equalsIgnoreCase("TreasureIsland")){
               this.island.setImage("Treasure.png");
               this.island.getImage().scale(150,150);
               
               //Notify the server 
               notifyReached();
            }
        }
        else{
            //display message and end the game
            TreasureHuntWorld treasureHuntWorld = (TreasureHuntWorld) getWorld();
            List<Message> messageList = treasureHuntWorld.getObjects(Message.class);
            if(!messageList.isEmpty()){
                messageList.get(0).setImage(new GreenfootImage("You do not have sufficient fuel to travel." , 15, Color.black, Color.RED));
            }
        }
    } 
    
    public void updateScoreboard(){

        String myURL = "http://localhost:8080/treasureHunt/updateScore";
        ClientResource client = new ClientResource( myURL ); 
        String fuel = Integer.toString(fuelLeft);
       
//        System.out.println("Sending a score");
        

        try {
            
            JSONObject jo = new JSONObject();
            jo.put("playerName", playerName);
            jo.put("fuelLeft", fuel);

            client.post(new JsonRepresentation(jo));

          //  System.out.println("Score sent");
            
        } catch(JSONException e) {
            e.printStackTrace();
        }
    }
    
    public void notifyReached(){
        
       String myURL = "http://localhost:8080/treasureHunt/notifyreached";
       ClientResource client = new ClientResource(myURL);         
       
     //  System.out.println("Notifying that i reached");               
       
       try {
            JSONObject jo = new JSONObject();
            jo.put("playerName", playerName);
            
            client.post(new JsonRepresentation(jo));
            
            System.out.println("Notifying request sent");
            
       }catch(JSONException e) {
            e.printStackTrace();
       }       
    //   Greenfoot.stop();    
    }
   public Island getIsland(){
        return this.island;
    }
    
    public void setIsland(Island island){
        this.island = island;
    }
    
    public String getPlayerName(){
        return this.playerName;
    }
    
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }
    
    public int getFuelLeft(){
        return this.fuelLeft;
    }
    
    public void setFuelLeft(int fuelLeft){
        this.fuelLeft = fuelLeft;
    }    
}
