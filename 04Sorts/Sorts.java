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
    public static void main(String[] a){
	int[] ary = {599, 84, 72, 1, 21};
	Sorts.selectionSort(ary);
	for(int i = 0; i < ary.length; i++){
	    System.out.print(ary[i] + ",");
	}
    }
}
	      
