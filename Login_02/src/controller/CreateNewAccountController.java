package controller;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javafx.application.Platform;
import javafx.stage.Stage;
import models.NewAccountModel;
import models.UserProfile;
import views.CreateNewAccountView;

public class CreateNewAccountController{

	
	private final NewAccountModel newAccountModel;
	private final CreateNewAccountView createNewAccountView;
	
	public CreateNewAccountController(NewAccountModel newAccountModel, CreateNewAccountView createNewAccountView) {
		this.newAccountModel = newAccountModel;
		this.createNewAccountView = createNewAccountView;
	}
	
	public NewAccountModel getNewAccountModel() {
		return this.newAccountModel;
	}
	
	public CreateNewAccountView getCreateNewAccountView() {
		return this.createNewAccountView;
	}
	
	public void createAccount(final UserProfile userProfile) throws SQLException, FileNotFoundException {
			this.newAccountModel.insertRecords(userProfile);
	}
	
	public void createAccountView() throws SQLException, FileNotFoundException {
		Platform.runLater(new Runnable() {
		      @Override
		      public void run() {
		    	  CreateNewAccountController.this.createNewAccountView.start(new Stage());
		      }
		  });
		
		}
}
	
	
