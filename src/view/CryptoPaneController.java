package view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

/**
 * @author Peter Vukas Controls the CryptoPane.fxml
 */
public class CryptoPaneController {
	/**
	 * User inputted key
	 */
	@FXML
	private TextField keyField;
	/**
	 * Shows what is to be entered the entryField
	 */
	@FXML
	private Label entryLbl;
	/**
	 * Cipher or Plain text entry field based on mode
	 */
	@FXML
	private TextField entryField;
	/**
	 * Indicates the user wishes to encrypt or decrypt entered text
	 */
	@FXML
	private Button submitBtn;
	/**
	 * Uneditable field to display a result
	 */
	@FXML
	private TextField resultField;

	/**
	 * Sets the entry label value based on mode
	 * 
	 * @param mode Mode of encryption
	 */
	public void setLabels(CryptoMode mode) {
		if (mode == CryptoMode.Shift_Encrypt || mode == CryptoMode.SS_Encrypt) {
			entryLbl.setText("Plain Text to Encrypt:");
		}
		if (mode == CryptoMode.Shift_Decrypt || mode == CryptoMode.SS_Decrypt) {
			entryLbl.setText("Cipher Text to Decrypt:");
		}
	}

	/**
	 * Sets the associated event handlers for all associated panes
	 * 
	 * @param crypto Stores the action event related to the CryptoPane's submit
	 *               function
	 */
	public void setOnActions(EventHandler<ActionEvent> crypto) {
		submitBtn.setOnAction(crypto);
	}

	/**
	 * @return User's entered key
	 */
	public String getKey() {
		return keyField.getText();
	}

	/**
	 * @return User's entered text (Cipher/Plain)
	 */
	public String getEntry() {
		return entryField.getText();
	}

	/**
	 * Displays a result to the user
	 * 
	 * @param result String containing the result
	 */
	public void setResult(String result) {
		resultField.setText(result);
	}
}
