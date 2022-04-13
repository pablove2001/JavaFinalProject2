package iteso.libs;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class PanelLogIn extends JFrame implements ActionListener {
	
	private final int PANEL_WIDTH = 400, PANEL_HEIGHT = 300;
	
	JPanel jpPanel;
	JLabel jlTitle, jlUserName, jlPassword;
	JTextField jtfUserName, jtfPassword;
	JButton jbLogIn;
	
	public PanelLogIn() {
		
		// Create JPanel
		jpPanel = new JPanel();
		jpPanel.setLayout(null);
		add(jpPanel);
		setTitle("PanelLogIn");
		setSize(PANEL_WIDTH, PANEL_HEIGHT);
		setLocation(250, 250);
		setVisible(true);		
		setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		// Create Font
		Font font1 = new Font("Arial", 1, 35);
		Font font2 = new Font("Arial", 1, 20);
		Font font3 = new Font("Arial", 1, 15);
		Font font4 = new Font("Arial", 0, 20);
		
		// Create JLabel
		jlTitle = new JLabel("Log In");
		jlTitle.setFont(font1);
		jlTitle.setBounds(149, 15, 102, 45);
		jlTitle.setOpaque(true);
		jpPanel.add(jlTitle);
		
		jlUserName = new JLabel("User Name:");
		jlUserName.setFont(font2);
		jlUserName.setBounds(20, 75, 110, 30);
		jlUserName.setOpaque(true);
		jpPanel.add(jlUserName);
		
		jlPassword = new JLabel("Password:");
		jlPassword.setFont(font2);
		jlPassword.setBounds(30, 115, 100, 30);
		jlPassword.setOpaque(true);
		jpPanel.add(jlPassword);
		
		// Create JButton
		jbLogIn = new JButton("Login");
		jbLogIn.setFont(font3);
		jbLogIn.setBounds(160, 230, 80, 20);
		jbLogIn.addActionListener(this);
		jpPanel.add(jbLogIn);
		
		// Create JTextField
		jtfUserName = new JTextField();
		jtfUserName.setFont(font4);
		jtfUserName.setBounds(135, 75, 225, 30);
		jpPanel.add(jtfUserName);
		
		// Create JPasswordField
		JPasswordField jtfPassword = new JPasswordField();
		jtfPassword.setFont(font4);
		jtfPassword.setBounds(135, 115, 225, 30);
		jtfPassword.setEchoChar('*');
        jpPanel.add(jtfPassword);

		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbLogIn) {
			System.out.println("User Name: "+ jtfUserName.getText());
		}
		
	}

}
