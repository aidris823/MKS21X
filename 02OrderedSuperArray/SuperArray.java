import java.util.*;
public class SuperArray{
    private String[] data = new String[10];
    private int size = 0;

    public SuperArray(String[] d) {
        data = d;
    }

    public void clear() {
        data = new String[data.length];
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return data.length;
    }

    public boolean isEmpty() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                return false;
            }
        }
        return true;
    }

    public boolean add(String element) {
        String[] newData = new String[data.length + 1];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        if (isEmpty()){
            data = new String[1];
            data[0] = element;
            return true;
        }
        newData[newData.length - 1] = element;
        data = newData;
        return true;
    }

    public String toString() {
        String ans = "[";
        for (int i = 0; i < data.length; i++) {
            ans += data[i];
            if (i != data.length - 1) {
                ans += ",";
            }
        }
        ans += "]";
        return ans;
    }

    public String get(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("That index is larger than the array's possible indexes, you fool!");
            return null;
        }
        return data[index];
    }

    public String set(int index, String element) {
        if (index < 0 || index >= size()) {
            System.out.println("That index is bigger than the array's possible indexes, you fool!");
            return null;
        }
        String buffer = data[index];
        data[index] = element;
        return buffer;
    }

    private void resize() {
        size = data.length * 2;
        String[] newData = new String[size];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public boolean contains(String element) {
        if (isEmpty()){
            return false;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(String element) {
        if (isEmpty()){
            return -1;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String element) {
        String[] revData = new String[data.length];
        int j = 0;
        if (isEmpty()){
            return -1;
        }
        for (int i = size() - 1; i >= 0; i--) {
            revData[j] = data[i];
            j++;
        }
        for (int i = 0; i < revData.length; i++) {
            if (revData[i].equals(element)) {
                return size() - i - 1;
            }
        }
        return -1;
    }

    public void add(int index, String element) {
        this.resize();
        for (int i = index; i < data.length; i++) {
            data[i] = data[i + 1];
        }
        data[index] = element;
    }
    public String remove(int index){
        String ans = data[index];
        for (int i = data.length - 1; i < index; i--){
            data[i] = data[i-1];
        }
        data[index] = null;
        return ans;
    }
    public boolean remove(String element){
        size = -1;
        for (int i = 0; i < data.length; i++){
            if (data[i].equals(element)) {
                size = i;
            }
        }
        for (int i = data.length - 1; i < size; i--){
            data[i] = data[i-1];
        }
        data[size] = null;
        return (size != -1);
    }
    public static void main(String[] arguments){
        System.out.println("SuperArray main method!");
    }
}
