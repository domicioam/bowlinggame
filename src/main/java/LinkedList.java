package main.java;

public class LinkedList {
	private Frame head;
	private Frame last;
	private int size;
	
	void add(Frame frame) {
		if(head == null) {
			head = frame;
			last = frame;
		} else {
			last.setNext(frame);
			last = frame;
		}
		size++;
	}
	public Frame getHead() {
		return head;
	}
	public Frame getLast() {
		return last;
	}
	public int size() {
		return size;
	}
}
