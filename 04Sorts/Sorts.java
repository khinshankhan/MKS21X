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
    public static void bubbleSort(int[] data) {
	int previousSwap = data.length-1;
	for(int i=1; i < data.length; i++){
	    boolean ordered = true;
	    int currentSwap = -1;
	    for(int ind=0; ind < previousSwap; ind++){
		if(data[ind] > data[ind+1]){
		    swap(data, ind, ind+1);
		    ordered = false;
		    currentSwap = ind;
		}
	    }
	    if(ordered){
		return;
	    }
	    previousSwap = currentSwap;
	}
    }

//swap two values in int array, finally using my personal library! Worth editting my bubble sort I guess...
    public static void swap(int[] data, int a, int b) {
	int store = data[a];
	data[a] = data[b];
	data[b] = store;
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
    public static String Test(String method, int[]initial){
	String sorted;
	long startTime = System.currentTimeMillis();
	int[] copy = new int[initial.length];
	System.arraycopy( initial, 0, copy, 0, initial.length );
	Arrays.sort(copy);
	Object[] Sorted = {copy};
	int[] ary = new int[initial.length];
	System.arraycopy( initial, 0, ary, 0, initial.length );
	switch(method){
	    case "selectionSort":Sorts.selectionSort(ary);
		break;
	    case "insertionSort":Sorts.insertionSort(ary);
		break;
	    case "bubbleSort":Sorts.bubbleSort(ary);
		break;
	    default: return "INVALID. CURENTLY THERE ARE ONLY:\nselectionSort, insertionSort, bubbleSort \nPlease try again.";
	}
	Object[] Applied = {ary};
	if (Arrays.deepEquals(Sorted, Applied)){
	    sorted="Did sort";
	}
	else{
	    sorted="Did not sort";
	}
	long endTime = System.currentTimeMillis();
	long time=endTime-startTime;


	return String.format("%s: %s and took time of %s ms", method, sorted, time);
}
    
    public static void main(String[] a){
	System.out.println(Test(a[0],randomArray(10000,1000)));
	
    }
}
	      
