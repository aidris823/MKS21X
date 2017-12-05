
import java.util.*;
import java.io.*;

public class WordSearch {

    private ArrayList<String> wordsToAdd = new ArrayList<String>();
    private ArrayList<String> wordsAdded = new ArrayList<String>();
    private Random randgen;


    private char[][] data;
    private char[][] solution;
    private int rowCount;
    private int colCount;
    private int seedNo;

    public WordSearch(int rows, int cols) {
        randgen = new Random();
        data = new char[rows][cols];
        solution = new char[rows][cols];
        rowCount = rows;
        colCount = cols;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i][j] = '_';
            }
        }
        clear();
    }

    public WordSearch(int rows, int cols, String fileName) {
        data = new char[rows][cols];
        rowCount = rows;
        colCount = cols;
        randgen = new Random();

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i][j] = '_';
            }
        }
        clear();
        try {
            File f = new File(fileName);
            Scanner in = new Scanner(f);
            while (in.hasNext()) {
                String line = in.nextLine();
                wordsToAdd.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            System.exit(1);
        }
        addAllWords();
        solutionMaker();
        char[] alphabet =  {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data.length; j++){
                if (data[i][j] == '_'){
                    data[i][j] = alphabet[randgen.nextInt(25)];
                }
            }
        }
    }

    public WordSearch(int rows, int cols, String fileName, int randSeed) {
        data = new char[rows][cols];
        rowCount = rows;
        colCount = cols;
        randgen = new Random(randSeed);
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i][j] = '_';
            }
        }
        clear();
        try {
            File f = new File(fileName);
            Scanner in = new Scanner(f);
            while (in.hasNext()) {
                String line = in.nextLine();
                wordsToAdd.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            System.exit(1);
        }
        addAllWords();
        solutionMaker();
        char[] alphabet =  {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data.length; j++){
                if (data[i][j] == '_'){
                    data[i][j] = alphabet[randgen.nextInt(25)];
                }
            }
        }
    }


    private void clear() {
        for (int i = 0; i <= rowCount - 1; i++) {
            for (int j = 0; j <= colCount - 1; j++) {
                data[i][j] = '_';
            }
        }
    }

    public void solutionMaker(){
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data.length; j++){
                solution[i][j] = data[i][j];
            }
        }
    }

    public String toString(char[][] x){
        String ans = "";
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                ans += Character.toString(data[i][j]);
                System.out.println("" + i);
                System.out.println("" + j);
                ans += " ";
                if ((j + 1) == colCount) {
                    ans += "\n";
                }
            }
        }
        return ans;
    }

    //View a list of added words:
    public String getAddedWords() {
        String ans = "[";
        for (int i = 0; i < wordsAdded.size(); i++) {
            ans += wordsAdded.get(i);
            ans += " ,";
        }
        ans += "]";
        return ans;
    }

    public String getSolution() {
        addAllWords();
        return toString();
    }

    public boolean addWord(int r, int c, String word, int rowIncrement, int colIncrement) {
        int wLength = word.length();
        int dLength = data.length;
        if (rowIncrement == 0 && colIncrement == 0){
            return false;
        }
        if (r > data.length || c > data.length){
            return false;
        }
        char[] wordBroken = new char[wLength];
        for (int i = 0; i < wordBroken.length; i++){
            wordBroken[i] = word.charAt(i);
        }
        for (int i = 0; i < wLength; i++){
            data[r+wLength*colIncrement][c+wLength*rowIncrement] = wordBroken[i];
        }
        wordsAdded.add(word);
        wordsToAdd.remove(word);
        return true;
    }


    public boolean addAllWords() {
        int count = 0;
        int x = 0;
        int wordSize = wordsToAdd.size();

        if (data.length != 0){
            while (wordsToAdd.size() != 0 && count < 1000){
                int r = randgen.nextInt()%2;
                while (r == 0){
                    r = randgen.nextInt()%2; //Do it again!
                }
                int c = randgen.nextInt()%2;
                while (c == 0){
                    c = randgen.nextInt()%2; //Also, do it again!
                }
                addWord(randgen.nextInt(data.length),randgen.nextInt(data.length),wordsToAdd.get(x),r,c);
                count++;
            }
        }
        return true;
    }


    public static void main(String[] arguments) {
        if (arguments.length == 0) {
            System.out.print("Hello there!  My name is Anand.  This is my Word Search project.  Allow me to teach you how to use it:"
                    + "\n" + "In your terminal, you have a plethora of arguments: rows, cols, filename, randomSeed, and answers." + "\n" + "Rows (int) and cols (int) " +
                    "lets you set how big you want the puzzle to be." +
                    "filename (String) is, well, the file whose words you want scanned." + "\n" +
                    "Please note that if you start putting arguments, the rows, columns, and filename MUST be there at least." +
                    "randomSeed (int) is the seed through you want to sort everything." + "\n" + "Answers gives the answers." + "\n" + "Enjoy the quiz!");
        } else {
            try {
                if (arguments.length == 3) {
                    WordSearch wdSearch = new WordSearch(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]), arguments[2]);
                }
                if (arguments.length == 4) {
                    WordSearch wdSearch = new WordSearch(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]), arguments[2], Integer.parseInt(arguments[3]));
                }
                if (arguments.length == 5) {
                    WordSearch wdSearch = new WordSearch(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]), arguments[2], Integer.parseInt(arguments[3]));
                    System.out.println(wdSearch.getSolution());
                }
            } catch (IllegalArgumentException e) {
                System.out.print("Hello there!  My name is Anand. This is my Word Search project. It appears you entered the arguments incorrectly.  No worries, I'll teach you how it works:"
                        + "\n" + "In your terminal, you have a plethora of arguments: rows, cols, filename, randomSeed, and answers." + "\n" + "Rows (int) and cols (int) " +
                        "lets you set how big you want the puzzle to be." +
                        "filename (String) is, well, the file whose words you want scanned." + "\n" +
                        "Please note that if you start putting arguments, the rows, columns, and filename MUST be there at least." +
                        "randomSeed (int) is the seed through you want to sort everything." + "\n" + "Answers gives the answers." + "\n" + "Enjoy the quiz!");
            }
        }
    }
}
