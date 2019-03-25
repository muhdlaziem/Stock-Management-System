import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.UIManager;
import java.awt.Font;

public class SMS {

	public JFrame frame;
	private JButton btnAdd,btnUpdate,btnDisplay, btnDelete;
	public static  Stock[] Data = new Stock[100];
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SMS window = new SMS();
					
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SMS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 682, 453);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		 btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Add news =new Add();
					frame.dispose();
					news.frame.setVisible(true);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(292, 203, 97, 38);
		panel.add(btnAdd);
		
		 btnUpdate = new JButton("UPDATE");
		 btnUpdate.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try{
					Update news =new Update();
					frame.dispose();
					news.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 	}
		 });
		btnUpdate.setBounds(292, 261, 97, 38);
		panel.add(btnUpdate);
		
		 btnDisplay = new JButton("DISPLAY");
		 btnDisplay.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try{
					Display news =new Display();
					frame.dispose();
					news.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 	}
		 });
		btnDisplay.setBounds(292, 321, 97, 38);
		panel.add(btnDisplay);
		
		 btnDelete = new JButton("DELETE");
		 btnDelete.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try{
					Delete news =new Delete();
					frame.dispose(); //dispose current window without terminating the application
					news.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 	}
		 });
		btnDelete.setBounds(292, 381, 97, 38);
		panel.add(btnDelete);
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\muhdl\\Desktop\\package.png"));
		lblNewLabel.setBounds(307, 67, 68, 89);
		panel.add(lblNewLabel);
	}
}
