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

            /**********************
            declaring the Islands
            ***********************/
            
            OtherIsland otherisland = new OtherIsland();
            addObject(otherisland,107,343);
            OtherIsland otherisland2 = new OtherIsland();
            addObject(otherisland2,98,53);
            OtherIsland otherisland3 = new OtherIsland();
            addObject(otherisland3,498,285);
            OtherIsland otherisland4 = new OtherIsland();
            addObject(otherisland4,232,207);
            TreasureIsland treasureisland = new TreasureIsland();
            addObject(treasureisland,462,84);
            

            /**********************
            declaring the Routes
            ***********************/

            //Setting up the Island1: Routes for A and B for this island
            
            RouteA routea = new RouteA();
            addObject(routea,66,311);
            RouteB routeb = new RouteB();
            addObject(routeb,150,310);
            
            //Setting up the Island2: Routes for A and B for this island
            
            RouteA routea2 = new RouteA();
            addObject(routea2,63,23);
            RouteB routeb2 = new RouteB();
            addObject(routeb2,132,24);
            
            //Setting up the Island3: Routes for A and B for this island
            
            RouteA routea3 = new RouteA();
            addObject(routea3,463,255);
            RouteB routeb3 = new RouteB();
            addObject(routeb3,539,254);
            
            //Setting up the Island4: Routes for A and B for this island
            
            RouteA routea4 = new RouteA();
            addObject(routea4,192,175);
            RouteB routeb4 = new RouteB();
            addObject(routeb4,274,177);
            
            /**********************
            declaring the Ship
            ***********************/

            ship = new Ship();
            addObject(ship,107,343);
            
            ship.setIsland(otherisland);
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
        }
        
        public Ship getShip()
        {
            return this.ship;
        }
    }
