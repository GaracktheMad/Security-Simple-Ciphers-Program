package view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.layout.VBox;

public class FrequencyAnalyzerController {
	@FXML
	private TextField cipherTxt;
	@FXML
	private Button analyzeField;
	@FXML
	private TextField decryptKey;
	@FXML
	private Button decryptBtn;
	@FXML
	private TextField resultField;
	@FXML
	private VBox labelBox;

	// Event Listener on Button[#analyzeField].onAction
	@FXML
	public void analyze(ActionEvent event) {
		// TODO generate frequency analysis
	}
	// Event Listener on Button[#decryptBtn].onAction
	@FXML
	public void decryptAttempt(ActionEvent event) {
		// TODO decrypt text
	}
}
