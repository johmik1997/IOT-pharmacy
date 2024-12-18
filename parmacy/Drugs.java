package parmacy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Drugs {
    private String drugName;
    private String drugGroup;
    private String expireDate;
    private String brands;
    private String drugAmount;
    Scanner input = new Scanner(System.in);
    String phathName = "C:\\Users\\Hp\\Desktop\\javaproject\\druginformation.txt";

    public void drugsInfo() {
        System.out.println("\t\t\t*********** wellcome to the iot pharmacy system*********" +
                "\t\t**********   welocome to the drug information segment***********");
        System.out.println(" enter the drug name");
        String namedrug = input.nextLine();
        this.drugName = namedrug;
        System.out.println(" enter the group of the drug e.g antibiotics");
        String groupOfdrug = input.nextLine();
        this.drugGroup = groupOfdrug;
        System.out.println(" enter the expiredate of the drug");
        String expiredate = input.nextLine();
        this.expireDate = expiredate;
        System.out.println(" enter the the manufaturing brand of the drug");
        String brand = input.nextLine();
        this.brands = brand;
        System.out.println(" enter the amount of the drug ");
        String amount = input.nextLine();
        this.drugAmount = amount;
        try {
            writeDrugs();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void writeDrugs() throws FileNotFoundException, IOException {
        File file = new File(phathName);
        try {
            FileWriter writer = new FileWriter(file);
            try (BufferedWriter writFile = new BufferedWriter(writer)) {
                writFile.write(drugName + drugGroup + expireDate + brands + drugAmount);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(
                " you have to successfully the drugs information , do you want add another drug type say yes(y) or no(n)");
        char opt = input.next().charAt(0);
        if (opt == 'y' || opt == 'Y') {
            drugsInfo();
        } else {
            PharmaLogin teo = new PharmaLogin();
            teo.pharmaJob();
        }
    }

    public void updateDrug() {
        String drugupdate = "";
        String amount = "";
        String drugName = "";
        System.out.println("\t\t\t*********** wellcome to the iot pharmacy system*********" +
                "\t\t******** welocome to the drug update information segment***********" +
                "\t\t********* to update drug enter drug name to search ");
        // int opt= input.nextInt();
        System.out.println("enter the name of the drug you want to update");
        drugName = input.nextLine();
        String[] arr = new String[5];
        int i = 0;
        String line = "";
        File file = new File(phathName);
        try (FileReader reader = new FileReader(file)) {
            BufferedReader readLine = new BufferedReader(reader);
            while ((line = readLine.readLine()) != null) {
                arr = line.split(" ");
                // Check if there are exactly 2 elements to prevent array index issues

                if (arr[0].equals(drugName)) {
                    System.out.println("what do you want to update the drug infomstion, amount");
                    drugupdate = input.nextLine();
                    if (drugupdate.equalsIgnoreCase("amount")) {
                        System.out.println("enter the amount of the drug you want update");
                        amount = input.nextLine();
                        arr[4] = amount;
                        System.out.println(" you have succesfull update you data");
                        break;
                    }
                } else {
                    System.out.println("the drug name you entered is not found in the file please try again later");
                    updateDrug();
                }

            }
        }

        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deletDrug() {
        String drugdelet = "";
        // String amount="";
        String trashpath = "\"C:\\Users\\Hp\\Desktop\\javaproject\\trashfile.txt\";";
        System.out.println("\t\t\t*********** wellcome to the iot pharmacy system*********\n" +
                "\t\t******** welocome to the drug update information segment***********\n" +
                "\t\t********* *********************************************************** ");
        System.out.println("enter the name of the drug you want to update");
        drugdelet = input.nextLine();
        String[] arr2 = new String[5];
        String[] arr = new String[5];
        int i = 0;
        String line2 = "";
        File file = new File(trashpath);
        try (FileReader reader = new FileReader(file)) {
            BufferedReader readLine = new BufferedReader(reader);
            while ((line2 = readLine.readLine()) != null) {
                arr2 = line2.split(" ");
                // Check if there are exactly 2 elements to prevent array index issues

                if (arr2[0].equals(drugdelet)) {
                    System.out.println("are you sure do you wanna delete this drug information please say yes or no");
                    String delet = input.nextLine();
                    if (delet.equalsIgnoreCase("yes")) {
                        for (int index = 0; i < arr2.length; i++) {
                            arr[i] = arr2[i];
                            arr2[i] = "";
                            try {
                                FileWriter writer = new FileWriter(file);
                                try (BufferedWriter writFile = new BufferedWriter(writer)) {
                                    writFile.write(arr2[i]);
                                }
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                        System.out.println(
                                "you have deleted successfully,if you want next time it's found in trash file");

                    }
                    break;
                } else {
                    System.out.println("we can not find the file");
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


public void viewDrug(){
     String line="";
    File file = new File(phathName);
    try (FileReader reader = new FileReader(file)) {
        BufferedReader readLine = new BufferedReader(reader);
        while ((line = readLine.readLine()) != null) {
            System.out.println(line);
        }}
    
    catch (IOException e) {
        e.printStackTrace();
    }

}

public void searchDrug(){
    String line="";
    System.out.println("###### enter drug name to search from the inventory ");
      String drName=input.nextLine();
      File file = new File(phathName);
    try (FileReader reader = new FileReader(file)) {
        BufferedReader readLine = new BufferedReader(reader);
        while ((line = readLine.readLine()) != null) {
            String[] column=line.split(",");
            String drugname=column[0].trim();
            if(drugname==drName){
                System.out.println("the drug is found");
            }
            else{System.out.println("we can not find the drug");}
}
    }
     catch (Exception e) {
        // TODO: handle exception
    }

}}