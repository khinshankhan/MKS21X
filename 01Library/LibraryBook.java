abstract class LibraryBook extends Book implements Comparable<LibraryBook>
{
    private String callNumber;
    
    public Book(String author, String title, String ISBN){
	super(author, title, ISBN);
	this.callNumber=callNumber;
    }

    public void setCallNumber(String callNumber) {
       this.callNumber = callNumber;
    }
    public String getCallNumber() {
        return callNumber;
    }

    public abstract void checkout(String patron, String due);
    public abstract void returned();
    public abstract String circulationStatus();
    
    public int compareTo(LibraryBook o){
	return callNumber.compareTo(o.getCallNumber());
    }
    public String toString(){
	return super.toString()+"\n"+"Circulation Status #: "
	    +circulationStatus();+"\n"+"Call Number: "
	    +this.callNumber;
        }
}
