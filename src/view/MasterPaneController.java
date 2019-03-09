package view;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;

public class MasterPaneController extends BorderPane {
	@FXML
	private BorderPane mainPane;

	@FXML
	private ComboBox<String> selectionCmb;

	// Event Listener on ComboBox[#selectionCmb].onAction
	@FXML
	public void selectionSet(ActionEvent event) {
		// TODO Process a selection

	}

	@FXML
	void initialize() {
		assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file 'MasterPane.fxml'.";
		assert selectionCmb != null : "fx:id=\"selectionCmb\" was not injected: check your FXML file 'MasterPane.fxml'.";
		selectionCmb.getItems().setAll("Shift Cipher", "Substitution Cipher", "Substitution Frequency Analyzer");
	}
}
