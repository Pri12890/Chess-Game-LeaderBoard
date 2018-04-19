package views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UpdateProfileView extends Application {
//stage window
	Stage window;
	Scene scene;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = primaryStage;
		Label label = new Label("Update Your Profile");
		Button updateBtn = new Button("Click to Update");
		
		//layout our object in a vertical column
		VBox layout1 = new VBox(10);
		layout1.getChildren().addAll(label,updateBtn);
		scene = new Scene(layout1, 300, 200);
		
		window.setScene(scene);
		window.show();
		
	}
//Allows the user to update their profile
	
}
