public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    //Constructor:
    public LibraryBook(String a, String t, String i, String cn){
	super(a,t,i);
	callNumber = cn;
    }
    // Get Functions:
    public String getCallNumber(){
	return callNumber;
    }
    //Set Functions:
 
    public void setCallNumber(String cn){
	callNumber = cn;
    }
    //Abstract Functions:
    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();
    //CompareTo function which compares the CallNumber between this class' callNumber and another class' callNumber.
    public int compareTo(LibraryBook x){
	return (this.callNumber).compareTo(x.getCallNumber());
    }
    //Forms String in order of "author, title, ISBN, callNumber".
    public String toString(){
	return getAuthor() + ", " + getTitle() + ", " + getISBN() + ", " + callNumber;
    }
}
