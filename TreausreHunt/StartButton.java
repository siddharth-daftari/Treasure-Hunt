import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;
/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public StartButton() {
        this.getImage().scale(250,50);
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            Startgame startgame = (Startgame) getWorld();
            List<TextField> textfields = startgame.getObjects(TextField.class);
            TextField textfield = textfields.get(0);
            String text = textfield.getText();
            
            if(!(text.equals("") || text.equals("Enter your Name")))
            {
                Greenfoot.setWorld(new TreasureHuntWorld(text));
            }
        }// Add your action code here.
    }    
}
