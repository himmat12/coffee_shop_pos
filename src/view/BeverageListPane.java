package view;

import java.util.ArrayList;
import java.util.function.Consumer;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import model.Beverage;

/**
 * Container for list of beverageFlowPane like coffee or addons
 */

public class BeverageListPane extends VBox {

	// properties
	private Label title;
	private FlowPane beverageFlowPane;
	private Boolean isBtnDasabled = false;

	// constructor
	public BeverageListPane() {
		this.beverageFlowPane = new FlowPane();
		this.title = new Label("Coffee Beans");
		beverageFlowPane.setVgap(12);
		beverageFlowPane.setHgap(12);

		this.setSpacing(12);
		this.setPadding(new Insets(2, 16, 2, 16));
		this.getChildren().addAll(title, beverageFlowPane);
	}

	// methods
	public void addBeveragesData(ArrayList<Beverage> beverages, Consumer<Beverage> handler) {

		for (Beverage e : beverages) {
			final String name = e.getDescription();
			Button btn = new Button(name);
			btn.setPrefHeight(80);
			btn.setPrefWidth(80);
			btn.setFocusTraversable(false);
			btn.setDisable(isBtnDasabled);
			beverageFlowPane.setHgap(12.0);
			beverageFlowPane.getChildren().add(btn);

			// attaching consumer handler passing the specific beverage object to it
			btn.setOnAction(event -> handler.accept(e));

		}

	}

	/**
	 * @return the isBtnDasabled
	 */
	public Boolean getIsBtnDasabled() {
		return isBtnDasabled;
	}

	/**
	 * @param isBtnDasabled the isBtnDasabled to set
	 */
	public void setIsBtnDasabled(Boolean isBtnDasabled) {
		this.isBtnDasabled = isBtnDasabled;
	}

}
