public class LinkedList {
	private ListNode head = null;
	public int n = 0;
	
	public void addFirst(Object o) {
		head = new ListNode(o, head);
		n++;
	}
	
	public Object get(int i) {
		ListNode current = head;
		
		for(int j = 0; j < i; j++) {
			current = current.next;
		}
		return current.element;
	}
	
	public void insert(Object o, int i) {
		ListNode newNode = new ListNode(o, null);
		
		if(i == 0) {
			addFirst(o);
			return;
		}
		else {
			ListNode previous = head;
			int count = 1;
			while(count < i) {
				previous = previous.next;
				count++;
			}
			
			ListNode current = previous.next;
			newNode.next = current;
			previous.next = newNode;
			
		}
	}
	
	public void remove(int i) {
		if(i == 0) {
			head = head.next;
			n--;
			return;
		}
		else {
			ListNode previous = head;
			int count = 1;
			while(count < i) {
				previous = previous.next;
				count++;
			}
			
			ListNode current = previous.next;
			previous.next = current.next;
			current.next = null;
		}
	}
	
	public void add(Object o) {
		if(head == null) {
			addFirst(o);
			return;
		}
		
		ListNode current = head;
		
		while(current.next != null) {
			current=current.next;
		}
		current.next = new ListNode(o, current.next);
	}
}
