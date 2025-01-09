package view;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class OrdersListPane extends VBox {
	private TextArea textBox;
	private Label title;

	public OrdersListPane() {
		textBox = new TextArea();
		textBox.setDisable(true);
		textBox.setPrefHeight(340);
		textBox.setPrefWidth(400);
		textBox.setWrapText(true);
		textBox.setStyle("-fx-text-fill: black; -fx-opacity: 1;");

		title = new Label("Orders");

		this.setSpacing(6);
		this.getChildren().addAll(title, textBox);
	}

	// methods
	public void setOrders(String text) {
		textBox.setText(text);
	}

}
