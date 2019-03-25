package Main;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	public JFrame frame;
	private JTextField usernametext;
	private JPasswordField passwordField;
	private static List<User> User= new ArrayList<User>(Arrays.asList(new User("Admin","Admin"),new User("Worker","Worker")));
	private char[] passwordvalue;
	private String usernamevalue;
	private boolean isSuccessfull = false;

	//This class for login purpose. This class is the initialization of the application
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Menu.Data.add(new Electronic("Redmi 3S", "E001", 600,10));
		Menu.Data.add(new Fabric("Adidas Cap @Blue", "F001", 30,9));
		Menu.Data.add(new Electronic("Iphone X", "E002", 3000,8));
		Menu.Data.add(new Fabric("Jubah Naruto", "F002", 55.90,100));
		Menu.Data.add(new Electronic("Electric Cooker", "E003", 100,10));    //initialize five products
		
		EventQueue.invokeLater(new Runnable() {    //The Application will run in this class first
			public void run() {
				try {
					Login window = new Login();     //go to Login frame
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//customize jFrame
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/res/warehouse.png")));
		frame.setTitle("Stock Management System");
		frame.setBounds(450, 200, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//left side panel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 375, 665);
		frame.getContentPane().add(panel);
		
		//icon label
		JLabel icon = new JLabel("");
		icon.setBounds(55, 190, 265, 272);
		icon.setIcon(new ImageIcon(Login.class.getResource("/res/warehouse.png")));
		
		//title label
		JLabel lblStockManagementSystem = new JLabel("STOCK MANAGEMENT\r\n");
		lblStockManagementSystem.setBounds(24, 92, 326, 42);
		lblStockManagementSystem.setForeground(new Color(255, 255, 255));
		lblStockManagementSystem.setFont(new Font("Bebas Neue", Font.PLAIN, 50));
		panel.setLayout(null);
		panel.add(lblStockManagementSystem);
		panel.add(icon);
		
		//title label
		JLabel lblSystem = new JLabel("SYSTEM");
		lblSystem.setForeground(Color.WHITE);
		lblSystem.setFont(new Font("Bebas Neue", Font.PLAIN, 50));
		lblSystem.setBounds(126, 147, 122, 42);
		panel.add(lblSystem);
		
		//user name label
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Century Gothic", Font.BOLD, 21));
		lblUsername.setBounds(454, 250, 115, 43);
		frame.getContentPane().add(lblUsername);
		
		//user name textField
		usernametext = new JTextField();
		usernametext.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				usernamevalue = usernametext.getText();          //get user name from usernametext
				}
		});
		usernametext.setFont(new Font("Brandon Grotesque Light", Font.PLAIN, 21));
		usernametext.setBounds(581, 250, 222, 43);
		frame.getContentPane().add(usernametext);
		usernametext.setColumns(10);
		
		//password label
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Century Gothic", Font.BOLD, 21));
		lblPassword.setBounds(454, 331, 115, 43);
		frame.getContentPane().add(lblPassword);
		
		//password field
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				passwordvalue = passwordField.getPassword();      //get password from passwordField
			}
		});
		passwordField.setFont(new Font("Brandon Grotesque Light", Font.PLAIN, 21));
		passwordField.setBounds(581, 331, 222, 43);
		frame.getContentPane().add(passwordField);
		
		//login title
		JLabel Login = new JLabel("LOGIN\r\n");
		Login.setForeground(new Color(255, 127, 80));
		Login.setFont(new Font("Brandon Grotesque Black", Font.PLAIN, 38));
		Login.setBounds(454, 149, 147, 59);
		frame.getContentPane().add(Login);
		
		//button login
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0; i<User.size(); i++) {
					//check the user name and password match in the database or not
					if(User.get(i).getUsername().equals(usernamevalue) && User.get(i).getPassword().equals(String.valueOf(passwordvalue))) {   
						JOptionPane.showMessageDialog(null, "Login Successful");
						isSuccessfull = true;  //if matched isSuccessfull=true
						break;
					}
				}
					if(isSuccessfull==true) {                         //if isSuccessful is true, the user can access the menu
						try{
							Menu menu =new Menu();
							frame.dispose();
							menu.frame.setVisible(true);
							
						} catch (Exception e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if(isSuccessfull==false){                         //if not show dialog login unsuccessful
						JOptionPane.showMessageDialog(null, "Login Unsuccessful");
						passwordField.setText("");
						usernametext.setText("");
						
					}
			}
		});
		btnLogin.setFont(new Font("Brandon Grotesque Bold", Font.PLAIN, 21));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(255, 69, 0));
		btnLogin.setBounds(707, 417, 106, 43);
		frame.getContentPane().add(btnLogin);
		
		JLabel ask = new JLabel("Do not have username?");
		ask.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JOptionPane.showMessageDialog(null, "Please contact Administrator");   //showing the message to contact the administrator 
			}
		});
		ask.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		ask.setBounds(534, 429, 168, 16);
		frame.getContentPane().add(ask);
		
		JLabel aboutlabel = new JLabel("");
		aboutlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					About about =new About();                  //go to about frame
					
					about.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		aboutlabel.setIcon(new ImageIcon(Login.class.getResource("/res/support.png")));
		aboutlabel.setBounds(821, 595, 73, 70);
		frame.getContentPane().add(aboutlabel);
	}
}
