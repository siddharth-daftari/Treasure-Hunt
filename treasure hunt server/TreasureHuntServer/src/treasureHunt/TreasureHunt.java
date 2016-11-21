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
	public final static long GAME_MAX_TIME = 99999;
	
	public TreasureHunt() {
		
		treasureHunt = this;
		
		Timer timer = new Timer();
		map.put("timeup", "false");
		TimerTask task = new TimerTask()
		{
		
		    @Override
		    public void run()
		    {
		    	timeLeft++;
		    	//System.out.println("time is: " + timeLeft);
			    
		    	if(timeLeft == GAME_MAX_TIME)
		    	{
		    	    System.out.println("time's up : " + timeLeft);
		    		timer.cancel();
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
