public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String a, String t, String i, String cn){
	super(a,t,i,cn);
	currentHolder = null;
	dueDate = null;
    }
    //Get Functions:
    public String getCurrentHolder(){
	return currentHolder;
    }
    public String getDueDate(){
	return dueDate;
    }
    //Set Functions:
    public void setCurrentHolder(String ch){
	currentHolder = ch;
    }
    public void setDueDate(String dd){
	dueDate = dd;
    }
    //Stores patron's name and the date is due in fields:
    public void checkout(String name, String date){
	currentHolder = name;
	dueDate = date;
    }
    //Handles returning a book, sets holder and due date back to null.
    public void returned(){
	currentHolder = null;
	dueDate = null;
    }
    public String circulationStatus(){
	if (currentHolder == null && dueDate == null){
	    return "Book available on shelves";
	}
	return "Holder: " + currentHolder + "\n" + "Due on: " + dueDate;
    }
    public String toString(){
	String ans = "";
	ans += getAuthor() + ", " + getTitle() + ", " + getISBN() + ", " + getCallNumber();
	if (currentHolder != null && dueDate != null){
	    ans += currentHolder + ", " + dueDate;
	}
	return ans;
    }
}
	
    
