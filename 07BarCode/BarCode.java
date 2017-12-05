public class BarCode{
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
    //You technically don't need a Barcode String because ZipCode can calculate that.
    private String zip;
    //I chose to make one anyway.:
    private String barcode = "|";
    //Constructor:
    public BarCode(String z){
	zip = z;
	int sum = 0;
	for (int i = 0; i < z.length(); i++){
	    sum += Integer.parseInt(z.substring(i,i+1));
	}
	sum %= 10;
	zip += sum;
	for (int i = 0; i < z.length(); i++){
	    barcode += codes[Integer.parseInt(z.substring(i,i+1))];
	}
	barcode += "|";
    }
    public String toString(){
	return barcode + " (" + zip + ")";
    }
    public String getZip(){
	return zip.substring(0,zip.length()-2);
    }
    public String getCode(){
	return barcode;
    }
    public boolean equals(BarCode b){
	return (compareTo(b) == 0);
    }
    public int compareTo(BarCode b){
	return (this.barcode).compareTo(b.getCode());
    }
    public static void main(String[] arguments){
	String qwerty = "125358";
	BarCode x = new BarCode(qwerty);
	System.out.println(x.getZip());
	System.out.println(x.getCode());
    }
}
    
				    
