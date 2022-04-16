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
		System.out.println("\n\n Como llega array a la funcion");
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + ", ");
			}
			System.out.println();
		}
		
		String[][] newArray = new String[array.length+1][];
		for(int i = 0; i< array.length; i++) {
			newArray[i] = array[i];
			System.out.println("\n\ndentro del for newArray");
			for (int j = 0; j < 5; j++) System.out.print(newArray[i][j] + ", ");
			System.out.println("\n\ndentro del for array");
			for (int j = 0; j < 5; j++) System.out.print(array[i][j] + ", ");
		}
		
		System.out.println("\n\ndentro de addElementArray");
//		for (int i = 0; i < 5; i++) System.out.print(toAdd[i] + ", ");
		
		newArray[array.length] = toAdd;
		
		for (int i = 0; i < newArray.length; i++) {
			for (int j = 0; j < newArray[i].length; j++) {
				System.out.print(newArray[i][j] + ", ");
			}
			System.out.println();
		}
		
		//newArray[array.length] = toAdd;
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
		try {
			File myObj = new File("inventory.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				toAdd[lineCounter%5] = myReader.nextLine().toString();
				if (lineCounter%5 == 4) {
					System.out.println("\n\nLo que se queire añadir");
					for (int i = 0; i < 5; i++) System.out.print(toAdd[i] + ", ");
					System.out.println();
					System.out.println("\n\nAntes de ir a la funcion");
					for (int i = 0; i < information.length; i++) {
						for (int j = 0; j < information[i].length; j++) {
							System.out.print(information[i][j] + ", ");
						}
						System.out.println();
					}
					
					information = Inventory.addElementArray(information, toAdd);
					
					System.out.println("\n\nComo sale de la funcion");
					for (int i = 0; i < information.length; i++) {
						for (int j = 0; j < information[i].length; j++) {
							System.out.print(information[i][j] + ", ");
						}
						System.out.println();
					}
					
					System.out.println();
					System.out.println();
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
