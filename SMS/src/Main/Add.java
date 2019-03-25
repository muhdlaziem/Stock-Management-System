package Main;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Add {

	public JFrame frame;
	private JTextField name;
	private JTextField productid;
	private JTextField quantity;
	private JTextField price;
	private JButton btnSave;
	private JButton btnBack;
	private JLabel lblType;
	private String namevalue;
	private String idvalue;
	private int quantityvalue;
	private double pricevalue;
	private int type;
	private JButton btnClear;
	private Boolean isIdEntered = false;
	private Boolean isNameEntered = false;

	//This Class is for function Add Item
	
	public Add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//customize frame
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/res/warehouse.png"))); // This so our program's icon
		frame.setTitle("Stock Management System");
		frame.getContentPane().setFont(new Font("Century Gothic", Font.BOLD, 21));
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(450, 200, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//label name
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Century Gothic", Font.BOLD, 21));
		lblName.setBounds(203, 152, 119, 41);
		frame.getContentPane().add(lblName);
		
		//name textField
		name = new JTextField();
		name.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 21));
		name.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!(name.getText().equals(""))) {
					namevalue = name.getText();                 //get product name from JTextField
					isNameEntered = true;						//indicate name is entered
				}
				
			}
		});
		name.setBounds(334, 152, 426, 41);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		//product id label
		JLabel lblProductId = new JLabel("Product ID:");
		lblProductId.setFont(new Font("Century Gothic", Font.BOLD, 21));
		lblProductId.setBounds(203, 70, 119, 41);
		frame.getContentPane().add(lblProductId);
		
		//product id TextField
		productid = new JTextField();
		productid.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 21));
		productid.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				for(int i = 0; i < Menu.Data.size(); i++) {                               //This loop is for checking if the new product already registered or not
					if(!(Menu.Data.get(i).getProductID().equals(productid.getText()))) {  
						idvalue = productid.getText();                                    //get product id from JTextField
						isIdEntered = true;												  //indicate product id is entered
					}
					else {
						JOptionPane.showMessageDialog(null, "This product is already added");  //this dialog message will show if product already added
						productid.setText("");
					}
						
				}
				
			}
		});
		productid.setColumns(10);
		productid.setBounds(334, 70, 426, 41);
		frame.getContentPane().add(productid);
		
		//quantity label
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Century Gothic", Font.BOLD, 21));
		lblQuantity.setBounds(203, 231, 119, 41);
		frame.getContentPane().add(lblQuantity);
		
		//quantity textField
		quantity = new JTextField();
		quantity.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 21));
		quantity.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost  (FocusEvent e) {
				if(!(quantity.getText().equals(""))) {
					try {
						quantityvalue = Integer.parseInt(quantity.getText());                      //get quantity value from JTextField
						}
						catch(NumberFormatException e1) {                                          //catch the NumberFormatException if user enter string value
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Please enter numeric value");     //and this dialog message will be shown
							quantity.setText("");
							
							
						}
				}
				
			}
		});
		quantity.setColumns(10);
		quantity.setBounds(334, 231, 426, 41);
		frame.getContentPane().add(quantity);
		
		//price label
		JLabel pricelabel = new JLabel("Price:");
		pricelabel.setFont(new Font("Century Gothic", Font.BOLD, 21));
		pricelabel.setBounds(203, 400, 119, 40);
		frame.getContentPane().add(pricelabel);
		
		//price TextField
		price = new JTextField();
		price.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 21));
		price.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e1) {
				if(!(price.getText().equals(""))) {
					try {
						pricevalue = Double.parseDouble(price.getText());                            //get price value from JTextField
						
						}
						catch(NumberFormatException e2) {                                            //catch the NumberFormatException if user enter string value
							
							JOptionPane.showMessageDialog(null, "Please enter numeric value");        //and this dialog message will be shown
							price.setText("");
							
							
						}
				}

			}
		});
		price.setColumns(10);
		price.setBounds(334, 400, 426, 40);
		frame.getContentPane().add(price);
		
		//save button
		btnSave = new JButton("SAVE");                    //this button is to save an object to ArrayList
		btnSave.setFont(new Font("Consolas", Font.BOLD, 21));
		btnSave.setBackground(new Color(255, 255, 255));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (type==1 && isIdEntered==true && isNameEntered==true) {                                   //check type, product name, product are already entered or not
					
						 Stock Electronic = new Electronic(namevalue,idvalue,pricevalue,quantityvalue);      //an object is created
						 Menu.Data.add(Electronic);                                                          //and store into the ArrayList
						 JOptionPane.showMessageDialog(null, "A product has been added");                    //this dialog message will be appeared once the product is added
				}
				else if(type==2 && isIdEntered==true && isNameEntered==true) {                               //same as above
					Stock Fabric = new Fabric(namevalue,idvalue,pricevalue,quantityvalue);
					 Menu.Data.add(Fabric);
					 JOptionPane.showMessageDialog(null, "A product has been added");
				}
				else {
					JOptionPane.showMessageDialog(null, "Please fill in the required  field");               //if required field is not completed, this dialog message will appear
				}
				
				
				
			}
		});
		btnSave.setBounds(146, 516, 180, 60);
		frame.getContentPane().add(btnSave);
		
		//back button
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Consolas", Font.BOLD, 21));
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Menu menu =new Menu();                                //call back menu JFrame
					frame.dispose();
					menu.frame.setVisible(true);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBack.setBounds(657, 516, 180, 60);
		frame.getContentPane().add(btnBack);
		
		//type label
		lblType = new JLabel("Type:");
		lblType.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblType.setBounds(204, 311, 119, 40);
		frame.getContentPane().add(lblType);
		
		//Electronic check box
		JCheckBox chckbxElectronic = new JCheckBox("Electronic");
		chckbxElectronic.setFont(new Font("Verdana", Font.PLAIN, 21));
		chckbxElectronic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxElectronic.isSelected() == true) {               //check if JCheckBox is selected or not
					type=1;                                               //indicate product type 1 which is electronic
				}
			}
		});
		chckbxElectronic.setBounds(335, 317, 164, 37);
		frame.getContentPane().add(chckbxElectronic);
		
		//Fabric check box
		JCheckBox chckbxFabric = new JCheckBox("Fabric");
		chckbxFabric.setFont(new Font("Verdana", Font.PLAIN, 21));
		chckbxFabric.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxFabric.isSelected() == true) {                 //check if JCheckBox is selected or not
					type=2;                                               //indicate product type 2 which is fabric
				}
			}
		});
		chckbxFabric.setBounds(547, 315, 164, 40);
		frame.getContentPane().add(chckbxFabric);
		
		//clear button
		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Consolas", Font.BOLD, 21));
		btnClear.setBackground(new Color(255, 255, 255));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {            //to clear all field
				name.setText("");
			    productid.setText("");
			    quantity.setText("");
			    price.setText("");
			    chckbxElectronic.setSelected(false);
			    chckbxFabric.setSelected(false);
			}
		});
		btnClear.setBounds(401, 516, 180, 60);
		frame.getContentPane().add(btnClear);
	}
}

