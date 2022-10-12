
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection; 
import java.util.NoSuchElementException;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestLists {

	public static Collection<Object[]> LISTNUMS =
			Arrays.asList(new Object[][] { {"Linked"}, {"Array"} });
	private String listType;

	public TestLists(String listType) {
		super();
		this.listType = listType;
	}

	@Parameterized.Parameters(name = "{0}List")
	public static Collection<Object[]> bags() {
		return LISTNUMS;
	}

	private <E> MyList<E> makeList(E[] contents) {
		switch (this.listType) {
		case "Linked":
			return new LinkedGL<E>(contents);
		case "Array":
			return new ArrayGL<E>(contents);
		}
		return null;
	}

  // Don't change code above this line, it ensures the autograder works as
  // expected


  // This is a sample test; you can keep it, change it, or remove it as you like.
  // Note that it uses the method `assertArrayEquals`, which you should use to
  // test equality of arrays in this PA.
	@Test
	public void testSimpleToArray() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {1, 2, 3};
		MyList<Integer> int_s = makeList(int_input);
		//assertEquals(false, int_s.isEmpty());
		assertArrayEquals(int_input, int_s.toArray());
		
		// Using the generic list to create a String list
		String[] string_input = {"a", "b", "c"};
		MyList<String> string_s = makeList(string_input);
		assertArrayEquals(string_input, string_s.toArray());
	}
	
	
	
	@Test
	public void testMakeEmpty() {
		Integer[] emptyArray = {};
		MyList<Integer> array = makeList(emptyArray);
		Integer[] filledArray = {1,2,3,4,5};
		assertEquals(true, array.isEmpty());
		array = makeList(filledArray);
		assertEquals(false,array.isEmpty());
	}
	
	
	
	@Test
	public void testTransformer() {
		String[] filled = {"A", "a", "b", "c","d"};
		String[] expected= {"A", "A" , "B" , "C" , "D"};
		MyList<String> array = makeList(filled);
		MyTransformer mt = new UpperCaseTransformer();
		array.transformAll(mt);
		assertArrayEquals(expected, array.toArray());
		
		Integer[] filled2 = {1,2,null,8000,6,9,7};
		Integer[] expected2 = {1,0,null,0,0,1,1};
		MyList<Integer> array2 = makeList(filled2);
		mt = new ModByTwoTransformer();
		array2.transformAll(mt);

		assertArrayEquals(expected2, array2.toArray());
		
	}
	
	@Test
	public void testChooser() {
	    MyChooser mc = new EvenNumberChooser();
		Integer[] filled = {1,2,4,null,0,1,6,8};
		Integer[] expected = {2,4,0,6,8};
		MyList<Integer> array2 = makeList(filled);
		
		array2.chooseAll(mc);

		assertArrayEquals(expected, array2.toArray());
		
		
	}
	
	@Test
	public void testChooser2() {
	    String[] filled = {"12345", "123456", "123", "1234567",""};
        String[] expected= {"123456"  , "1234567" };
        MyList<String> array = makeList(filled);
        MyChooser mc = new LongWordChooser();
        array.chooseAll(mc);
        assertArrayEquals(expected, array.toArray());
	}
	
	
	@Test
	public void sillyTests() {
	    MyChooser mc = new EvenNumberChooser();
        Integer[] filled = {1};
        Integer[] expected = {};
        MyList<Integer> array2 = makeList(filled);
        array2.chooseAll(mc);
        assertArrayEquals(expected, array2.toArray());
	    
	    
	    
	    
	}
	
	
	

}