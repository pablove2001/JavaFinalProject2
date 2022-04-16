import iteso.libs.*;

public class Main {

	public static void main(String[] args) {

//				PanelLogIn.createPanelLogIn();
//				PanelMenu.createPanelMenu(4);
		
		
		String[][] information = {{"", "nombre4", "1", "precio4", "porcentaje ganancia4"}, {"", "nombre1", "1", "precio1", "porcentaje ganancia1"}, {"", "nombre2", "3", "precio2", "porcentaje ganancia2"}};
		Inventory.outsInventory(information);
		
//		String[] toadd= {"", "nombre5", "50", "precio5", "porcentaje ganancia5"};
//		Inventory.addProduct(toadd);
		
		
//		information = Inventory.inventoryInformation(0, "");
//		
//		for (int i = 0; i < information.length; i++) {
//			for (int j = 0; j < information[i].length; j++) {
//				System.out.print(information[i][j] + ", ");
//			}
//			System.out.println();
//		}
	}

}
