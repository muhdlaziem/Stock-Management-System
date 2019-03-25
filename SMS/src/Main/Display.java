package Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class Display extends JFrame {

	private JPanel contentPane;
	private JTextField idtext;
	private String textvalue;
	private int index;
	private JTable table;
	private String[] Header = {"Product ID","Name","Quantity","Price per item","Type"};        //Initialize table header
	private int qtyv;
	private double pricev;
	private String typev;

	//this frame is for displaying the products
	
	/**
	 * Create the frame.
	 */
	public Display() {
		//customize contentPane
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/res/warehouse.png")));
		setTitle("Stock Management System");
		setBounds(450, 200, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(100, 100, 700, 500);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		//product id label
		JLabel lblEnterProductId = new JLabel("Enter Product ID:");
		lblEnterProductId.setFont(new Font("Century Gothic", Font.BOLD, 21));
		lblEnterProductId.setBounds(274, 42, 180, 34);
		contentPane.add(lblEnterProductId);
		
		DefaultTableModel tableModel = new DefaultTableModel(Header, 0){            //create tableModel with header
		    public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		  };
		
		  // customize product id textField
		idtext = new JTextField();
		idtext.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				textvalue = idtext.getText();   //getText from idtext when the idtext lost focus
			}
		});
		idtext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textvalue = idtext.getText();   //getText from idtext when user press enter
				
			}
		});
		idtext.setBounds(466, 42, 244, 34);
		contentPane.add(idtext);
		
		//back button
		JButton button = new JButton("BACK");
		button.setFont(new Font("Consolas", Font.BOLD, 21));
		button.setBackground(new Color(255, 255, 255));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {       //back to Menu frame
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
		button.setBounds(413, 561, 156, 48);
		contentPane.add(button);
		
		//load button
		JButton btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Consolas", Font.BOLD, 18));
		btnLoad.setBackground(new Color(255, 255, 255));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                                         //event handling for showing particular product id
				index = 0;
				
				for(int i = 0; i<Menu.Data.size(); i++) {
					if( Menu.Data.get(i).getProductID().equals(textvalue)==true) {                     //check every index in ArrayList that contains what the user entered
						 index = i;
						 	System.out.println(Menu.Data.get(index).toString());                    
						 	if(Menu.Data.get(index) instanceof Electronic) {                       //this is for Electronic product
						 		String productid = Menu.Data.get(index).getProductID();
						 		String name = Menu.Data.get(index).getName();
						 		int qty = ((Electronic)Menu.Data.get(index)).getQuantity();
						 		Double  price = ((Electronic)Menu.Data.get(index)).getPrice();
						 		String type = ((Electronic)Menu.Data.get(index)).getType();
						 		Object[] show= {productid,name,qty,price,type};                     //create the object array of electronic product
						 		tableModel.addRow(show);                                            //and add it into tableModel as row
								
							}
							else if(Menu.Data.get(index) instanceof Fabric) {                      //same as above above but for Fabric product
								String productid = Menu.Data.get(index).getProductID();
						 		String name = Menu.Data.get(index).getName();
						 		int qty = ((Fabric)Menu.Data.get(index)).getQuantity();
						 		Double  price = ((Fabric)Menu.Data.get(index)).getPrice();
						 		String type = ((Fabric)Menu.Data.get(index)).getType();
						 		Object[] show= {productid,name,qty,price,type};
						 		tableModel.addRow(show);
								
							}
							
							
						break; //break when a row is added
					}
				}
				int counter=0;
				for(int i = 0; i<Menu.Data.size(); i++) {
					if( Menu.Data.get(i).getProductID().equals(textvalue)==false ) {
						 counter++;
					}
				}
				if(Menu.Data.isEmpty()==true || counter==Menu.Data.size()) {
					JOptionPane.showMessageDialog(null, "The product does not exist in database"); ///showing dialog message if the product does not exist in database
				}
				
				
				
				 
			}
		});
		btnLoad.setBounds(228, 99, 134, 34);
		contentPane.add(btnLoad);
		
		//customize table
        table = new JTable(tableModel);                                                  //Initialize tableModel into table
        table.setFont(new Font("Cambria Math", Font.PLAIN, 15));                         //defined the font
        table.setRowHeight(40);                                                          //set row height for the table
        
        //scrollPane for scrolling purpose
        JScrollPane scrollPane = new JScrollPane(table);                                 //add the table into JScrollpane: to enable scrolling
        table.getTableHeader().setPreferredSize(
       	     new Dimension(scrollPane.getWidth(),40)                                     //Row Height for header
       	);
        table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
        scrollPane.setBounds(94, 166, 794, 362);
        table.setFillsViewportHeight(true);
        getContentPane().add(scrollPane);
        
        //clear table button
        JButton btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Consolas", Font.BOLD, 18));
        btnClear.setBackground(new Color(255, 255, 255));
        btnClear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tableModel.setRowCount(0);                                        //clear all row
        	}
        });
        btnClear.setBounds(424, 99, 134, 34);
        contentPane.add(btnClear);
        
        //show all button
        JButton btnShowAll = new JButton("Show All");
        btnShowAll.setFont(new Font("Consolas", Font.BOLD, 18));
        btnShowAll.setBackground(new Color(255, 255, 255));
        btnShowAll.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {                          //event handling for showing all data in ArrayList
        		for (int i = 0; i < Menu.Data.size(); i++){                       //this loop for adding every elements in ArrayList into the table
        			String productid = Menu.Data.get(i).getProductID();
			 		String name = Menu.Data.get(i).getName();
			 		if(Menu.Data.get(i) instanceof Electronic) {
			 			 qtyv = ((Electronic)Menu.Data.get(i)).getQuantity();
				 		  pricev = ((Electronic)Menu.Data.get(i)).getPrice();
				 		 typev = ((Electronic)Menu.Data.get(i)).getType();
					}
					else if(Menu.Data.get(i) instanceof Fabric) {
						
				 		 qtyv = ((Fabric)Menu.Data.get(i)).getQuantity();
				 		  pricev = ((Fabric)Menu.Data.get(i)).getPrice();
				 		 typev = ((Fabric)Menu.Data.get(i)).getType();
				 		
					}
			 		Object[] show= {productid,name,qtyv,pricev,typev};         //create the object array containing the attributes of the element
			 		tableModel.addRow(show);                                    //add the object array into tableModel to form a row
        			}
        	}
        });
        btnShowAll.setBounds(615, 99, 135, 34);
        contentPane.add(btnShowAll);
 
        
		
		
	}
}

