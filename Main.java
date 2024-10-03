public class Main {

	public static void main(String[] args) {
		
		// Define column labels and example data
		String[] columnLabels = {"Name", "Salary", "ID", "POGI?"};
		String[] exampleArray = {"John", "Mike", "Carl", "1234567890", "Lamelo", "Revlon"}; 
		int[] exampleArray2 = {10, 200, 3000, 4000, 500, 100};
		int[] exampleArray3 = {11, 12, 13, 14, 15, 16};
		boolean[] exampleArray4 = {true, true, false, false, true, false};
		
		// Print the formatted table
		printAndFormatTable(columnLabels, exampleArray, exampleArray2, exampleArray3, exampleArray4);
	}

	// Function to print and format the table
	public static void printAndFormatTable(String[] columnLabels, String[] array1, int[] array2, int[] array3, boolean[] array4) {
		
		/* !!!! IMPORTANT !!!!! NOTES FOR FUTURE ME INCASE MAKALIMUTAN !!! IMPORTANT !!!
		 * 
		 * HOW TO REUSE :
		 * 		1 GAWA KA MUNA ARRAY FOR THE LABELS OR TITLES NG BAWAT COLUMN (names age id etc..)
		 * 		2 CREATE THE ACTUAL ARRAYS THAT CONTAINS THE ACTUAL ELEMENTS
		 * 		3 COPY THE FUNCTIONS - eto yung mga necessary funcs (prntandformattable, prntcolumnlbls, prntcentrdlbs, horiline, clobariteminfo, openingbar, findlong(overloaded array ito for handling diff data types array));
		 * 		4.PARAMS ng printAndFormatTable = add or decrease as needed
		 * 		5. adjust ung mga widths pag nag overflow design border (5 hours sumakit ulo mo dito wag mo kakalimutan)
		 * 		6. WAG MO ISTRESSIN SARILI MO SA **PRINTING** ACTIVITIES, WALA MAPAPALA SA PRINTING FORMAT IN REAL LIF WORK
		 * 		
		*
		*/
		
		int spacing = 10; // White spaces around bars
		int leftMargin = 2; // Left margin
		String font = "|"; // Border design
		
		// Determine column widths dynamically
		//ADJUST THE NUMBERS OF WIDTHS NG COLUMN PAG MAG OVERFLOW UNG TABLE BORDERS
		int longestNameLen = findLongestLength(array1);
		int salaryColumnWidth = findLongestLength(array2) + 2;
		int idColumnWidth = findLongestLength(array3);
		int pogiColumnWidth = 5;
		
		// Print the column labels
		printColumnLabels("-", spacing, leftMargin, columnLabels, longestNameLen, salaryColumnWidth, idColumnWidth, pogiColumnWidth);
		
		// Print each row
		for (int i = 0; i < array1.length; i++) {
			printOpeningBar(leftMargin, spacing, font);

			printClosingBarWithItemInfo(String.valueOf(array3[i]), idColumnWidth, spacing, font); // Employee ID column
			printClosingBarWithItemInfo(array1[i], longestNameLen, spacing, font);  // Name column
			printClosingBarWithItemInfo(String.valueOf(array2[i]), salaryColumnWidth, spacing, font); // Salary column
			printClosingBarWithItemInfo(String.valueOf(array4[i]), pogiColumnWidth, spacing, font); // Salary column
			System.out.println();
		}
		int numOfColumns = columnLabels.length;
		int tableLen = longestNameLen + salaryColumnWidth + idColumnWidth + pogiColumnWidth + (spacing * numOfColumns * 2) + numOfColumns + 1;

		printHorizontalLine("-", leftMargin, spacing, tableLen);

	}

	// Function to print column labels
	private static void printColumnLabels(String font, int spacing, int leftMargin, String[] columnLabels, int longestNameLen, int salaryColumnWidth, int idColumnWidth, int pogiColumnWidth) {
		int numOfColumns = columnLabels.length;
		int tableLen = longestNameLen + salaryColumnWidth + idColumnWidth + pogiColumnWidth + (spacing * numOfColumns * 2) + numOfColumns + 1;
		
		printHorizontalLine("-", leftMargin, spacing, tableLen);
		printOpeningBar(leftMargin, spacing, "|");
		
		// Print each column label centered (MANUALLY ITO!!!!!!!!!);
		// IF EVER LUMAGPAS OR OVERFLOW UNG BORDERS, DAHIL HINDI TUGMA YUNG LENGTH NG COL NAME K?!;
		printCenteredLabel(columnLabels[2], idColumnWidth, spacing, "|");
		printCenteredLabel(columnLabels[0], longestNameLen, spacing, "|");
		printCenteredLabel(columnLabels[1], salaryColumnWidth, spacing, "|");
		printCenteredLabel(columnLabels[3], pogiColumnWidth, spacing, "|");

		System.out.println();
		
		printHorizontalLine("-", leftMargin, spacing, tableLen);
	}

	// Function to print centered column label
	private static void printCenteredLabel(String label, int columnWidth, int spacing, String font) {
		int labelLen = label.length();
		int padding = (columnWidth - labelLen) / 2;
		
		// Print left padding, label, right padding, and border
		for (int i = 0; i < padding; i++) System.out.print(" ");
		System.out.print(label);
		for (int i = 0; i < (columnWidth - labelLen - padding); i++) System.out.print(" ");
		System.out.print(" ".repeat(spacing) + font + " ".repeat(spacing));
	}

	// Function to print horizontal line
	private static void printHorizontalLine(String font, int leftMargin, int spacing, int tableLen) {
		System.out.print("\t".repeat(leftMargin));
		System.out.print(" ".repeat(spacing));
		System.out.println("+".repeat(1) + font.repeat(tableLen - 2) + "+".repeat(1));
	}

	// Function to print each row item with correct spacing
	private static void printClosingBarWithItemInfo(String item, int columnWidth, int spacing, String font) {
		int itemLen = item.length();
		int padding = columnWidth - itemLen;
		System.out.print(" ".repeat(padding) + item + " ".repeat(spacing) + font + " ".repeat(spacing));
	}

	// Function to print opening bar with margin and spacing
	private static void printOpeningBar(int leftMargin, int spacing, String font) {
		System.out.print("\t".repeat(leftMargin));
		System.out.print(" ".repeat(spacing) + font + " ".repeat(spacing));
	}

	// Helper function to find the longest string length in a String array
	private static int findLongestLength(String[] array) {
		int maxLen = 0;
		for (String item : array) {
			if (item.length() > maxLen) maxLen = item.length();
		}
		return maxLen;
	}

	// Helper function to find the longest string length in an int array
	private static int findLongestLength(int[] array) {
		int maxLen = 0;
		for (int item : array) {
			int len = String.valueOf(item).length();
			if (len > maxLen) maxLen = len;
		}
		return maxLen;
	}
}
