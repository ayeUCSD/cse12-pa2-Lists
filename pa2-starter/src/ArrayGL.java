
public class ArrayGL<E> implements MyList<E> {

    E[] elements;
    int size;
    int index;

    public ArrayGL(E[] initialElements) {
        this.elements = initialElements;
        this.size= initialElements.length;
        this.index = initialElements.length - 1; //we want the index
    }

    
    /**
     * 
     * @param input
     * @return if we expanded the list or not
     */
    public boolean add(E input) {
        elements[index] = input;
         size++;
         return setIndex();
       
    }
    
    
    /**
     * stupid linear search for a null index
     * sets index to a spot with a null
     * otherwise sets it to the end and doubles the size of the list
     * 
     * returns whether or not we expanded the list or not
     */
    public boolean setIndex() {
    	for(int i = 0; i < size; i++) {
    		if(elements[i] == null) {
    			index = i;
    			return false;
    		}
    	}
    	index = elements.length;
    	expandSize();
    	return true;
    }
    
    public E remove(E input) {
    	//we do a linear search for input :(
    	//swap end with index value
    	for(int i = 0; i < size; i++) {
    		if(elements[i].equals(input)) {
    			E output = elements[i];
    			elements[i] = null;
    			size--;
    			return output;
    		}
    	}
    	return null;
    }
    
    /**
     * doubles the size of the array
     */
    @SuppressWarnings("unchecked")
    public void expandSize() {
        E[] copyArray = (E[]) new Object[2*size];
        for(int i = 0; i < this.size; i++) {
        	copyArray[i] = elements[i];
        }
    }
    
    // Fill in all required methods here
    /**
     * returns an array in the same order without null spaces between entries
     */
    @SuppressWarnings("unchecked")
    public E[] toArray() {
    	/**
    	E[] output = (E[]) new Object[size];
    	int i = 0;
    	for(E e : elements) {
    		if(e != null) {
    			output[i++] = e;
    		}
    	}
    	
    	return output;
        */
    	return elements;
    }
    
    @SuppressWarnings("unchecked")
    public void transformAll(MyTransformer mt) {
        for(int i = 0; i < elements.length; i++) {
        	if(elements[i] != null) {		
        	elements[i] = (E) mt.transformElement(elements[i]);
        	}
        }
    }
    public void chooseAll(MyChooser mc) {
    	for(int i = 0; i < elements.length; i++) {
        	if(!mc.chooseElement(elements[i])){
        		elements[i] = null;
        	}
        }
    	elements = toArray();
        size = elements.length;
    }
    
    
    public boolean isEmpty() {
    	
    	return size == 0;
    }
}