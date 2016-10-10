import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RouteA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RouteA extends Route
{
    private Island islandRouteBelongsTo;
    
    public void act() 
    {
       if(Greenfoot.mouseClicked(this)){
           if(this.islandRouteBelongsTo.getHasShip()){
               TreasureHuntWorld treasureHuntWorld = (TreasureHuntWorld) getWorld();
               treasureHuntWorld.getShip().moveToIsland(islandRouteBelongsTo.getNextIslandA());
               this.islandRouteBelongsTo.setHasShip(false);
            }
        }
    } 
    
    public void setIslandRouteBelongsTo(Island islandRouteBelongsTo){
        this.islandRouteBelongsTo = islandRouteBelongsTo;
    }
    
    public Island getIslandRouteBelongsTo(){
        return this.islandRouteBelongsTo;
    }
}
