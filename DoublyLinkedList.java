public class DoublyLinkedList {
    private ListNode2 head = null;
    public int n = 0; 
    
    public void addFirst(Object o) {
    	ListNode2 newNode = new ListNode2(o, null, null);
    	newNode.next = head;
    	newNode.prev = null;
    	
    	if(head != null) {
    		head.prev = newNode;
    	}
		head = newNode;
	}
    
    public Object get(int i) {
		ListNode2 current = head;
		
		for(int j = 0; j < i; j++) {
			current = current.next;
		}
		return current.element;
	}
    
    public void insert(Object o, int i) {
		ListNode2 newNode = new ListNode2(o, null, null);
		
		if(i == 0) {
			addFirst(o);
			return;
		}
		else {
			ListNode2 previous = head;
			ListNode2 current = head.next;
			int count = 1;
			while(count < i) {
				current = current.next;
				previous = previous.next;
				count++;
			}
			
			newNode.next = current;
			newNode.prev = previous;
			
			if(current != null) {
				current.prev = newNode;
			}
			
			previous.next = newNode;
		}
	}
    
    public void remove(int i) {
    	ListNode2 previous = head;
    	ListNode2 current = head.next;
    	if(i == 0) {
    		head = previous.next;
    		if(current != null) {
    			current.prev = null;
    		}
    	}
    	else {
    		
    		int count = 1;
    		
    		while(count < i) {
    			current = current.next;
    			previous = previous.next;
    			count++;
    		}
    		if(previous != null) {
    			previous.next = current.next;
    		}
    		
    		if(current.next != null){
    			current.next.prev = previous;
    			System.out.println(current.next.prev.element);
    		}
    		
    		current.prev = null;
    		current.next = null;
    	}
			
			
	}
    
    	
   
    /**
     * Prints out the elements in the list from the first to the last (front to back) and then from the last to the first
     * (back to front). This is useful to test whether the list nodes are connected correctly with next and prev references.
     */
    public void print() {
        // no elements to print for empty list
        if (head == null) {
            System.out.println("list empty.");
            return;
        }

        // follow next references to list elements from the front to the back of the list
        System.out.print("front to back: ");
        ListNode2 node = head;
        System.out.print(node.element + " ");
        while (node.next != null) {
            node = node.next;
            System.out.print(node.element + " ");
        }

        // follow prev references to list elements from the back to the front of the list
        System.out.print("-- and back to front: ");
        while (node != null) {
            System.out.print(node.element + " ");
            node = node.prev;
        }
        System.out.println();
    }
}
