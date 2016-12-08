//Importations
import java.util.*;

public class Barcode implements Comparable<Barcode>{
// instance variables
   private String _zip;
   private int _checkDigit;

// constructors
//precondtion: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
  public Barcode(String zip){
      if(!(zip.length()==5)){
	      throw new IllegalArgumentException("zip is not the correct length");
	  }
      try{
	      Integer.parseInt(zip);
      }catch(Exception e){
	  throw new IllegalArgumentException("zip contains only digits");
      }
      _zip = zip;
      _checkDigit = checkSum();
      toString();
  }
    
// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
      Barcode clone= new Barcode(_zip);
      return clone;
  }

// postcondition: computes and returns the check sum for _zip
  private int checkSum(){
      int sum= 0;
      for(int i= 0; i<_zip.length(); i++){
	  sum+= (int)_zip.charAt(i);
      }
      return sum%10;
  }
    
//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	String barcode = _zip + _checkDigit+ "  " + "|";
	for(int i = 0; i < (_zip + _checkDigit).length(); i++){
	    switch((_zip + _checkDigit).charAt(i)){
	    case '0': barcode += "||:::";
		break;
	    case '1': barcode += ":::||";
		break;
	    case '2': barcode += "::|:|";
		break;
	    case '3': barcode += "::||:";
		break;
	    case '4': barcode += ":|::|";
		break;
	    case '5': barcode += ":|:|:";
		break;
	    case '6': barcode += ":||::";
		break;
	    case '7': barcode += "|:::|";
		break;
	    case '8': barcode += "|::|:";
		break;
	    case '9': barcode += "|:|::";
		break;
	    }
	}
	return barcode + "|";
    }

// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){
      Integer o = new Integer(_zip + checkSum()+"") ;
      Integer p = new Integer(other._zip + other.checkSum()+"");
      return o.compareTo(p);
  }
}
