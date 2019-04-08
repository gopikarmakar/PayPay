package com.coding.challenge.paypay;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Main Class contains all test cases implementation.
 */
public class App {
    
	public static void main( String...items ) {
		ArrayList<String> list = new ArrayList<>();
		for(String s : items) {
			list.add(s);
		}
		testQCreationFromGivenValues(list);
	}
	
	public static String testQCreationFromGivenValues(Collection<String> input) {		
		return testIteration(input);
	}
	
	public static String testEnqueueNullValue(Collection<String> input) {
		String msg = testIteration(input);
		System.out.println("Error Message = " + msg);
		return msg;
	}
	
	public static String testEmptyQueue(String...items) {
		String msg = "";
		ImmutableQueue<String> queue = new ImmutableQueue<String>();
		try {
			enqueueAll(queue, items);
			dequeueAll(queue);
			dequeue(queue);
		} catch (NullPointerException npe) {
			msg = npe.getMessage();
			System.out.println("Error Message = " + msg);
		}
		return msg;
	}
    
    public static String testHead(int d, String...items) {
    	ImmutableQueue<String> queue = new ImmutableQueue<String>();
    	for(int i = 0; i < d; i++) {
			enqueue(queue, items[i]);
		}    	
    	for(int i = 0; i < d; i++) {
			queue.deQueue();
		}
    	
    	enqueue(queue, items[items.length-1]);
    	
    	String item = queue.head();
    	System.out.println("Head = " + item);
    	return item;
    }
    
    public static String testAllEnqueueDequeue(String...items) {
		ImmutableQueue<String> queue = new ImmutableQueue<String>();
		enqueueAll(queue, items);		
		return dequeueAll(queue);
	}
	
	public static String testRandomEnqueDequeue(String...items) {
		String result = "";
		ImmutableQueue<String> queue = new ImmutableQueue<String>();				
		enqueueAll(queue, items);				
		for(int i = 0; i < 3; i++) {
			result += dequeue(queue);
		}		
		for(int i = 0; i < 4; i++) {
			enqueue(queue, items[i]);
		}	
		for(int i = 0; i < 4; i++) {
			result += dequeue(queue);
		}		
		return result;
	}
	
	public static int testSize(int d, String...items) {
		ImmutableQueue<String> queue = new ImmutableQueue<String>();
		enqueueAll(queue, items);
		for(int i = 0; i < d; i++) {
			queue.deQueue();
		}
		enqueueAll(queue, items);
		System.out.println("Size = " + queue.size());
		return queue.size();
	}
	
	private static String testIteration(Collection<String> input) {
		String result = "";
		ImmutableQueue<String> queue = null;
		try {		
			queue = new ImmutableQueue<>(input);
		} catch (IllegalArgumentException e) {
			return e.getMessage();
		}
					
		Iterator<String> itr = queue.iterator();
		while(itr.hasNext()) {
			String item = itr.next();
			System.out.println(item);
			result += item;
		}
		return result;
	}
	
	private static void enqueue(ImmutableQueue<String> queue, String item) {
		queue.enQueue(item);
	}
	
	private static String dequeue(ImmutableQueue<String> queue) {
		String result = "";
		String item = queue.head();
		result += item;
		System.out.println(item);			
		queue.deQueue();
		
		return result;
	}
	
	private static void enqueueAll(ImmutableQueue<String> queue, String...items) {
		for(String item : items) {
			enqueue(queue, item);
		}
	}
		
	private static String dequeueAll(ImmutableQueue<String> queue) {
		String result = "";
		while(!queue.isEmpty()) {
			String item = queue.head();
			result += item;
			System.out.println(item);			
			queue.deQueue();	
		}
		return result;
	}
}