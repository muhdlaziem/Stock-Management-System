package Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class About extends JFrame { 
	
	//This Class only shows our developers list names.

	private JPanel contentPane;

	public About() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/res/warehouse.png")));
		setTitle("Stock Management System: About");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(700, 400, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDevelopers = new JLabel("Developers: ");
		lblDevelopers.setForeground(new Color(255, 255, 255));
		lblDevelopers.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblDevelopers.setBounds(170, 23, 92, 30);
		contentPane.add(lblDevelopers);
		
		JLabel lblMuhammadLaziemBin = new JLabel("Muhammad Laziem Bin Shafie (1621781)");
		lblMuhammadLaziemBin.setForeground(new Color(255, 255, 255));
		lblMuhammadLaziemBin.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblMuhammadLaziemBin.setBounds(69, 60, 293, 30);
		contentPane.add(lblMuhammadLaziemBin);
		
		JLabel lblMuhammadSyafiqBin = new JLabel("Muhammad Syafiq Bin Mohd. Faudzy (1623765)");
		lblMuhammadSyafiqBin.setForeground(new Color(255, 255, 255));
		lblMuhammadSyafiqBin.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblMuhammadSyafiqBin.setBounds(44, 87, 344, 30);
		contentPane.add(lblMuhammadSyafiqBin);
		
		JLabel lblNikAhmadFaiz = new JLabel("Nik Ahmad Faiz Bin Mohd Fauzi (1623399)");
		lblNikAhmadFaiz.setForeground(new Color(255, 255, 255));
		lblNikAhmadFaiz.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNikAhmadFaiz.setBounds(63, 116, 306, 30);
		contentPane.add(lblNikAhmadFaiz);
		
		JLabel lblMuhammadYusufBin = new JLabel("Muhammad Yusuf Bin Zainul Ariffin (1620815)");
		lblMuhammadYusufBin.setForeground(new Color(255, 255, 255));
		lblMuhammadYusufBin.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblMuhammadYusufBin.setBounds(55, 145, 322, 30);
		contentPane.add(lblMuhammadYusufBin);
	}

}
