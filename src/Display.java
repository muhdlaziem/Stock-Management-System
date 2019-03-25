import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class Display extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String textvalue;

	/**
	 * Create the frame.
	 */
	public Display() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList<Stock> Description = new JList<Stock>();
		
       
		
		Description.setToolTipText("System.out.print(\"dsff\");");
		Description.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Description.setValueIsAdjusting(true);
		Description.setBounds(61, 132, 327, 168);
		contentPane.add(Description);
		
		JLabel lblEnterProductId = new JLabel("Enter Product ID:");
		lblEnterProductId.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblEnterProductId.setBounds(61, 77, 156, 16);
		contentPane.add(lblEnterProductId);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textvalue = textField.getText();
				
			}
		});
		textField.setBounds(230, 75, 244, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					SMS news =new SMS();
					dispose();
					news.frame.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(305, 351, 97, 48);
		contentPane.add(button);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<Stock> listModel = new DefaultListModel<>();
				for(int i = 0; i<SMS.Data.length; i++) {
					if(textvalue == SMS.Data[i].getProductID()) {
						listModel.addElement(SMS.Data[i]);
						
					}
				}
				
				
				
				 
			}
		});
		btnLoad.setBounds(502, 74, 97, 25);
		contentPane.add(btnLoad);
	}
}
