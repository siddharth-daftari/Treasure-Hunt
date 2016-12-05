package treasureHunt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


public class TreasureHunt {
	private static TreasureHunt treasureHunt ;
	private Map<String,Object> map = new HashMap<String, Object>();
	private ArrayList winnerList = new ArrayList(); 
	public static int timeLeft=0;
	public final static int GAME_MAX_TIME = 300;
	public static int totalPlayers = 0;
	Timer timer;
	
	public TreasureHunt() {
		System.out.println("Game started");
		treasureHunt = this;
	}
	
	public void resetGame(){
		//System.out.println("time is : " + timeLeft);
		
		timer.cancel();
		timeLeft = 0;
		totalPlayers = 0;
		this.winnerList.clear();
		this.map.clear();
		System.out.println("game reseted : ");
		
	}
	
    public void startGame(){

    	timer = new Timer();
		map.put("timeup", "false");
		map.put("allreached","false");
		
		TimerTask task = new TimerTask()
		{
		
		    @Override
		    public void run()
		    {
		    	timeLeft++;
		    	System.out.println("time is: " + timeLeft);
			    
		  	if(timeLeft == GAME_MAX_TIME + 10)
		   	{
		    	    System.out.println("time's up : " + timeLeft);
		    		timer.cancel();
		    		
		    		timeLeft = 0;
		    		totalPlayers = 0;
		    		winnerList.clear();
		    		map.clear();
		    	}
		    }
			    
		};
		timer.schedule(task, 0, 1000);
	//	timer.cancel();
	}	
	public static TreasureHunt getInstance() {
			return treasureHunt ;
	}
	public Map<String, Object> getScoreMap(){
        return map;
	}
	public ArrayList getWinnerList(){
		return winnerList;
	}
	
}