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
      if(numString(zip)){
	  _zip = zip;
      }
  }
    public static boolean numString(String zip){
	if(!(zip.length()==5)){
	      throw new IllegalArgumentException("zip is not the correct length");
	  }
      try{
	      Integer.parseInt(zip);
      }catch(Exception e){
	  throw new IllegalArgumentException("zip should contain only digits");
      }
      return true;
    }
    
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
	return toZipAndCode(_zip);
    }
    /*String barcode = _zip + checkSum(_zip)+ "  " + "|";
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
    */
    
//for toString
    public static String toZipAndCode(String zip){
      if(!(zip.length()==5)){
	      throw new IllegalArgumentException("zip is not the correct length");
	  }
      try{
	      Integer.parseInt(zip);
      }catch(Exception e){
	  throw new IllegalArgumentException("zip should contain only digits");
      }
      String result= "";
      String preBarcode= zip+checkSum(zip);
      for(int i = 0; i < preBarcode.length(); i++){
	  result+=key[Integer.parseInt(""+preBarcode.charAt(i))];
	  }
      return preBarcode+ "  " +"|"+result + "|";
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
	  throw new IllegalArgumentException("zip should contain only digits");
      }
      String result= "";
      String preBarcode= zip+checkSum(zip);
      for(int i = 0; i < preBarcode.length(); i++){
	  result+=key[Integer.parseInt(""+preBarcode.charAt(i))];
	  }
      return "|"+result + "|";
  }

//Splits string
    private static List<String> getParts(String s, int portion) {
	List<String> parts = new ArrayList<String>();
	int l = s.length();
	for (int i=0; i<l; i+=portion){
	    parts.add(s.substring(i, Math.min(l, i + portion)));
        }
        return parts;
    }
//checks if a string is part of an array
//will check if the encoded are valid
    public static boolean valid(String[] key, String check) {
	return Arrays.asList(key).contains(check);
    }

//Converts a barcode to a 5 digit zip
//Parameters:code - the barcode to convert into a zipcode
//Returns:the 5 digit zipcode
//Throws:java.lang.IllegalArgumentException - when:checksum is invalid; encoded ints are invalid; non-barcode characters are used;
//length of the barcode is not 32; the left and rigthmost charcters are not '|'*/
    public static String toZip(String code){
	if(code.charAt(0)!='|' || code.charAt(code.length()-1)!='|'){
	    throw new IllegalArgumentException("the left and/or rigthmost characters are not '|'");
	}
	if(code.length()!=32){
	    throw new IllegalArgumentException("length of the barcode is not 32");
	}
	for(int i=0; i<code.length(); i++){
	    if(code.charAt(i)!='|' && code.charAt(i)!=':'){
		throw new IllegalArgumentException("non-barcode characters are used");
	    }
	}
	String preCode =code.substring(1,31);
	for(String part : getParts(preCode, 5)) {
	    if(!(valid(key,part))){
                throw new IllegalArgumentException("encoded ints are invalid");
	    }
	}
	String preZip ="";
	for(String part : getParts(preCode, 5)) {
	    for(int i =0; i< key.length;i++){
		if(part.equals(key[i])){
		    preZip+=i;
		    break;
		}
	    }
	}
	String zip= preZip.substring(0,5);
	int checkDigit= (int)(preZip.charAt(5)-'0');
	if(checkSum(zip)!=checkDigit){
	    throw new IllegalArgumentException("checksum is invalid");
	}
	else{
	    return zip;
	}
    }

    public static void main(String args[]){
	Barcode b = new Barcode("08451");
	System.out.println(b); //084518  |||:::|::|::|::|:|:|::::|||::|:|
	System.out.println(toZip("|||:::|::|::|::|:|:|::::|||::|:|")+checkSum("08451")+"  "+toCode("08451"));//same as above
	System.out.println(b.toString().compareTo("084518  |||:::|::|::|::|:|:|::::|||::|:|")); //0
	System.out.println(toCode("08451").compareTo("|||:::|::|::|::|:|:|::::|||::|:|")); //0
	System.out.println(b.compareTo(b)); //0
	System.out.println((new Barcode("11426")).compareTo(new Barcode("11426"))); //0
	System.out.println((new Barcode("99999")).compareTo(b)); //some positive, preferably 1
	System.out.println((new Barcode("01111")).compareTo(b)); //some negative, preferably -1
	System.out.println(b.compareTo(new Barcode("01111"))); //some negative, preferably 1
	System.out.println(b.compareTo(new Barcode("99999"))); //some positive, preferably -1
	int sum= 0;
	try{
	//length
	  System.out.println((new Barcode("123456")));
	  }catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	//length
	  System.out.println(toCode("123456"));
	  }catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	  //length
	  System.out.println((new Barcode("1234")));
	  }catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	  //length
	  System.out.println(toCode("1234"));
	  }catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	  //type
	  System.out.println((new Barcode("12.45")));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	  //type
	  System.out.println(toCode("12.45"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	  //type
	  System.out.println((new Barcode("12a45")));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	  //type
	  System.out.println(toCode("12a45"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	  //type
	  System.out.println((new Barcode("12/45")));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	  //type
	  System.out.println(toCode("12/45"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	  //length
	    System.out.println(toZip("|||:::|:::|::|::|:|:|::::|||::|:|"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	  //length
	    System.out.println(toZip("|||:::|::|::|::||:|::::|||::|:|"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	  //nonbarcode char were used
	    System.out.println(toZip("|||:::|::|::|a:|:|:|::::|||::|:|"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	  //nonbarcode char were used
	    System.out.println(toZip("|||::::::|::||||:|:|:::::||::|:|"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	  //checkSum is wrong
	    System.out.println(toZip("|||:::|::|::|::|:|:|::::||||:::|"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	  //left or right is wrong
	    System.out.println(toZip(":||:::|::|::|::|:|:|::::||||:::|"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	try{
	  //left or right is wrong
	    System.out.println(toZip("|||:::|::|::|::|:|:|::::||||::::"));
	}catch(Exception e){
	    sum+=1;
	    e.printStackTrace();
	}
	System.out.println("\nThere were 17 errors, if youre not interested in type, just look below to make \nsure there are 17 lol\n");
	System.out.println("The number of errors caught were: "+ sum);
    }
}
