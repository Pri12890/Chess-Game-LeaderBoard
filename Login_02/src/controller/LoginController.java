package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import models.LoginModel;

public class LoginController  {
	private	final CreateNewAccountController createNewAccountController;
	private final LoginModel loginModel; 
	private final PlayerCardController playerCardController; 
	
	public LoginController(final CreateNewAccountController createNewAccountController,
						   final LoginModel loginModel,
						   final PlayerCardController playerCardController) {
		this.createNewAccountController = createNewAccountController;
		this.loginModel = loginModel; 
		this.playerCardController = playerCardController; 
		
	}
	
	public void createAccountView() throws FileNotFoundException, SQLException {
		this.createNewAccountController.createAccountView();
	}
	
	public void login(String userName, String password) throws SQLException, IOException {
		 this.loginModel.login(userName, password);
		//final ResultSet rs2 = rs;
//		boolean hasResults = rs.next();
//		if(hasResults) {
//			
//		}else {
//			final Text actiontarget = new Text();
//			actiontarget.setFill(Color.FIREBRICK);
//			String error = "User not found for: "+ userName + password;
//			actiontarget.setText(error);
//			GridPane grid = new GridPane();
//			grid.add(actiontarget, 1,9);
//			System.out.println(error);
//		}
	}
	
	

}
