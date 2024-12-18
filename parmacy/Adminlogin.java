package parmacy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Adminlogin  extends Loginpage{
     String path = "C:\\Users\\Hp\\Desktop\\javaproject\\administrators.txt"; // Corrected file path
    Scanner input = new Scanner(System.in);

    public void loginmethod() {
        System.out.println("\t\t\t\t*********************************************************************************\n" +
                "\t\t\t\t*********************************************************************************\n" +
                "\t\t\t\t**         Hi, THIS IS AN iOT PHARMACY INVOICE MANAGEMENT SYSTEM.       *********\n" +
                "\t\t\t\t***                    welcome to the admin interface                                                                  "+
                "\t\t\t\t**                  PLEASE FOLLOW THE FOLLOWING INSTRUCTIONS             ********\n" +
                "\t\t\t\t**       1.ENTER THE USERNAME AND PASSWORD ON THE INTERFACE BELOW               **\n" +
                "\t\t\t\t**          IN ORDER TO SIGN IN                                                 **\n" +
                "\t\t\t\t**      ********************************************************************    **\n" +
                "\t\t\t\t**                                                                             **\n" +
                "\t\t\t\t**                     PLEASE ENTER:                                           **\n" +
                "\t\t\t\t**                                  1  TO SIGN IN                              **\n" +
                "\t\t\t\t**                                                                             **\n" +
                "\t\t\t\t*********************************************************************************\n" +
                "\t\t\t\t*********************************************************************************");
        System.out.print("\t\t\t\t  ==> ");
        int value = input.nextInt();
        input.nextLine(); // Consume the newline left by nextInt()
        if (value == 1) {
            signIn_page();
        } else {
            System.out.println("********** You entered an invalid input, please try again!");
            loginmethod();
        }
    }
     protected void signIn_page() {
             System.out.println("\t\t\t\t*********************************************************************************\n" +
                     "\t\t\t\t**                                    SIGN IN PAGE                             **");
             System.out.print("\t\t\t\t      USERNAME: ");
             String usersname = input.nextLine();
     
             System.out.print("\t\t\t\t      PASSWORD: ");
             String userpassword = input.nextLine();
     
             boolean found = false;
             File file = new File(path);
     
             try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                 String line;
     
                 while ((line = reader.readLine()) != null) {
                     String[] credentials = line.split(" ");
                     // Check if there are exactly 2 elements to prevent array index issues
                     if (credentials.length == 2) {
                         if (credentials[0].equals(usersname) && credentials[1].equals(userpassword)) {
                             found = true;
                             break;
                         }
                     }
                 }
     
                 if (found) {
                     System.out.println("You have successfully signed in.");
                 } else {
                     System.out.println("Login failed. Please try again.");
                     signIn_page(); // Optionally, you might want to prompt again or exit
                 }
     
             } catch (IOException e) {
                 System.out.println(e.getMessage());
             }
             
         }
}


