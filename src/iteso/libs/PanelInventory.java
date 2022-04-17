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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class PanelInventory extends JFrame implements ActionListener {

	static private PanelInventory singleton = null;

	private final int PANEL_WIDTH = 500, PANEL_HEIGHT = 400;
	int accountType;

	JPanel jpPanel;
	JButton jbReturn, jbShowInventory;
	
	FrameInventory inventory;

	private PanelInventory(int accountType) {
		this.accountType = accountType;
		
		// Create JPanel
		jpPanel = new JPanel();
		jpPanel.setLayout(null);
		add(jpPanel);
		setTitle("PanelMenu");
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
		Font font5 = new Font("Arial", 0, 15);

		// Create JButton
		jbReturn = new JButton("Return");
		jbReturn.setFont(font3);
		jbReturn.setBounds(0, 0, 100, 20);
		jbReturn.addActionListener(this);
		jpPanel.add(jbReturn);
		
		jbShowInventory = new JButton("Show Inventory");
		jbShowInventory.setFont(font3);
		jbShowInventory.setBounds(100, 0, 200, 20);
		jbShowInventory.addActionListener(this);
		jpPanel.add(jbShowInventory);

	}

	static public void createPanelInventory(int accountType) {
		singleton = new PanelInventory(accountType);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbReturn) {
			// PanelMenu	
			PanelMenu.createPanelMenu(accountType);
			inventory.closeFrame();
			dispose();
		}
		if (e.getSource() == jbShowInventory) {
			// ShowInventory
			inventory = FrameInventory.createFrameInventory(0, "");	
			inventory.jfFrame.setVisible(true);
		}

	}

}
