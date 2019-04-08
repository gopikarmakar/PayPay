package com.coding.challenge.paypay;

import com.coding.challenge.paypay.App;

import java.util.ArrayList;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Test class with all unit test cases for rigorous testing
 */
public class AppTest extends TestCase {
	
	private App main;
	
    /**
     * Create the test case
     * @param testName name of the test case
     */
    public AppTest( String testName ) {
        super( testName ); 
        main = new App();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( AppTest.class );       
    }
    
    public void testQCreationFromGivenValues() {
    	
    	String[] input = {
				"One",
				"Two", 
				"Three",
				"Four",
				"Five"
		};
    	
    	ArrayList<String> list = new ArrayList<>();
		for(String s : input) {
			list.add(s);
		}
		
		String expectedOutput = "One" +
								"Two" +
								"Three" +
								"Four" +
								"Five";
		
		System.out.println("### Testing Queue Creation & Iteration From Given Values ###");        
        assertEquals(expectedOutput, App.testQCreationFromGivenValues(list));
	}
    
    public void testEnqueueNullValue() {
    	
    	String expectedOutput = "Value Can't Be Null";
    	System.out.println("### Testing Enqueue a Null Value ###");        
        assertEquals(expectedOutput, App.testEnqueueNullValue());
    }
    
    public void testEmptyQueue() {		
		
		String[] input = {
				"One",
				"Two", 
				"Three",
				"Four",
				"Five"				
		};
		
		String expectedOutput = "Queue Is Empty";
		
		System.out.println("### Testing Empty Queue Dequeue ###");              
        assertEquals(expectedOutput, App.testEmptyQueue(input));
	}
    
    public void testHead() {
    	
    	String[] input = {
				"One",
				"Two", 
				"Three",
				"Four",
				"Five",
				"Three"				
		};
    	
    	String expectedOutput = "Three";
    	
    	System.out.println("### Testing Head ###");
    	assertEquals(expectedOutput, App.testHead(input.length-1, input));
    }

    public void testAllEnqueDeque() {
        
    	String[] input = {
				"One",
				"Two", 
				"Three",
				"Four",
				"Five"				
		};
		
		String expectedOutput = "One" +
								"Two" +
								"Three" +
								"Four" +
								"Five";
		
		System.out.println("### Testing All Enque Deque ###"); 
        assertEquals(expectedOutput, App.testAllEnqueueDequeue(input));
    }   
	
	public void testRandomEnqueDequeue() {
		
		String[] input = {
				"One",
				"Two", 
				"Three",
				"Four",
				"Five"				
		};
		
		String expectedOutput = "One" +
								"Two" +
								"Three" +
								"Four" +
								"Five" +
								"One" +
								"Two";
		
		System.out.println("### Testing Random Enque Deque ###");               
        assertEquals(expectedOutput, App.testRandomEnqueDequeue(input));
    }
	
	public void testSize() {
		
		String[] input = {
				"One",
				"Two", 
				"Three",
				"Four",
				"Five"				
		};
		int d = 2;
		int expectedOutput = (input.length-d)+input.length;
		
		System.out.println("### Testing Size ###");              
        assertEquals(expectedOutput, App.testSize(d, input));
	}	
}
