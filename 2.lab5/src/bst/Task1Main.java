package bst;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

//
//Krasnogon,1,13243557,78,Ukraine,
//Bulaevskiy,2,89241783,99,Tatarstan,
//Volk,1,16643557,78,Ukraine,
//Trush,7,62019837,87,Belorusia,
//Gorba,4,76726363,89,Kasahstan,
//Anisich,3,12093809,94,America,
//Honcharuk,4,33848102,71,Poland,
//Zgurovskyi,2,12938073,65,Ukraine,
//Lee,2,10293847,61,Nort Korea,
//

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Task1Main {
	// name of file which stores data about students
	private static String fileName = "students.csv";

	// path to the current directory that contains directory "data"
	private static String currenDir = System.getProperty("user.dir")
			+ File.separatorChar + "data";

	public static void main(String[] args) {
		// create object of class StudentReader and invoke method read
		StudentReader str = new StudentReader("students.txt", 
				"C:\\Users\\MindTitan\\eclipse-workspace\\2.lab5\\src\\data");

		List<Student> stArray = str.read();
		
		StudentDictionary<Student> dict = new BSTree<>();

		System.out.println("{\n\n}");
		
		for (Iterator<Student> it = stArray.iterator(); it.hasNext();) {
			// System.out.println(it.next() + " p");
			Student st = it.next();
			System.out.println("{|} " + st.toString() + " {|}");
			
			dict.put(st.getID(), st);
		}
		dict.printDictionary();
		
//		assertTrue(null == dict.put(60000000, stArray.get(0))); // krasnogon (null will return)

		assertTrue(dict.containsKey(30000000));	// honcharuk
		assertTrue(dict.containsKey(00000001)); // Trush
		assertFalse(dict.containsKey(45624262));
		
		System.out.println("\n" + dict.get(9876543));	// Bilko	
		System.out.println(dict.get(67800000)); // buhta
		

		// dict.remove(30000000);
		// lee Honcharuck Trush Volk
//		int ar[] = {80000000};
//		
//		for (int i = 0; i < ar.length; i++) {
//			dict.remove(ar[i]);
//			assertFalse(dict.containsKey(ar[i]));
//		}
		// "Name" 
//		"gradYear" 
//		"ID" 
//		"averScore" 
//		"Nation"
		// "gradYear", "1", "nation", "Ukraine", "averScore", "80"
		// Krasnogon,1,60000000,69,Ukraine,
		// Honcharuk,1,30000000,71,Ukraine,
		// Zvirko,1,65200076,74,Ukraine,
		String[] str2 = {"Nation", "Ukraine" ,"averScore", "70", "gradYear", "1" };
		dict.remove(str2);
		dict.printDictionary();
	}

}
