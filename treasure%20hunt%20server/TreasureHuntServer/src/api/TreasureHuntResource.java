package api;

import java.io.IOException;

import java.util.*;

import org.json.* ;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.resource.* ;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import treasureHunt.TreasureHunt ;

public class TreasureHuntResource extends ServerResource{
	TreasureHunt treasureHunt = TreasureHunt.getInstance();

    @Get
    public Representation get() throws JSONException {
    	
    	String requestedAction = (String) getRequest().getAttributes().get("param");
    	
    	Map<String,Object> map = treasureHunt.getScoreMap();
    	
    	
    	ObjectMapper mapper = new ObjectMapper();
        String json = "";
        
        String playernName = null;
        
    	if(requestedAction.equalsIgnoreCase("getscore")){	        
	        // convert map to JSON string
	     	try {
	     		json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
				// pretty print
				System.out.println("Get is : " + json);
			
	     	} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else if(requestedAction.equalsIgnoreCase("getwinners")){
    		Set keys = map.keySet();
    	}
    	return new JsonRepresentation ( json ) ; 
    }
    
    @Post
    public Representation post(JsonRepresentation jsonRep) {

    	System.out.println("received objects.!!");

    	String playerName, fuel;
    	String requestedAction = (String) getRequest().getAttributes().get("param");
    	
    	JSONObject requestJSON = jsonRep.getJsonObject() ;
    	String responseJSON = "";
    	
    	
    	Map<String,Object> map = treasureHunt.getScoreMap();
    	ObjectMapper mapper = new ObjectMapper();
        
        
        if(requestedAction.equalsIgnoreCase("updatescore")){
        	// String state = treasureHunt.getStateString() ;
        	System.out.println("The routing is okay as well.!!!!!!!!");
        	
        	// Updating a map setting new values
        	playerName = requestJSON.getString("playerName");
        	fuel = requestJSON.getString("fuelLeft");
              
        	map.put(playerName, fuel);
          
         	try {
         		// Converting map to JSON String
	     		responseJSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
				// pretty print
				System.out.println("My response would be " + responseJSON);
	     	} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        else if(requestedAction.equalsIgnoreCase("notifyreached")){
        	
        	System.out.println("One player reached.!!!! Hurrah");
        	
        	playerName = requestJSON.getString("playerName");
        	
        	treasureHunt.getWinnerList().add(playerName);
        	
        	System.out.println(treasureHunt.getWinnerList().toString());
        }
        else{
        	System.out.println("NEED TO MODIFY THE CODE :(((");
        }
        return new JsonRepresentation(responseJSON);
    }
}
