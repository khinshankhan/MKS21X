//Importations
import java.util.*;

public class Barcode implements Comparable<Barcode>{
// instance variables
   private String _zip;
   private int _checkDigit;
//array to use for conversions
   private static String[] key = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};

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
      toString();
  }
  public Barcode(String zip){
      if(zip.length()!=5 || numString(_zip)){
	  throw new IllegalArgumentException();
      }
  }
  private boolean numString(zip){
    
// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
      Barcode clone= new Barcode(_zip);
      return clone;
  }

// postcondition: computes and returns the check sum for _zip
  public static int checkSum(String zip){
      int sum= 0;
      for(int i= 0; i<zip.length(); i++){
	  sum+= (int)(zip.charAt(i)-'0');
      }
      return sum%10;
  }
    
//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	String barcode = _zip + checkSum(_zip)+ "  " + "|";
	for(int i = 0; i < (_zip + checkSum(_zip)).length(); i++){
	    switch((_zip + checkSum(_zip)).charAt(i)){
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
      Integer o = new Integer(_zip + checkSum(_zip)+"") ;
      Integer p = new Integer(other._zip + other.checkSum(_zip)+"");
      return o.compareTo(p);
  }

//Converts 5 digit zipcodes to barcodes
//Parameters:zip - the 5 digit zip code.
//Returns:The barcode formatted as "|||:::|::|::|::|:|:|::::|||::|:|"
//Throws:java.lang.IllegalArgumentException - if zip is not the correct length or zip contains a non digit
  public static String toCode(String zip){
      if(!(zip.length()==5)){
	      throw new IllegalArgumentException("zip is not the correct length");
	  }
      try{
	      Integer.parseInt(zip);
      }catch(Exception e){
	  throw new IllegalArgumentException("zip contains only digits");
      }
      String result= "";
      return result;
  }

    public static void main(String args[]){
	try{
	    Barcode b = new Barcode("08451");
	    Barcode c = new Barcode("99999");
	    Barcode d = new Barcode("01111");
	    System.out.println(b); //084518  |||:::|::|::|::|:|:|::::|||::|:|
	    System.out.println(b.toString().compareTo("084518  |||:::|::|::|::|:|:|::::|||::|:|")); //0
	    System.out.println(b.compareTo(b)); //0
	    System.out.println((new Barcode("11426")).compareTo(new Barcode("11426"))); //0
	    System.out.println(c.compareTo(b)); //some positive, preferably 1
	    System.out.println(d.compareTo(b)); //some negative, preferably -1
	//length
	  Barcode e = new Barcode("123456");
	  System.out.println(e);
	  //length
	  Barcode f = new Barcode("1234");
	  System.out.println(f);
	  //type
	  Barcode g= new Barcode("12.45");
	  System.out.println(g);
	}catch(Exception e){
	    e.printStackTrace();
	}
    }
}
