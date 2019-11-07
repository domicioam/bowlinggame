package main.java;

public class LinkedList<T> {
	private Node<T> head;
	private Node<T> last;
	void add(T frame) {
		Node<T> node = new Node<T>();
		node.setValue(frame);
		
		if(head == null) {
			head = node;
			last = node;
		} else {
			last.setNext(node);
			last = node;
		}
	}
	public Node<T> getHead() {
		return head;
	}
	public Node<T> getLast() {
		return last;
	}
}
