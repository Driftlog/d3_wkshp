package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {   
        //directory to create
        String dirPath = args[0];

        File newDir = new File(dirPath);
        if (newDir.exists()) {
            System.out.println("Directory already exists.");
        } else {
            newDir.mkdir();
        }

        System.out.println("Welcome to my Shopping Cart");

        List<String> cart = new ArrayList<>();

        Console con = System.console();
        String input = "";
        //keeps track of current user
        //stores user cart items as well
        String user = "";

        while(!input.equals("quit")) {
            input = con.readLine("What do you wanna do");

            if (input.startsWith("login")) {
                Scanner scan = new Scanner(input.substring(6));
                
                while (scan.hasNext()) {
                    user = scan.next();
                }

                //check if file exists
                
                File loginFile = new File(dirPath + File.separator + user);
                if (loginFile.exists()) {
                    System.out.println("File " + user + "already exists");
                } else {
                    loginFile.createNewFile();
                }
            }

            if (input.equals("users")) {
                File directoryPath = new File(dirPath);
                String [] directoryList = directoryPath.list();

                System.out.println("List of files and directories in the specific folder" + dirPath);
                for (String dirList : directoryList) {
                    System.out.println(dirList);
                }
            }

            if (input.startsWith("add")) {
                input = input.replace(",", "");

                //1. use FileWriter & PrinterWriter to write a <loginuser> file

                FileWriter fw = new FileWriter(dirPath);
                PrintWriter pw = new PrintWriter(fw);

                String currentScanString = "";
                Scanner inputScanner = new Scanner(input.substring(4));
                while (inputScanner.hasNext()) {
                    currentScanString = inputScanner.next();
                    cart.add(currentScanString);

                    //2.write to file using PrintWriter
                    pw.write("\n" + currentScanString);
                }

                //flush and close fileWriter & PrintWriter objects
                pw.flush();
                pw.close();
                fw.close();
            }

            if (input.equals("list")) {
                //need file and br to read cart items from File
                File readFile = new File(dirPath + File.separator + user);
                BufferedReader br = new BufferedReader(new FileReader(readFile));


                String readFileInput = "";

                //While loop to read item records in file
                
                (while ) {
                    
                }
            }
        }

    }
}
