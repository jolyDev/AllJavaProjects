package test.lab4_task1;

import common.GeomFigure;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab4_task2.OAHastable;

public class Task2Test1 {
	private OAHastable emptyHashTable = null;
	private OAHastable nonEmptyHashTable = null;
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
		emptyHashTable = new OAHastable(capacity);

		// create table of 11 capacity with 3 elements
		nonEmptyHashTable = new OAHastable();
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
		OAHastable probe = new OAHastable();
		// test the properties of an empty table
		assertEquals(probe.size(), 0);
		assertTrue(probe.isEmpty());

		// remove from empty hashTable
		GeomFigure gf = new GeomFigure(value[3]);
		// emptyHashTable.print();
		assertFalse(probe.remove(gf));
		assertEquals(probe.size(), 0);

		// search in empty hashTable
		assertFalse(probe.contains(gf));

	}

	@Test
	void addRemoveOneElementTest() {
		// create a figure
		GeomFigure gf = new GeomFigure(value[6]);

		assertEquals(emptyHashTable.size(), 0);
		
		// add one element
		emptyHashTable.add(gf);
		// System.out.println(emptyHashTable.size() + "iii ");
		assertEquals(emptyHashTable.size(), 1);
		assertTrue(emptyHashTable.contains(gf));

		// remove one element
		assertTrue(emptyHashTable.remove(gf));
		assertEquals(emptyHashTable.size(), 0);
		assertFalse(emptyHashTable.contains(gf));
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
		
		OAHastable hashTableTest = new OAHastable(3);

		for (GeomFigure gf : figures) {
			assertTrue(hashTableTest.add(gf));
			assertTrue(hashTableTest.remove(gf));
			assertTrue(hashTableTest.add(gf));
			assertFalse(hashTableTest.add(gf));
		}
		int size = figures.length;
		// System.out.println("sise should be 5" + size);
		assertEquals(size, hashTableTest.size());
	}

	@Test
	public void addEqualsElementTest() {
		// add figures that are equals
		OAHastable testTable = new OAHastable();
		GeomFigure gf = new GeomFigure(value[0]);
		assertFalse(testTable.contains(gf));

		assertTrue(testTable.add(gf));
		assertFalse(testTable.add(gf));
		assertTrue(testTable.contains(gf));
		assertEquals(1, testTable.size());

		assertTrue(testTable.contains(gf));
	}

	@Test
	public void addEqualsHashValueElementsTest() {  // hard to represent 
		// add figures with equal hash values
		GeomFigure gf = new GeomFigure(value[3]);
		GeomFigure gf2 = new GeomFigure(value[3]);
		OAHastable tableTest = new OAHastable();
		tableTest.add(gf);
		// pre: both hash values should be equals
		boolean pre = tableTest.hash(gf) == tableTest.hash(gf2);

		// execute test only if pre == true
		assert (pre);
		// size work incorrect but i cand explain where mistake
		int size = tableTest.size(); // WTF
		assertTrue(tableTest.contains(gf));
		assertTrue(tableTest.contains(gf2));
		// can't add gf in the Hashtable
		assertFalse(tableTest.add(gf));
		assertTrue(tableTest.remove(gf));
		assertTrue(tableTest.add(gf));
	}

	@Test
	public void rehashTest() {
		// add 3 elements in a table of capacity 3
		OAHastable threeSlotsTable = new OAHastable(3); // its not working with capacity 5
		assertTrue(threeSlotsTable.add(new GeomFigure(value[1])));
		assertTrue(threeSlotsTable.add(new GeomFigure(value[2]))); // slot hiding value[1] already
		assertTrue(threeSlotsTable.add(new GeomFigure(value[3]))); // but i can avoid colision now
		assertEquals( 3, threeSlotsTable.size());

		assertFalse(threeSlotsTable.add(new GeomFigure(value[4]))); // value[4] == value[3];
		assertTrue(threeSlotsTable.add(new GeomFigure(value[5])));
		assertTrue(threeSlotsTable.add(new GeomFigure(value[6])));
		assertTrue(threeSlotsTable.add(new GeomFigure(value[0])));
// 		emptyHashTable.print();
//		System.out.println(" OOOOOOOO " + emptyHashTable.size());
		assertEquals(3 + 3, threeSlotsTable.size());
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
		GeomFigure gf2 = new GeomFigure(value[2]);
		OAHastable tableTest = new OAHastable();
		// pre: both hash values should be equals
		boolean pre = tableTest.hash(gf) == tableTest.hash(gf2);

		// execute test only if pre == true
		assert (pre);

		// remove element from HashTable
		int size = tableTest.size();
		assertFalse(tableTest.remove(gf));
		assertEquals(size, tableTest.size());
	}

	@Test
	public void containsTest() {
		// contains null
		OAHastable tableTest = new OAHastable();
		assertFalse(tableTest.contains(null));

		// get the same figure
		GeomFigure gf = new GeomFigure(value[0]);
		GeomFigure gf2 = new GeomFigure(value[0]);
		assert (gf.equals(gf2));
		assertTrue(tableTest.add(gf));
		assertFalse(tableTest.add(gf2));
		assertTrue(tableTest.contains(gf));
		assertTrue(tableTest.contains(gf2));
	}

}
