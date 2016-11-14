package treasureHunt;

import java.util.*;


public class TreasureHunt {
	private static TreasureHunt treasureHunt ;
	private Map<String,Object> map = new HashMap<String, Object>();
	private ArrayList winnerList = new ArrayList(); 
	public static int timeLeft=0;
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
			    
		    	if(timeLeft == 40)
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
