package iteso.libs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Users {

	final static String USER_SUPERADMIN = "superAdmin";
	final static String USER_ADMIN = "admin";
	final static String USER_EMPLOYEE = "employee";

	private Users() {}

	private static void createTxtFile() {
		try {
			File myObj = new File("users.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
				try {
					FileWriter myWriter = new FileWriter("users.txt", true);
					myWriter.write("1\n");
					myWriter.write("SuperAdmin\n");
					myWriter.write("12345678\n");
					myWriter.write("superAdmin\n");
					myWriter.close();
				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static int loginValidation(String userName, String password) {
		createTxtFile();
		int idUser;

		// find user name and password
		try {
			File myObj = new File("users.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				idUser = Integer.parseInt(myReader.nextLine());
				String data = myReader.nextLine();
				if (data.equals(userName)) {
					if (myReader.nextLine().equals(password)) {
						return idUser;
					}
					else {
						// incorrect password
						return -2;
					}
				}
				myReader.nextLine();
				myReader.nextLine();
			}
			myReader.close();

			// user name does not exist
			return -1;

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return -1;
	}

	public static int idToTypeUser(int idUser) {
		String[][] users = usersInformation();
		if (idUser > users.length || idUser < 1) return -1;
		
		return TypeUserInt(users[idUser-1][3]);
	}
	
	public static int TypeUserInt(String typeUser) {
		if(typeUser.equals(USER_SUPERADMIN)) return 0;
		if(typeUser.equals(USER_ADMIN)) return 1;
		return 2;
	}
	
	public static String[][] usersInformation() {
		String[][] information = {};

		createTxtFile();

		int lineCounter = 0;
		String[] toAdd = new String[4];
		String presta;
		try {
			File myObj = new File("users.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				presta = myReader.nextLine();
				toAdd[lineCounter%4] = presta;
				if (lineCounter%4 == 3) {						
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
