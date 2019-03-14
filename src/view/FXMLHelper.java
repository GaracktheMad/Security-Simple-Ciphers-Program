package view;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

/**
 * @author Peter Vukas Prepares the Master pane and associated controllers.
 */
public class FXMLHelper {
	/**
	 * MasterPaneController for this view
	 */
	public final MasterPaneController mpc;
	/**
	 * BorderPane controlled by the MasterPaneController
	 */
	public final BorderPane masterPane;

	/**
	 * Sets the associated event handlers for all associated panes
	 * 
	 * @param handleCrypto      Stores the action event related to the CryptoPane's
	 *                          submit function
	 * @param handleFreqDecrypt Stores the action event related to the
	 *                          FrequencyAnalyzer's decrypt function
	 * @param handleFreqAnalyze Stores the action event related to the
	 *                          FrequencyAnalyzer's analyze function
	 * @throws IOException Critical error has occurred in which the MasterPane.fxml
	 *                     file isn't found.
	 */
	public FXMLHelper(EventHandler<ActionEvent> handleCrypto, EventHandler<ActionEvent> handleFreqDecrypt,
			EventHandler<ActionEvent> handleFreqAnalyze) throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("MasterPane.fxml"));
		masterPane = load.load();
		mpc = load.getController();
		mpc.setOnActions(handleCrypto, handleFreqDecrypt, handleFreqAnalyze);
	}

	/**
	 * @return CryptoPaneController associated to this frame if the frame is in the
	 *         associated modes
	 */
	public CryptoPaneController getCPC() {
		if (mpc.getMode() != null && mpc.getMode() != CryptoMode.SS_Analyze) {
			return mpc.cpc;
		} else {
			return null;
		}
	}

	/**
	 * @return FrequencyAnalyzerController associated to this frame if the frame is
	 *         in the associated mode
	 */
	public FrequencyAnalyzerController getFAC() {
		if (mpc.getMode() == CryptoMode.SS_Analyze) {
			return mpc.fac;
		} else {
			return null;
		}
	}

}