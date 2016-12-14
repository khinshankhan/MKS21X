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
	System.out.print("\n Selection sort: ");
	int[] selection = {599, 84, 72, 1, 21};
	Sorts.selectionSort(selection);
	for(int i = 0; i < selection.length; i++){
	    System.out.print(selection[i] + ",");
	}
	System.out.print("\n Bubble sort: ");
	int[] bubble = {500, 44, 92, 1, 41};
	Sorts.bubbleSort(bubble);
	for(int i = 0; i < bubble.length; i++){
	    System.out.print(bubble[i] + ",");
	}
    }
}
	      
