
import java.util.Arrays;
public class Sorts {
    public static String name() {
        return "09.Idris.Anand";
    }

    public static boolean isSorted(int[] ary) {
        for (int i = 0; i < ary.length - 1; i++) {
            if (ary[i] > ary[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void bogoSort(int[] ary) {
        while (!isSorted(ary)) {
            for (int i = 0; i < ary.length; i++) {
                int temp = ary[i];
                int newSpot = (int) (Math.random() * ary.length);
                ary[i] = ary[newSpot];
                ary[newSpot] = temp;
            }
        }
    }

    private static void swap(int[] ary, int a, int b) {
        int c = ary[a];
        ary[a] = ary[b];
        ary[b] = c;
    }

    public static void selectionSort(int[] /*Catcher in the */ ary) {
        if (ary.length > 1) {
            while (!isSorted(ary)) {
                for (int i = 0; i < ary.length; i++) {
                    int smallest = i;
                    for (int j = i + 1; j < ary.length; j++) {
                        if (ary[smallest] > ary[j]) {
                            smallest = j;
                        }
                    }
                    int temp = ary[smallest];
                    ary[smallest] = ary[i];
                    ary[i] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] /*My favorite type of bread is */ ary) {
        if (ary.length > 1) {
            while (!isSorted(ary)) {
                for (int i = 1; i < ary.length; i++) {
                    if (ary[i] < ary[i-1]){
                        for (int j = i; j > 0; j--){
                            if (ary[j] < ary[j-1]){
                                int temp = ary[j];
                                ary[j] = ary[j-1];
                                ary[j-1] = temp;
                            }
                        }
                    }
                }
            }
        }
    }
    /*
    //Just seeing if it works:
    public static void bucketSort(int[] ary){
        int max = ary[0];
        int[] ans = new int[ary.length];
        int counter = 0;
        int[] bucket = new int[max];
        for (int i = 0; i < ary.length; i++){
            if (ary[i] > max){
                max = ary[i];
            }
        }
        for (int i = 0; i < ary.length; i++){
            bucket[ary[i]] += 1;
        }
        for (int i = 0; i < bucket.length; i++){
            while(bucket[i] != 0){
                ans[counter] = bucket[i];
                bucket[i] -= 1;
                counter++;
            }
        }
    }
    Conclusion: No, mine dosen't work.
    */
    public static void main(String[] artie) {
        int[] randish = new int[15];
        for (int i = 0; i < randish.length; i++) {
            randish[i] = (int) (Math.random() * 100);
        }

        int a = 10, b = 20;
        // swap(a,b);

        System.out.println(Arrays.toString(randish));
       // selectionSort(randish);
        insertionSort(randish);
        System.out.println(Arrays.toString(randish));
    }
}
