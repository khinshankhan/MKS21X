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


    
    public static void main(String[] a){
	int[] initial  = new int[]{599, 84, 72, 1, 21};
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
	
    }
}
	      
