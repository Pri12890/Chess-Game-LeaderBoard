package application;

import java.util.UUID; 
/**
 * This class creates unique id for each player who logs in into the system for the first time
 */
public class PlayerIdGenerator {
	public static UUID getRandomUUID() {
		return UUID.randomUUID(); 
	}
	
}
