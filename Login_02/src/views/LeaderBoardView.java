package views;

import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.LeaderBoardModel.UserPartialInfo;

public class LeaderBoardView extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	List<UserPartialInfo> listSortedUsers;

	public void helper(Stage primaryStage) {
		GridPane grid = new GridPane();
		primaryStage.setTitle("Welcome to LeaderBoard");
		Text scenetitle = new Text("\t\tUserId\t\t\tUserName\t\t\tUserScore");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		grid.add(scenetitle, 0, 0, 2, 1);
		// Group root = new Group();
		StackPane root = new StackPane();
		Label userID = new Label("User ID");
		Label userName = new Label("User Name");
		Label score = new Label("Score");

		// grid.add(userID, 5, 4);
		// grid.add(userName, 9, 4);
		// grid.add(score, 13, 4);
		final ObservableList options = FXCollections.observableArrayList(this.listSortedUsers);
		ListView listView = new ListView(options);
		listView.setMaxSize(400, 400);
		// BorderPane.setMargin(listView, new Insets(10));

		// listView.getItems().addAll(1, "Userid\t\tUserName\t\tScore");

		// listView = new
		// ListView(FXCollections.observableArrayList(this.listSortedUsers));
		listView.setPrefSize(200, 250);
		listView.setEditable(false);
		// Scene scene = new Scene(root, 1000, 1000);
		// root.getChildren().addAll(listView, grid);

		// listView.setCellFactory(ComboBoxListCell.forListView(names));

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
		// starter(primaryStage);
		// test(primaryStage);

	}

	private void starter(Stage primaryStage) {
		try {
			final ScrollBar sc = new ScrollBar();
			GridPane grid = new GridPane();
			Group root = new Group();

			Text scenetitle = new Text("Welcome to LeaderBoard");
			Scene scene = new Scene(root, 1000, 1000);
			root.getChildren().addAll(sc, grid);
			Label userID = new Label("User ID");
			Label userName = new Label("User Name");
			Label score = new Label("Score");
			grid.add(userID, 0, 1);
			grid.add(userName, 1, 1);
			grid.add(score, 2, 1);
			sc.setMin(0);
			sc.setMax(100);
			sc.setValue(50);
			sc.setLayoutX(scene.getWidth() - sc.getWidth());
			sc.setOrientation(Orientation.VERTICAL);
			sc.setPrefHeight(1000);
			sc.setMax(2000);
			int ctr = 2;
			for (UserPartialInfo info : listSortedUsers) {
				final TextField userId = new TextField();
				final TextField userTextField = new TextField();
				final TextField userScore = new TextField();
				userId.setText(Integer.toString(info.getId()));
				userTextField.setText(info.getName());
				userScore.setText(info.getScore() == null ? "" : info.getScore().toString());
				// text field name and entrance area for username
				grid.add(userId, 0, ctr);
				grid.add(userTextField, 1, ctr);
				grid.add(userScore, 2, ctr);
				ctr++;
			}

			grid.setAlignment(Pos.TOP_CENTER);
			grid.setHgap(10);
			grid.setVgap(10);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			grid.setPadding(new Insets(25, 25, 25, 25));

			// Add Text, Labels, and Text Fields
			// set our scene title it will appear in the center of our box
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);

			primaryStage.setScene(scene);
			// sets our title for our window
			primaryStage.setTitle("Hello to Chess Login");
			primaryStage.show();

			// Text control for displaying the message
			// grid.add(actiontarget, 1, 6);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void test(Stage stage) {
		final ScrollBar sc = new ScrollBar();
		// final VBox vb = new VBox();
		// DropShadow shadow = new DropShadow();

		Group root = new Group();
		Scene scene = new Scene(root, 1000, 1000);
		scene.setFill(Color.BLACK);
		stage.setScene(scene);
		// stage.setTitle("Scrollbar");
		GridPane grid = new GridPane();
		root.getChildren().addAll(sc, grid);

		// shadow.setColor(Color.GREY);
		// shadow.setOffsetX(2);
		// shadow.setOffsetY(2);

		// vb.setLayoutX(50);
		// vb.setSpacing(100);

		sc.setLayoutX(scene.getWidth() - sc.getWidth());
		// sc.setMin(0);
		sc.setOrientation(Orientation.VERTICAL);
		sc.setPrefHeight(1000);
		sc.setMax(1000);
		// for (int i = 0; i < 5; i++) {
		// // final Image image = images[i] = new
		// Image(getClass().getResourceAsStream("fw"
		// // + (i + 1) + ".jpg"));
		// // final ImageView pic = pics[i] = new ImageView(images[i]);
		// // pic.setEffect(shadow);
		// // vb.getChildren().add(pics[i]);
		// }

		// sc.valueProperty().addListener(new ChangeListener<Number>() {
		// @Override
		// public void changed(ObservableValue<? extends Number> ov, Number old_val,
		// Number new_val) {
		// // vb.setLayoutY(-new_val.doubleValue());
		// }
		// });

		stage.show();

	}

}
