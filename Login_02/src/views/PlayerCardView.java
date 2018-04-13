package views;


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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class PlayerCardView extends Application {


	@Override
		public void start(Stage primaryStage) {
			try {
				
				
				// For Image 
				// VBox vBox = new VBox(); vBox.setAlignment(Pos.CENTER);
				// Add image view to the pane. vBox.getChildren().add(new ImageView("tiger.jpg"));
				// Set the stage and show. Scene scene = new Scene(vBox); stage.setTitle("Image Demo"); stage.setScene(scene); stage.show();

				
				
				BorderPane root = new BorderPane();
				//Scene scene = new Scene(root,800,800);
				GridPane grid = new GridPane();
				//text control for displaying the message 

				Scene scene = new Scene(grid, 600, 600);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

				primaryStage.setScene(scene);
				grid.setAlignment(Pos.CENTER);
				grid.setHgap(10);
				grid.setVgap(10);
				grid.setPadding(new Insets(25, 25, 25, 25));
				primaryStage.setScene(scene);
				//sets our title for our window 
				primaryStage.setTitle("Hello to Chess Login");
				primaryStage.show();
				Text scenetitle = new Text("Welcome");
				scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
				grid.add(scenetitle, 0, 0, 2, 1);
				//grid.getChildren().add(new ImageView("tiger.jpg"));

				Label userId = new Label("User Id:");
				grid.add(userId, 0, 1);

				TextField userTextField = new TextField();
				grid.add(userTextField, 1, 1);

				Label userName = new Label("UserName:");
				grid.add(userName, 0, 2);

				TextField userTextField1 = new TextField();
				grid.add(userTextField1, 1, 2);

				Label description = new Label("Description:");
				grid.add(description, 0, 3);

				TextField userTextField2 = new TextField();
				grid.add(userTextField2, 1, 3);


				Label image = new Label("Image:");
				grid.add(image, 0, 4);

				//			Image image1 = new Image("/Users/harshitdokania/Dropbox/Screenshots/grad");
				//			grid.getChildren().add(new ImageView(image1));

				TextField userTextField3 = new TextField();
				grid.add(userTextField3, 1, 4);

				Button btn = new Button("View Your Score");
				//final Text actiontarget = new Text();
				//grid.add(actiontarget, 0, 6);


				Button btn1 = new Button("View Highest Score");
				//final Text actiontarget1 = new Text();
				//grid.add(actiontarget1, 0, 7);


				//Add "View Your Score" Button 
				HBox hbBtn = new HBox(10);
				hbBtn.setAlignment(Pos.BOTTOM_LEFT);
				hbBtn.getChildren().add(btn);
				grid.add(hbBtn, 0, 7);

				//Add "View Highest Score  Button 
				HBox hbBtn1 = new HBox(10);
				hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
				hbBtn1.getChildren().add(btn1);
				grid.add(hbBtn1, 1, 7);

				// Call Controller to call Your Stats View 		       
				//		        btn.setOnAction(new EventHandler<ActionEvent>() {
				//		        	 
				//		            @Override
				//		            public void handle(ActionEvent e) {
				//		                actiontarget.setFill(Color.FIREBRICK);
				//		                actiontarget.setText("Account Created");
				//		            }
				//		        });


				// Call Controller to call Your Stats View 		       
				//		        btn.setOnAction(new EventHandler<ActionEvent>() {
				//		        	 
				//		            @Override
				//		            public void handle(ActionEvent e) {
				//		                actiontarget.setFill(Color.FIREBRICK);
				//		                actiontarget.setText("Account Created");
				//		            }
				//		        });			 



				//			HBox hbBtn = new HBox(10);
				//			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
				//			hbBtn.getChildren().add(btn);
				//			grid.add(hbBtn, 1, 6);



				PasswordField pwBox = new PasswordField();
				grid.add(pwBox, 1, 2);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}



	public static void main(String[] args) {
		launch(args);
	}
}
