package parmacy;
import java.util.Scanner;;
public class firstpage {
   String roleName;
    public void identifyRole(){
      System.out.println("\t\t\t\t*********************************************************************************\n" +
                "\t\t\t\t*********************************************************************************\n" +
                "\t\t\t\t**      Hi, THIS IS AN iOT PHARMACY MANAGEMENT SYSTEM.                            *********\n" +
                "\t\t\t\t**      PLEASE FOLLOW THE FOLLOWING INSTRUCTIONS              **\n"+
                "\t\t\t********** if you are a pharmacict enter 1*****************************************\n"+
                "\t\t\t\t********* if you are a user please enter 2***************************************\n"+
                "\t\t\t\t************ if you are an admin please enter 3**********************************\n" );
      Scanner input=new Scanner(System.in);
      int cho=input.nextInt();
      switch (cho) {
         case 1:
            System.out.println(" your are a pharmacict");

            PharmaLogin pharma =new PharmaLogin();
            pharma.loginmethod();

            break;
         case 2:
         System.out.println("you are the user of our pharmacy, thank you for choosing our service");
         Loginpage move = new Loginpage();
         move.loginmethod();
         break;
         case 3:
         System.out.println(" you are our adminstrator welcome to the system");
         Adminlogin admin =new Adminlogin();
         admin.loginmethod();
         break;
         default:
            break;
      }

    }
public static void main(String[] args) {
   firstpage move = new firstpage();
   move.identifyRole();
   //scanner input=new scanner(System.in);
}
}
