package api;

import java.util.Map;

import org.json.JSONObject;
import org.restlet.resource.ServerResource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import treasureHunt.TreasureHunt ;

public class UpdateScoreRequestHandler extends ServerResource implements PostRequestHandler{
	TreasureHunt treasureHunt = TreasureHunt.getInstance();

private PostRequestHandler successor = null;
	
	public void setSuccessor(PostRequestHandler next) {
        this.successor = next ;
	}

	public String handleRequest(String requestedAction, JSONObject requestJSON){
		String playerName, fuel;
		String responseJSON = "";
		Map<String,Object> map = treasureHunt.getScoreMap();
		ObjectMapper mapper = new ObjectMapper();
		
		if(requestedAction.equalsIgnoreCase("updatescore")){
        	// Updating a map setting new values
			
			System.out.println("Received Update Score request");
			
        	playerName = requestJSON.getString("playerName");
        	System.out.println("received player name is  " + playerName);
        	fuel = requestJSON.getString("fuelLeft");
        	System.out.println("Received fuel is  " + fuel);
        	map.put(playerName, fuel);
          
         	try {
	     		responseJSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
	     	} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
        }else{
            if ( successor != null )
                return successor.handleRequest(requestedAction, requestJSON);
        }
		return responseJSON;
	}
}
