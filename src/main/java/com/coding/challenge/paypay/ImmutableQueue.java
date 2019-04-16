package com.coding.challenge.paypay;

import java.util.Iterator;
import java.util.Collection;

/**
 * A concrete immutable, non-null valued and linked list  
 * based queue(FIFO) Implementation with the
 * constant O(1) runtime complexity for 
 * enqueue, dequeue, head and size.
 * 
 * @author gopi_karmakar
 *
 * @param <T>
 */
public final class ImmutableQueue<T> implements Queue<T>, Iterable<T> {
	
	private final String emptyQueueMsg = "Queue Is Empty";	
	private final String illegalArgsMsg = "Value Can't Be Null"; 	

	/**
	 * Tracks size;
	 */
	private int size = 0;
	/**
	 * Tracks head and rear.
	 */
	private Node head, tail;
	
	/**
	 * Each node will carry it's own item
	 * and a link to the next item to iterate through.	  	
	 */
	private class Node {
		T item;
		Node next = null;
		Node(T item) {
			this.item = item;
		}
	}
	
	/**
	 * Default constructor
	 */
	public ImmutableQueue() {}
	
	/*
	 * Creates an empty queue if the given value is null else 
	 * Creates a queue from given collection of values. 
	 * 
	 */
	public ImmutableQueue(Collection<T> v) throws IllegalArgumentException {
		this();
		if(v != null) {
			for(T t : v) {
				try {				
					enQueue(t);
				} catch (IllegalArgumentException e) {
					throw new IllegalArgumentException(illegalArgsMsg);
				}				
			}
		}
	}
	
	/**
	 * Enqueue every new item to it's rear.
	 */
	@Override
	public Queue<T> enQueue(T t) {
		if(t == null) {
			throw new IllegalArgumentException(illegalArgsMsg);
		}
		size += 1;
		Node node = tail;
		tail = new Node(t);
		if(head == null) {
			head = tail;
			return this;
		}		
		node.next = tail;
		return this;
	}

	/**
	 * Dequeue item from it's head.
	 */
	@Override
	public Queue<T> deQueue() {
		Node node = head;
		if(node == null)
			throw new NullPointerException(emptyQueueMsg);
		size -= 1;
		head = head.next;		
		node = null; //Making available for garbage collection.
		return this;
	}

	/**
	 * Returns the head item only will not dequeue.
	 */
	@Override
	public T head() {
		if(isEmpty())
			throw new NullPointerException(emptyQueueMsg);		
		return head.item;
	}

	/**
	 * Returns true if there's no head to return.
	 */
	@Override
	public boolean isEmpty() {
		return (head == null);
	}
	
	/**
	 * Return the size of the queue.
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns an iterator to iterate through the queue.
	 */
	@Override
	public Iterator<T> iterator() {
		Iterator<T> itr = new Iterator<T>() {

			Node current = head;
			
			@Override
			public boolean hasNext() {
				return (current != null);
			}

			@Override
			public T next() {
				T t = current.item;
				current = current.next;
				return t;
			}
						
			@Override
			public void remove() {				
				throw new UnsupportedOperationException();
			}			
		};
		return itr;
	}
}