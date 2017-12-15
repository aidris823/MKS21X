
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureWindow extends JFrame implements ActionListener{
    //Fields:
    private Container pane;
    private JButton b;
    private JTextField t;
    private JCheckBox c;
    private JLabel l;

    //Takes a double and returns that double to Fahrenheit form, assuming that double was originally Celsius.
    public static double CtoF(double t){
	return (t * 1.8 + 32);
    }
    //Takes a double and returnst that double to Celsius form on the assumption that the number given was in Fahrenheit.
    public static double FtoC(double t){
	return ((t - 32) * (5.0/9));
    }
    
    public TemperatureWindow(){
	//Create the actual window:
	this.setTitle("That's why they call me Mr. Fahrenheeeeiiiiiiiit");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	//Give value, meaning, and worth to these once useless widgets:
	b = new JButton("Convert Temperature");
	b.addActionListener(this);
	t = new JTextField(12);
	t.addActionListener(this);
	c = new JCheckBox("Temperature Convert: Celsius to Fahrenheit");
	c.addActionListener(this);
	l = new JLabel("Temperature Convert" + "\n");

	//Let's paint some happy little widgets.
	pane.add(l);
	pane.add(b);
	pane.add(t);
	pane.add(c);	
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if(event.equals("Convert Temperature")){
	    try{
		if (c.isSelected()){
		    t.setText("" + CtoF(Double.parseDouble(t.getText())));
		}
		else{
		    t.setText("" + FtoC(Double.parseDouble(t.getText())));
		}
	    }
	    //Catch non-numbers:
	    catch(IllegalArgumentException argex){
		t.setText("You must convert a number.");
	    }
	}
    }

		 
		 
    public static void main(String[] arguments){
	TemperatureWindow f = new TemperatureWindow();
	f.setVisible(true);
	}
}
		 
		 
		 
