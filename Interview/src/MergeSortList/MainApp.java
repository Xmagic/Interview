package MergeSortList;

import ReverseList.ListNode;

public class MainApp {

	private static ListNode doSort(ListNode head) {
		if (head == null || head.getNext() == null)
			return head;// This is must, or stackOverflow

		ListNode nodeFast = head;
		ListNode nodeSlow = head;

		// Set slow with step 1, fast with step 2. Once the fast reach the end,
		// slow is just at the middle.
		while (nodeFast.getNext() != null && nodeFast.getNext().getNext() != null) {
			nodeFast = nodeFast.getNext().getNext();
			nodeSlow = nodeSlow.getNext();
		}

		// Cur the list, or will stackOverflow
		nodeFast = nodeSlow.getNext();
		nodeSlow.setNext(null);

		// Recursive do sort sub lists
		ListNode subList1 = doSort(head);
		ListNode subList2 = doSort(nodeFast);

		return merge(subList1, subList2);
	}

	private static ListNode merge(ListNode subList1, ListNode subList2) {
		ListNode newHead = new ListNode("-1", null);
		ListNode p = newHead;

		while (subList1 != null && subList2 != null) {
			if (subList1.getValue().compareTo(subList2.getValue()) < 0) {
				p.setNext(subList1);
				subList1 = subList1.getNext();
			} else {
				p.setNext(subList2);
				subList2 = subList2.getNext();
			}
			p = p.getNext();
		}

		p.setNext((subList1 == null) ? subList2 : subList1);

		return newHead.getNext();
	}

	public static void main(String[] args) {
		int a[] = { 9, 2, 3, 5, 6, 4, 7, 1 };

		ListNode head = createNode(a, 0);
		doPrint(head);
		System.out.println("=======Sorted=======");

		ListNode sortedHead = doSort(head);
		doPrint(sortedHead);

	}

	private static void doPrint(ListNode node) {
		if (node == null)
			return;
		System.out.println(node.getValue());
		doPrint(node.getNext());
	}

	public static ListNode createNode(int[] a, int index) {
		if (index >= a.length)
			return null;
		ListNode next = createNode(a, index + 1);
		return new ListNode(String.valueOf(a[index]), next);
	}

}
