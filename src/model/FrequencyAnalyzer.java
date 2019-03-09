package model;

public class FrequencyAnalyzer {
	private String dataString;
	private int[] frequencyData = new int[26];

	public FrequencyAnalyzer(String dataString) {
		this.dataString = dataString.toUpperCase().replace(" ", "");
		resetFrequencyData();
		analyze();
	}

	public FrequencyAnalyzer() {
		dataString = "";
		resetFrequencyData();
	}

	private void resetFrequencyData() {
		for (int i = 0; i < frequencyData.length; i++) {
			frequencyData[i] = 0;
		}
	}

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

	public String getDataString() {
		return dataString;
	}

	public void setDataString(String dataString) {
		this.dataString = dataString.toUpperCase().replace(" ", "");
		resetFrequencyData();
		analyze();
	}

	public int[] getFrequencyData() {
		return frequencyData;
	}

}
