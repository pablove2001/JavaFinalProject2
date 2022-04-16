import iteso.libs.*;

public class Main {

	public static void main(String[] args) {

//				PanelLogIn.createPanelLogIn();
//				PanelMenu.createPanelMenu(4);

		
//		String[][] information = Inventory.inventoryInformation(0, "");
//		
//		for (int i = 0; i < information.length; i++) {
//			for (int j = 0; j < information[i].length; j++) {
//				System.out.print(information[i][j] + ", ");
//			}
//			System.out.println();
//		}
		
		
		String[][] information = {{"4", "nombre1", "4", "precio4", "porcentaje ganacia4"}, {"2", "nombre2", "3", "precio2", "porcentaje ganacia2"}, {"2", "nombre4", "3", "precio2", "porcentaje ganacia2"}};
		Inventory.inputsInventory(information);
		
		
//		information = Inventory.inventoryInformation(0, "");
//		for (int i = 0; i < information.length; i++) {
//			for (int j = 0; j < information[i].length; j++) {
//				System.out.print(information[i][j] + ", ");
//			}
//			System.out.println();
//		}


	}

}
