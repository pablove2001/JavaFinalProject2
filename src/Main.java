import iteso.libs.*;

public class Main {

	public static void main(String[] args) {

		//		PanelLogIn.createPanelLogIn();
		//		PanelMenu.createPanelMenu(4);

		
		
		String[][] information = Inventory.inventoryInformation(1, "");
		
		for (int i = 0; i < information.length; i++) {
			for (int j = 0; j < information[i].length; j++) {
				System.out.print(information[i][j] + ", ");
			}
			System.out.println();
		}
		
//		String[][] information = {{"0 0", "0 1", "0 2"},{"1 0", "1 1", "1 2"},{"2 0", "2 1", "2 2"}};
//		String[] toAdd = {"3 0", "3 1", "3 2"};
//		
//		information = Inventory.addElementArray(information, toAdd);
//		
//		for (int i = 0; i < information.length; i++) {
//			for (int j = 0; j < information[i].length; j++) {
//				System.out.print(information[i][j] + ", ");
//			}
//			System.out.println();
//		}


	}

}
