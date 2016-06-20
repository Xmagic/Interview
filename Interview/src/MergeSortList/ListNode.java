package MergeSortList;

public class ListNode {
	private String value;
	private ListNode next;
	public ListNode(String v, ListNode n) {
		setValue(v);
		setNext(n);
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
}
