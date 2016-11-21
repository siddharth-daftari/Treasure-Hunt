import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	public static void main(String[] args) {

		
		
		Thread myThread = new Thread ( 
	            new Runnable() 
	            {
	                 public void run() 
	                 {
	                      System.out.println(); 
	                 }
	            }
	      ) ;
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("sid",2);
        map.put("aditya",2);
        map.put("rushi",3);
        map.put("gagan",4);
        map.put("tanmay",5);
        
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        
        // convert map to JSON string
     	try {
     		json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
			// pretty print
			System.out.println(json);
		
     	} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}

}
