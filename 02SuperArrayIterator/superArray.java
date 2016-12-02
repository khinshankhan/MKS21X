//importations
import java.util.*; 
//class name
public class superArray{
    //private variable declaration
    private String[] data;
    private int size;
    //first type of constructor, also default. needs no parameters
    //data capacity will be 10, but size will be 0
    superArray(){
	data = new String[10];
	size = 0;
    }
    //similar to previous constructor, will make the data capacity
    //whatever maay be initialcapacity
    public superArray(int initialCapacity){
	if(initialCapacity<0){
	    throw new IllegalArgumentException();
	}
	data = new String[initialCapacity];
	size = 0;
    }
    //accessor method for size
    public int size(){
	return size;
    }
    //add method, returns true to show it happended
    public boolean add(String n){
	if (data.length > size()){
	    data[size] = n;
	    size++;
	}
	else{
	    grow();
	    add(n);
	}
	return true;
    }
    //method to 'append' data
    //doubles it for work efficiency
    private void grow(){
	String[] temp = new String[data.length * 2];
	for(int i = 0; i < size; i++){
	    temp[i] = data[i];
	}
	data = temp;
    }
    //since private, it'll only work in this class
    public void grow(int n){
	String[] temp = new String[size + n];
	for(int x = 0; x < size; x++){
	    temp[x] = data[x];
	}
	data = temp;
    }
    //format the super array like this :   [ 1, 3, 6, 8, 23, 99, -4, 5] 
    //commas between... square bracket start/end and no comma at end.
    public String toString(){
	if (size() > 0){
	    String result = "[ " + data[0];
	    for(int x = 1; x < size(); x++){
		result += ", " + data[x];
	    }
	    result += "]";
	    return result;
	}
	else{
	    return "[]";
	}
    }
    //format the super array like this :[ 1, 8, 23, 99, -4, 5, _, _, _, _]
    //(capacity is 10, but only 6 are used)
    //commas between... square bracket start/end and no comma at end.
    //unused slots should be printed as _ (underscores)
    public String toStringDebug(){
	if (size() > 0){
	    String result = "[ " + data[0];
	    for(int x = 1; x < data.length; x++){
		if (x< data.length && x >= size) {
		    result += ", _";
		}
		else{
		    result += ", " + data[x];
		}
	    }
    result += "]";
    return result;
    }
    else{
        return "[]";
    }
    }
    //shrinks the capacity to size
    public void trimToSize(){
	String temp[] = new String[size()];
	for(int x=0; x<size(); x++){
	    temp[x]=data[x];
	}
	data=temp;
    }
    //view specific index in data
    public String get(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	/*else if(index < size){
	    return data[index];
	    }*/
	else{
	    //return "0";
	    return data[index];
	}
    }
    //clears can be shown
    public void clear(){
	size= 0;
    }
    //shows if it's empty
    public boolean isEmpty(){
	return (size == 0);
    }
    //put the element in a certain place
    public String set(int index, String element){
    String x;
    if(index < 0 || index > size()){
	throw new IndexOutOfBoundsException();
    }
        x = data[index];
        data[index] = element;
        return x;
    }
    //adds the element to a certain place
    public void add(int index, String element){
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	else if(size < data.length){
	    for(int i =size; i > index; i--){
		data[i]=data [i - 1];
	    }
	    data[index]=element;
	    size++;
	}
	else{
	    grow();
	    add(index, element);
	}
    }
    //removes the element at an index
    public String remove(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	else if (index < size()){
	    String result = data[index];
	    for (int x = index; x < size(); x++){
		set(x, data[x + 1]);
	    }
	    return result;
	}
	else{
	    return "0";
	}
    }
    //returns copy of data
    public String[] toArray(){
	String[] temp = new String[size];
	for (int x = 0; x < size(); x++){
	    temp[x] = data[x];
	}
	return temp;
    }
    //shows first index of string
    public int indexOf(String str){
	boolean isThere = false;
	int x = 0;
	for(int i = 0; i < size && !(isThere); i++){
	    if(str.compareTo(data[i]) == 0){
		x = i;
		isThere = true;
	    }
	}
	if(isThere){
	    return x;
	}else{
	    return -1;
	}
    }
    //shows last index of the string
    public int lastIndexOf(String str){
	boolean isThere = false;
	int x = 0;
	for(int i = size - 1; i >= 0 && !(isThere); i--){
	    if(str.compareTo(data[i]) == 0){
		x = i;
		isThere = true;
	    }
	}
	if(isThere){
	    return x;
	}else{
	    return -1;
	}	
    }
    //
}
