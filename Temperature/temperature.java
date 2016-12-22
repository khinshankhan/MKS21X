//importations
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class temperature extends JFrame implements ActionListener{

    private Container pane;
    private JButton cf;
    private JButton fc;
    private JLabel TEMP;
    private JLabel EQUAL;
    private JTextField t;
    private JTextField output;

    public temperature(){
	this.setTitle("Temperature Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
    
	TEMP = new JLabel("Temperature:",null,JLabel.CENTER);
	EQUAL = new JLabel("Equals:",null,JLabel.CENTER);
        output = new JTextField(15);
	output.setEditable(false);
	t = new JTextField(15);
	cf = new JButton("Convert to Farenheit");
	cf.addActionListener(this);
	cf.setActionCommand("1");
	fc = new JButton("Convert to Celcius");
	fc.addActionListener(this);
	fc.setActionCommand("2");

	pane.add(TEMP);
	pane.add(t);
	pane.add(EQUAL);
	pane.add(output);
	pane.add(cf);
	pane.add(fc);

    }

    public void actionPerformed(ActionEvent e){
	final String DEGREE  = "\u00b0";
	if(e.getActionCommand().equals("1")){
	    output.setText(Double.toString(CtoF(Double.parseDouble(t.getText())))+DEGREE+"F");
	}
	else if(e.getActionCommand().equals("2")){
	    output.setText(Double.toString(FtoC(Double.parseDouble(t.getText())))+DEGREE+"C");
	}
    }

    public static double CtoF(double t){
	return (t*1.8+32);
    }
    public static double FtoC(double t){
	return ((t-32)*5/9);
    }
    
    public static void main(String[] a){
	temperature w = new temperature();
	w.setVisible(true);
    }
}
