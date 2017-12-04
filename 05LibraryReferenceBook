public class ReferenceBook extends LibraryBook{
    private String collection;
    public ReferenceBook(String a, String t, String i, String cn, String c){
	super(a,t,i,cn);
	collection = c;
	
    }
    //Get Functions:
    public String getCollection(){
	return collection;
    }
    //Set Functions:
    public void setCollection(String c){
	collection = c;
    }
    public void checkout(String patron, String due){
	System.out.println("Cannot check out a reference book.)");
    }
    public void returned(){
	System.out.println("Reference book could not have been checked out - return impossible.");
    }
    public String circulationStatus(){
	return "Non-circulating reference book";
    }
    public String toString(){
	return getAuthor() + ", " + getTitle() + ", " + getISBN() + ", " + getCallNumber() + ", " + collection;
    }
}
	    
