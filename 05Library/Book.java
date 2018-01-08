public class Book{
 //The file with my original Book file was on my Desktop, so I had to rewrite this file.  
 //Luckily the info of what we had to write was on the website (posted on November 28th, 2017) and it was not very long code.
 
 //Fields:
  private String author;
  private String title;
  private String ISBN;
  
  //Null constructor:
  public Book(){
    author = "";
    title = "";
    isbn = "";
  }
  
  //Constructor for author, title, and ISBN:
  public Book(String a, String t, String isbn){
    author = a;
    title = t;
    ISBN = isbn;
 
 //Getters:
  public String getAuthor(){
    return author;
  }
  public String getTitle(){
    return title;
  }
  public String getISBN(){
   return ISBN;
 }
 
 //Setters: 
  public void setAuthor(String a){
    author = a;
    }
 public void setTitle(String t){
  title = t;
  }
  public void setISBN(String isbn){
    ISBN = isbn;
  }
  
  //ToString in "Title, Author, ISBN" format
  public String toString(){
    String ans = "" + title + "," + author + "," + ISBN;
    return ans;
  }
  public static void main(String[] arguments){
   System.out.println("Book");
  }
 }
 
  
