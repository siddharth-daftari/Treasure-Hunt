import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Color.*;

public class Message extends Actor implements ShipObserver
{
    /**
     * Act - do whatever the Message wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void update()
    {
        this.setImage(new GreenfootImage("Hurrah!! You have discovered Treasure." , 20, Color.black, Color.GREEN));   
    }
    Message(){
        this.getImage().clear();
    }
}
