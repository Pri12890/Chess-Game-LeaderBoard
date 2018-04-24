package views;

import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.LeaderBoardModel.UserPartialInfo;

/**
 * This class has the responsibility to create a leader board view for the user
 * so that they can view all the user names and scores.
 */
public class LeaderBoardView extends Application {

	List<UserPartialInfo> listSortedUsers;

	public void helper(Stage primaryStage) {
		GridPane grid = new GridPane();
		primaryStage.setTitle("Welcome to LeaderBoard");
		Text scenetitle = new Text("\t\tUserId\t\t\tUserName\t\t\tUserScore");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		grid.add(scenetitle, 0, 0, 2, 1);
		// Group root = new Group();
		StackPane root = new StackPane();

		// grid.add(userID, 5, 4);
		// grid.add(userName, 9, 4);
		// grid.add(score, 13, 4);
		final ObservableList options = FXCollections.observableArrayList(this.listSortedUsers);
		ListView listView = new ListView(options);
		listView.setMaxSize(400, 400);
		listView.setPrefSize(200, 250);
		listView.setEditable(false);
		root.getChildren().addAll(grid, listView);
		primaryStage.setScene(new Scene(root, 500, 500));
		primaryStage.show();
	}

	public void setListSortedUsers(final List<UserPartialInfo> listSortedUsers) {
		this.listSortedUsers = listSortedUsers;
	}

	@Override
	public void start(Stage primaryStage) {
		helper(primaryStage);
	}

}
