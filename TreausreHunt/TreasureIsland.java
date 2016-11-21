import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TreasureIsland here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TreasureIsland extends Actor implements IslandInterface, ShipObserver
{
    
    private boolean hasShip ;
    private IslandInterface nextIslandA;
    private IslandInterface nextIslandB;
    
 
    public void act() 
    {
        // Add your action code here.
    } 
    
    public void update()
    {
      this.setImage("Treasure.png");
      this.getImage().scale(150,150);
    }
    
    public TreasureIsland(){
        this.getImage().scale(150,150);
    }
    
    public boolean getHasShip(){ 
        return this.hasShip;
    }
    
    public void setHasShip(boolean hasShip){
        this.hasShip = hasShip;
    }
    
    
    public IslandInterface getNextIslandA(){
        return this.nextIslandA;
    }
    
    public void setNextIslandA(IslandInterface nextIslandA){
        this.nextIslandA = nextIslandA;
    }
    
    
    public IslandInterface getNextIslandB(){
        return this.nextIslandB;
    }
    
    public void setNextIslandB(IslandInterface nextIslandB){
        this.nextIslandB = nextIslandB;
    }
}
