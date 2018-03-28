package application;
import java.util.Comparator;
import java.util.HashMap;
// This class sorts Key and Value i.e. <UUID, Player Score> 
// in descending order of Player Score
import java.util.Map;
import java.util.UUID;
/**
 * This class will sort the player scores in descending order
 * @param <K>
 * @param <V>
 */
public class HighestScore<K,V extends  Comparable<V>> extends ProfileCard implements Comparator<K> {

	
	Map<K, V> map = new HashMap<>(); 
	
	public HighestScore(Map<K, V> map2) {
		this.map.putAll(map2);
	}
	
	
	@Override
	public int compare(K arg0, K arg1) {
		return map.get(arg1).compareTo(map.get(arg0)); 
	
	}

}
