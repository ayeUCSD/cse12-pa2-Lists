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
        this.front = new Node(contents[0], null);
        Node temp = front;
        for(int i = 1; i < contents.length; i++) {
        	temp.next = new Node(contents[i],null);
        	temp = temp.next;
        }
    }
    
    public void add(E input) {
    	Node end = getEnd();
    	end.next = new Node(input, null);
    }
    
    public void remove(E input) {
    	Node temp = front;
    	Node previous = null;
    	while(temp != null && !temp.next.value.equals(input)) {
    		previous = temp;
    		temp = temp.next;
    	}
    	if(temp == null) {
    		return;
    	}
    	previous.next = temp.next;
    }

    public Node getEnd() {
    	Node temp = front;
    	while(temp.next != null) {
    		temp = temp.next;
    	}
    }
    
    // Fill in all methods
    // Fill in all required methods here
    @SuppressWarnings("unchecked")
    public E[] toArray() {
    	return null;
    }
    
    @SuppressWarnings("unchecked")
    public void transformAll(MyTransformer mt) {
    }
    public void chooseAll(MyChooser mc) {
    }
    
    
    public boolean isEmpty() {
    	return false;
    }
}