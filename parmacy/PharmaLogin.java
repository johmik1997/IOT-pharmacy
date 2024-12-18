package parmacy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PharmaLogin extends Loginpage {
       
    String path = "C:\\Users\\Hp\\Desktop\\javaproject\\pharmacists.txt"; // Corrected file path
    Scanner input = new Scanner(System.in);

    public void loginmethod() {
        System.out.println("\t\t\t\t*********************************************************************************\n" +
                "\t\t\t\t*********************************************************************************\n" +
                "\t\t\t\t**   Hi, THIS IS AN iOT PHARMACY INVOICE MANAGEMENT SYSTEM. welcome to the system                          *********\n" +
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
                     pharmaJob();
                 } else {
                     System.out.println("Login failed. Please try again.");
                     signIn_page(); // Optionally, you might want to prompt again or exit
                 }
     
             } catch (IOException e) {
                 System.out.println(e.getMessage());
             }
             
         }
        public void pharmaJob() throws FileNotFoundException, IOException{
            System.out.println("\t\t****** This is the interface for only pharmacist*******\n"+
                             "\t\t***** * enter 1 to add drug information to the file *********\n"+
                             "\t\t****** enter 2 to update the drug information on the file*****\n"+
                             "\t\t******* enter 3 to delete the drug information****************\n"+
                             "\t\t########## enter 4 to view all drug from the inventory##########\n"+
                             "\t\t########## enter 5 to search the drug from the inventory #######\n"); 
                             int cho=input.nextInt();
                    switch (cho) {
                        case 1:
                            Drugs drug =new Drugs();
                            drug.drugsInfo();
                            break;
                        case 2:
                        Drugs add=new Drugs();
                          add.updateDrug();
                        break;
                        case 3:
                        Drugs delet=new Drugs();
                        delet.deletDrug();
                        break;
                        case 4:
                        Drugs view=new Drugs();
                        view.viewDrug();
                        case 5:
                        Drugs search=new Drugs();
                        search.searchDrug();
                        default:
                            break;
                    }
        }
}
