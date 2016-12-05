package api;

import java.util.Map;

import org.json.JSONObject;
import org.restlet.resource.ServerResource;

import treasureHunt.TreasureHunt ;

public class RegisterRequestHandler extends ServerResource implements PostRequestHandler{
	TreasureHunt treasureHunt = TreasureHunt.getInstance();

	private PostRequestHandler successor = null;
	private static int MAX_PLAYERS = 5;
	
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
			TreasureHunt.totalPlayers++;
			System.out.println("Total players now is : " + TreasureHunt.totalPlayers);
			System.out.println("Received Register request");
			
    		playerName = requestJSON.getString("playerName");
    		
    		fuel = requestJSON.getString("fuel");
    		
    		if(map.isEmpty())
    		{
    			treasureHunt.startGame();
    		}
    		
     		map.put(playerName, fuel);
     		
    		if(map.size() - 2 > MAX_PLAYERS){
    			responseJSON = "{ isRequestValid: " +  false + "}";
    		}else{
    			map.put(playerName, fuel);
    			responseJSON = "{ isRequestValid: " +  true + "}";
    		}
    	}else{
            if ( successor != null )
                return successor.handleRequest(requestedAction, requestJSON);
        }
		return responseJSON;
	}
}
