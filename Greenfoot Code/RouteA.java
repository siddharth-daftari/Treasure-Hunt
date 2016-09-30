import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class RoutA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RouteA extends Island
{
    /**
     * Act - do whatever the RoutA wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        List<Ship> ls = getObjectsInRange(150, Ship.class);
        Ship s = null;
        if(!ls.isEmpty())
        {
           s = ls.get(0);
        }
        if(Greenfoot.mouseClicked(getWorld())){
            if(s!=null)
            {
                 System.out.println("Mouse Clicked");
                 int sourX = s.getX();
                 int sourY = s.getY();
                 Island i1 = getWorld().getObjects(Island.class).get(1);
                 int desX = i1.getX();
                 int desY = i1.getY();
                 while(sourX <= desX && sourY <=desY)
                 {
                     if(sourX < desX)
                     {
                         sourX++;
                     }
                     if(sourY < desY)
                     {
                         sourY++;
                     }
                     setLocation(sourX,sourY);
                 }
            }
        }
    }    
}
