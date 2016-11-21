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

public class OnTreasureIslandState implements ShipState
{
   Ship ship;
   
   public OnTreasureIslandState(Ship ship)
   {
       this.ship = ship;
   }
    private IslandInterface island;
    private final int SHIP_STEP = 3;
    private String playerName = "";
    private int fuelLeft = INITAL_FUEL_LEFT;
    
    public void act() 
    {
        // Add your action code here.
    }
    
    public void moveToIsland(IslandInterface destinationIsland,Route route){ } 
    
    public void updateScoreboard(){ }
    
    public void notifyReached(){

      String myURL = "http://localhost:8080/treasureHunt/notifyreached";
      ClientResource client = new ClientResource(myURL);         
       
      //  System.out.println("Notifying that i reached");                
       try {
            JSONObject jo = new JSONObject();
            jo.put("playerName", ship.getPlayerName());
            
            client.post(new JsonRepresentation(jo));
            
            System.out.println("Notifying request sent");
            
       }catch(JSONException e) {
            e.printStackTrace();
       }       
      //   Greenfoot.stop();    
    }
}
  

