/**
 * Write a description of class IslandFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IslandFactory  
{
   public IslandInterface getIsland(String islandType){
       
      if(islandType == null){
         return null;
      }		
      
      if("TREASURE_ISLAND".equalsIgnoreCase(islandType)){
         return new TreasureIsland();
         
      } else if("OTHER_ISLAND".equalsIgnoreCase(islandType)){
         return new OtherIsland();
         
      }
      
      return null;
   }
}
