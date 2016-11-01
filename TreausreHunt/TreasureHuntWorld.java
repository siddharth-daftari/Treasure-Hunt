import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TreasureHuntWorld extends World
{

    private Ship ship;
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

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    private void prepare()
    {

        /**********************
        declaring the Islands
         ***********************/

        OtherIsland otherisland = new OtherIsland();
        addObject(otherisland,117,389);

        OtherIsland otherisland2 = new OtherIsland();
        addObject(otherisland2,117,104);

        OtherIsland otherisland3 = new OtherIsland();
        addObject(otherisland3,602,334);

        OtherIsland otherisland4 = new OtherIsland();
        addObject(otherisland4,345,235);

        TreasureIsland treasureisland = new TreasureIsland();
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

        Ship ship = new Ship();
        addObject(ship,117,389);
        ship.setIsland(otherisland);
        otherisland.setHasShip(true);
        this.ship = ship;

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
        addObject(scoreboard,785,152);

    }
    
    public Ship getShip()
    {
        return this.ship;
    }
}