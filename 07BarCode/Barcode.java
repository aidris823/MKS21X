
public class Barcode implements Comparable<Barcode> {
    //The *nuclear* codes:
    private String[] codes = {"||:::",
                ":::||",
                "::|:|",
                "::||:",
                ":|::|",
                ":|:|:",
                ":||::",
                "|:::|",
                "|::|:",
                "|:|::"};
    //You don't need a code String because Zipcode can calculate that.  Therefore, we just have a zip.
    private String zip;
    //Constructor:
    public Barcode(String _zip) {
        if (_zip.length() != 5) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < _zip.length(); i++) {
            if (!Character.isDigit(_zip.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
        zip = _zip;
    }
    //To String function; Returns "[code + check number] (zip)"
    public String toString() {
        String ans = "|";
        for (int i = 0; i < zip.length(); i++) {
            ans += codes[Integer.parseInt(zip.substring(i,i+1))];
        }
        int check = 0;
        for (int i = 0; i < zip.length(); i++) {
            check += Integer.parseInt(zip.substring(i,i+1));
        }
        check %= 10;
        ans += codes[check] + "|" + " (" + zip + ")";
        return ans;
    }
    //Compares objects with class Barcode by their numerical order.
    public int compareTo(Barcode other) {
        return (this.zip).compareTo(other.getZip());
    }
    //Static function that don't need no outside zip; converts a 5 digit zipcode to code.
    public static String toCode(String zip){
        String[] codes = {"||:::",
                ":::||",
                "::|:|",
                "::||:",
                ":|::|",
                ":|:|:",
                ":||::",
                "|:::|",
                "|::|:",
                "|:|::"};
        if (zip.length() != 5) {
            System.out.println(""+zip.length());
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < zip.length(); i++) {
            if (!Character.isDigit(zip.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
        String ans = "|";
        for (int i = 0; i < zip.length(); i++) {
            ans += codes[Integer.parseInt(zip.substring(i,i+1))];
        }
        int check = 0;
        for (int i = 0; i < zip.length(); i++) {
            check += Integer.parseInt(zip.substring(i,i+1));
        }
        check %= 10;
        ans += codes[check] + "|";
        zip = ans;
        return zip;
    }
    //Throws IllegalArgumentException if checksum is not valid, the sequence is not valid, non-barcode characters are in use, barcode's length is not 32, or if the left and rightmost characters aren't "|".
    public static String toZip(String code) {
        String rawCode = new String(code.substring(1, code.length() - 6));
        String zip = "";

        String[] codes = {"||:::",
                ":::||",
                "::|:|",
                "::||:",
                ":|::|",
                ":|:|:",
                ":||::",
                "|:::|",
                "|::|:",
                "|:|::"};

        if (code.length() != 32 || code.charAt(0) != '|' || code.charAt(code.length() - 1) != '|') {
            throw new IllegalArgumentException();
        }


        for (int i = 0; i < code.length()-1; i++){
            if ((code.charAt(i) != ':') && (code.charAt(i) != '|')){
                throw new IllegalArgumentException();
            }
        }


        for (int i = 0; i < rawCode.length(); i += 5){
            if ((rawCode.substring(i,i+5).equals(codes[0])) && (rawCode.substring(i,i+5).equals(codes[1])) && (rawCode.substring(i,i+5).equals(codes[2])) && (rawCode.substring(i,i+5).equals(codes[3])) &&
                    (rawCode.substring(i,i+5).equals(codes[4])) && (rawCode.substring(i,i+5).equals(codes[5])) && (rawCode.substring(i,i+5).equals(codes[6])) && (rawCode.substring(i,i+5).equals(codes[7])) &&
                    (rawCode.substring(i,i+5).equals(codes[8])) && rawCode.substring(i,i+5).equals(codes[9])){
                throw new IllegalArgumentException();
            }
        }

        for (int i = 0; i < rawCode.length(); i += 5){
            for (int j = 0; j < codes.length; j++){
                if ((rawCode.substring(i,i+5).equals(codes[j]))){
                    zip += j;
                }
            }
        }
        return zip;

    }
    public String getCode(){
        return toCode(zip);
    }
    public String getZip(){
        return zip;
    }
    public boolean equals(Barcode b) {
        return (compareTo(b) == 0);
    }

    public static void main(String[] arguments){
       // Barcode b = new Barcode("92010");
      //  System.out.println(b.toString());
        //I used Jason Lin's Driver to test my function here :
        Barcode a = new Barcode("11245");
        Barcode b = new Barcode("38760");
        Barcode c = new Barcode("11245");
        Barcode d = new Barcode("00294");

        System.out.println(a.getZip());//11245
        System.out.println(d.getZip());//00234
        System.out.println(a.getCode());// |:::||:::||::|:|:|::|:|:|:::||:|
        System.out.println(a.toString());// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
        System.out.println(b);// |::||:|::|:|:::|:||::||::::|::|| (38760)
        System.out.println(c);// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
        System.out.println(d);// |||:::||:::::|:||:|:::|::|:|:|:| (00294)
        System.out.println(a.compareTo(b));// negative
        System.out.println(a.compareTo(c));// 0
        System.out.println(a.compareTo(d));// positive
        System.out.println(a.equals(b));// false
        System.out.println(a.equals(c));// true
        System.out.println(a.equals(d));// false

        //My own tests;
        System.out.println(a.toZip("|:::||:::||::|:|:|::|:|:|:::||:|")); // Expected: 11245
       System.out.println(a.toCode("11245")); //Expected: |:::||:::||::|:|:|::|:|:|:::||:|
     //   System.out.println(a.toZip("|||||::::::::::::::::::::::::::::::::::::::")); //Expected: Exception
      //  System.out.println(a.toCode("12345")); //Expected: Exception
            }
        }
