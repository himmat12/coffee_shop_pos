package view;

import javafx.scene.control.Alert;

/**
 * alert dialog box
 */
public class AlertDialog extends Alert {

	public AlertDialog(AlertType alertType, String title, String text) {
		super(alertType);
		this.setAlertType(AlertType.INFORMATION);
		this.setTitle(title);
		this.setContentText(text);
	}

}
