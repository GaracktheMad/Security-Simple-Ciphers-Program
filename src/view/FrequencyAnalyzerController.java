package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

/**
 * @author Peter Vukas Controls all actions associated with the
 *         FrequencyAnalyzer.fxml
 */
public class FrequencyAnalyzerController {
	/**
	 * User-filled cipher text field
	 */
	@FXML
	private TextField cipherTxt;
	/**
	 * Used by the user to commence frequency analysis
	 */
	@FXML
	private Button analyzeBtn;
	/**
	 * User-filled key field
	 */
	@FXML
	private TextField decryptKey;
	/**
	 * Used by the user to test a decryption key
	 */
	@FXML
	private Button decryptBtn;
	/**
	 * Uneditable text field which should be filled with a calculated result on a
	 * decrypt button call
	 */
	@FXML
	private TextField resultField;
	/**
	 * Filled with resulting frequency analysis
	 */
	@FXML
	private VBox labelBox;

	/**
	 * Sets the associated event handlers
	 * 
	 * @param freqDecrypt Stores the action event related to the FrequencyAnalyzer's
	 *                    decrypt function
	 * @param freqAnalyze Stores the action event related to the FrequencyAnalyzer's
	 *                    analyze function
	 */
	public void setOnActions(EventHandler<ActionEvent> freqDecrypt, EventHandler<ActionEvent> freqAnalyze) {
		analyzeBtn.setOnAction(freqAnalyze);
		decryptBtn.setOnAction(freqDecrypt);
	}

	/**
	 * Fills the result field
	 * 
	 * @param result String to be put into this field
	 */
	public void setResult(String result) {
		resultField.setText(result);
	}

	/**
	 * @return User's inputted key
	 */
	public String getKey() {
		return decryptKey.getText();
	}

	/**
	 * @return User's inputted cipher
	 */
	public String getCipher() {
		return cipherTxt.getText();
	}

	/**
	 * Fills the frequency VBox based on an array of integer frequencies
	 * 
	 * @param data Integer array of frequencies
	 */
	public void setFrequencies(int[] data) {
		labelBox.getChildren().clear();
		char alphabet = 'A';
		for (int i : data) {
			Label l = new Label();
			l.setText(String.format("%c : %d", alphabet, i));
			labelBox.getChildren().add(l);
			alphabet++;
		}
	}
}
