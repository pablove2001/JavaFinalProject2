package iteso.libs;


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

public class PanelLogIn extends JFrame implements ActionListener {
	
	private final int PANEL_WIDTH = 400, PANEL_HEIGHT = 300;
	
	JPanel jpPanel;
	JLabel jlTitle, jlName, jlPassword;
	JTextField jtfName, jtfPassword;
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
		Font font1 = new Font("Arial", 3, 19);
		
		// Create JLabel
		jlTitle = new JLabel("Log In");
		jlTitle.setFont(font1);
		jlTitle.setBounds(PANEL_WIDTH-200, 30, 200, 20);
		jpPanel.add(jlTitle);
		
				
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
