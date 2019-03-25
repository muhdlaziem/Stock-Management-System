package Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField idtext;
	private String idvalue;
	private int index ;

	//This frame is for deletion of product
	

	/**
	 * Create the frame.
	 */
	public Delete() {
		//customize contentPane
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
		
		//product id label
		JLabel productidlabel = new JLabel("Enter Product ID:");
		productidlabel.setFont(new Font("Century Gothic", Font.BOLD, 21));
		productidlabel.setBounds(124, 280, 172, 41);
		contentPane.add(productidlabel);
		
		//customize id TextField
		idtext = new JTextField();
		idtext.setFont(new Font("Courier New", Font.PLAIN, 21));
		idtext.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				idvalue = idtext.getText();
				
			}
		});
		idtext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idvalue = idtext.getText();
			
			}
		});
		idtext.setBounds(313, 280, 283, 41);
		contentPane.add(idtext);
		idtext.setColumns(10);
		
		//button back
		JButton button = new JButton("BACK");
		button.setBackground(new Color(255, 255, 255));
		button.setFont(new Font("Consolas", Font.BOLD, 21));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button.setBounds(367, 523, 228, 54);
		contentPane.add(button);
		
		//delete product label
		JLabel lblDeleteProduct = new JLabel("Delete Product");
		lblDeleteProduct.setFont(new Font("Brandon Grotesque Black", Font.PLAIN, 46));
		lblDeleteProduct.setBounds(340, 94, 302, 114);
		contentPane.add(lblDeleteProduct);
		
		//button delete
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setFont(new Font("Consolas", Font.BOLD, 21));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = 0;
				int counter=0;
				Boolean isDeleted = false;
				
				for(int i = 0; i<Menu.Data.size(); i++) {
					if( Menu.Data.get(i).getProductID().equals(idvalue)==true) {                        //check if product id entered exist in database or not
						 index = i;           
						Menu.Data.remove(index);                                                        //delete element on ArrayList which the product id lies on
						JOptionPane.showMessageDialog(null, "The product has been deleted");
						isDeleted = true;                                                                      //indicate the deleted product
						break;
					}
					else if(Menu.Data.get(i).getProductID().equals(idvalue)==false ) {             //counter++ if if product id doesn't exist in particular element
						 counter++;
						}
					if(counter==Menu.Data.size()) {
						idtext.setText("");
						JOptionPane.showMessageDialog(null, "The product does not exist in database");          //show this dialog message if the product id doesn't exist
						break;
					}
				}
				if((Menu.Data.isEmpty()==true && isDeleted==false)) {                                     //check if the ArrayList is empty
					idtext.setText("");
					JOptionPane.showMessageDialog(null, "The product does not exist in database");        //this dialog message will appear if ArrayList is empty
				}
				
				
			}
		});
		btnDelete.setBounds(607, 280, 178, 41);
		contentPane.add(btnDelete);
	}

}

