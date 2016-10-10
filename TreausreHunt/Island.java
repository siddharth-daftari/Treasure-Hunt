import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Island here.
 * 
 * @author (Gagan Jain) 
 * @version (10/9/2016)
 */
public class Island extends Actor
{
    private boolean hasShip;
    private Island nextIslandA;
    private Island nextIslandB;
    
    public void act() 
    {
       
    }
    
    
    public boolean getHasShip(){ 
        return this.hasShip;
    }
    
    public void setHasShip(boolean hasShip){
        this.hasShip = hasShip;
    }
    
    
    public Island getNextIslandA(){
        return this.nextIslandA;
    }
    
    public void setNextIslandA(Island nextIslandA){
        this.nextIslandA = nextIslandA;
    }
    
    
    public Island getNextIslandB(){
        return this.nextIslandB;
    }
    
    public void setNextIslandB(Island nextIslandB){
        this.nextIslandB = nextIslandB;
    }
}
