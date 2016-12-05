package api;


import treasureHunt.TreasureHunt;

public class ResetGame implements GetRequestHandler{
	TreasureHunt treasureHunt = TreasureHunt.getInstance();
	private GetRequestHandler successor = null;
	
	
	public String handleRequest(String requestedAction) {
		String json = "";
		
		if(requestedAction.equalsIgnoreCase("reset")){
			System.out.println("Received reset request");
			
			treasureHunt.resetGame();
	     	
    	}
		else
        {
            if ( successor != null )
                return successor.handleRequest(requestedAction);
        }
		System.out.println(json);
		return json;
	}

	@Override
	public void setSuccessor(GetRequestHandler next) {
		this.successor = next ;
		
	}

}
