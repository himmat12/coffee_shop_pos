package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BottomPane extends HBox {

	// fields
	private TextField textField;
	private Button addBtn;
	private Button clearBtn;
	private Button payBtn;
	private Button voidOrderBtn;
	private Label title;

	public BottomPane() {
		VBox vBox = new VBox();
		vBox.setSpacing(6);

		title = new Label("Add items");

		textField = new TextField();
		textField.setPrefSize(370, 40);
		textField.setFocusTraversable(false);
		textField.setDisable(true);
		textField.setStyle("-fx-text-fill: black; -fx-opacity: 1;");

		vBox.getChildren().addAll(title, textField);

		addBtn = new Button();
		addBtn.setText("Add");
		addBtn.setPrefSize(80, 40);
		addBtn.setFocusTraversable(false);

		clearBtn = new Button();
		clearBtn.setText("Clear");
		clearBtn.setPrefSize(80, 40);
		clearBtn.setFocusTraversable(false);

		voidOrderBtn = new Button();
		voidOrderBtn.setText("Void Order");
		voidOrderBtn.setPrefSize(100, 40);
		voidOrderBtn.setFocusTraversable(false);

		payBtn = new Button();
		payBtn.setText("Pay");
		payBtn.setPrefSize(100, 40);
		payBtn.setFocusTraversable(false);

		this.setSpacing(8);
		this.setAlignment(Pos.BOTTOM_LEFT);
		this.getChildren().addAll(vBox, addBtn, clearBtn, voidOrderBtn, payBtn);

	}

	// methods

	/**
	 * cleares the text field
	 */
	public void clearTextField() {
		textField.clear();
	}

	/**
	 * @return the textField
	 */
	public TextField getTextField() {
		return textField;
	}

	/**
	 * @param text the textField text value to set
	 */
	public void setTextFieldText(String text) {
		this.textField.setText(text);
	}

	// this method lets to attach text field event handler from external controllers
	public void addTextFieldHandler(EventHandler<InputMethodEvent> handler) {
		textField.setOnInputMethodTextChanged(handler);
	}

	// this method lets to attach add btn event handler from external controllers
	public void addAddBtnHandler(EventHandler<ActionEvent> handler) {
		addBtn.setOnAction(handler);
	}

	// this method lets to attach clear btn event handler from external controllers
	public void addClearBtnHandler(EventHandler<ActionEvent> handler) {
		clearBtn.setOnAction(handler);
	}

	// this method lets to attach void order btn event handler from external
	// controllers
	public void addVoidOrderBtnHandler(EventHandler<ActionEvent> handler) {
		voidOrderBtn.setOnAction(handler);
	}

	// this method lets to attach pay btn event handler from external controllers
	public void addPayBtnHandler(EventHandler<ActionEvent> handler) {
		payBtn.setOnAction(handler);
	}

}
