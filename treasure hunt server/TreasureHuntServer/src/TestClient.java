import java.net.* ;
import java.util.* ;
import java.io.* ;
import org.json.* ;
import org.restlet.resource.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Uniform;
import org.restlet.data.* ;

public class TestClient {
	
	
	public static void main( String[] args ) 
	{
		String myURL = "http://localhost:8080/treasureHunt/getscore";
		ClientResource client = new ClientResource( myURL ); 
		String result = "" ;
		
		client.setOnResponse(new Uniform() {
		    public void handle(Request request, Response response) {
		    	JSONObject json_response = null;
				try {
					json_response = new JSONObject( response.getEntity().getText() );
				} catch (JSONException | IOException e) {
					e.printStackTrace();
				}
		        System.out.println("---------> " + json_response.toString());
		        
		        Map<String, Object> map1 = new HashMap<String, Object>();

				// convert JSON string to Map
		        ObjectMapper mapper = new ObjectMapper();
				try {
					map1 = mapper.readValue(json_response.toString(), new TypeReference<Map<String, String>>(){});
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(map1.get("sid"));
		    }

		});
		// get scores
        Representation scores = client.get() ; 
        
        
	}
}
