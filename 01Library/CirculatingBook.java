public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String author, String title, String ISBN, String callNumber){
	super(author, title, ISBN, callNumber);
	this.currentHolder="";
	this.dueDate="";
    }
    
    public void setCurrentHolder(String currentHolder) {
       this.currentHolder=currentHolder;
    }
    public String getCurrentHolder() {
        return currentHolder;
    }
    public void setDueDate(String dueDate) {
       this.dueDate=dueDate;
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
	    return "Book is currently borrowed by " + currentHolder + " and is due on " + dueDate;
	}
    }
    }
    public String toString(){
	return super.toString()+"\n"+"Current Holder: "+this.currentHolder+"\n"+"Due Date : "+this.dueDate;
        }
}
