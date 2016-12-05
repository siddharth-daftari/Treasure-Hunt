import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OtherIsland here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OtherIsland extends Actor implements IslandInterface 
{
    
    private boolean hasShip ;
    private IslandInterface nextIslandA;
    private IslandInterface nextIslandB;
    
    /**
     * Act - do whatever the TreasureIsland wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    public OtherIsland(){
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
