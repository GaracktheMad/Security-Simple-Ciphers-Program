package model;

/**
 * @author Peter Vukas Performs a frequency analysis on a given string
 */
public class FrequencyAnalyzer implements UsesAlphabet {
	/**
	 * String to be analyzed
	 */
	private String dataString;
	/**
	 * Parallel array to the alphabet giving the frequency of each alphabetical
	 * value starting with A as an integer
	 */
	private int[] frequencyData = new int[26];

	/**
	 * Creates a frequency Analyzer with a predetermined data string
	 * 
	 * @param dataString String to be analyzed
	 */
	public FrequencyAnalyzer(String dataString) {
		this.dataString = dataString.toUpperCase().replace(" ", "");
		resetFrequencyData();
		analyze();
	}

	/**
	 * Creates a frequency analyzer with a data string to be given later
	 */
	public FrequencyAnalyzer() {
		dataString = "";
		resetFrequencyData();
	}

	/**
	 * Sets frequency data to all 0s
	 */
	private void resetFrequencyData() {
		for (int i = 0; i < frequencyData.length; i++) {
			frequencyData[i] = 0;
		}
	}

	/**
	 * Fills the frequency data string with appropriate data
	 */
	private void analyze() {
		char[] analysisDatum = dataString.toCharArray();
		for (char c = 'A'; c <= 'Z'; c++) {
			for (char ca : analysisDatum) {
				if (ca == c) {
					frequencyData[Integer.valueOf(c) - 65]++;
				}
			}
		}
	}

	/**
	 * @return Current string being analyzed
	 */
	public String getDataString() {
		return dataString;
	}

	/**
	 * Sets and analyzes a new data string
	 * 
	 * @param dataString String to be analyzed
	 * @throws InvalidTextException Thrown if a non-alphabetic string is provided
	 */
	public void setDataString(String dataString) throws InvalidTextException {
		rangeCheck(dataString.toUpperCase().toCharArray());
		this.dataString = dataString.toUpperCase().replace(" ", "");
		resetFrequencyData();
		analyze();

	}

	/**
	 * @return Frequencies of the currently analyzed string. Array will contain
	 *         values of all 0 if no string was analyzed yet.
	 */
	public int[] getFrequencyData() {
		return frequencyData;
	}

}
