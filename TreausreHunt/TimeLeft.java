import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color.*;
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class TimeLeft here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimeLeft extends Actor
{
    private static String timeLeft = "";
    private static boolean hasTimeLeftChanged = true;
    public void act() 
    {
        if(hasTimeLeftChanged){
           
            this.getImage().clear();
            this.setImage("timeleftImage.png");
            this.getImage().scale(250, 50);
            this.getImage().setTransparency(255);
            Font myFont = new Font("Courier New", 1, 20);
            this.getImage().setFont(myFont);
            this.getImage().setColor(Color.WHITE);
            this.getImage().drawString("Time Left: " + timeLeft, 20 ,25 );
            
            hasTimeLeftChanged = false;
        }
    }   
    
    public TimeLeft(){
        this.getImage().clear();
    }
    public static void setTimeLeft(String timeLeftVar){
        hasTimeLeftChanged = true;
        timeLeft = timeLeftVar;
        
    }
}
