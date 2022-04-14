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
		
		// find user name and password
		try {
			File myObj = new File("users.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				myReader.nextLine();
				String data = myReader.nextLine();
				if (data.equals(userName)) {
					if (myReader.nextLine().equals(password)) {
						String typeUser = myReader.nextLine();
						if (typeUser.equals(USER_SUPERADMIN))
							return 2;
						if (typeUser.equals(USER_ADMIN))
							return 3;
						if (typeUser.equals(USER_EMPLOYEE))
							return 4;
						else return 5;
					}
					else {
						// incorrect password
						return 1;
					}
				}
				myReader.nextLine();
				myReader.nextLine();
			}
			myReader.close();
			
			// user name does not exist
			return 0;
			
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return 1;
	}

}
