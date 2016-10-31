import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;

public class ScoreBoard extends Actor
{
    Map<String,Integer> map = new HashMap();
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        String scoreboardTempString = "";
        
        //sorting and displying player names and scores 
        Map<String, Integer> sortedMap = sortByValue(map);
        
        for(Map.Entry entry : sortedMap.entrySet()){
            scoreboardTempString = scoreboardTempString + entry.getKey() + ": " + entry.getValue() + "\n";
        }
        this.setImage(new GreenfootImage(scoreboardTempString, 36, Color.black, Color.YELLOW));
    }   
    
    public void sortMap(){
        
    }
    
    public ScoreBoard(){
        this.getImage().clear();
        map.put("sid",2);
        map.put("aditya",2);
        map.put("rushi",3);
        map.put("gagan",4);
        map.put("tanmay",5);
    }
    
    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        /*
        //classic iterator example
        for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }*/


        return sortedMap;
    }
}
