package iteso.libs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Inventory {

	private Inventory() {

	}

	private static void createInventoryTxt() {
		try {
			File myObj = new File("inventory.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static String[][] appendArray2D(String[][] array, String[] toAdd){
		String[][] newArray = new String[array.length+1][];
		for(int i = 0; i< array.length; i++) {
			newArray[i] = array[i];
		}		
		newArray[array.length] = toAdd.clone();
		return newArray;
	}

	public static void printArray2D(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + ", ");
			}
			System.out.println();
		}
	}
	
	// without using
	public static void inputsInventory(String[][] input) {
		String[][] inventory = inventoryInformation(0, "");

		for(int i = 0; i< input.length; i++) {
			for(int j = 0; j< inventory.length; j++) {
				if(input[i][1].equals(inventory[j][1])) {
					int amount = Integer.parseInt(inventory[j][2])+Integer.parseInt(input[i][2]);
					inventory[j][2] = ""+amount;
					break;
				}
			}
		}

		Inventory.overwriteInventoryTxt(inventory);
	}
	
	// without using
	public static void outsInventory(String[][] input) {
		String[][] inventory = inventoryInformation(0, "");

		for(int i = 0; i< input.length; i++) {
			for(int j = 0; j< inventory.length; j++) {
				if(input[i][1].equals(inventory[j][1])) {
					int amount = Integer.parseInt(inventory[j][2])-Integer.parseInt(input[i][2]);
					if (amount <= 0) amount = 0;
					inventory[j][2] = ""+amount;
					break;
				}
			}
		}

		Inventory.overwriteInventoryTxt(inventory);
	}

	public static boolean productActive(String name) {
		String[][] inventory = inventoryInformation(0, "");
		for (int i = 0; i<inventory.length; i++) {
			if (inventory[i][1].equals(name)) {
				if (inventory[i][5].equals("active"))return true;
				else return false;
			}
				
		}	
		return false;
	}

	public static void addNewProduct(String[] toAdd) {
		String[][] inventory = inventoryInformation(0, "");
		toAdd[0] = ""+(inventory.length+1);
		inventory = appendArray2D(inventory, toAdd);

		overwriteInventoryTxt(inventory);
	}

	public static void editProduct(String[] toEdit) {
		String[][] inventory = inventoryInformation(0, "");

		for(int i = 0; i< inventory.length; i++) {
			if(toEdit[0].equals(inventory[i][1])) { // find old name
				toEdit[2] = inventory[i][2];
				addNewProduct(toEdit);
				
				inventory = inventoryInformation(0, "");
				inventory[i][2] = "0";
				inventory[i][5] = "deleted";
				overwriteInventoryTxt(inventory);
				return;
			}

		}
	}

	// incomplete
	public static void deliteProduct(String name) {
		String[][] inventory = inventoryInformation(0, "");
		for (int i = 0; i<inventory.length; i++) {
			if (inventory[i][1].equals(name)) {
				inventory[i][5] = "deleted";
				overwriteInventoryTxt(inventory);
				return;
			}
		}
	}

	public static void overwriteInventoryTxt(String[][] inventory) {
		try {
			FileWriter myWriter = new FileWriter("inventory.txt");
			for (int i = 0; i < inventory.length; i++) {
				for (int j = 0; j < inventory[i].length; j++) {
					myWriter.write(inventory[i][j]);
					if (!((i == inventory.length-1) && (j == inventory[i].length-1))) {
						myWriter.write("\n");
					}
				}
			}

			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static String[][] inventoryInformation(int order, String toFind) {
		String[][] information = {};

		createInventoryTxt();

		// Line Counter
		int lineCounter = 0;		
		try {
			File myObj = new File("inventory.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				myReader.nextLine();
				lineCounter++;
			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// empty
		if (lineCounter < 6) {
			String[][] empty = {{"", "", "", "", "", ""}};
			return empty;
		}

		// no empty		
		lineCounter = 0;
		String[] toAdd = new String[6];
		try {
			File myObj = new File("inventory.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				toAdd[lineCounter%6] = myReader.nextLine();
				if (lineCounter%6 == 5) {						
					information = Inventory.appendArray2D(information, toAdd);
				}
				lineCounter++;
			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}		

		return information;		
	}

}
