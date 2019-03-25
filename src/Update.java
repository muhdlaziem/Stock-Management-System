import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		button.setBounds(384, 363, 97, 48);
		contentPane.add(button);
		
		JLabel lblEnterProductId = new JLabel("Enter Product ID:");
		lblEnterProductId.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblEnterProductId.setBounds(95, 84, 119, 16);
		contentPane.add(lblEnterProductId);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(257, 82, 262, 22);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_1.setBounds(171, 155, 119, 16);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(302, 153, 192, 22);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("Quantity:");
		label_2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_2.setBounds(171, 199, 119, 16);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(302, 197, 192, 22);
		contentPane.add(textField_2);
		
		JLabel label_3 = new JLabel("Price:");
		label_3.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_3.setBounds(171, 244, 119, 16);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(302, 242, 192, 22);
		contentPane.add(textField_3);
		
		button_1 = new JButton("SAVE");
		button_1.setBounds(182, 363, 97, 48);
		contentPane.add(button_1);
	}

}
