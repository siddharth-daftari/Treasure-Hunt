/**
 * Write a description of class ShipState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ShipState  
{
    public static final int INITAL_FUEL_LEFT = 10000;
    public static final int LOW_FUEL_MARK = 1000;
    public static final int MEDIUM_FUEL_MARK = 2000;
    public final int SHIP_STEP = 3;
    
    public void moveToIsland(IslandInterface destinationIsland,Route route);
    public void notifyReached();
    public void updateScoreboard();
  //  public Island getIsland();
   // public void setIsland(Island island);
   // public String getPlayerName();
   // public void setPlayerName(String playerName);
   // public int getFuelLeft();
   // public void setFuelLeft(int fuelLeft);
}
