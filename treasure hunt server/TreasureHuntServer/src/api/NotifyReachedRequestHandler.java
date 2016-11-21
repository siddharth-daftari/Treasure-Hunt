package api;

import org.json.JSONObject;
import org.restlet.resource.ServerResource;

import treasureHunt.TreasureHunt ;

public class NotifyReachedRequestHandler extends ServerResource implements PostRequestHandler{
	TreasureHunt treasureHunt = TreasureHunt.getInstance();

private PostRequestHandler successor = null;
	
	public void setSuccessor(PostRequestHandler next) {
        this.successor = next ;
	}

	public String handleRequest(String requestedAction, JSONObject requestJSON){
		String playerName;
		String responseJSON = "";
		
		if(requestedAction.equalsIgnoreCase("notifyreached")){
			
			System.out.println("Received Notify reached request");
        	
        	playerName = requestJSON.getString("playerName");
        	
        	treasureHunt.getWinnerList().add(playerName);
        	
        	System.out.println(treasureHunt.getWinnerList().toString());
        }
		else
        {
            if ( successor != null ){
            	return successor.handleRequest(requestedAction, requestJSON);
            }
        }
		return responseJSON;
	}
}
