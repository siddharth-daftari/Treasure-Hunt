package api;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation; 
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import treasureHunt.TreasureHunt ;

public class TreasureHuntResource extends ServerResource{
    TreasureHunt treasureHunt = TreasureHunt.getInstance();

    @Get
    public Representation get() throws JSONException {
        
        String requestedAction = (String) getRequest().getAttributes().get("param");
        
        GetScoreRequestHandler getScoreRequestHandler = new GetScoreRequestHandler();
        GetWinnersRequestHandler getWinnersRequestHandler = new GetWinnersRequestHandler();
        ResetGame resetGame = new ResetGame();
        
        getScoreRequestHandler.setSuccessor(getWinnersRequestHandler);
        getWinnersRequestHandler.setSuccessor(resetGame);
        
        String json = getScoreRequestHandler.handleRequest(requestedAction);
        
        return new JsonRepresentation ( json ) ; 
    }
    
    
    @Post
    public Representation post(JsonRepresentation jsonRep) {
        
        String requestedAction = (String) getRequest().getAttributes().get("param");
        
        System.out.println(requestedAction);
        JSONObject requestJSON = jsonRep.getJsonObject() ;
        String responseJSON = "";
        
        NotifyReachedRequestHandler notifyReachedRequestHandler = new NotifyReachedRequestHandler();
        RegisterRequestHandler registerRequestHandler = new RegisterRequestHandler();
        UpdateScoreRequestHandler updateScoreRequestHandler = new UpdateScoreRequestHandler();
        
        notifyReachedRequestHandler.setSuccessor(registerRequestHandler);
        registerRequestHandler.setSuccessor(updateScoreRequestHandler);
        
        responseJSON = notifyReachedRequestHandler.handleRequest(requestedAction, requestJSON);
        
        return new JsonRepresentation(responseJSON);
    }
}
