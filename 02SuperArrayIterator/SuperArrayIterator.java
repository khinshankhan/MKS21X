import java.util.Iterator;
import java.util.NoSuchElementException;
public class SuperArrayIterator implements Iterator<String> {
    
    private int element;
    private SuperArray superArray;
    
    public SuperArrayIterator(SuperArray superArray) {
	this.superArray = superArray;
	element =0;
    }
    public String next() {
	if (hasNext()) {
	    element++;
	    return superArray.get(element-1);
	}
        else {
	    throw new NoSuchElementException();
	}
    }
    public boolean hasNext() {
	return element < superArray.size();
    }
    public void remove() {
	throw new UnsupportedOperationException();
    }
}
