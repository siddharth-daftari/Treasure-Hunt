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

public class OnOtherIslandState implements ShipState
{
   Ship ship;
   
   public OnOtherIslandState(Ship ship)
   {
       this.ship = ship;
   }
    
    public void act() 
    {
        // Add your action code here.
    }
    
    public void moveToIsland(IslandInterface destinationIsland,Route route){
        
        //fuel deduction and calculation
        int fuelTempVar = ship.getFuelLeft() - route.getFuelNeeded();
        if(fuelTempVar > 0){
            ship.setShipState(ship.getTravellingState());
            
            IslandInterface sourceIsland = ship.getIsland();
            List<IslandInterface> islandList = null;
            int sourceIslandX = sourceIsland.getX();
            int sourceIslandY = sourceIsland.getY();
            
            int destinationIslandX = destinationIsland.getX();
            int destinationIslandY = destinationIsland.getY();
            boolean isShipFlipped = false;
             //calculating the distance between islands
            int distance = (int)Math.sqrt(Math.pow(destinationIslandX - sourceIslandX, 2) + Math.pow(destinationIslandY - sourceIslandY, 2));
             
            ship.turnTowards(destinationIslandX,destinationIslandY);
            if(ship.getRotation() <= 270 && ship.getRotation() >= 90){
                ship.getImage().mirrorVertically();
                ship.setImage(ship.getImage());
                isShipFlipped = true;
            }
                    
            for(int i=0;i<distance;i= i + SHIP_STEP){
                
                //logic for breaking the loop when ship is in vicinity of destination island
                islandList = ship.getObjectsInRangeFromShip();
                if(!islandList.isEmpty() && islandList.get(0).getX() == destinationIsland.getX() && islandList.get(0).getY() == destinationIsland.getY()){
                    ship.setRotation(0);
                    if(isShipFlipped){
                        isShipFlipped = false;
                        ship.getImage().mirrorVertically();
                    }
                    break;
                }
                //constantly adjust the path ship
                ship.turnTowards(destinationIslandX,destinationIslandY);
                
                //move ship by mentioned number of steps
                ship.move(SHIP_STEP);
                //add delay of 1 timestep after each move
                Greenfoot.delay(1);
            }
            
            
            islandList.get(0).setHasShip(true);
            ship.setIsland(destinationIsland);
            ship.setFuelLeft(fuelTempVar);
            
            ship.setShipState(ship.getOnOtherIslandState());            
            updateScoreboard();
        }
        else{
            //display message and end the game
            TreasureHuntWorld treasureHuntWorld = (TreasureHuntWorld) ship.getWorld();
            List<Message> messageList = treasureHuntWorld.getObjects(Message.class);
            if(!messageList.isEmpty()){
                messageList.get(0).setImage(new GreenfootImage("You do not have sufficient fuel to travel." , 15, Color.black, Color.RED));
            }
        }  
        
      
    } 
    
    public void updateScoreboard(){

        String myURL = TreasureHuntWorld.BASE_URL + "/updateScore";
        ClientResource client = new ClientResource( myURL ); 

        String playerName = ship.getPlayerName();
        String fuel = Integer.toString(ship.getFuelLeft());
        
        //        //System.out.println("Sending a score");
        
        try {
            
            JSONObject jo = new JSONObject();
            jo.put("playerName", playerName);
            jo.put("fuelLeft", fuel);

            client.post(new JsonRepresentation(jo));

          //  //System.out.println("Score sent");
            
        } catch(JSONException e) {
            e.printStackTrace();
        }
        
        if(ship.getIsland().getClass().getName().equalsIgnoreCase("TreasureIsland")){
               
                ship.setShipState(ship.getOnTreasureIslandState());
                ship.notifyReached();               
                //Notify the server 
        }
    }
    
   public void notifyReached(){}
    
      
}

