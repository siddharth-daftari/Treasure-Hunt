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

public class TravellingState implements ShipState
{
   Ship ship;
   
   public TravellingState(Ship ship)
   {
       this.ship = ship;
   }
    
    public void act() 
    {
        
    }
    
    public void moveToIsland(IslandInterface destinationIsland,Route route){
        
        //display message and end the game
        TreasureHuntWorld treasureHuntWorld = (TreasureHuntWorld) ship.getWorld();
        List<Message> messageList = treasureHuntWorld.getObjects(Message.class);
        
        if(!messageList.isEmpty()){
            messageList.get(0).setImage(new GreenfootImage("Ship is already travelling." , 15, Color.black, Color.RED));
        }
    } 
   public void updateScoreboard(){ }
   
   public void notifyReached(){}
}

