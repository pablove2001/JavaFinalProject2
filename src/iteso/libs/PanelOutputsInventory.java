package iteso.libs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PanelOutputsInventory extends JFrame implements ActionListener {

	private final int PANEL_WIDTH = 260, PANEL_HEIGHT = 255;
	int idUser;

	JPanel jpPanel;
	JButton jbReturn, jbReset, jbAdd, jbSubmit;
	JLabel jlTitle, jlName, jlQuantity, jlStatus;
	JTextField jtfName, jtfQuantity;
	
	String[][] inputs = {};
	
	FrameInputsInventory inputsInventory = null;

	private PanelOutputsInventory(int idUser) {
		this.idUser = idUser;
		if (inputsInventory != null) inputsInventory.jfFrame.setVisible(false);	

		// Create JPanel
		jpPanel = new JPanel();
		jpPanel.setLayout(null);
		add(jpPanel);
		setTitle("PanelInputInventory");
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
		Font font4 = new Font("Arial", 1, 17);
		Font font5 = new Font("Arial", 0, 17);

		// Create JLabel
		jlTitle = new JLabel("Input Inventory");
		jlTitle.setFont(font2);
		jlTitle.setBounds(30, 30, 300, 23);
		jpPanel.add(jlTitle);

		jlName = new JLabel("Name:");
		jlName.setFont(font5);
		jlName.setBounds(25, 60, 300, 23);
		jpPanel.add(jlName);
		
		jlQuantity = new JLabel("Quantity:");
		jlQuantity.setFont(font5);
		jlQuantity.setBounds(25, 90, 300, 23);
		jpPanel.add(jlQuantity);

		jlStatus = new JLabel("Status");
		jlStatus.setVisible(false);
		jlStatus.setFont(font5);
		jlStatus.setBounds(25, 130, 300, 23);
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

		jbAdd = new JButton("Add");
		jbAdd.setFont(font3);
		jbAdd.setBounds(25, 180, 65, 20);
		jbAdd.addActionListener(this);
		jpPanel.add(jbAdd);

		jbSubmit = new JButton("Submit");
		jbSubmit.setFont(font3);
		jbSubmit.setBounds(129, 180, 90, 20);
		jbSubmit.addActionListener(this);
		jpPanel.add(jbSubmit);

		// JTextField
		jtfName = new JTextField();
		jtfName.setText("");
		jtfName.setFont(font5);
		jtfName.setBounds(77, 60, 140, 23);
		jpPanel.add(jtfName);
		
		jtfQuantity = new JTextField();
		jtfQuantity.setText("");
		jtfQuantity.setFont(font5);
		jtfQuantity.setBounds(95, 90, 122, 23);
		jpPanel.add(jtfQuantity);
	}

	static public void createPanelAddNewProduct(int accountType) {
		new PanelOutputsInventory(accountType);
	}

	private boolean validateName() {
		if (jtfName.getText().length() <= 0) {
			jlStatus.setVisible(true);
			jlStatus.setText("Name is empty");
			return false;
		}

		if (!Inventory.productActive(jtfName.getText())) {
			jlStatus.setVisible(true);
			jlStatus.setText("Name does not exists");
			return false;
		}

		return true;
	}

	private boolean validateQuantity() {
		if (jtfQuantity.getText().length() <= 0) {
			jlStatus.setVisible(true);
			jlStatus.setText("Quantity is empty");
			return false;
		}
		// si esta añadido ya
		
		
		// si no esta añadido ya
		if (Integer.parseInt(jtfQuantity.getText()) > Inventory.getQuantityProduct(jtfName.getText())) {
			jlStatus.setVisible(true);
			jlStatus.setText("Max Quantity: " + Inventory.getQuantityProduct(jtfName.getText()));
			return false;
		}
		
		return true;
	}
	
	private void resetPanel() {
		jtfName.setText("");
		jtfQuantity.setText("");
		jlStatus.setVisible(false);
		jlStatus.setForeground(Color.red);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbReturn) {
			// PanelProducts	
			PanelMenu.createPanelMenu(idUser);
			if (inputsInventory != null) inputsInventory.jfFrame.dispose();	
			dispose();
		}
		if (e.getSource() == jbReset) {
			// Reset
			resetPanel();
		}		
		if (e.getSource() == jbAdd) {
			// Validate
			jlStatus.setForeground(Color.red);
			if (validateName())
				if (validateQuantity()) {
					resetPanel();
					jlStatus.setVisible(true);
					jlStatus.setForeground(new Color(0, 102, 0));
					jlStatus.setText("Correct input");
					
					if (inputsInventory != null) inputsInventory.jfFrame.dispose();	
					inputsInventory = new FrameInputsInventory(inputs);	
					inputsInventory.jfFrame.setVisible(true);	

//					String[] str = {"", jtfName.getText(), "0", jtfUnitPrice.getText(), jtfProfit.getText(), "active"};
//					Inventory.addNewProduct(str);
				}
		}
		if (e.getSource() == jbSubmit) {
			resetPanel();
			jlStatus.setVisible(true);
			jlStatus.setForeground(new Color(0, 102, 0));
			jlStatus.setText("Correct Submit");
		}

	}

}
