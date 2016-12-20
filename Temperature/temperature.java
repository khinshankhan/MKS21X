public class temperature{
    public static double CtoF(double t){
	return (t*1.8+32);
    }
    public static double FtoC(double t){
	return ((t-32)*5/9);
    }
    public static void main(String[] a){
	System.out.println(FtoC(-40));
	System.out.println(FtoC(212));
    }
}
