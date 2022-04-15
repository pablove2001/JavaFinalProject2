package iteso.libs;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelInputsInventory extends JFrame implements ActionListener {
	static private PanelInputsInventory singleton = null;

	private final int PANEL_WIDTH = 800, PANEL_HEIGHT = 600;

	JPanel jpPanel;

	private PanelInputsInventory() {
		// Create JPanel
		jpPanel = new JPanel();
		jpPanel.setLayout(null);
		add(jpPanel);
		setTitle("PanelInventoryManagement");
		setSize(PANEL_WIDTH, PANEL_HEIGHT);
		setVisible(true);		
		setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
	}
	
	static public void createPanelInputsInventory() {
		singleton = new PanelInputsInventory();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
