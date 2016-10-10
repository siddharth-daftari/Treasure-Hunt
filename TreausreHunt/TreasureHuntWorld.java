import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TreasureHuntWorld extends World
{

    private Ship ship;
    private Ship ship1;
    private Ship ship2;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    
    public TreasureHuntWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 450, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //declaring the objects and setting their position
        
        OtherIsland otherisland = new OtherIsland();
        addObject(otherisland,107,343);
        OtherIsland otherisland2 = new OtherIsland();
        addObject(otherisland2,98,53);
        OtherIsland otherisland3 = new OtherIsland();
        addObject(otherisland3,498,285);
        OtherIsland otherisland4 = new OtherIsland();
        addObject(otherisland4,212,204);
        TreasureIsland treasureisland = new TreasureIsland();
        addObject(treasureisland,462,84);
        otherisland4.setLocation(232,207);
        
        //Setting up the Island1: Routes for A and B for this island
        
        RouteA routea = new RouteA();
        addObject(routea,73,320);
        routea.setLocation(66,311);
        RouteB routeb = new RouteB();
        addObject(routeb,156,318);
        routeb.setLocation(150,310);
        
        //Setting up the Island4: Routes for A and B for this island
        
        RouteA routea4 = new RouteA();
        addObject(routea4,206,183);
        routea4.setLocation(192,175);
        RouteB routeb4 = new RouteB();
        addObject(routeb4,279,184);
        routeb4.setLocation(274,177);
        
        //Setting up the Island3: Routes for A and B for this island
        
        RouteA routea3 = new RouteA();
        addObject(routea3,470,262);
        routea3.setLocation(463,255);
        RouteB routeb3 = new RouteB();
        addObject(routeb3,545,261);
        routeb3.setLocation(539,254);
        
        //Setting up the Island2: Routes for A and B for this island
        
        RouteA routea2 = new RouteA();
        addObject(routea2,70,31);
        routea2.setLocation(63,23);
        RouteB routeb2 = new RouteB();
        addObject(routeb2,131,22);
        routeb2.setLocation(132,24);
        
        //Setting up the Ship and it's location and also set the ship on first island
        ship = new Ship();
        addObject(ship,111,350);
        ship.setLocation(106,347);
        
        ship.setIsland(otherisland);
        otherisland.setHasShip(true);
        
        //setting up next target island for Island1, Island2, Island3, and Island4
        otherisland.setNextIslandA(otherisland2);
        otherisland.setNextIslandB(otherisland3);
        
        otherisland2.setNextIslandA(otherisland3);
        otherisland2.setNextIslandB(otherisland4);
        
        otherisland3.setNextIslandA(otherisland);
        otherisland3.setNextIslandB(otherisland2);
        
        otherisland4.setNextIslandA(otherisland3);
        otherisland4.setNextIslandB(treasureisland);
        
        //setting the route for the respective islands
        routea.setIslandRouteBelongsTo(otherisland);
        routeb.setIslandRouteBelongsTo(otherisland);
        
        routea2.setIslandRouteBelongsTo(otherisland2);
        routeb2.setIslandRouteBelongsTo(otherisland2);
        
        routea3.setIslandRouteBelongsTo(otherisland3);
        routeb3.setIslandRouteBelongsTo(otherisland3);
        
        routea4.setIslandRouteBelongsTo(otherisland4);
        routeb4.setIslandRouteBelongsTo(otherisland4);
    }
    
    public Ship getShip()
    {
        return this.ship;
    }
}
