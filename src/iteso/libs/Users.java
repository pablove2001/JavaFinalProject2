package iteso.libs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Users {

	private Users() {}
	
	private static void createTxtFile() {
		try {
			File myObj = new File("users.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
				try {
					FileWriter myWriter = new FileWriter("users.txt", true);
					myWriter.write("1\n");
					myWriter.write("superAdmin\n");
					myWriter.write("SuperAdmin\n");
					myWriter.write("12345678\n");
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
				myReader.nextLine();
				String data = myReader.nextLine();
				if (data.equals(userName)) {
					if (myReader.nextLine().equals(password)) {
						// correct user name and password
						return 0;
					}
					else {
						// incorrect password
						return 2;
					}
				}
				myReader.nextLine();
			}
			myReader.close();
			
			// user name does not exist
			return 1;
			
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return 1;
	}

}
