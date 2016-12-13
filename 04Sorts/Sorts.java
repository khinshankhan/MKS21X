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
	  for(int index = i; index < data.length; index++){
	      if(data[min] < data[index])
	      
