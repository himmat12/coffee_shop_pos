package view;

import java.util.ArrayList;
import java.util.function.Consumer;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import model.Cake;

public class CakesListPane extends VBox {

	// properties
	private Label title;
	private FlowPane cakesFlowPane;

	// constructor
	public CakesListPane() {
		this.cakesFlowPane = new FlowPane();
		this.title = new Label("Cakes");
		cakesFlowPane.setVgap(12);
		cakesFlowPane.setHgap(12);

		this.setSpacing(12);
		this.setPadding(new Insets(2, 16, 2, 16));
		this.getChildren().addAll(title, cakesFlowPane);
	}

	// methods
	public void addCakesData(ArrayList<Cake> cakes, Consumer<Cake> handler) {

		for (Cake e : cakes) {
			final String name = e.getName();
			Button btn = new Button(name);
			btn.setPrefHeight(80);
			btn.setPrefWidth(80);
			btn.setFocusTraversable(false);

			cakesFlowPane.setHgap(12.0);
			cakesFlowPane.getChildren().add(btn);

			// attaching consumer handler passing the specific addons object to it
			btn.setOnAction(event -> handler.accept(e));

		}

	}

}
