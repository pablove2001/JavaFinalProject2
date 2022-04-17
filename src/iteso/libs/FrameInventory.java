package iteso.libs;

import java.awt.Dimension;
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

public class FrameInventory extends JFrame implements ActionListener {

	static private FrameInventory singleton = null;

	private final int PANEL_WIDTH = 500, PANEL_HEIGHT = 475;

	JPanel jpPanel;
	JFrame jfFrame;
	JTable jtTable;
	JScrollPane jspScrollPane;
	JButton jbReturn;

	private FrameInventory(int order, String toFind) {
		// Create JPanel
		jpPanel = new JPanel();
		// Create JFrame
		jfFrame = new JFrame();
		// Create JTable
		String[][] information = Inventory.inventoryInformation(order, toFind);
		String[] header = { "ID", "Name", "Count No.", "Unit Price", "Profit %" };
		jtTable = new JTable(information, header){
			public boolean isCellEditable(int row, int column) { 
				return false;             
			}
		};
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for (int i = 0; i<5; i++) jtTable.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		jtTable.getColumnModel().getColumn(0).setPreferredWidth(20);
		jtTable.getColumnModel().getColumn(2).setPreferredWidth(20);
		jtTable.getColumnModel().getColumn(3).setPreferredWidth(30);
		jtTable.getColumnModel().getColumn(4).setPreferredWidth(30);
		// Create JScrollPane
		jspScrollPane = new JScrollPane(jtTable);
		
		jpPanel.add(jspScrollPane);
		jfFrame.add(jpPanel);
		jfFrame.setSize(PANEL_WIDTH, PANEL_HEIGHT);
		jfFrame.setResizable(false);
		jfFrame.setVisible(true);
		jfFrame.setTitle("PanelInventory");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		jfFrame.setLocation(dim.width/2-jfFrame.getSize().width/2, dim.height/2-jfFrame.getSize().height/2);

	}

	static public FrameInventory createFrameInventory(int order, String toFind) {
		if (singleton == null) singleton = new FrameInventory(order, toFind);
		return singleton;
	}
	
	public void closeFrame() {
		jfFrame.dispose();
		singleton = null;
	}
	
	public FrameInventory reload(int order, String toFind) {
		jfFrame.dispose();
		singleton = null;
		return createFrameInventory(order, toFind);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
