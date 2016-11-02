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
		String myURL = "http://localhost:8080/treasureHunt/get";
		ClientResource client = new ClientResource( myURL ); 
		String result = "" ;
		
        
        
	}
}
