public class LinkedGL<E> implements MyList<E> {

    class Node {
        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node front;
    int size;

    public LinkedGL(E[] contents) {
    	if(contents.length == 0) {
    		return;
    	}
    	this.size = contents.length;
        this.front = new Node(contents[0], null);
        Node temp = front;
        for(int i = 1; i < contents.length; i++) {
        	temp.next = new Node(contents[i], null);
        	temp = temp.next;
        }
    }
    
    public void add(E input) {
    	if(input == null) {
    		return;
    	}
    	Node end = getEnd();
    	end.next = new Node(input, null);
    	size++;
    }
    
    public void remove(E input) {
    	if(input == null) {
    		return;
    	}
    	
    	Node current = front;
    	Node previous = null;
    	while(current != null) {
    		if(current.value != null && current.value.equals(input)) {
    			break;
    		}
    		previous = current;
    		current = current.next;
    	}
    	
    	if(current == null) {
    		return;
    	}
    	else if(current == front) {
    		front = front.next;
    	}
    	else {
    	previous.next = current.next;
    	}
    	size--;
    }
    

    public Node getEnd() {
    	Node temp = front;
    	while(temp.next != null) {
    		temp = temp.next;
    	}
    	return temp;
    }
    
    // Fill in all methods
    // Fill in all required methods here
    @SuppressWarnings("unchecked")
    public E[] toArray() {
    	E[] output = (E[]) new Object[size];
    	int i = 0;
    	for(Node n = front; n != null; n = n.next) {
    		output[i++] = n.value;
    		
    	}
    	return output;
    }
    
    @SuppressWarnings("unchecked")
    public void transformAll(MyTransformer mt) {
    	for(Node n = front; n != null; n = n.next) {
    		if(n.value != null) {
    		n.value = (E)mt.transformElement(n.value);
    		}
    	}
    }
    public void chooseAll(MyChooser mc) {
    	Node previous;
    	for(Node n = front; n != null; n = n.next) {
    		previous = n;
    		if(n.value!= null && !mc.chooseElement(n.value)) {
    			remove(n.value);
    			n = previous;
    		}
    		
    	}
    }
    
    
    public boolean isEmpty() {
    	return size == 0;
    }
}