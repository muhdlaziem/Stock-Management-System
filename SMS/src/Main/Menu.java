package Main;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu {

	public JFrame frame;
	private JButton btnAdd,btnUpdate,btnDisplay, btnDelete;
	public static  List<Stock> Data = new ArrayList<Stock>();
	private JLabel aboutlabel;
 
	//this frame is for showing the available menus
	
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//customize jFrame
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/res/warehouse.png")));
		frame.setTitle("Stock Management System");
		frame.setBounds(450, 200, 1000, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		//panel background
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		frame.getContentPane().add(panel);
		
		 btnAdd = new JButton("ADD");
		 btnAdd.setFont(new Font("Century Gothic", Font.BOLD, 18));
		 btnAdd.setForeground(new Color(0, 0, 0));
		 btnAdd.setBackground(new Color(255, 255, 255));
		 btnAdd.setBounds(386, 289, 210, 56);
		 
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Add add =new Add();        //go to Add frame
					frame.dispose();
					add.frame.setVisible(true);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		 btnUpdate = new JButton("UPDATE");
		 btnUpdate.setFont(new Font("Century Gothic", Font.BOLD, 18));
		 btnUpdate.setBackground(new Color(255, 255, 255));
		 btnUpdate.setBounds(387, 380, 210, 56);
		 btnUpdate.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try{
					Update update =new Update();    //go to Update frame
					frame.dispose();
					update.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 	}
		 });
		
		 btnDisplay = new JButton("DISPLAY");
		 btnDisplay.setFont(new Font("Century Gothic", Font.BOLD, 18));
		 btnDisplay.setBackground(new Color(255, 255, 255));
		 btnDisplay.setBounds(387, 469, 210, 56);
		 btnDisplay.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try{
					Display display =new Display();    //go to Display frame
					frame.dispose();
					display.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 	}
		 });
		
		 btnDelete = new JButton("DELETE");
		 btnDelete.setFont(new Font("Century Gothic", Font.BOLD, 18));
		 btnDelete.setBackground(new Color(255, 255, 255));
		 btnDelete.setBounds(390, 557, 207, 56);
		 btnDelete.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try{
					Delete delete =new Delete();     //go to Delete frame
					frame.dispose(); //dispose current window without terminating the application
					delete.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 	}
		 });
		panel.setLayout(null);
		panel.add(btnUpdate);
		panel.add(btnDelete);
		panel.add(btnDisplay);
		panel.add(btnAdd);
		
		JLabel lblStockManagementSystem = new JLabel("Stock Management System");
		lblStockManagementSystem.setForeground(new Color(255, 255, 255));
		lblStockManagementSystem.setFont(new Font("Bebas Neue", Font.PLAIN, 85));
		lblStockManagementSystem.setBounds(112, 35, 757, 89);
		panel.add(lblStockManagementSystem);
		
		JLabel icon = new JLabel(" ");
		icon.setBounds(423, 137, 136, 138);
		icon.setIcon(new ImageIcon(Menu.class.getResource("/res/warehouse128.png")));
		panel.add(icon);
		
		aboutlabel = new JLabel("");
		aboutlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					About about =new About();      //go to About frame
					
					about.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		aboutlabel.setIcon(new ImageIcon(Menu.class.getResource("/res/support.png")));
		aboutlabel.setBounds(909, 580, 73, 70);
		panel.add(aboutlabel);
		
		JLabel logout = new JLabel("");
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					Login login = new Login();                   //go to Login frame
					frame.dispose();
					login.frame.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		logout.setIcon(new ImageIcon(Menu.class.getResource("/res/logout-or-send-square-with-right-arrow-interface-symbol.png")));
		logout.setBounds(931, 530, 39, 46);
		panel.add(logout);
		
	}
}
