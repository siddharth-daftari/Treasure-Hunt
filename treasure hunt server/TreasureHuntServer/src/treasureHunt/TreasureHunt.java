package treasureHunt;

import java.util.*;

public class TreasureHunt {
	private static TreasureHunt treasureHunt ;
	private Map<String,Object> map = new HashMap<String, Object>();
	
	public static TreasureHunt getInstance() {
		if (treasureHunt == null) {
			treasureHunt = new TreasureHunt() ;
			treasureHunt.init() ;
			return treasureHunt ;
		}
		else {
			return treasureHunt ;
		}
	}
	
	private void init() {
	}
	
	
	
}
