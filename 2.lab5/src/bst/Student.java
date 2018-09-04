package bst;

/**
 * KPI- FPM - PZKS Course: Algorithms and Data Structures (2) Laboratory work 5
 * 
 * @author Olena Khomenko <br>
 *         Represents information about student: its name and number of course <br>
 *         This class is a sample how to define class, fields and methods
 * 
 *         Rewrite this class and its methods <br>
 *         Choose information to be saved in a class from lab manuals (table 1,
 *         col.2).<br>
 * 
 *         Write methods setXXX to set specified value to the field XXX. <br>
 * 
 *         Write method print to output information about student (values of the
 *         fields) in formatted string. <br>
 * 
 *         Write static methods boolean isValidXXX to check whether specified
 *         string could set (or convert and set) to the field XXX
 *
 */

public class Student {
	
	private String name;
	private int gradYear;
	private int ID;
	private Double averScore;
	private String nation;

	// TODO
	// add fields according to your variant
	
	public Student() {}
	
	public Student(String[] line) {
			if (isValidData(line)) {
//				for (int i = 0; i < line.length; i++) 
//					line[i] = skipspaces(line[i]);
				this.name = line[0];
				this.gradYear = Integer.valueOf(line[1]);
				this.ID = Integer.valueOf(line[2]);
				this.averScore = Double.valueOf(line[3]);
				this.nation = line[4];
			}
	}

	// names slots
	public String getName() { return this.name; }
	
	public String getSurName() { return this.name; }
	
	// key slots
	public int getID() { return this.ID; }
	
	public int getkey() { return this.ID; }
	
	public int getCardNumber() { return this.ID; }
	
	// grad. year score
	public int getCourse() { return this.gradYear; }
	
	public int getGradYear() { return this.gradYear; }
	
	// score year
	public Double getScore() { return this.averScore; }
	
	public Double getAverScore() { return this.averScore; }
	
	// other
	public String getNation() { return this.nation; }
	
	@Override
	public String toString() {
		String to_ret = new String();
		to_ret = this.name + " ";
		to_ret = to_ret + " " + Integer.toString(this.gradYear);
		to_ret = to_ret + " " + Integer.toString(this.ID);
		to_ret = to_ret + " " + Double.toString(this.averScore);
		to_ret = to_ret + " " + this.nation;
		return to_ret;
		
		//this.name + "\n" + "%-1d" + "\n" + "%-10d" + "\n" + "%-lf" + this.nation + "\n",
		//ID, this.averScore
		// return String.format("poap");
	}

	/**
	 * Determines if the specified string is valid card number: contains only
	 * one digit character
	 * 
	 * @param number
	 *            the string to be tested
	 * @return true if the specified string is a valid card number, false
	 *         otherwise.
	 */

	public static boolean isValidData(String[] lines) {
		if (lines.length == 6)
			return isValidName(lines[0]) && isValidGradYear(lines[1]) && isValidID(lines[2])
					&& isValidAverScore(lines[3]) && isValidNation(lines[4]);
		return false;
	}
	
	public static boolean isValidName(String name) {
		if (name == null || name.length() == 0)
			return false;
		char[] sym = name.toCharArray();
		if (Character.isUpperCase(name.charAt(0))) {
			for (int i = 0; i < sym.length; i++) {
				if (!Character.isAlphabetic(name.charAt(i)) && name.charAt(i) != ' ')
					return false;
			}
			return true;
		}
		return false;
	}
	
	public static boolean isValidGradYear(String number) {
		if (!isNumber(number))
			return false;
		return Integer.valueOf(number) >= 0 && Integer.valueOf(number) < 25;
	}
	
	public static boolean isValidAverScore(String number) {
		if (!isNumber(number))
			return false;
		return Integer.valueOf(number) <= 100 && Integer.valueOf(number) >= 0;
	}
	
	public static boolean isValidNation(String nation) {
		// nation = skipspaces(nation);
		if (Character.isUpperCase(nation.charAt(0)))
			return true;
		return false;
	}
	
	public static boolean isValidID(String number) {
		if (!isNumber(number))
			return false;
		if (number == null || number.length() != 8)
			return false;
		char[] chArray = number.toCharArray();
		for (char ch : chArray)
			if (!Character.isDigit(ch))
				return false;
		return true;
	}
	
	private static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            return false;
        }
        return true;
	}
	
//	private static String skipspaces(String str) {
//		if (str == null)
//			return null;
//		String clean = "";
//		for (int i = 0; i < str.length(); i++)
//			if (str.charAt(i) != ' ')
//				clean = str.charAt(i) + clean;
//		return clean;
//	}

}
