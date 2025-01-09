package main;

import controller.AppController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Cream;
import model.DecafCoffee;
import model.Flapjack;
import model.Milk;
import model.Muffin;
import model.Panettone;
import model.RegularCoffee;
import model.Sprinkles;
import model.Sugar;
import view.BeverageListPane;
import view.DashboardPane;

public class MainApp extends Application {

	private DashboardPane view; // root of the scene

	@Override
	public void init() throws Exception {

		// view
		view = new DashboardPane();

		// controller
		new AppController(view);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setResizable(false);
		primaryStage.centerOnScreen();
		primaryStage.setTitle("Coffee Shop");
		primaryStage.setScene(new Scene(view, 800, 500));
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
