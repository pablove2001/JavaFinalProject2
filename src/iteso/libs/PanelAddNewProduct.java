package iteso.libs;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAddNewProduct extends JFrame implements ActionListener {

	static private PanelAddNewProduct singleton = null;

	private final int PANEL_WIDTH = 260, PANEL_HEIGHT = 285;
	int idUser;

	JPanel jpPanel;
	JButton jbReturn, jbReset, jbAccept;
	JLabel jlTitle, jlName, jlUnitPrice, jlProfit, jlStatus;
	JTextField jtfName, jtfUnitPrice, jtfProfit;

	private PanelAddNewProduct(int idUser) {
		this.idUser = idUser;

		// Create JPanel
		jpPanel = new JPanel();
		jpPanel.setLayout(null);
		add(jpPanel);
		setTitle("PanelAddNewProduct");
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
		Font font5 = new Font("Arial", 0, 17);

		// Create JLabel
		jlTitle = new JLabel("Add a new Product");
		jlTitle.setFont(font2);
		jlTitle.setBounds(30, 30, 300, 23);
		jpPanel.add(jlTitle);

		jlName = new JLabel("Name:");
		jlName.setFont(font5);
		jlName.setBounds(25, 60, 300, 23);
		jpPanel.add(jlName);

		jlUnitPrice = new JLabel("Unit Price:");
		jlUnitPrice.setFont(font5);
		jlUnitPrice.setBounds(25, 90, 300, 23);
		jpPanel.add(jlUnitPrice);

		jlProfit = new JLabel("Profit %:");
		jlProfit.setFont(font5);
		jlProfit.setBounds(25, 120, 300, 23);
		jpPanel.add(jlProfit);

		jlStatus = new JLabel("Status");
		jlStatus.setVisible(false);
		jlStatus.setFont(font5);
		jlStatus.setBounds(70, 160, 300, 23);
		jpPanel.add(jlStatus);

		// Create JButton
		jbReturn = new JButton("Return");
		jbReturn.setFont(font3);
		jbReturn.setBounds(0, 0, 100, 20);
		jbReturn.addActionListener(this);
		jpPanel.add(jbReturn);
		
		jbReset = new JButton("Reset");
		jbReset.setFont(font3);
		jbReset.setBounds(PANEL_WIDTH-116, 0, 100, 20);
		jbReset.addActionListener(this);
		jpPanel.add(jbReset);

		jbAccept = new JButton("Accept");
		jbAccept.setFont(font3);
		jbAccept.setBounds(70, 210, 100, 20);
		jbAccept.addActionListener(this);
		jpPanel.add(jbAccept);

		// JTextField
		jtfName = new JTextField();
		jtfName.setText("");
		jtfName.setFont(font5);
		jtfName.setBounds(77, 60, 140, 23);
		jpPanel.add(jtfName);
		
		jtfUnitPrice = new JTextField();
		jtfUnitPrice.setText("");
		jtfUnitPrice.setFont(font5);
		jtfUnitPrice.setBounds(106, 90, 111, 23);
		jpPanel.add(jtfUnitPrice);
		
		jtfProfit = new JTextField();
		jtfProfit.setText("");
		jtfProfit.setFont(font5);
		jtfProfit.setBounds(92, 120, 125, 23);
		jpPanel.add(jtfProfit);
	}

	static public void createPanelAddNewProduct(int accountType) {
		singleton = new PanelAddNewProduct(accountType);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbReturn) {
			// PanelMenu	
			PanelMenu.createPanelMenu(idUser);
			dispose();
		}
		if (e.getSource() == jbReset) {
			// Reset
			jtfName.setText("");
			jtfUnitPrice.setText("");
			jtfProfit.setText("");
			jlStatus.setVisible(false);
		}		
		if (e.getSource() == jbAccept) {
			// Validate	
//			if () algun campo basio
		}

	}

}
