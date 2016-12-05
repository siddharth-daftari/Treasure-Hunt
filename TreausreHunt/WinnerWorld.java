import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
import java.util.*;

/**
 * Write a description of class WinnerWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinnerWorld extends World
{
    Map<String,String> winnermap = new HashMap();
    public WinnerWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 550, 1); 
    }
    public WinnerWorld(Map<String,String> map)
    {
        super(1000, 550, 1); 
        winnermap = map;
        //System.out.println("constructed winnerworld");
        prepare();
    }
    private void prepare()
    {
        //System.out.println("this is prepare method");
        
        Winnerlist winnerlist = new Winnerlist(winnermap);
        addObject(winnerlist,this.getWidth()/2,this.getHeight()/2);
        
        RestartButton restart = new RestartButton();
        addObject(restart,this.getWidth()/2,this.getHeight()/2 + 180);
    }
}
