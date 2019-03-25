import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class Add extends SMS{

	public JFrame frame;
	private JTextField name;
	private JTextField productid;
	private JTextField quantity;
	private JTextField price;
	private JLabel lblBestBefore;
	private JTextField bestbefore;
	private JButton btnSave;
	private JButton btnBack;
	private JLabel lblType;
	private String namevalue;
	private String idvalue;
	private int quantityvalue;
	private double pricevalue;
	private String BBvalue;
	private int type;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblName.setBounds(180, 78, 119, 16);
		frame.getContentPane().add(lblName);
		
		name = new JTextField();
		name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 namevalue = name.getText();
			}
		});
		name.setBounds(311, 76, 192, 22);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblProductId = new JLabel("Product ID:");
		lblProductId.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblProductId.setBounds(180, 39, 119, 16);
		frame.getContentPane().add(lblProductId);
		
		productid = new JTextField();
		
		productid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  idvalue = productid.getText();
				 
			}
		});
		productid.setColumns(10);
		productid.setBounds(311, 37, 192, 22);
		frame.getContentPane().add(productid);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblQuantity.setBounds(180, 122, 119, 16);
		frame.getContentPane().add(lblQuantity);
		
		quantity = new JTextField();
		quantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quantityvalue = Integer.parseInt(quantity.getText());
			}
		});
		quantity.setColumns(10);
		quantity.setBounds(311, 120, 192, 22);
		frame.getContentPane().add(quantity);
		
		JLabel lblQuantity_1 = new JLabel("Price:");
		lblQuantity_1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblQuantity_1.setBounds(180, 167, 119, 16);
		frame.getContentPane().add(lblQuantity_1);
		
		price = new JTextField();
		price.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pricevalue = Integer.parseInt(price.getText());
			}
		});
		price.setColumns(10);
		price.setBounds(311, 165, 192, 22);
		frame.getContentPane().add(price);
		
		lblBestBefore = new JLabel("Best Before:");
		lblBestBefore.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblBestBefore.setBounds(180, 212, 119, 16);
		frame.getContentPane().add(lblBestBefore);
		
		bestbefore = new JTextField();
		bestbefore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BBvalue = bestbefore.getText();
			}
		});
		bestbefore.setColumns(10);
		bestbefore.setBounds(311, 210, 192, 22);
		frame.getContentPane().add(bestbefore);
		
		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (type==1) {
					for(int i = 0; i<SMS.Data.length; i++)
					if(SMS.Data[i]==null) {
						Data[i] = new Electronic(namevalue,idvalue,pricevalue,quantityvalue,BBvalue);
						
					}
					
				}
			}
		});
		btnSave.setBounds(216, 366, 97, 48);
		frame.getContentPane().add(btnSave);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					SMS news =new SMS();
					frame.dispose();
					news.frame.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBack.setBounds(371, 366, 97, 48);
		frame.getContentPane().add(btnBack);
		
		lblType = new JLabel("Type:");
		lblType.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblType.setBounds(180, 255, 119, 16);
		frame.getContentPane().add(lblType);
		
		JCheckBox chckbxElectronic = new JCheckBox("Electronic");
		chckbxElectronic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxElectronic.isSelected() == true) {
					type=1;
				}
			}
		});
		chckbxElectronic.setBounds(311, 252, 113, 25);
		frame.getContentPane().add(chckbxElectronic);
		
		JCheckBox chckbxFabric = new JCheckBox("Fabric");
		chckbxFabric.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxFabric.isSelected() == true) {
					type=2;
				}
			}
		});
		chckbxFabric.setBounds(311, 282, 113, 25);
		frame.getContentPane().add(chckbxFabric);
	}
}
