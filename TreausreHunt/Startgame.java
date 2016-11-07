import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

/**
 * Write a description of class startgame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Startgame extends World
{

    /**
     * Constructor for objects of class startgame.
     * 
     */
    public Startgame()
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
        addObject(new TextField(200, 30, Color.white, Color.black, "Enter your Name", 20), 283, 89);
        StartButton startbutton = new StartButton();
        addObject(startbutton,286,272);
    }
    public void act() {
    
    }
}
