//importations (because im so lazy)
import java.util.*;
//WILL ADD JAVA DOCS LATER
public class PersonalLibrary{
//MY NAME
    public static String name(){
	return "Khinshan Khan";
    }
    
//return an array of size param1 randomly filled with the max being param2
    public static int[] randomArray(int size, int max){
	int[] data= new int[size];
	Random num = new Random();
	for(int i=0; i<data.length; i++){
	    data[i]=num.nextInt(max);
	}
	return data;
    }
    
//Splits string and stores the parts in an arraylist
    private static List<String> getParts(String s, int portion) {
	List<String> parts = new ArrayList<String>();
	int l = s.length();
	for (int i=0; i<l; i+=portion){
	    parts.add(s.substring(i, Math.min(l, i + portion)));
        }
        return parts;
    }
    
//checks if a string is part of an 'key' int array
    public static boolean valid(String[] key, String check) {
	return Arrays.asList(key).contains(check);
    }
    
//swap two values in int array
    public static void swap(int[] data, int a, int b) {
	int store = data[a];
	data[a] = data[b];
	data[b] = store;
    }
    
//Check if all elements of an int array equal in value
    public static boolean equality(int array[]){
	boolean equalityChecker = true;
	int equalityCheck = array[0];
	for (int i = 0; i < array.length; i++){
	    if (equalityCheck != array[i]){
		equalityChecker=false;
		break;
	    }
	}
	return equalityChecker;
    }
//Checks if an array is in order
    public static boolean isInOrder(int[] data) {
	for(int i = data.length-1; i > 0; i--){
	    if(data[i]<data[i-1]){
		return false;
	    }
	}
	return true;
    }
}
    
