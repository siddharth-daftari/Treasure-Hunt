import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PirateWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public PirateWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Ship ship = new Ship();
        addObject(ship,140,263);
        RouteA routea = new RouteA();
        addObject(routea,95,224);
        RouteB routeb = new RouteB();
        addObject(routeb,206,296);
        ship.setLocation(175,234);
        routeb.setLocation(185,290);
        routea.setLocation(119,216);
        ship.setLocation(190,230);
        Island island = new Island();
        addObject(island,88,290);
        Island island2 = new Island();
        addObject(island2,485,64);
        RouteA routea2 = new RouteA();
        addObject(routea2,376,82);
        RouteB routeb2 = new RouteB();
        addObject(routeb2,459,137);
        island.setLocation(81,350);
        routeb.setLocation(193,344);
        routea.setLocation(118,279);
        ship.setLocation(198,280);
        routeb2.setLocation(512,127);
        island2.setLocation(529,34);
        routeb2.setLocation(500,99);
        routea2.setLocation(423,41);
    }
}
