package api;

import java.util.Map;

import org.json.JSONObject;
import org.restlet.resource.ServerResource;

import treasureHunt.TreasureHunt ;

public class RegisterRequestHandler extends ServerResource implements PostRequestHandler{
	TreasureHunt treasureHunt = TreasureHunt.getInstance();

private PostRequestHandler successor = null;
	
	public void setSuccessor(PostRequestHandler next) {
        this.successor = next ;
	}

	public String handleRequest(String requestedAction, JSONObject requestJSON){
		
		String playerName, fuel;
		
		//JSONObject requestJSON = jsonRep.getJsonObject() ;
		String responseJSON = "";
		Map<String,Object> map = treasureHunt.getScoreMap();
		
		if("register".equalsIgnoreCase(requestedAction))
    	{
			System.out.println("Received Register request");
			
    		playerName = requestJSON.getString("playerName");
    		
    		fuel = requestJSON.getString("fuel");
    		map.put(playerName, fuel);
    	}else{
            if ( successor != null )
                return successor.handleRequest(requestedAction, requestJSON);
        }
		return responseJSON;
	}
}
