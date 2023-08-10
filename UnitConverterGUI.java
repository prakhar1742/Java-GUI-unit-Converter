package unitconverter;
import javax.swing.*;
import java.awt.event.*;
public class UnitConverterGUI{
	private JFrame frame;
	private JTextField input;
	private JTextField output;
	private JComboBox<String> fromUnit;
	private JComboBox<String> toUnit;
	private JLabel inputLabel,outputLabel;
	private JButton convert;
	protected void initComponents() {
		frame=new JFrame("Unit Converter");
		frame.setSize(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		inputLabel=new JLabel("Input ");
		input=new JTextField("10");
		outputLabel=new JLabel("output ");
		fromUnit=new JComboBox<String>(new String[] {"Meter","Feet","Inches","Centimeters"});
		toUnit=new JComboBox<String>(new String[] {"Meter","Feet","Inches","Centimeters"});
		output=new JTextField();
		convert=new JButton("Convert");
		output.setEditable(false); 
		inputLabel.setBounds(20,50,100,20);
		input.setBounds(150,50,100,20);
		outputLabel.setBounds(20,80,100,20);
		output.setBounds(150,80,100,20);
		fromUnit.setBounds(270,50,100,20);
		toUnit.setBounds(270,80,100,20);
		convert.setBounds(155, 120, 100, 20);
		convert.addActionListener(new ConvertButtonListener());
		
		frame.add(convert); frame.add(fromUnit);
		frame.add(input); frame.add(inputLabel);
		frame.add(output); frame.add(outputLabel);
		frame.add(toUnit); 
		frame.setVisible(true);
		
	}
	public UnitConverterGUI(){
		initComponents();
		
	}
	public static void main(String []args) {
		new UnitConverterGUI();
	}
	
	private class ConvertButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			 String fromUnitType=fromUnit.getSelectedItem().toString();
			 String toUnitType=toUnit.getSelectedItem().toString();
			 double inputValue=Double.parseDouble(input.getText());
			 double outputValue=0.0;
			 if(fromUnitType.equals("Meter")) {
				 if(toUnitType.equals("Meter")) {
					 outputValue=inputValue;
				 }
				 else if(toUnitType.equals("Feet")) {
					 outputValue=3.2*inputValue;
					 
				 }
				 else if(toUnitType.equals("Inches")) {
					 outputValue=39.3700787*inputValue;
					 
				 }else if(toUnitType.equals("Centimeters")) {
					 
					 outputValue=100*inputValue;
				 }
				 
			 }
			 else if(fromUnitType.equals("Feet")) {
				 if(toUnitType.equals("Meter")) {
					 outputValue=0.3048*inputValue;
				 }
				 else if(toUnitType.equals("Feet")) {
					 
					 outputValue=inputValue;
				 }
				 else if(toUnitType.equals("Inches")) {
					 outputValue=12*inputValue;
					 
				 }else if(toUnitType.equals("Centimeters")) {
					 
					 outputValue=30.48*inputValue;
				 }
				 
			 }
			 else if(fromUnitType.equals("Inches")) {
				 if(toUnitType.equals("Meter")) {
					 outputValue=0.0254*inputValue;
				 }
				 else if(toUnitType.equals("Feet")) {
					 outputValue=0.083333*inputValue;
					 
				 }
				 else if(toUnitType.equals("Inches")) {
					 
					 outputValue=inputValue;
				 }else if(toUnitType.equals("Centimeters")) {
					 
					 outputValue=2.54*inputValue;
				 }
				 
			 }else if(fromUnitType.equals("Centimeters")) {
				 if(toUnitType.equals("Meter")) {
					 outputValue=0.01*inputValue;
				 }
				 else if(toUnitType.equals("Feet")) {
					 
					 outputValue=0.0328*inputValue;
				 }
				 else if(toUnitType.equals("Inches")) {
					 outputValue=0.3937*inputValue;
					 
				 }else if(toUnitType.equals("Centimeters")) {
					 
					 outputValue=inputValue;
				 }
				 
			 }
			 
			 output.setText(""+outputValue);
		}
		
	}
}
