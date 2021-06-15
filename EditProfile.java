import java.io.IOException;
import java.util.Scanner;

class EditProfile 
{
    Scanner sc = new Scanner(System.in);
    
    public void editProfile() throws IOException 
    {
        MainPage.clearScreen(); // Clear Screen

        int choice;

        do
        {
            MainPage.clearScreen(); // Clear Screen
        
            // Show Profile with Editing Options
            System.out.println("\n\n\n\n\t\t\t-----------------------------------------------------------\n");
            System.out.println("\t\t\t\t\t    " + Login.currentLoginAccount.getName() + "'s Profile");
            System.out.println("\n\t\t\t-----------------------------------------------------------");

            System.out.println("\n\t\t\t" + Login.currentLoginAccount.showProfile());

            System.out.println("\n\t\t\t-----------------------------------------------------------");

            System.out.println("\n\n\t\t\t0. Exit");
            System.out.println("\n\n\t\t\t1. Edit Name \t\t\t 2. Edit Username");
            System.out.println("\n\t\t\t3. Edit Mobile Number \t\t 4. Edit Email ID");
            System.out.println("\n\t\t\t5. Edit Date of Birth \t\t 6. Reset Password");

            System.out.print("\n\n\t\t\tEnter Here: ");
            choice = sc.nextInt();

            switch(choice)
            {
                case 0:
                    // Exit
                    System.out.print("\n\n\n Press Enter to Exit..... ");

                    sc.nextLine();

                    MainPage.clearScreen(); // Clear Screen

                    break;

                case 1:
                    // Edit Name
                    Login.currentLoginAccount.setName();

                    break;

                case 2:
                    // Edit Username
                    Login.currentLoginAccount.setUserName();

                    break;

                case 3:
                    // Edit Mobile Number
                    Login.currentLoginAccount.setMob();

                    break;

                case 4:
                    // Edit Email ID
                    Login.currentLoginAccount.setEmail();

                    break;

                case 5:
                    // Edit DOB
                    Login.currentLoginAccount.setDOB();

                    break;

                case 6:
                    // Reset Password
                    Login.currentLoginAccount.resetPassword();

                    break;

                default:
                    MainPage.clearScreen();
            }

        } while(choice != 0);
    }
}
