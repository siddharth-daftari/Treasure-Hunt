import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

import java.io.* ;
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

public class TreasureHuntWorld extends World
{

    private String playerName;
    private Ship ship;
    private GreenfootImage scoreboardImage;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public TreasureHuntWorld() 
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 550, 1); 
        prepare();
    }
    
    public TreasureHuntWorld(String playerName) 
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 550, 1); 
        this.playerName = playerName;
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    private void prepare()
    {

        /**********************
        declaring the Islands
         ***********************/
        IslandFactory islandFactory = new IslandFactory();
        String OTHER_ISLAND = "OTHER_ISLAND";
        String TREASURE_ISLAND = "TREASURE_ISLAND";
        
        OtherIsland otherisland = (OtherIsland)islandFactory.getIsland(OTHER_ISLAND);
        addObject(otherisland,117,389);

        OtherIsland otherisland2 = (OtherIsland)islandFactory.getIsland(OTHER_ISLAND);
        addObject(otherisland2,117,104);

        OtherIsland otherisland3 = (OtherIsland)islandFactory.getIsland(OTHER_ISLAND);
        addObject(otherisland3,602,334);

        OtherIsland otherisland4 = (OtherIsland)islandFactory.getIsland(OTHER_ISLAND);
        addObject(otherisland4,345,235);

        TreasureIsland treasureisland = (TreasureIsland)islandFactory.getIsland(TREASURE_ISLAND);
        addObject(treasureisland,519,84);

        /**********************
        declaring the Routes
         ***********************/

        //Island 1 

        RouteA routea = new RouteA();
        addObject(routea,83,436);
        routea.setFuelNeeded(200);

        RouteB routeb = new RouteB();
        addObject(routeb,162,426);
        routeb.setFuelNeeded(300);

        //Island 2

        RouteA routea2 = new RouteA();
        addObject(routea2,83,151);
        routea2.setFuelNeeded(400);

        RouteB routeb2 = new RouteB();
        addObject(routeb2,162,141);
        routeb2.setFuelNeeded(200);

        //Island 3

        RouteA routea3 = new RouteA();
        addObject(routea3,568,382);
        routea3.setFuelNeeded(300);

        RouteB routeb3 = new RouteB();
        addObject(routeb3,648,372);
        routeb3.setFuelNeeded(400);

        //Island 4

        RouteA routea4 = new RouteA();
        addObject(routea4,311,282);
        routea4.setFuelNeeded(200);

        RouteB routeb4 = new RouteB();
        addObject(routeb4,390,273);
        routeb4.setFuelNeeded(100);

        /**********************
        declaring the Ship
         ***********************/

        ship = new Ship();
        addObject(ship,117,389);
        ship.setIsland(otherisland);
        ship.setPlayerName(playerName);
        otherisland.setHasShip(true);

        /**********************
        Setting up routes
         ***********************/

        otherisland.setNextIslandA(otherisland2);
        otherisland.setNextIslandB(otherisland3);

        otherisland2.setNextIslandA(otherisland3);
        otherisland2.setNextIslandB(otherisland4);

        otherisland3.setNextIslandA(otherisland);
        otherisland3.setNextIslandB(otherisland2);

        otherisland4.setNextIslandA(otherisland3);
        otherisland4.setNextIslandB(treasureisland);

        /**********************
        Assiging routes to Island
         ***********************/

        routea.setIslandRouteBelongsTo(otherisland);
        routeb.setIslandRouteBelongsTo(otherisland);

        routea2.setIslandRouteBelongsTo(otherisland2);
        routeb2.setIslandRouteBelongsTo(otherisland2);

        routea3.setIslandRouteBelongsTo(otherisland3);
        routeb3.setIslandRouteBelongsTo(otherisland3);

        routea4.setIslandRouteBelongsTo(otherisland4);
        routeb4.setIslandRouteBelongsTo(otherisland4);

        /**********************
        Declaring Fule left Symbols, Message and scoreboard
         ***********************/

        FuelLeftSymbol fuelleftsymbol = new FuelLeftSymbol();
        addObject(fuelleftsymbol,787,163);
        fuelleftsymbol.setLocation(778,507);

        Message message = new Message();
        addObject(message,72,505);
        message.setLocation(209,507);

        ScoreBoard scoreboard = new ScoreBoard();
        addObject(scoreboard,845,297);
        setScoreboardImage(scoreboard.getImage());
        scoreboard.setLocation(831,298);      
        
        TimeLeft timeLeft = new TimeLeft();
        addObject(timeLeft,800,100);
        
        ship.attach(message);
        ship.attach(treasureisland);
        
        registerPlayer();
    }

    public void setScoreboardImage(GreenfootImage scoreboardImage)
    {
        this.scoreboardImage = scoreboardImage;
    }
    public GreenfootImage getScoreboardImage()
    {
        return scoreboardImage;
    }
    public Ship getShip()
    {
        return this.ship;
    }
    
    public void registerPlayer()
    {
       String myURL = "http://localhost:8080/treasureHunt/register";
       ClientResource client = new ClientResource(myURL);         
       String fuel = Integer.toString(ship.getFuelLeft());
       //  System.out.println("Notifying that i reached");               
       
       try {
            JSONObject jo = new JSONObject();
            jo.put("playerName", playerName);
            jo.put("fuel",fuel);
            JsonRepresentation tempVar = new JsonRepresentation(jo);
            System.out.println(jo);
            client.post(tempVar);
            
            System.out.println("Notifying request sent");
            
       }catch(JSONException e) {
            e.printStackTrace();
       }    
    }
}