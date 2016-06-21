package ReverseList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class MainApp {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6,7,8,9};
		
		ListNode head = createNode(a, 0);
		doPrint(head);
		System.out.println("=======Reverse=======");
		doPrint(doReverse(head));
		
	}
	
	private static void doPrint(ListNode node) {
		if(node == null)
			return ;
		System.out.println(node.getValue());
		doPrint(node.getNext());
	}
	
	public static ListNode createNode(int[] a, int index) {
		if(index >= a.length)
			return null;
		ListNode next = createNode(a, index + 1);
		return new ListNode(String.valueOf(a[index]), next);
	}
	
	
	static ListNode next = null;
	static ListNode prev = null;
	static ListNode newHead = null;
	public static ListNode doReverse(ListNode node) {
		next = null;
		prev = null;
		while(node != null) {
			next = node.getNext();
			node.setNext(prev);
			
			prev = node;
			node = next;
		}
		
		return prev; //new Head
	}
	
}
