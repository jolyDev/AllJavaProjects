package lab1;

/**
 * KPI- FPM - PZKS Course: Algorithms and Data Structures (2) Laboratory work 1
 * 
 * @author Olena Khomenko
 * 
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
	
	/**
	 * second name of this student
	 */
	String secondName;
	
	/**
	 * name of this student
	 */
	String name;

	/**
	 * number of student ticket (should have 8-symbols length)
	 */
	int ticketNumber;
	
	/**
	 * group to which the student belongs
	 */
	String group;
	
	/**
	 * Sets the second name of a student
	 * 
	 * @param name
	 *            string specified the name
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	/**
	 * Sets the name of a student
	 * 
	 * @param name
	 *            string specified the name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Sets the number of student ticket (should have 8-symbols length)
	 * 
	 * @param course
	 *            integer specified the number of student's course
	 */
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	
	/**
	 * Sets the group to which the student belongs
	 * 
	 * @param name
	 *            string specified the name
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * Outputs formatted values of fields in standard output
	 * 
	 */
	public void print() {
		System.out.println(String.format("%-10s|   %-10s|   %-8d|   %-10s|", secondName, name, ticketNumber, group));
	}

	/**
	 * Determines if the specified string is a student's name. This string is
	 * valid if it contains all alphabet letters and begins from uppercase
	 * letter
	 * 
	 * @param name or second name
	 *            the string to be tested
	 * @return true if the specified string is a name, false otherwise.
	 */
	public boolean isValidName(String name) {
		if (name == null || name.length() == 0)
			return false;
		if (!Character.isUpperCase(name.charAt(0))) {
			return false;
		}
		for (int i = 1; i < name.length(); i++) {
			if (!Character.isAlphabetic(name.charAt(i)) && name.charAt(i) != ' ')
				return false;
		}
		return true;

	}

	/**
	 * Determines if the specified string is number of course. This string is
	 * valid if it contains only one digit character: '1', '2', '3', '4', '5' or
	 * '6'
	 * 
	 * @param courseStr
	 *            the string to be tested
	 * @return true if the specified string is a number of course, false
	 *         otherwise.
	 */
	public boolean isValidTicketNumber(String numberStr) {
		if (numberStr == null || numberStr.length() != 8)
			return false;

		for (int i = 0; i < 8; i++) {
			char ch = numberStr.charAt(i);
			if (ch < '0' || ch > '9') {
				return false;
			}
		}
		return true;
	}
	/*
	@param
	@return
	*/
	public boolean isGroup(String group) {
		if (group == null || group.length() != 5)
			return false;
		
		for (int i = 0; i < 2; i++) {
			if (!Character.isUpperCase(group.charAt(i)) 
					|| !Character.isAlphabetic(group.charAt(i))) {
				return false;
			}
		}
		if (group.charAt(2) != '-') {
			return false;
		}
		for (int i = 3; i < 5; i++) {
			if (!Character.isDigit(group.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
