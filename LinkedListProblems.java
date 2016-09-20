public class LinkedListProblems {
	public static void main(String[] args) {
		testReverseList();
	}

	public static ListNode<Integer> generateSequence(int n) {
		ListNode<Integer> head = new ListNode<Integer>(1, null);
		ListNode<Integer> curr = head;
		for(int i = 2; i <= n; i++) {
			curr.next = new ListNode<Integer>(i, null);
			curr = curr.next;
		}
		return head;
	}

	public static ListNode<Integer> reverseList(ListNode<Integer> lst) {
		if(lst == null) {
			return lst;
		}
		ListNode<Integer> prev = lst, curr = lst.next, next;
		lst.next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static void testReverseList() {
		//System.out.println(reverseList(generateSequence(10)));
		System.out.println(reverseListK(generateSequence(8),1));
	}

	/* Reverse a Linked List in groups of given size */
	public static ListNode<Integer> reverseListK(ListNode<Integer> lst, int k) {
		if(lst == null) {
			return lst;
		}
		ListNode<Integer> prev = lst, curr = lst.next, next;
		ListNode<Integer> head = lst;
		lst.next = null;
		int counter = 1;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			counter++;
			if(counter == k) {
				head.next = reverseListK(curr, k);
				break;
			}
		}
		return prev;
	}
}

class ListNode<T> {
	public T data;
	public ListNode<T> next;

	public ListNode(T data, ListNode<T> next) {
		this.data = data;
		this.next = next;
	}

	public String toString() {
		String str = this.data+"";
		if(this.next != null) {
			str += ",";
			str += this.next.toString();
		}
		return str;
	}
}