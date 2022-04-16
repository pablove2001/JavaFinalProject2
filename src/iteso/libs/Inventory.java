package iteso.libs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Inventory {

	private Inventory() {

	}

	private static void createTxtFile() {
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
	
	public static String[][] addElementArray(String[][] array, String[] toAdd){
		
		String[][] newArray = new String[array.length+1][];
		for(int i = 0; i< array.length; i++) {
			newArray[i] = array[i];
		}
		
		newArray[array.length] = toAdd;

		return newArray;
	}

	public static String[][] inventoryInformation(int order, String toFind) {
		String[][] information = {};

		createTxtFile();

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
		if (lineCounter < 5) {
			String[][] empty = {{"", "", "", "", ""}};
			return empty;
		}

		// no empty		
		lineCounter = 0;
		String[] toAdd = new String[5];
		String presta;
		try {
			File myObj = new File("inventory.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				presta = myReader.nextLine();
				toAdd[lineCounter%5] = presta;
				if (lineCounter%5 == 4) {						
					information = Inventory.addElementArray(information, toAdd);
					toAdd = new String[5];
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
