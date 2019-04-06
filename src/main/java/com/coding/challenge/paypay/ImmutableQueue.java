package com.coding.challenge.paypay;

import java.util.Iterator;

/**
 * Concrete Queue Implementation with
 * constant O(1) Runtime for enqueue, dequeue and size.
 * 
 * @author gopi_karmakar
 *
 * @param <T>
 */
public class ImmutableQueue<T> implements Queue<T>, Iterable<T> {

	private int size = 0;
	private Node head, rear;
	
	/**
	 * 
	 * 
	 * @author gopi_karmakar
	 *
	 */
	private class Node {
		T item;
		Node next = null;
		Node(T item) {
			this.item = item;
		}
	}
	
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

	@Override
	public T head() {
		if(isEmpty())
			throw new NullPointerException("Queue Is Empty");		
		return head.item;
	}

	@Override
	public boolean isEmpty() {
		return (head == null);
	}
	
	public int size() {
		return size;
	}

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
