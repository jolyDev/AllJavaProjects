package bst;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;

/**
 * KPI- FPM - PZKS Course: Algorithms and Data Structures (2) Laboratory work 5
 * 
 * @author Olena Khomenko <br>
 *
 */
public class StudentReader {
	private String path;
	private CSVReader reader = null;

	public StudentReader(String fileName, String currenDir) {
		path = Paths.get(currenDir, fileName).toString();

	}

	public StudentReader(String fileName) {

		String currenDir = System.getProperty("user.dir") + File.separatorChar
				+ "data";
		path = Paths.get(currenDir, fileName).toString();

	}

	/**
	 * Reads the content of a csv file, checks data from the file and returns
	 * the array of students. If the file is empty returns empty list. Object of
	 * class Student is created by invoking method createStudent
	 * 
	 * @return list of Students
	 */
	public List<Student> read() {
		ArrayList<Optional<Student>> students = new ArrayList<>();
		ArrayList<Student> emptyList = new ArrayList<>();

		// read all lines from a file
		List<String[]> lines = readFile();

		// return empty list, if the list of lines is empty
		if (lines.isEmpty())
			return emptyList;

		// otherwise, analyze line by line
		for (Iterator<String[]> it = lines.iterator(); it.hasNext();) {
			String[] curr = it.next();
			if (!Student.isValidData(curr)) {
				System.out.println(curr[0] + " unadded");
				continue ;
			} else System.out.println(curr[0] + " added");
			
			// add student to the list
			students.add(createStudent(curr));
		}

		// return list of Students
		if (students.isEmpty()) {
			return emptyList;
		} else {
			return getStudents(students);
		}
	}

	private List<Student> getStudents(ArrayList<Optional<Student>> students) {
		return students.stream().filter(s -> s.isPresent() == true)
				.map(Optional::get).collect(Collectors.toList());  // need explaination
	}

	/**
	 * Checks correctness the information about student in this line. If checks
	 * for all elements in this line are successful, create and return the
	 * object of Student.
	 * 
	 * @param line
	 *            array of Strings represented data about student. If line is
	 *            null, return empty Student
	 * @return object of Student if all data about student are correct, empty
	 *         Student - otherwise
	 */
	private Optional<Student> createStudent(String[] line) {

		// return empty object of Student if number of string in a line don't
		// equals
		// the number of Student's fields
		if (line.length != Student.class.getDeclaredFields().length) {
			System.err.println("Error: the line  \"" + Arrays.toString(line)
					+ "\" not completed");
			return Optional.empty();

		} else {
			if (!Student.isValidData(line))
				return Optional.empty();
			
			return Optional.of(new Student(line));
		}

	}

	private List<String[]> readFile() {
		List<String[]> list = new ArrayList<>();
		try {
			reader = new CSVReader(new FileReader(path));
			list = reader.readAll();
		} catch (FileNotFoundException e) {
			System.out.println("Error: file  " + path + "   not found");
			return Collections.emptyList();
		} catch (IOException | SecurityException e) {
			System.err.println("Error:read file " + path + "   error");
			return Collections.emptyList();
		}

		try {
			reader.close();
		} catch (IOException e) {
			System.err.println("Error:close file " + path + "   error");
		}
		return list;
	}
}
