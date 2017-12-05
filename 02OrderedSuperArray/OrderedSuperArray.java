public class OrderedSuperArray extends SuperArray {

    public String set(int index, String element){
        throw new UnsupportedOperationException();
    }

    public void add(int index, String element){
        super.add(index, element);
    }

    public OrderedSuperArray(){
        super();
    }

    public OrderedSuperArray(int capacity){
        super(capacity);
    }

    public OrderedSuperArray(String[] array){
        for (int i = 0; i < array.length; i++){
            super.add(array[i]);
        }
    }

    public boolean add(String value){
        if (size() == 0){
            super.add(value);
        }
        else{
            //int x = findIndex(value);
            int x = findIndexBinary(value);
            super.add(x,value);
        }
        return true;
    }

    private int findIndex(String x){
        for (int i = 0; i < size(); i++){
            if (x.compareTo(super.get(i)) <= 0){
                return i;
            }
        }
        return size() - 1;
    }

    private int findIndexBinary(String x){
        int start = 0;
        int end = size() - 1;
        int mid = end / 2;
        while (mid != end || mid != start){
            if (x.compareTo(super.get(mid)) <= 0){
                end = mid;
                mid = end / 2;
            }
            else {
                start = mid;
                mid = end / 2;
            }
        }
        if (start == mid){
            return start;
        }
        return end;
    }

    public int indexOfBinary(String x){
        return findIndexBinary(x);
    }
}
