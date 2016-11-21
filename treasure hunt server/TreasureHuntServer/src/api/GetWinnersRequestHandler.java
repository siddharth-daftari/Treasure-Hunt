package api;

import java.util.ArrayList;

import org.restlet.resource.ServerResource;

import treasureHunt.TreasureHunt ;

public class GetWinnersRequestHandler extends ServerResource implements GetRequestHandler {
	TreasureHunt treasureHunt = TreasureHunt.getInstance();
	private GetRequestHandler successor = null;
	
	public void setSuccessor(GetRequestHandler next) {
        this.successor = next ;
	}

	public String handleRequest(String requestedAction){
		String json = null;
		ArrayList winnerList = treasureHunt.getWinnerList();
		
		if(requestedAction.equalsIgnoreCase("getwinners")){
			System.out.println("Received Get Winners request");
			
    		json = "{ Winners : " +  winnerList + "}";
            
    		System.out.println("Winner list json: " + json);
    	}
		else
        {
            if ( successor != null )
                return successor.handleRequest(requestedAction);
        }
		return json;
	}
}