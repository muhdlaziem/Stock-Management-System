package Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField idtext;
	private JTextField updateqty;
	private JTextField updateprice;
	private JButton saveprice;
	private String idvalue;
	private int index;
	private int qtyvalue;
	private Double pricevalue;
	Boolean isEntered = false;
	Boolean isError = false;
	private JButton enterbutton;

	//this jFrame is to update quantity or price

	/**
	 * Create the frame.
	 */
	public Update() {
		//customize content pane
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/res/warehouse.png")));
		setTitle("Stock Management System");
		setBounds(450, 200, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//back button
		JButton button = new JButton("BACK");
		button.setFont(new Font("Consolas", Font.BOLD, 21));
		button.setBackground(new Color(255, 255, 255));
		button.addActionListener(new ActionListener() {                          
			public void actionPerformed(ActionEvent e) {                       // call back menu JFrame
				try{
					Menu menu =new Menu();
					dispose();
					menu.frame.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(402, 521, 178, 70);
		contentPane.add(button);
		
		//product id label
		JLabel lblEnterProductId = new JLabel("Enter Product ID:");
		lblEnterProductId.setFont(new Font("Century Gothic", Font.BOLD, 21));
		lblEnterProductId.setBounds(235, 95, 178, 41);
		contentPane.add(lblEnterProductId);
		
		//idtext for id
		idtext = new JTextField();
		idtext.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		idtext.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				idvalue = idtext.getText();                              //get product id from JTextField
				
			}
		});
		idtext.setColumns(10);
		idtext.setBounds(457, 99, 274, 41);
		contentPane.add(idtext);
		
		//quantity label
		JLabel quantitylabel = new JLabel("Quantity:");
		quantitylabel.setFont(new Font("Century Gothic", Font.BOLD, 21));
		quantitylabel.setBounds(255, 291, 119, 41);
		contentPane.add(quantitylabel);
		
		//update quantity textField
		updateqty = new JTextField();
		updateqty.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		updateqty.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(isEntered==true) {                                                                     //check if product is entered or not
					
					if(!(updateqty.getText().equals(""))) {
						try {
							qtyvalue = Integer.parseInt(updateqty.getText());                             //get updated quantity value from JTextField
							}
							catch(NumberFormatException e1) {                                             //catch the exception if user enter string value
								isError = true;                                                           //indicate there is an error
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "Please enter numeric value");        //dialog message appear ask user to enter numeric value
								updateqty.setText("");
								
								
							}
					}
				}
			}
		});
		updateqty.setColumns(10);
		updateqty.setBounds(433, 291, 284, 41);
		contentPane.add(updateqty);
		
		//price label
		JLabel pricelabel = new JLabel("Price:");
		pricelabel.setFont(new Font("Century Gothic", Font.BOLD, 21));
		pricelabel.setBounds(255, 364, 119, 41);
		contentPane.add(pricelabel);
		
		//update price textField
		updateprice = new JTextField();
		updateprice.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		updateprice.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {                                                              //same as updated quantity function
				if(isEntered==true ) {
					
					if(!(updateprice.getText().equals(""))) {
						try {
							pricevalue = Double.parseDouble(updateprice.getText());
							
							}
							catch(NumberFormatException e2) {
								isError = true;
								JOptionPane.showMessageDialog(null, "Please enter numeric value");
								updateprice.setText("");
								
								
								
							}
					}
					
				}
				
			}
		});
		updateprice.setColumns(10);
		updateprice.setBounds(433, 368, 284, 41);
		contentPane.add(updateprice);
		
		//save price button
		saveprice = new JButton("SAVE");
		saveprice.setFont(new Font("Consolas", Font.BOLD, 21));
		saveprice.setBackground(new Color(255, 255, 255));
		saveprice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( isError == false) {                                                      //if there is no error this if will execute
					if(isEntered==true ) {                                                   //check if product id is entered or not
						
						if(Menu.Data.get(index) instanceof Electronic) {                          // check which subclass the object lies on
							
							
							((Electronic)Menu.Data.get(index)).setPrice(pricevalue);               //cast the object according to subclass to set new price value
							
						}
						else if(Menu.Data.get(index) instanceof Fabric) {                         //same as above
							
							
							((Fabric)Menu.Data.get(index)).setPrice(pricevalue);
							
						}
						JOptionPane.showMessageDialog(null, "Product is updated"); 
						}
					else {
						JOptionPane.showMessageDialog(null, "Enter the product ID first");              //ask user enter product id first
						updateprice.setText("");
						}	
				}
				
				
				
				
			}
		});
		saveprice.setBounds(729, 371, 109, 38);
		contentPane.add(saveprice);
		
		//enter button
		enterbutton = new JButton("Enter");
		enterbutton.setFont(new Font("Consolas", Font.BOLD, 21));
		enterbutton.setBackground(new Color(255, 255, 255));
		enterbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                                              //this function is to select product id
				index = 0;                                                                            //initialize index
				for(int i = 0; i<Menu.Data.size(); i++) {
					if( Menu.Data.get(i).getProductID().equals(idvalue)==true) {                             //check if product id entered exist in the database or not
						 index = i;
						 isEntered=true;                                                                     //indicate product id is entered
						 JOptionPane.showMessageDialog(null, "The product has been selected");
						break; //break the loop
					}
				}
				int counter=0;
				for(int i = 0; i<Menu.Data.size(); i++) {
					if( Menu.Data.get(i).getProductID().equals(idvalue)==false ) {                        //check if product id entered exist in the database or not
						 counter++;                                                           
					}
				}
				if(Menu.Data.isEmpty()==true || counter==Menu.Data.size()) {
					idtext.setText("");
					JOptionPane.showMessageDialog(null, "The product does not exist in database"); //this dialog message appeared when product id not exist in the database
				}
				
			}
		});
		enterbutton.setBounds(442, 178, 97, 59);
		contentPane.add(enterbutton);
		
		//save quantity button
		JButton savequantity = new JButton("SAVE");
		savequantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                                     //same as function in save price button
				if(isError == false) {
					if(isEntered==true ) {
						
						if(Menu.Data.get(index) instanceof Electronic) {
							((Electronic)Menu.Data.get(index)).setQuantity(qtyvalue);
							
						}
						else if(Menu.Data.get(index) instanceof Fabric) {
							((Fabric)Menu.Data.get(index)).setQuantity(qtyvalue);
							
						}
						JOptionPane.showMessageDialog(null, "Product is updated");
						}
					else {
					JOptionPane.showMessageDialog(null, "Enter the product ID first");
					updateqty.setText("");
					}
				}
				
				
				
			}
		});
		savequantity.setFont(new Font("Consolas", Font.BOLD, 21));
		savequantity.setBackground(Color.WHITE);
		savequantity.setBounds(729, 291, 109, 41);
		contentPane.add(savequantity);
	}
}

