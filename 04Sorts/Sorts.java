//importations (for test cases only)
import java.util.*;

public class Sorts{
  /**EDIT THIS METHOD TO MATCH YOUR NAME 
  */
  public static String name(){
    return "09.Khan.Khinshan"; 
  }
    
  /**Selection sort of an int array. 
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
    public static void selectionSort(int[] data){
	for(int i = 0; i < data.length - 1; i++){
	    int min = i;
	    for(int index = i + 1; index < data.length; index++){
		if(data[min] > data[index]){
		    min = index;
		}
	    }
	    int previous = data[i];
	    data[i] = data[min];
	    data[min] = previous;
	}
    }

  /**Insertion sort of an int array. 
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
    public static void insertionSort(int[] data){
	int select;
	for(int i = 1; i < data.length; i++){
	    select = data[i];
	    int check= i-1;
	    while(check >=0 && select < data[check]){
		data[check+1]=data[check];
		check--;
	    }
	    data[check+1]=select;
	}
    }

    /**Bubble sort of an int array. 
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
    public static void bubbleSort(int[] data){
	int min;
	for(int i=0; i < data.length; i++){
	    for(int index = 1; index < (data.length-i); index++){
		if(data[index] < data[index-1]){
		    min = data[index-1];
		    data[index-1] = data[index];
		    data[index] = min;
		}
	    }
	}
    }
    
    /**Fills int array with random integers. 
  *Upon completion, the elements of the array will be in a random order (max is 10000 because why not?).
  *@param data array to fill.
  */
    public static int[] randomArray(int size, int max){
	int[] data= new int[size];
	Random num = new Random();
	for(int i=0; i<data.length; i++){
	    data[i]=num.nextInt(max);
	}
	return data;
    }
    public static String Test(String method){
	String a= "will be sorted";
	String b= "will be time";
	int[] initial  = randomArray(5,1000);
	System.out.println("Initial Array: " +Arrays.toString(initial)); 
	int[] copy = new int[initial.length];
	System.arraycopy( initial, 0, copy, 0, initial.length );
	Arrays.sort(copy);
	Object[] Sorted = {copy};
	int[] ary = new int[initial.length];
	System.arraycopy( initial, 0, ary, 0, initial.length );
	switch(method){
	    case 'insertion':Sorts.insertionSort(bubble);
		break;
	}

	return String.format("%s: %s and took time of %s", method, a, b);;
}
    
    public static void main(String[] a){
	int[] initial  = randomArray(0,1000);
	System.out.println("Initial Array: " +Arrays.toString(initial)); 
	int[] copy = new int[initial.length];
	System.arraycopy( initial, 0, copy, 0, initial.length );
	Arrays.sort(copy);
	Object[] Sorted = {copy};
	
	System.out.print("\n Selection sort: ");
	int[] selection = new int[initial.length];
	System.arraycopy( initial, 0, selection, 0, initial.length );
	Sorts.selectionSort(selection);
	Object[] Selection = {selection};
	if (Arrays.deepEquals(Sorted, Selection)){
	    System.out.println("Sorted");
	}
	else{
	    System.out.println("Not sorted");
	}
	
	System.out.print("\n Bubble sort: ");
	int[] bubble = new int[initial.length];
	System.arraycopy( initial, 0, bubble, 0, initial.length );
	Sorts.bubbleSort(bubble);
	Object[] Bubble = {bubble};
	if (Arrays.deepEquals(Sorted, Bubble)){
	    System.out.println("Sorted");
	}
	else{
	    System.out.println("Not sorted");
	}

	System.out.print("\n Insertion sort: ");
	int[] insert = new int[initial.length];
	System.arraycopy( initial, 0, insert, 0, initial.length );
	Sorts.insertionSort(insert);
	Object[] Insert = {insert};
	if (Arrays.deepEquals(Sorted, Insert)){
	    System.out.println("Sorted");
	}
	else{
	    System.out.println("Not sorted");
	}
	
    }
}
	      
