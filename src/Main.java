import iteso.libs.*;

public class Main {

	public static void main(String[] args) {

//				PanelLogIn.createPanelLogIn();
//				PanelMenu.createPanelMenu(4);

		
		
		String[][] information = Inventory.inventoryInformation(1, "");
		
		for (int i = 0; i < information.length; i++) {
			for (int j = 0; j < information[i].length; j++) {
				System.out.print(information[i][j] + ", ");
			}
			System.out.println();
		}



	}

}
