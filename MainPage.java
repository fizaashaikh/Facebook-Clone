/*
***********************************************************************************************************************************************

Batch: C3

-------------------------------
Roll No           Name
-------------------------------
2954           Fiza Shaikh
2968           Neha Bhandari
2969           Pratiksha Bhise
2970           Ashwini Biradar
--------------------------------


PROBLEM STATEMENT:

Write a program in Java to implement social media network for example: Facebook, which consists of the following operations-
1. Create Account
2. Send Friend Request
3. Show Friend Requests
4. Remove Friend
5. Search Profile

***********************************************************************************************************************************************
*/

import java.io.IOException;
import java.util.*;

// Class MainPage
public class MainPage 
{
        public static void clearScreen() 
        {

            System.out.print("\033[H\033[2J");

            System.out.flush();

         }

        // main Function 
        public static void main(String[] args) throws IOException, InterruptedException 
        {
            clearScreen();

            // Add already created accounts
            AddAccounts.addAccounts();

            int choice;
            
            Scanner sc = new Scanner(System.in);

            // Object of CreateAccount Class
            CreateAccount obj1 = new CreateAccount();

            // Object of Login Class
            Login obj2 = new Login();

            ////////////////////////////////////// HOME PAGE ////////////////////////////////////
            
            do {
                System.out.println("\n\n\n --------------------------------------------------------------");
                System.out.println("                    WELCOME TO FACEBOOK!!!");
                System.out.println(" --------------------------------------------------------------");

                System.out.println("\n\n Create a New Account Here!!! Press 1\n\n");
                System.out.println("\n\n                                   Already have an Account?");
                System.out.println("                                               Press 2 to Login\n\n");
                System.out.println("\n\n Press 3 to Close the App");
                System.out.println(" --------------------------------------------------------------");

                System.out.print("\n\n Enter Your Choice: ");
                choice = sc.nextInt();

                switch (choice) 
                {
                    case 1:
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                        // Create Account
                        obj1.createAccount();   

                        break;

                    case 2:
                        // Login
                        obj2.login();   

                        break;

                    default:
                        // Clear Screen
                        clearScreen();  
                }

            } while (choice != 3);

            sc.close();

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            System.out.println("\n\n\n\n\t\t\t\t-----------------------------");
            System.out.println("\n\t\t\t\t        THANK YOU!!!");
            System.out.println("\n\t\t\t\t-----------------------------\n\n\n");
    }

}