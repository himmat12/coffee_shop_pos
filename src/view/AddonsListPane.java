package view;

import java.util.ArrayList;
import java.util.function.Consumer;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import model.AddOns;

public class AddonsListPane extends VBox {

	// properties
	private Label title;
	private FlowPane addOnsFlowPane;

	// constructor
	public AddonsListPane() {
		this.addOnsFlowPane = new FlowPane();
		this.title = new Label("Add ons");
		addOnsFlowPane.setVgap(12);
		addOnsFlowPane.setHgap(12);

		this.setSpacing(12);
		this.setPadding(new Insets(12, 16, 12, 16));
		this.getChildren().addAll(title, addOnsFlowPane);
	}

	// methods
	public void addAddOnsData(ArrayList<AddOns> addOns, Consumer<AddOns> handler) {

		for (AddOns e : addOns) {
			final String name = e.getName();
			Button btn = new Button(name);
			btn.setPrefHeight(80);
			btn.setPrefWidth(80);
			btn.setFocusTraversable(false);

			addOnsFlowPane.setHgap(12.0);
			addOnsFlowPane.getChildren().add(btn);

			// attaching consumer handler passing the specific addons object to it
			btn.setOnAction(event -> handler.accept(e));
		}

	}

}
