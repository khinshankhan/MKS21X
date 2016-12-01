public class CirculatingBook extends LibraryBook{
    
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String author, String title, String ISBN, String callNumber){
	super(author, title, ISBN, callNumber);
	currentHolder="";
	dueDate="";
    }
    
    public void setCurrentHolder(String patron) {
       currentHolder=patron;
    }
    public String getCurrentHolder() {
        return currentHolder;
    }
    public void setDueDate(String due) {
       dueDate=due;
    }
    public String getDueDate() {
        return dueDate;
    }
    
    public void checkout(String patron, String due){
	currentHolder = patron;
	dueDate = due;
    }
    public void returned(){
	currentHolder = "";
	dueDate = "";
    }
    public String circulationStatus(){
	if(currentHolder.equals("") && dueDate.equals("")){
	    return "Book available on shelves";
	}
	else{
	    return ("Book is currently borrowed by " + currentHolder + " and is due on " + dueDate);
	}
    }
    public String toString(){
	return super.toString()+"\nCurrent Holder: "+currentHolder+"\nDue Date : "+dueDate;
        }
}
