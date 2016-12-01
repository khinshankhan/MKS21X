public class ReferenceBook extends LibraryBook{
    
    private String collection;
    
    public ReferenceBook(String author, String title, String ISBN, String callNumber, String collection){
	super(author, title, ISBN, callNumber);
	this.collection=collection;
    }
    
     public void setCollection(String collection) {
       this.collection = collection;
    }
    public String getCollection() {
        return collection;
    }
    
    public void checkout(String patron, String due){
	System.out.println("Cannot check out a reference book.");
    }
    public void returned(){
	System.out.println("Reference book could not have been checked out -- return impossible.");
    }
    public String circulationStatus(){
	System.out.println("Non-circulating reference book");
	return "";
    }
    public String toString(){
	return super.toString()+"\nCollection: "+collection;
        }
}
