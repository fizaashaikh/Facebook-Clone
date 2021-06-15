import java.io.IOException;
import java.util.Scanner;

class YourProfile 
{
    Scanner s = new Scanner(System.in);

    public void yourProfile() throws IOException
    {
        System.out.print("\n\n\n Press Enter to See Your Profile.... ");

        s.nextLine();

        MainPage.clearScreen(); // Clear Screen

        int choice;

        // Object of EditProfile Class
        EditProfile obj = new EditProfile();

        do
        {
            MainPage.clearScreen(); // Clear Screen

            // Show Profile
            System.out.println("\n\n\n\n\t\t\t----------------------------------------------------------------\n");
            System.out.println("\t\t\t\t\t     " + Login.currentLoginAccount.getName() + "'s Profile");
            System.out.println("\n\t\t\t----------------------------------------------------------------");

            System.out.println("\n\t\t\t" + Login.currentLoginAccount.showProfile());

            System.out.println("\n\t\t\t----------------------------------------------------------------");

            System.out.println("\n\n\t\t\tPress 1 to Edit Your Profile\t\t\tPress 0 to Return");
            System.out.print("\n\t\t\tEnter Here: ");
            choice = s.nextInt();

            switch(choice)
            {
                case 1:
                    // Edit Profile
                    obj.editProfile();

                    break;
                    
                case 0:
                    System.out.print("\n\n\n Press Enter and Return..... ");
                    s.nextLine();

                    MainPage.clearScreen(); // Clear Screen

                    break;

                default:
                    MainPage.clearScreen();
            }

        } while(choice != 0);

    }
}
