package api;

import java.util.Map;

import org.restlet.resource.ServerResource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import treasureHunt.TreasureHunt ;

public class GetScoreRequestHandler extends ServerResource implements GetRequestHandler{
	TreasureHunt treasureHunt = TreasureHunt.getInstance();

private GetRequestHandler successor = null;
	
	public void setSuccessor(GetRequestHandler next) {
        this.successor = next ;
	}

	public String handleRequest(String requestedAction){
		Map<String,Object> map = treasureHunt.getScoreMap();
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		
		if(requestedAction.equalsIgnoreCase("getscore")){
			System.out.println("Received Get Score request");
			
    		if(treasureHunt.timeLeft == TreasureHunt.GAME_MAX_TIME){
            	map.put("timeup", "true");
            	
            }
    		map.put("timeLeft", TreasureHunt.GAME_MAX_TIME - treasureHunt.timeLeft);
	     	try {
	     		json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
			
	     	} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
	     	
    	}
		else
        {
            if ( successor != null )
                return successor.handleRequest(requestedAction);
        }
		return json;
	}
}
