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



public class PanelMenu extends JFrame implements ActionListener {
	
	static private PanelMenu singleton = null;

	private final int PANEL_WIDTH = 300, PANEL_HEIGHT = 249;

	JPanel jpPanel;
	JButton jbReturn, jbSettings, jbInputsInventory, jbOutputsInventory, jbInventory, jbRecord, jbStatistics, jbAccountManager;
	JLabel jlTitle;

	private PanelMenu(int accountType) {
		// Create JPanel
		jpPanel = new JPanel();
		jpPanel.setLayout(null);
		add(jpPanel);
		setTitle("PanelMenu");
		setSize(PANEL_WIDTH, PANEL_HEIGHT);
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

		jbSettings = new JButton("Settings");
		jbSettings.setFont(font3);
		jbSettings.setBounds(PANEL_WIDTH-110-16, 0, 110, 20);
		jbSettings.addActionListener(this);
		jpPanel.add(jbSettings);
		
		jbInputsInventory = new JButton("Inputs Inventory");
		jbInputsInventory.setFont(font3);
		jbInputsInventory.setBounds(0, 60, PANEL_WIDTH-16, 30);
		jbInputsInventory.addActionListener(this);
		jpPanel.add(jbInputsInventory);
		
		jbOutputsInventory = new JButton("Outputs Inventory");
		jbOutputsInventory.setFont(font3);
		jbOutputsInventory.setBounds(0, 90, PANEL_WIDTH-16, 30);
		jbOutputsInventory.addActionListener(this);
		jpPanel.add(jbOutputsInventory);
		
		jbInventory = new JButton("Inventory");
		jbInventory.setFont(font3);
		jbInventory.setBounds(0, 120, PANEL_WIDTH-16, 30);
		jbInventory.addActionListener(this);
		jpPanel.add(jbInventory);
		
		jbRecord = new JButton("Record");
		jbRecord.setFont(font3);
		jbRecord.setBounds(0, 150, PANEL_WIDTH-16, 30);
		jbRecord.addActionListener(this);
		jpPanel.add(jbRecord);
		
		jbStatistics = new JButton("Statistics");
		jbStatistics.setFont(font3);
		jbStatistics.setBounds(0, 180, PANEL_WIDTH-16, 30);
		jbStatistics.addActionListener(this);
		jpPanel.add(jbStatistics);
		
		//jbAccountManager
		if (accountType != 4) {
			jbAccountManager = new JButton("Accounts Manager");
			jbAccountManager.setFont(font3);
			jbAccountManager.setBounds(0, 210, PANEL_WIDTH-16, 30);
			jbAccountManager.addActionListener(this);
			jpPanel.add(jbAccountManager);
			setSize(PANEL_WIDTH, PANEL_HEIGHT+30);			
		}

		// Create JLabel
		switch (accountType) {
		case 2: 
			jlTitle = new JLabel("SuperAdmin menu"); 
			jlTitle.setBounds(56, 20, 200, 45); 
			break;
		case 3: 
			jlTitle = new JLabel("Admin menu");
			jlTitle.setBounds(85, 20, 200, 45); 
			break;
		case 4: 
			jlTitle = new JLabel("Employee menu"); 
			jlTitle.setBounds(70, 20, 200, 45); 
			break;
		}		
		jlTitle.setFont(font2);
		jpPanel.add(jlTitle);
	}
	
	static public void createPanelMenu(int accountType) {
        singleton = new PanelMenu(accountType);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbReturn) {
			// PanelLogIn	
			PanelLogIn.createPanelLogIn();
			setVisible(false);
		}
		if (e.getSource() == jbSettings) {
			// PanelSettings
			System.out.println("PanelSettings");
		}
		if (e.getSource() == jbInputsInventory) {
			// PanelInventoryManagement
			System.out.println("PanelInputsInventory");
		}
		if (e.getSource() == jbOutputsInventory) {
			// PanelInventoryManagement
			System.out.println("PanelOutputsInventory");
		}
		if (e.getSource() == jbInventory) {
			// PanelInventory
			System.out.println("PanelInventory");
		}
		if (e.getSource() == jbRecord) {
			// PanelRecord
			System.out.println("PanelRecord");
		}
		if (e.getSource() == jbStatistics) {
			// PanelStatistics
			System.out.println("PanelStatistics");
		}
		if (e.getSource() == jbAccountManager) {
			// PanelAccountManager
			System.out.println("PanelAccountManager");
		}
		
		
	}
}
