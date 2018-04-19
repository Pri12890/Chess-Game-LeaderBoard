package views;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import controller.CreateNewAccountController;
import controller.LoginController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class LoginView extends Application {

	LoginController controller ;
	PlayerCardView playerCardView = new PlayerCardView();
	public void addController(LoginController controller) {
		this.controller = controller;
	}
	

	public void start(Stage primaryStage) {
		try {

			BorderPane root = new BorderPane();
			GridPane grid = new GridPane();
			Text scenetitle = new Text("Welcome");
			Scene scene = new Scene(grid,400,400);
			Label userName = new Label("User Name:");
			TextField userTextField = new TextField();
			Button signInBtn = new Button("Sign in");
			Button btn1 = new Button("Create New Account");

			//text field for password
			Label pw = new Label("Password:");
			grid.add(pw, 0, 2);
			PasswordField pwBox = new PasswordField();
			grid.add(pwBox, 1, 2);
			final Text actiontarget = new Text();
			try {
			if( )
			{
			signInBtn.setOnAction(e -> playerCardView.start(primaryStage)
			
					
					
					);
			}
		} catch (SQLException e1) {
			System.out.println("User Not Found");
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
			
			

			//??????
			//Code to Handle an Event
			//make the button display the text message when the user presses it. 

			//			btn.setOnAction(new EventHandler<ActionEvent>() {
//
//					@Override
//					public void handle(ActionEvent e) {
//					actiontarget.setFill(Color.FIREBRICK);
//					actiontarget.setText("Sign in button pressed");
//					try {
//						LoginView.this.controller.login(userTextField.getText(), pwBox.getText());
//						P
//					} catch (SQLException e1) {
//						System.out.println("User Not Found");
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					}
//					});

			btn1.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						try {
							// From Login View, Control comes to LoginController from this handle
							LoginView.this.controller.createAccountView();
						} catch (FileNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					//actiontarget.setFill(Color.FIREBRICK);
					actiontarget.setText("Create New Account button pressed");
					}
					});


			//sets the position of our objects to center
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			grid.setPadding(new Insets(25, 25, 25, 25));

			//Add Text, Labels, and Text Fields
			//set our scene title it will appear in the center of our box
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);

			//text field name and enterance area for username
			grid.add(userName, 0, 1);


			grid.add(userTextField, 1, 1);


			//Add our sign in Button 
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn.getChildren().add(signInBtn);
			grid.add(hbBtn, 1, 4);

			//Add our Create New Account button Button 
			HBox hbBtn1 = new HBox(10);
			hbBtn1.setAlignment(Pos.BOTTOM_LEFT);
			hbBtn1.getChildren().add(btn1);
			grid.add(hbBtn1, 0, 4);

			primaryStage.setScene(scene);
			//sets our title for our window
			primaryStage.setTitle("Hello to Chess Login");
			primaryStage.show();

			//Text control for displaying the message
			grid.add(actiontarget, 1, 6);



		} catch(Exception e) {
			e.printStackTrace();
		}


	}


	public static void main(String[] args) {
		launch(args);
	}
}
