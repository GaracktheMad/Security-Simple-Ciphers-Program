package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Caesar;
import model.FrequencyAnalyzer;
import model.Identifier;
import model.InvalidKeyException;
import model.InvalidTextException;
import model.SimpleSub;
import view.CryptoMode;
import view.CryptoPaneController;
import view.FXMLHelper;

@SuppressWarnings("javadoc")
public class Controller extends Application {
	public Caesar caesar;
	public FrequencyAnalyzer freq;
	public SimpleSub sub;
	public FXMLHelper fh;

	@Override
	public void start(Stage stage) throws Exception {
		fh = new FXMLHelper(new HandleSubmitCrypto(), new HandleFreqDecrypt(), new HandleFreqAnalyze());
		caesar = new Caesar();
		freq = new FrequencyAnalyzer();
		sub = new SimpleSub();
		Scene scene = new Scene(fh.masterPane);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * @author Peter Vukas Processes an encryption or decryption operation based on
	 *         current mode when the submit button is selected
	 *
	 */
	public class HandleSubmitCrypto implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			CryptoMode mode = fh.mpc.getMode();
			CryptoPaneController cpc = fh.getCPC();
			if (cpc != null) {
				try {
					if (mode == CryptoMode.Shift_Decrypt) {
						cpc.setResult(caesar.decrypt(cpc.getEntry(), cpc.getKey()));
					} else if (mode == CryptoMode.Shift_Encrypt) {
						cpc.setResult(caesar.encrypt(cpc.getEntry(), cpc.getKey()));
					} else if (mode == CryptoMode.SS_Decrypt) {
						cpc.setResult(sub.decrypt(cpc.getEntry(), cpc.getKey()));
					} else if (mode == CryptoMode.SS_Encrypt) {
						cpc.setResult(sub.encrypt(cpc.getEntry(), cpc.getKey()));
					} else {
						fh.mpc.setErrorMessage("CRYPTO MODE ERROR. CONTACT IDIOT PROGRAMMER.");
					}
				} catch (InvalidTextException e) {
					fh.mpc.setErrorMessage(
							"Your Cipher Text contains some invalid text. It cannot include non-alphabetic characters.");
				} catch (InvalidKeyException e) {
					if (e.i == Identifier.BAD_KEY_INT) {
						fh.mpc.setErrorMessage("Your key must be an integer!");
					} else if (e.i == Identifier.BAD_KEY_IMPROPER_ALPHABET) {
						fh.mpc.setErrorMessage(
								"Your key isn't a proper alphabet. It must contain 1 of each letter in the alphabet ONLY.");
					} else {
						fh.mpc.setErrorMessage("Unknown Key Error");
					}
				}
			} else {
				fh.mpc.setErrorMessage("CRYPTO SUBMISSION ERROR. CONTACT IDIOT PROGRAMMER.");
			}
		}

	}

	/**
	 * @author Peter Vukas Decrypts the current cipher text given the guessed key
	 *         when the associated action is activated
	 *
	 */
	public class HandleFreqDecrypt implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			try {
				fh.getFAC().setResult(sub.decrypt(fh.getFAC().getCipher(), fh.getFAC().getKey()));
			} catch (InvalidKeyException e) {
				if (e.i == Identifier.BAD_KEY_IMPROPER_ALPHABET) {
					fh.mpc.setErrorMessage(
							"Your key isn't a proper alphabet. It must contain 1 of each letter in the alphabet ONLY.");
				} else {
					fh.mpc.setErrorMessage("Unknown Key Error");
				}
			} catch (InvalidTextException e) {
				fh.mpc.setErrorMessage(
						"Your Cipher Text contains some invalid text. It cannot include non-alphabetic characters.");
			}
		}

	}

	/**
	 * @author Peter Vukas Creates frequencies when the action is activated
	 */
	public class HandleFreqAnalyze implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			try {
				freq.setDataString(fh.getFAC().getCipher());
				fh.getFAC().setFrequencies(freq.getFrequencyData());
			} catch (InvalidTextException e) {
				fh.mpc.setErrorMessage(
						"Your Cipher Text contains some invalid text. It cannot include non-alphabetic characters.");
			}

		}

	}

}