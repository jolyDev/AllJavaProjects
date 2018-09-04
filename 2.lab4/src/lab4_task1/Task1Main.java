package lab4_task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import common.FigureSet;
import common.GeomFigure;

public class Task1Main {
	// name of file which stores data about geometric figures
	private static String fileName = "figures.csv";

	// path to the current directory that contains directory "data"
	private static String currenDir = System.getProperty("user.dir")
			+ File.separatorChar + "data";

	public static void main(String[] args) {
		// 1) read all lines from a file

		List<String[]> lines = readcsvFile(fileName, currenDir);

		if (lines != null /*&& !lines.isEmpty()*/) {
			int numLines = lines.size();
			System.out.println("File contains " + numLines + "  lines");

			// 2) create the array of geometric figures and check data from the
			// file
			GeomFigure[] farray = createArrayOfFigures(lines);

			// 3) Create a set of figures
			FigureSet figures = new Hastable();
			for (GeomFigure f : farray) {
				System.out.print(" * ");
				figures.add(f);
			}
			System.out.println("");

			// 4) Print a set of figures
			figures.print();
//			for (GeomFigure f : farray) // prikolyas
//				f.printTrap();

		} else {
			System.out.println("Error: file  " + fileName + "   is empty");
			System.exit(0);
		}

	}

	static List<String[]> readcsvFile(String fileName, String dirName) {
		CSVReader reader = null;
		GeomFigure[] figures = null;
		String path = Paths.get(currenDir, fileName).toString();
		List<String[]> list = null;

		// read data from a file
		try {

			reader = new CSVReader(new FileReader(path));
			System.out.println("File \"" + path + " \"  have been reading ");

			// read all lines from a file
			list = reader.readAll();
			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error: file  " + path + "   not found");
		} catch (IOException e) {
			System.err.println("Error:read file " + path + "   error");
		} catch (SecurityException e) {
			System.err.println(e.getMessage());
		}

		return list;
	}

	static GeomFigure[] createArrayOfFigures(List<String[]> list) {
		// TODO
		int num = 0;

		// create empty array of geometric figures with the length = list.size()
		GeomFigure[] farray = new GeomFigure[list.size()];

		// start reading and analyzing each line from this list
		for (Iterator<String[]> it = list.iterator(); it.hasNext();) {

			// line contains data about one geometric figures
			String[] line = it.next();
			if(isTrap(line))
					farray[num++] = new GeomFigure(line);
		}
		// check if all data in a file are valid
		if (num != list.size()) {

			// if not, create new array with smaller length
			farray = copyOf(farray, num);
		}

		return farray;
	}
	
	static boolean isTrap(String[] line) {         
		GeomFigure gf = new GeomFigure(line);
		if (gf == null || gf.p == null)
			return false;
		int vx1 = gf.p[1].x - gf.p[0].x;
		int vy1 = gf.p[1].y - gf.p[0].y;
		int vx2 = gf.p[3].x - gf.p[2].x;
		int vy2 = gf.p[3].y - gf.p[2].y;
		if (gf.area == 0) {
			System.out.println("-");
			return false;
		}
		if ( vx2 != 0 &&  vy2!= 0) {
			int n = vx1 / vx2;
			int n2 = vy1 / vy2;
			System.out.println("+/-");
			return Math.abs(n - n2) < 1 ? true : false;
		}
		else if (vx1 != 0 && vy1 != 0){
			int n = vx2 / vx1;
			int n2 = vy2 / vy1;
			System.out.println("+/-");
			return Math.abs(n - n2) < 1 ? true : false;
		} else if (vx1 == vx2 || vy2 == vy1) {
			if (vy2 == vy1)
				if (vx1 / vx2 - (int) (vx1 / vx2) == 0) {
					System.out.println("+");
					return true;
				} 
				if (vy1 / vy2 - (int) (vy1 / vy2) == 0) {
					System.out.println("+");
					return true;
				}
		}
		System.out.println("-");
		return false;
	}

	static GeomFigure[] copyOf(GeomFigure[] farray, int num) {
		GeomFigure[] to_ret = new GeomFigure[num];
		for (int i = 0; i < num; i++) {
			to_ret[i] = farray[i];
		}
		return to_ret;
	}

}
