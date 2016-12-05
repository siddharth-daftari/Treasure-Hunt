import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
import java.util.*;
/**
 * Write a description of class winnerlist here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Winnerlist extends Actor
{
    Map<String,String> winnermap = new HashMap();
    String winnerlist = null;
    String winnerTempString= null;
    public Winnerlist(Map<String,String> map)
    {
        winnermap = map;
        //System.out.println("Constructured winner list object");
        displayWinners();
    }
    public void act()
    {
    
    }
    public void displayWinners() 
    {
        int i = 1;
        //System.out.println("Entered in act method of  winner list");
        winnerTempString = "\tWinners' Board\n\n";
        if(!winnermap.isEmpty())
        {
            Map<String, String> sortedMap = sortByValue(winnermap);
            for(Map.Entry entry : sortedMap.entrySet()){
            winnerTempString = winnerTempString + "  " + i++ + ". " + entry.getKey() + ": " + entry.getValue() + "\n";
            if(i==2)
                break;
            }
        }
        else
        {
            winnerTempString = winnerTempString + "Nobody won the game.!! Better Luck next time.";
        }
         GreenfootImage textImage = new GreenfootImage(winnerTempString, 36, Color.black, Color.WHITE);
        this.getImage().clear();
        this.setImage("schein-treasure-map-hi.png");
        this.getImage().scale(300, 250);
        //this.getImage().drawImage(textImage,20,7);
        Font myFont = new Font ("Courier New", 1, 20);
        //this.getImage().clear();
        this.getImage().setFont(myFont);
        //TreasureHuntWorld treasureHuntWorld = (TreasureHuntWorld) getWorld();
        //this.setImage(treasureHuntWorld.getScoreboardImage());
        this.getImage().drawString(winnerTempString, 20,50 ); 
        //System.out.println(winnerTempString);
    }    
    
    private static Map<String, String> sortByValue(Map<String, String> unsortMap) {

        List<Map.Entry<String, String>> list =
                new LinkedList<Map.Entry<String, String>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                //return (o2.getValue()).compareTo(o1.getValue());
                return Integer.compare(Integer.parseInt(o2.getValue()), Integer.parseInt(o1.getValue()));
            }
        });
        Map<String, String> sortedMap = new LinkedHashMap<String, String>();
        
        for (Map.Entry<String, String> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
