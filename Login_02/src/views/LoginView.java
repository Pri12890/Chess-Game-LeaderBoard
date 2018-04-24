package views;

import java.sql.SQLException;

import com.mysql.jdbc.StringUtils;

import controller.LoginController;
import controller.UserInfofromDb;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class has the responsibility to create a view for the users where
 * existing users can login into the leader board system and new users can
 * create their profile.
 */
public class LoginView extends Application {

	LoginController controller;

	public void addController(LoginController controller) {
		this.controller = controller;
	}

	@Override
	public void start(Stage primaryStage) {
		try {

			GridPane grid = new GridPane();
			Scene scene = new Scene(grid, 400, 400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hello to Chess Login");
			primaryStage.show();
			Text scenetitle = new Text("Welcome");
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			grid.setPadding(new Insets(25, 25, 25, 25));
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);

			// Label and TextField for UserName
			Label userName = new Label("User Name:");
			grid.add(userName, 0, 1);
			TextField userTextField = new TextField();
			grid.add(userTextField, 1, 1);

			// Label and Password Field for Password
			Label pw = new Label("Password:");
			grid.add(pw, 0, 2);
			PasswordField pwBox = new PasswordField();
			grid.add(pwBox, 1, 2);

			// Sign In Button
			Button signInBtn = new Button("Sign in");
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn.getChildren().add(signInBtn);
			grid.add(hbBtn, 1, 4);

			// Create New Account Button
			Button createAccountbtn = new Button("Create New Account");
			HBox hbBtn1 = new HBox(10);
			hbBtn1.setAlignment(Pos.BOTTOM_LEFT);
			hbBtn1.getChildren().add(createAccountbtn);
			grid.add(hbBtn1, 0, 4);

			final Text actiontarget = new Text();

			// Handle for SignInButton
			signInBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					try {
						String name = userTextField.getText();
						String pwd = pwBox.getText();
						if (StringUtils.isNullOrEmpty(name) || StringUtils.isNullOrEmpty(pwd)) {
							System.out.println("Missing user details ");
							throwError(grid, actiontarget, "Please enter id and password");
						} else {
							UserInfofromDb userInfofromDb = LoginView.this.controller.login(name, pwd);
							LoginView.this.controller.openPlayerCardView(userInfofromDb);
						}
					} catch (SQLException | NullPointerException e1) {
						throwError(grid, actiontarget, "User does not exist");
					}
				}

			});

			// Handle for Create Account Button
			createAccountbtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					try {
						LoginView.this.controller.createAccountView();
					} catch (NullPointerException e1) {
						throwError(grid, actiontarget, "Restart plz..");
					}
				}
			});

		} catch (Exception e) {
			System.out.println("Login view crashed " + e.getMessage());
		}

	}

	private void throwError(GridPane grid, final Text actiontarget, String error) {
		try {
			actiontarget.setFill(Color.FIREBRICK);
			actiontarget.setText(error);
			grid.add(actiontarget, 1, 6);
		} catch (IllegalArgumentException e) {
		}
	}
}
