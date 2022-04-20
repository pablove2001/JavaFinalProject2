package iteso.libs;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelInputsInventory extends JFrame implements ActionListener {

	private final int PANEL_WIDTH = 800, PANEL_HEIGHT = 600;

	JPanel jpPanel;
	JFrame jfFrame;
	JTable jtTable;

	private PanelInputsInventory() {
		// Create JPanel
		jpPanel = new JPanel();
		jpPanel.setLayout(null);
		add(jpPanel);
		setTitle("PanelInventory");
		setSize(PANEL_WIDTH, PANEL_HEIGHT);
		setVisible(true);		
		setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		// Create JFrame
		String[][] information = Inventory.inventoryInformation(0, "");
		jfFrame = new JFrame();
		String[] header = { "ID", "Name", "Count No.", "Unit Price", "Profit %" };
		jtTable = new JTable(information, header);
		jpPanel.add(new JScrollPane(jtTable));
		jfFrame.add(jpPanel);
		jfFrame.setSize(0, 0);
		jfFrame.setVisible(true);

	}

	static public void createPanelInputsInventory() {
		new PanelInputsInventory();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}



}
