import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class SearchProfile 
{
    Scanner s = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    // Function to Search Profile
    // Time Complexity - O(n)
    public void searchProfile() throws IOException
    {
        MainPage.clearScreen(); // Clear Screen

        SendRequest obj = new SendRequest();

        // Input Username of the account to send request
        System.out.println("\n\n\t\t\t----------------------------------");
        System.out.print("\t\t\t Enter Username: ");
        String name = br.readLine();
        System.out.println("\t\t\t----------------------------------");

        System.out.print("\n\n\n Press Enter to Continue..... ");

        s.nextLine();

        MainPage.clearScreen(); // Clear Screen

        Account account = obj.findAccountByName(name);

        // If account does not exist
        if (account == null) 
        {
            System.out.println("\n\n\t\t\t-----------------------------");
            System.out.println("\n\t\t\t      User Not Found!");
            System.out.println("\n\t\t\t-----------------------------");

            System.out.print("\n\n\n Press Enter and Return..... ");

            s.nextLine();

            MainPage.clearScreen(); // Clear Screen

            return;
        }

        System.out.println("\n\n\t\t\t----------------------------------");
        System.out.println("\t\t\t " + account.getName() + " Found");
        System.out.println("\t\t\t----------------------------------");

        System.out.print("\n\n\n Press Enter to See " + account.getName() + "'s Profile.... ");
        s.nextLine();

        MutualFriends friend = new MutualFriends();

        int choice;

        do
        {
            MainPage.clearScreen(); // Clear Screen

            // Show Profile
            System.out.println("\n\n\n\n\t\t\t----------------------------------------------------------------\n");
            System.out.println("\t\t\t\t\t   " + account.getName() + "'s Profile");
            System.out.println("\n\t\t\t----------------------------------------------------------------");

            System.out.println("\n\t\t\t" + account.showProfile());

            System.out.println("\n\t\t\t----------------------------------------------------------------");

            System.out.println("\n\n\t\t\tPress 1 to See Mutual Friends\t\tPress 0 to Return");
            System.out.print("\n\t\t\tEnter Here: ");
            choice = s.nextInt();

            switch(choice)
            {
                case 1:
                    // See Mutual Friends
                    friend.mutualFriends(account);

                    break;
                    
                case 0:
                    System.out.print("\n\n\n Press Enter and Return..... ");
                    s.nextLine();

                    MainPage.clearScreen(); // Clear Screen

                    break;

                default:
                    MainPage.clearScreen(); // Clear Screen
            }

        } while(choice != 0);
    }
}
