package api;

import org.json.JSONObject;

public interface PostRequestHandler {
	String handleRequest(String str, JSONObject requestJSON);
	void setSuccessor(PostRequestHandler next);
}
