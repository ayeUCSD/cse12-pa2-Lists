public class ArrayGL<E> implements MyList<E> {

    E[] elements;
    int size;
    int endInd;

    public ArrayGL(E[] initialElements) {
        this.elements = initialElements;
        this.size= this.endInd = initialElements.length;
    }

    
    
    public void add(E input) {
        if(elements[endInd] != null) {
            expandSize();
        }
    }
    
    
    public void remove(E input) {}
    
    
    /**
     * doubles the size of the array
     */
    public void expandSize() {
        E[] newArray = new E[2*size];
    }
    
    // Fill in all required methods here
    
    
    public E[] toArray() {
        
    }
    public void transformAll(MyTransformer mt) {
        
    }
    public void chooseAll(MyChooser mc) {
        
    }
    
    
    public boolean isEmpty() {
        return elements[0] != null;
    }
}