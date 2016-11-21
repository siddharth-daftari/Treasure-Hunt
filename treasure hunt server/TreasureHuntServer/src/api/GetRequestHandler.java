package api;

public interface GetRequestHandler {
	String handleRequest(String str);
	void setSuccessor(GetRequestHandler next);
}
