package com.coding.challenge.paypay;

import java.util.Iterator;

/**
 * A Concrete Queue Implementation with the
 * constant O(1) runtime for enqueue, dequeue, head and size.
 * 
 * @author gopi_karmakar
 *
 * @param <T>
 */
public class ImmutableQueue<T> implements Queue<T>, Iterable<T> {

	private int size = 0;
	private Node head, rear;
	
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
	 * Enqueue every new item to it's rear.
	 */
	@Override
	public Queue<T> enQueue(T t) {
		size += 1;
		Node node = rear;
		rear = new Node(t);
		if(head == null) {
			head = rear;
			return this;
		}		
		node.next = rear;
		return this;
	}

	/**
	 * Dequeue item from it's head.
	 */
	@Override
	public Queue<T> deQueue() {
		Node node = head;
		if(node == null)
			throw new NullPointerException("Queue Is Empty");
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
			throw new NullPointerException("Queue Is Empty");		
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
