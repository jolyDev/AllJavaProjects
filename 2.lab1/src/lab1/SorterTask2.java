package lab1;

import java.io.*;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
public class SorterTask2 {
	private static String fileName = "students.csv";
	//private static String fileName = "test1.csv";
	//private static String fileName = "test2.csv";
	//private static String fileName = "test3.csv";
	//private static String fileName = "test4.csv";

	// path to the current directory that contains directory "data"
	private static String currenDir = System.getProperty("user.dir")
			+ File.separatorChar + "data";

    public static HashSet<String> countryHashSet = new HashSet<>();

	public static void main(String[] args) {
		CSVReader reader = null;
		String[][] students = null; //new String[][];
		String path = Paths.get(currenDir, fileName).toString();

		try {

			reader = new CSVReader(new FileReader(path));
			System.out.println("File \"" + path + " \"  have been reading ");

			// 1) read all lines from a file
			List<String[]> list = reader.readAll();

			if (!list.isEmpty()) {
				int numLines = list.size();
				System.out.println("File contains " + numLines + "  lines");

				// 2) create the array of students and check data from the file
				students = createArrayOfStudents(list);

			} else {
				System.out.println("Error: file  " + path + "   is empty");
				reader.close();
				return;
			}

			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error: file  " + path + "   not found");
		} catch (IOException e) {
			System.err.println("Error:read file " + path + "   error");
		} catch (SecurityException e) {
			System.err.println(e.getMessage());
		}

		// 3) Output the array in a table view
		System.out.println("\nBefore sorting\n");
		printStudents(students);

		// 5) Output sorted array in a table view
		System.out.println("\nAfter sorting\n");
		printStudents(sort(students));
	}
	
	/**
	 * Checks validity data in the specified list of string array, creates array
	 * and fill the array by object of class Student using only valid data
	 * 
	 * @param list
	 *            the list of array of strings
	 * @return array of students or empty array if all items in the list are not
	 *         valid
	 */
	
	public static String[][] createArrayOfStudents(List<String[]> list) {
		// number of students with valid data
		int groupNum = unicGroupCount(list);
		String[][] students = new String[groupNum][list.size() - groupNum];
		
		// this module write data like this
		/*	 	  i = 0                       i = 1
		 * j = 0  KP-73						  KP-72
		 * j = 1  Bulayevsky,Igor,029383478   Vernygora,Artem,09876543
		 * j = 2  Trush,Artem,09827645		  Honcharuk,Bogdan,87651234
		 * j = 3  null						  null
		 * j = 4  null						  null
		 * Each group name corresponds to i
		 */
		
		// working at each lines by one
		for (Iterator<String[]> it = list.iterator(); it.hasNext();) {
			String[] line = it.next();
			if (line.length == 4) {
				Iterator<String> iterator = countryHashSet.iterator();
			    // creating new groups 
				for (int i = 0; i < countryHashSet.size() ; i++) {
				   	String str = iterator.next();
				   	if (str.equals(line[3]) || str == null) {
				   		students[i][0] = line[3];
				   		// add sudent info
				   		for (int j = 0; j < list.size() - countryHashSet.size(); j++ ) {
				   			if (students[i][j] == null && toRecord(line)) {
				   				students[i][j] = line[0] + "," + line[1] + "," + line[2];
				   				j = list.size();
				   			}	
				   		}
				   	}
				}
			}
		}
		return students;
	}
	
	public static int unicGroupCount( List<String[]> list) {
		if (list == null)
			return 0;
		for (Iterator<String[]> it = list.iterator(); it.hasNext();) {
			String[] line = it.next();
			if (line.length == 4)
				countryHashSet.add(line[3]);
		}
		return countryHashSet.size();	
	}


	public static void printStudents(String[][] studs) {
		if (studs != null && studs.length != 0) {
			System.out.println("| == | ===== ===== ===== ===== | ===== ===== ===== | ======== | ===== |");
			System.out.println("| №  |       Second name       |     First name    |   code   | group |");
			System.out.println("| == | ===== ===== ===== ===== | ===== ===== ===== | ======== | ===== |");
			int counter = 0;
			for (int i = 0; i < studs.length; i++) {
				for (int j = 1; j < studs[i].length && studs[i][j] != null; j++) {
					makeGaps(String.valueOf(counter), 3, 0);
					makeGaps(studs[i][j], 24, 0);
					makeGaps(studs[i][j], 18, 1);
					makeGaps(studs[i][j], 9, 2);
					makeGaps(studs[i][0], 5, 0);
					System.out.print(" |\n");
					counter++;
				}
			}
			System.out.println("|_____________________________________________________________________|");
		} 
	}
	
	public static int makeGaps(String str, int lineLen, int countToReach) {
		if(str == null)
			return 0;
		int i = 0;
		int count = 0;
		System.out.print("| ");
		while (count != countToReach && i < str.length()) {
			if (str.charAt(i) == ',') 
				count++;
			i++;
		}
		int prev = i;
		for (;i < lineLen + prev; i++ ) {
			if (i < str.length() && str.charAt(i) != ',')
				System.out.print(str.charAt(i));
			else {
				while (i < lineLen + prev) {
					System.out.print(" ");
					i++;
				}
			}
		}
		return i;
	}

	public static String[][] sort(String[][] s) {
		// sort by group
		for (int i = 1; i < s.length; i++) {
			String[] toDetermine = s[i];
			int j = i - 1;
			while (j >= 0 && MyStrCompare(s[j][0], toDetermine[0]) == 1) {
				s[j + 1] = s[j];
				j--;
			}
			s[j + 1] = toDetermine;
		}
		// sort by name at each group
		for (int i = 0; i < s.length; i++) {
			// sorting inside one group
			for (int j = 1; j < s[i].length; j++) {
				String toDetermineName = s[i][j];
				int k = j - 1;
				while ( k >= 1 && MyStrCompare(s[i][k], toDetermineName) == 1) {
					s[i][k + 1] = s[i][k];
					k--;
				}
				s[i][k + 1] = toDetermineName;
			}
		}//i
		//j
		return s;
	}
	
	public static int MyStrCompare(String s1, String s2) {
		if (s1 == null || s2 == null)
			return 0;
		if (s1.equals(s2)) {
			return 0;
		}
		int i = 0;
		for (; i < s1.length() && i < s2.length()
				&& s1.charAt(i) == s2.charAt(i); i++);
		if (i == s1.length()) {
			return 1;
		}
		if (i == s2.length()) {
			return -1;
		}
		if (s1.charAt(i) > s2.charAt(i)) {
			return 1;
		}
		return -1;
	}
	
	public static boolean toRecord(String[] line) {
		if (line == null)
			return false;
		if (isValidName(line) && isValidTicketNumber(line[2]) &&  isGroup(line[3]))
			return true;
		return false;
	}
	
	public static boolean isValidName(String[] name) {
		if (name == null || name.length < 3)
			return false;
		for (int i = 0; i < 2; i++) {
			if (name[i].length() == 0)
				return false;
			
			if (!Character.isUpperCase(name[i].charAt(0))) {
				return false;
			}
			for (int j = 1; j < name[i].length(); j++) {
				if (!Character.isAlphabetic(name[i].charAt(j)) && name[i].charAt(j) != ' ')
					return false;
			}
		}
		return true;
	}

	public static boolean isValidTicketNumber(String numberStr) {
		if (numberStr == null || numberStr.length() != 8) {
			return false;
		}
		for (int i = 0; i < 8; i++) {
			char ch = numberStr.charAt(i);
			if (ch < '0' || ch > '9') {
				return false;
			}
		}
		return true;
	}

	public static boolean isGroup(String group) {
		if (group == null || group.length() != 5) {
			return false;
		}
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
