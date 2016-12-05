import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.net.* ;
import java.io.* ;
import org.json.* ;
import org.restlet.resource.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.restlet.Uniform; 
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.data.* ;

public class ScoreBoard extends Actor
{
    Map<String,String> map = new HashMap();
    public static long currTime = 0;
    public static boolean prevReqFinished = true;
    public static String scoreboardTempString = "";
    public GreenfootImage greenfootImage =null;
    Thread myThread;
    
     public void act(){
        if(System.currentTimeMillis() - currTime > 2000 && prevReqFinished){
        
        prevReqFinished = false;
        myThread = new Thread ( 
               new Runnable() 
               {
                    public void run() 
                    {
                         act1() ; 
                    }
               }
         ) ;
         try {
             myThread.start() ;
        } catch ( Exception e ) {
         //System.out.println( "ERROR: " + e.getMessage() );
      }
        }
    }
    
    
    public synchronized void act1() 
    {
        //System.currentTimeMillis() - currTime > 5000
        if(true){
            scoreboardTempString = "";
            
            //code for fetching scores from server : start
            String myURL = TreasureHuntWorld.BASE_URL + "/getscore";
            ClientResource client = new ClientResource( myURL ); 
            String result = "" ;
            String timeup = null;
            
            client.setOnResponse(new Uniform() {
                public void handle(Request request, Response response) {
                    try {
                        JSONObject json_response = null;
                        try {
                            json_response = new JSONObject( response.getEntity().getText() );
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                
                        // convert JSON string to Map
                        ObjectMapper mapper = new ObjectMapper();
                        try {
                            map = mapper.readValue(json_response.toString(), new TypeReference<Map<String, String>>(){});
                            
                             if(map.get("timeup").equals("true") || map.get("allreached").equals("true")){
                                 getWinners();
                             }
                             map.remove("allreached");
                             map.remove("timeup");
                             TimeLeft.setTimeLeft(map.get("timeLeft"));
                             map.remove("timeLeft");
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        
                        //code for fetching scores from server : end
                        
                        //sorting and displying player names and scores 
                        Map<String, String> sortedMap = sortByValue(map);
                        
                        
                        for(Map.Entry entry : sortedMap.entrySet()){
                            scoreboardTempString = scoreboardTempString + entry.getKey() + ": " + entry.getValue() + "\n";
                        }
                        
                        
                    } catch (Exception e) {
                         e.printStackTrace();
                    }finally{
                        prevReqFinished = true;
                        currTime = System.currentTimeMillis();
                    }
                }
            });
            // get scores
            client.get() ; 
            
            GreenfootImage textImage = new GreenfootImage(scoreboardTempString, 36, Color.black, Color.WHITE);
            this.getImage().clear();
            this.setImage("schein-treasure-map-hi.png");
            this.getImage().scale(300, 250);
            //this.getImage().drawImage(textImage,20,7);
            Font myFont = new Font ("Courier New", 1, 20);
            //this.getImage().clear();
            this.getImage().setFont(myFont);
            //TreasureHuntWorld treasureHuntWorld = (TreasureHuntWorld) getWorld();
            //this.setImage(treasureHuntWorld.getScoreboardImage());
            this.getImage().drawString(scoreboardTempString, 20,50 ); 
            
        }
    }
    
    public ScoreBoard(){
        this.getImage().scale(300, 250);
        currTime = System.currentTimeMillis();
        greenfootImage = new GreenfootImage(this.getImage());
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
    
    public void getWinners(){
        //code for fetching scores from server : start
        //System.out.println("Getting list of winners");
        String myURL = TreasureHuntWorld.BASE_URL + "/getwinners";
        ClientResource client = new ClientResource( myURL ); 
        String result = "" ;
        String timeup = null;
        client.setOnResponse(new Uniform() {
            public void handle(Request request, Response response) {
                Map<String,String> tempmap = new HashMap();
                String winners = null;
                String[] winnerslist = null;
        
                try {
                    JSONObject json_response = null;
                    json_response = new JSONObject( response.getEntity().getText());
                    winners = json_response.get("Winners").toString();
                    //                    winners.replaceAll("[","");
                    //winners.replaceAll("]","");
                    //System.out.println("winner are finally  : " + winners);
                    Set<String> playerset = map.keySet();
                    Iterator<String> iterator = playerset.iterator();
                    while(iterator.hasNext())
                    {
                        String name = iterator.next();
                        if(winners.indexOf(name) !=-1)
                        {
                            //System.out.println("I found a keyword " + name);
                            tempmap.put(name,map.get(name));
                        }
                    }
                    Greenfoot.setWorld(new WinnerWorld(tempmap));
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });  
        client.get(); 
    }
}