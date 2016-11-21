import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Island here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IslandInterface
{
    public void act();
    public boolean getHasShip();
    public void setHasShip(boolean hasShip);
    public IslandInterface getNextIslandA();
    public void setNextIslandA(IslandInterface nextIslandA);
    public IslandInterface getNextIslandB();
    public void setNextIslandB(IslandInterface nextIslandB);
    public int getX();
    public int getY();
    public GreenfootImage getImage();
    public void setImage(String imageName);
}
