/*
 * This class will display a profile card with user details
 */

package application;
import java.awt.TextField;
import java.util.Map;
import java.util.UUID;

import javafx.scene.image.Image;
public class ProfileCard extends Login implements ProfileCard_Interface {

	
	//for storing username and password
	String username, description;
	//int values for player scoring
	int uniqueId, wins, losses, HighestScore;
	//stores the images of the person's avatar
	Image profileImage;
	//textbox to store the persons description pulled from database
	TextField userDescription;
	@Override
	public void updateWins() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateLosses() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateRank() {
		// TODO Auto-generated method stub
		
	}

	
	
}
