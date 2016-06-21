package IntersectionFor2Arrays;

public class IntersectionFor2Arrays {

	public static void main(String[] args) {
		IntersectionFor2Arrays t = new IntersectionFor2Arrays();
		int a[] = {1,2,2,1};
		int b[] = {2,2,3,4,5};
		int[] result = t.intersection(a, b);
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
	public int[] intersection(int[] nums1, int[] nums2) {

		ListNode l1 = createNode(nums1, 0);
		ListNode l2 = createNode(nums2, 0);
		l1 = doSort(l1);
		l2 = doSort(l2);
		ListNode end1 = getEnd(l1);
		ListNode end2 = getEnd(l2);

		int a[] = new int[Math.min(nums1.length, nums2.length)];
		int n = 0;
		
		while (l1 != null && l2 != null) {
			int low = Math.max(l1.getValue(), l2.getValue());
			int high = Math.min(end1.getValue(), end2.getValue());

			if(low > high)
				break;
			
			while (l1.getValue() < low) {
				l1 = l1.getNext();
			}

			while (l2.getValue() < low) {
				l2 = l2.getNext();
			}
			
			end1 = getEndNoMoreThan(l1, high);
			end2 = getEndNoMoreThan(l2, high);
			
			if(l1.getValue() == l2.getValue()) {
				a[n++] = l1.getValue();
				l1 = l1.getNext();
				l2 = l2.getNext();
			}
		}
		
		int [] result = new int[n];
		for(int i=0;i<n;i++)
		{
			result[i] = a[i];
		}
		return result;
	}

	
	private ListNode doSort(ListNode head) {
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

	private ListNode merge(ListNode subList1, ListNode subList2) {
		ListNode newHead = new ListNode(-1, null);
		ListNode p = newHead;

		while (subList1 != null && subList2 != null) {
			if (subList1.getValue() < subList2.getValue()) {
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
	
	public class ListNode {
		private int value;
		private ListNode next;
		public ListNode(int v, ListNode n) {
			setValue(v);
			setNext(n);
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public ListNode getNext() {
			return next;
		}
		public void setNext(ListNode next) {
			this.next = next;
		}
	}
	
	public ListNode createNode(int[] a, int index) {
		if(index >= a.length)
			return null;
		ListNode next = createNode(a, index + 1);
		return new ListNode(a[index], next);
	}
	
	private ListNode getEnd(ListNode head) {
		if(head == null)
			return null;
		ListNode p = head;
		while (p.getNext() != null) {
			p = p.getNext();
		}
		return p;
	}
	
	private ListNode getEndNoMoreThan(ListNode head, int value) {
		ListNode p = head;
		while (p.getNext() != null && p.getNext().getValue() <= value) {
			p = p.getNext();
		}
		return p;
	}

}
