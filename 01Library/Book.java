public class Book{
  private String author;
  private String title;
  private String ISBN;
  
  public void setAuthor(String author) {
       this.author = author;
    }
  public void setTitle(String title) {
       this.title = title;
    }
  public void setISBN(String ISBN) {
       this.ISBN = ISBN;
    }
  
  public String getAuthor() {
        return author;
    }
  public String getTitle() {
        return title;
    }
  public String getISBN() {
        return ISBN;
    }
  
  public Book()
  {
      this.author="John Doe";
      this.title="Life is a Joke";
      this.ISBN="000-0-00000-000-0";
  }
  public Book(String author, String title, String ISBN)
  {
      this.author=name;
      this.title=title;
      this.ISBN=ISBN;
  }
  public String toString(){
    return "Book has the folllowing parameters:"\n"+ "+"Author: "
	+this.author+"\n"+"Title: "+this.title+"\n"+"ISBN #: "
	+this.ISBN;
  }
}
