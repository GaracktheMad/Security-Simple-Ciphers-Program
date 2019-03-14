package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * @author Peter Vukas Handles actions involving the main view for the user,
 *         including changing of modes and views.
 */
public class MasterPaneController {
	/**
	 * Displays any related errors
	 */
	@FXML
	private Label errorLbl;
	/**
	 * Current BorderPane
	 */
	@FXML
	private BorderPane thisPane;
	/**
	 * Displays all modes of the program
	 */

	@FXML
	private ComboBox<String> selectionCmb;

	/**
	 * Stores the action event related to the CryptoPane's submit function
	 */
	private EventHandler<ActionEvent> crypto;
	/**
	 * Stores the action event related to the FrequencyAnalyzer's decrypt function
	 */
	private EventHandler<ActionEvent> freqDecrypt;
	/**
	 * Stores the action event related to the FrequencyAnalyzer's analyze function
	 */
	private EventHandler<ActionEvent> freqAnalyze;

	/**
	 * Controller for the frequency analyzer FXML
	 */
	protected FrequencyAnalyzerController fac;
	/**
	 * Controller for the crypto pane FXML
	 */
	protected CryptoPaneController cpc;
	/**
	 * Helps determine what mode the user has set
	 */
	private CryptoMode mode = null;

	/**
	 * @return Current user selected mode
	 */
	public CryptoMode getMode() {
		return mode;
	}

	/**
	 * Called when the mode combobox is changed to relay that information to the
	 * controller class.
	 * 
	 * @param event Combobox object is changed
	 */
	// Event Listener on ComboBox[#selectionCmb].onAction
	@FXML
	public void selectionSet(ActionEvent event) {
		String selection = selectionCmb.getValue();
		switch (selection) {
		case "Shift Cipher (Decrypt)":
			mode = CryptoMode.Shift_Decrypt;
			break;
		case "Substitution Cipher (Decrypt)":
			mode = CryptoMode.SS_Decrypt;
			break;
		case "Shift Cipher (Encrypt)":
			mode = CryptoMode.Shift_Encrypt;
			break;
		case "Substitution Cipher (Encrypt)":
			mode = CryptoMode.SS_Encrypt;
			break;
		case "Substitution Frequency Analyzer":
			mode = CryptoMode.SS_Analyze;
			break;
		default:
			mode = null;
		}
		if (mode != null && mode != CryptoMode.SS_Analyze) {
			try {
				FXMLLoader f = new FXMLLoader();
				f.setLocation(getClass().getResource("CryptoPane.fxml"));
				VBox v = f.load();
				cpc = f.getController();
				cpc.setLabels(mode);
				cpc.setOnActions(crypto);
				thisPane.setCenter(v);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (mode == CryptoMode.SS_Analyze) {
			try {
				FXMLLoader f = new FXMLLoader();
				f.setLocation(getClass().getResource("FrequencyAnalyzer.fxml"));
				BorderPane bp = f.load();
				fac = f.getController();
				fac.setOnActions(freqDecrypt, freqAnalyze);
				thisPane.setCenter(bp);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Sets the associated event handlers for all associated panes
	 * 
	 * @param handleCrypto      Stores the action event related to the CryptoPane's
	 *                          submit function
	 * @param handleFreqDecrypt Stores the action event related to the
	 *                          FrequencyAnalyzer's decrypt function
	 * @param handleFreqAnalyze Stores the action event related to the
	 *                          FrequencyAnalyzer's analyze function
	 */
	public void setOnActions(EventHandler<ActionEvent> handleCrypto, EventHandler<ActionEvent> handleFreqDecrypt,
			EventHandler<ActionEvent> handleFreqAnalyze) {
		crypto = handleCrypto;
		freqDecrypt = handleFreqDecrypt;
		freqAnalyze = handleFreqAnalyze;
	}

	/**
	 * Fills the selection Combo Box
	 */
	@FXML
	void initialize() {
		assert selectionCmb != null : "fx:id=\"selectionCmb\" was not injected: check your FXML file 'MasterPane.fxml'.";
		selectionCmb.getItems().setAll("Shift Cipher (Decrypt)", "Substitution Cipher (Decrypt)",
				"Shift Cipher (Encrypt)", "Substitution Cipher (Encrypt)", "Substitution Frequency Analyzer");
	}

	/**
	 * Sends an error message to the user displayed at the bottom of this border
	 * pane.
	 * 
	 * @param msg A string value to help the user pinpoint issues
	 */
	public void setErrorMessage(String msg) {
		errorLbl.setText(msg);
	}
}
