package test.lab4_task1;

import common.FigureSet;
import common.GeomFigure;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import common.GeomFigure;
import lab4_task1.Hastable;

public class Task1Test {
	private Hastable emptyHashTable = null;
	private Hastable nonEmptyHashTable = null;
	private int capacity = 3;
	GeomFigure fig47 = null;
	

	String[][] value = {{ "2", "4", "5", "8", "2", "0", "5", "5"}, 
						{"1", "3", "2", "6", "2", "0", "3", "3"},
						{"0", "0", "0", "0", "0", "0", "0", "0"},
						{"0", "5", "2", "5", "-2", "7", "6", "7"},
						{"0", "5", "2", "5", "-2", "7", "6", "7"},
						{"2", "4", "2", "8", "0", "2", "0", "9"},
						{"0", "0", "1", "1", "2", "2", "3", "3"}};

	@BeforeEach
	void init() {
		// create empty table Hastablof 3 capacity
		emptyHashTable = new Hastable(capacity);

		// create table of 11 capacity with 3 elements
		nonEmptyHashTable = new Hastable();
		for (int i = 0; i < 3; i++) {
			GeomFigure gf = new GeomFigure(value[i]);
			int hashValue = nonEmptyHashTable.hash(gf);
			nonEmptyHashTable.table[hashValue] = gf;
		}
		// add one figure
		fig47 = new GeomFigure(value[5]);
		nonEmptyHashTable.table[nonEmptyHashTable.hash(fig47)] = fig47;

	}

	@Test
	void emptyTableTest() {
		// test the properties of an empty table
		assertEquals(emptyHashTable.size(), 0);
		assertTrue(emptyHashTable.isEmpty());

		// remove from empty hashTable
		GeomFigure gf = new GeomFigure(value[3]);
		// emptyHashTable.print();
		assertFalse(emptyHashTable.remove(gf));
		assertEquals(emptyHashTable.size(), 0);

		// search in empty hashTable
		assertFalse(emptyHashTable.contains(gf));

	}

	@Test
	void addRemoveOneElementTest() {
		// create a figure
		GeomFigure gf = new GeomFigure(value[6]);
		
		Hastable tableTest = new Hastable();

		assertEquals(tableTest.size(), 0);
		
		// add one element
		tableTest.add(gf);
		// System.out.println(emptyHashTable.size() + "iii ");
		assertEquals(tableTest.size(), 1);
		assertTrue(tableTest.contains(gf));

		// remove one element
		assertTrue(tableTest.remove(gf));
		assertEquals(tableTest.size(), 0);
		assertFalse(tableTest.contains(gf));
	}

	@Test
	void addNullElementTest() {
		// can't add null object
		int size = nonEmptyHashTable.size();
		assertFalse(nonEmptyHashTable.add(null));
		assertEquals(size, nonEmptyHashTable.size());

	}

	@Test
	void removeNullElementTest() {
		// can't remove null element
		int size = nonEmptyHashTable.size();
		assertFalse(nonEmptyHashTable.remove(null));
		assertEquals(size, nonEmptyHashTable.size());
	}

	@Test
	public void addSomeNotUniqueElementstest() {
		GeomFigure[] figures = { new GeomFigure(value[1]), new GeomFigure(value[5]), 
					new GeomFigure(value[3]),  new GeomFigure(value[6]),
					new GeomFigure(value[0]), new GeomFigure(value[2])};
		
		Hastable hashTableTest = new Hastable(8);
		assertTrue(hashTableTest.add(figures[1]));
		assertTrue(hashTableTest.add(figures[2])); // colision
		assertTrue(hashTableTest.add(figures[0]));
		// pre: hash values should be not equals
		boolean pre = hashTableTest.hash(figures[0]) != hashTableTest.hash(figures[1]);
		pre = pre && hashTableTest.hash(figures[1]) != hashTableTest.hash(figures[2]);

		// execute test only if pre == true
		assert (pre);
		//assertTrue(emptyHashTable.add(figures[0]))
		assertTrue(hashTableTest.add(figures[3]));
		// System.out.println(hashTableTest.size());
		assertTrue(hashTableTest.add(figures[4]));
		assertFalse(hashTableTest.add(figures[5]));
		// System.out.println("-> " + hashTableTest.size());
//		Hastable emptyHashTableTest = new Hastable(3);
//		for (GeomFigure gf : figures) {
//			assertFalse(emptyHashTableTest.add(gf));
//			assertFalse(hashTableTest.contains(gf));
//			assertTrue(emptyHashTableTest.remove(gf));
//			assertFalse(hashTableTest.contains(gf));
//			assertTrue(emptyHashTableTest.add(gf));
//		}
		// System.out.println("sise should be 5" + size);
		assertEquals(5, hashTableTest.size());
	}

	@Test
	public void addEqualsElementTest() {
		// add figures that are equals
		Hastable testTable = new Hastable();
		GeomFigure gf = new GeomFigure(value[0]);
		assertFalse(testTable.contains(gf));

		assertTrue(testTable.add(gf));
		assertTrue(testTable.contains(gf));
		assertEquals(1, testTable.size());
	}

	@Test
	public void addEqualsHashValueElementsTest() {  // hard to represent 
		// add figures with equal hash values
		GeomFigure gf = new GeomFigure(value[6]);
		GeomFigure gf2 = new GeomFigure(value[0]);
		Hastable tableTest = new Hastable(3);
		tableTest.add(gf);
		assert(tableTest.hash(gf) == tableTest.hash(gf2));
		int size = tableTest.size();
		assertTrue(tableTest.contains(gf));
		assertFalse(tableTest.contains(gf2));
		assertFalse(tableTest.add(gf2));
		assertTrue(tableTest.remove(gf));
		assertTrue(tableTest.add(gf2));
	}

	@Test
	public void rehashTest() {
		Hastable tableTest = new Hastable(3, 0.4);
		// add 3 elements in a table of capacity 3
		assertTrue(tableTest.add(new GeomFigure(value[1])));
		assertFalse(tableTest.add(new GeomFigure(value[2]))); // slot hiding value[1] already
		assertTrue(tableTest.add(new GeomFigure(value[3])));
		assertEquals( 2, tableTest.size());

		// add more elements in a table of capacity 3 => it should be resized  // its not resised
		assertFalse(tableTest.add(new GeomFigure(value[4]))); // colision again
		assertTrue(tableTest.add(new GeomFigure(value[5]))); // colision
		assertTrue(tableTest.add(new GeomFigure(value[0])));
// 		emptyHashTable.print();
//		System.out.println(" OOOOOOOO " + emptyHashTable.size());
		assertEquals(2 + 2, tableTest.size());
	}

	@Test
	public void removeTest() {
		// remove element from HashTable
		int size = nonEmptyHashTable.size();
		assertTrue(nonEmptyHashTable.remove(fig47));
		assertFalse(nonEmptyHashTable.contains(fig47));
		assertEquals(size - 1, nonEmptyHashTable.size());
	}

	@Test
	public void removeEqualsHashValueElementsTest() {
		GeomFigure gf = new GeomFigure(value[2]);
		GeomFigure gf2 = new GeomFigure(value[6]);
		Hastable tableTest = new Hastable();
		// pre: both hash values should be equals
		boolean pre = tableTest.hash(gf) == tableTest.hash(gf2);

		// execute test only if pre == true
		assert (pre);

		// remove element from HashTable
		int size = tableTest.size();
		assertTrue(tableTest.add(gf));
		assertFalse(tableTest.add(gf2));
		assertFalse(tableTest.remove(gf2));
		assertTrue(tableTest.remove(gf));
		assertEquals(size, tableTest.size());
	}

	@Test
	public void containsTest() {
		// contains null
		Hastable tableTest = new Hastable();
		assertFalse(tableTest.contains(null));

		// get the same figure
		GeomFigure gf = new GeomFigure(value[0]);
		GeomFigure gf2 = new GeomFigure(value[0]);
		assert (gf != gf2);
		assert (gf.equals(gf2));
		tableTest.add(gf);
		assertTrue(tableTest.contains(gf));
		assertTrue(tableTest.contains(gf2));
	}

}
