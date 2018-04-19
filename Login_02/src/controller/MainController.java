package controller;

import javafx.application.Platform;
import javafx.stage.Stage;
import models.LoginModel;
import models.NewAccountModel;
import models.PlayerCardModel;
import views.CreateNewAccountView;
import views.LoginView;
import views.PlayerCardView;

public class MainController {
	
	public static void main(String[] args) {
    		
	final 	CreateNewAccountView createNewAccountview = new CreateNewAccountView();
	final	NewAccountModel model = new NewAccountModel();
	
	
	
	
	final	CreateNewAccountController createNewAccountcontroller = new CreateNewAccountController(model, createNewAccountview);
	createNewAccountview.addController(createNewAccountcontroller);
	
	LoginView loginView = new LoginView();
	LoginModel loginModel = new LoginModel(); 
	PlayerCardView playerCardView = new PlayerCardView();
	PlayerCardModel playerCardModel = new PlayerCardModel();
	PlayerCardController playerCardController = new PlayerCardController(playerCardModel, playerCardView); 
	final LoginController loginController = new LoginController(createNewAccountcontroller,
															   loginModel,
															   playerCardController);
	loginView.addController(loginController);
	
	
    // This operation is permitted on the event thread only; currentThread = main
   // create JavaFX runnable thread - to show view. 
	Platform.startup(new Runnable() {
	      @Override
	      public void run() {
	    	  // Application starts here with Login View 
	    	  loginView.start(new Stage());
	      }
	  });
	
	}	

	

}
