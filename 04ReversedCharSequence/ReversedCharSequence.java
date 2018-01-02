

public class ReversedCharSequence implements CharSequence {
    private String revChar;

    public ReversedCharSequence(String x) {
        String blanc = "";
        for (int i = x.length() - 1; i >= 0; i--) {
            blanc += x.charAt(i);
        }
        revChar = blanc;
    }

    public char charAt(int index) {
        return revChar.charAt(index);
    }

    public CharSequence subSequence(int start, int end) {
        return revChar.substring(start, end);
    }

    public int length() {
        return revChar.length();
    }
    public String toString(){
        return revChar;
    }
    /*
    public static void main(String[] arguments) {
	ReversedCharSequence fmercury = new ReversedCharSequence("BURKINAFASO");
	System.out.println(fmercury);
	for (int i = 0; i < fmercury.length(); i++) {
	    System.out.println(fmercury.charAt(i));
	}
	System.out.println(fmercury.subSequence(0, 4));
	System.out.println(fmercury.subSequence(1, 6));
    }
    */
}


