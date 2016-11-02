package api;

import java.util.Map;

import org.json.* ;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.resource.* ;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import treasureHunt.TreasureHunt ;

public class TreasureHuntResource extends ServerResource{
	TreasureHunt treasureHunt = TreasureHunt.getInstance();

    @Get
    public Representation get() throws JSONException {
    	
    	String requestedAction = (String) getRequest().getAttributes().get("param");
    	
    	ObjectMapper mapper = new ObjectMapper();
        String json = "";
        
    	return new JsonRepresentation ( json ) ; 
    }

/*
    @Post
    public Representation post(JsonRepresentation jsonRep) {

        JSONObject json = jsonRep.getJsonObject() ;
        String action = json.getString("action") ;
        System.out.println( "action: " + action ) ;

        if ( action.equals( "insert-quarter") )
        	treasureHunt.insertQuarter() ;
        if ( action.equals( "turn-crank") )
        	treasureHunt.turnCrank();

        JSONObject response = new JSONObject() ;
        String state = treasureHunt.getStateString() ;
        response.put( "result", state ) ;

        return new JsonRepresentation ( response ) ;

    }*/
}
