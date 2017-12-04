
import java.util.*;
public class SuperArrayIterator implements Iterator{
    //Where the iterator currently is:
    private int current;
    //Where do we stop?  Here:
    private int stop;
    //The SuperArray we'll be looking at:
   public SuperArray sArray;

    public SuperArrayIterator(int c, int s, SuperArray sa){
        current = c;
        stop = s;
        sArray = sa;
    }
    /*Iterator will go through the SuperArray starting at/currently at current
      all the way to where stop is. */
    public boolean hasNext(){
        return current <= stop;
    }
    public String next(){
        if (hasNext()){
            current++;
        }
        else{
            System.exit(1);
        }
        return sArray.get(current-1);
    }
    //Unsupported operation:
    public void remove(){
        throw new UnsupportedOperationException();
    }
}


