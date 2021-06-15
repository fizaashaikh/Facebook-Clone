import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class ShowFriendRequests
{
    Scanner sc = new Scanner(System.in);
    Scanner s = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Account account = null;
    
    // To check whether already friends or not
    public boolean isMyFriend(Account a) 
    {
        // If list is empty
        if (Login.currentLoginAccount.getFriends() == null)
            return false;

        for (Account b : Login.currentLoginAccount.getFriends() ) 
        {
            if (a.hashCode() == b.hashCode())
                return true;
        }
        
        return false;
    }

    // To check Pending Friend Requests
    public void showFriendRequests() throws IOException 
    {
        MainPage.clearScreen(); // Clear Screen

        // Object of SendRequest Class
        SendRequest obj = new SendRequest();

        // Object of FriendRequestList Class
        FriendRequestsList list = new FriendRequestsList();
            
        int choice;

        // Confirm or Delete the Request
        do 
        {
            list.friendRequestsList();

            System.out.println("\n\n\n\t\t\t1. Confirm Request\n");
            System.out.println("\t\t\t2. Delete Request");

            System.out.println("\n\n\t\t\tIf No Friends Available or to Return Press 0.");

            System.out.print("\n\n\t\t\tEnter Choice: ");
            choice = sc.nextInt();

            // To Confirm Request
            if(choice == 1)
            {
                MainPage.clearScreen(); // Clear Screen

                // Input Username of the account to Confirm Request
                System.out.println("\n\n\t\t\t----------------------------------");
                System.out.print("\t\t\t Enter Username: ");
                String name = br.readLine();
                System.out.println("\t\t\t----------------------------------");

                System.out.print("\n\n\n Press Enter to Continue..... ");
                s.nextLine();

                MainPage.clearScreen(); // Clear Screen

                // Find Account
                account = obj.findAccountByName(name);

                // If Account does not exist
                if (account == null) {
                    System.out.println("\n\n\t\t\t-----------------------------");
                    System.out.println("\n\t\t\t      User Not Found!");
                    System.out.println("\n\t\t\t-----------------------------");

                    System.out.print("\n\n\n Press Enter to Continue..... ");
                    s.nextLine();

                    MainPage.clearScreen(); // Clear Screen

                    return;
                }

                System.out.println("\n\n\t\t\t----------------------------------");
                System.out.println("\t\t\t " + account.getName() + " Found");
                System.out.println("\t\t\t----------------------------------");

                System.out.print("\n\n\n Press Enter to Confirm " + account.getName() + ".... ");
                s.nextLine();

                MainPage.clearScreen(); // Clear Screen

                // Add Account
                Login.currentLoginAccount.addFriend(account);

                System.out.println("\n\n\t\t\t----------------------------------");
                System.out.println("\n\t\t\t    Friend Request CONFIRMED!");
                System.out.println("\n\t\t\t----------------------------------");

                System.out.print("\n\n\n Press Enter to Continue..... ");
                s.nextLine();

                MainPage.clearScreen(); // Clear Screen
            }

            // To Delete the Request
            else if (choice == 2)
            {
                MainPage.clearScreen(); // Clear Screen

                System.out.println("\n\n\t\t\t----------------------------------");
                System.out.print("\t\t\t Enter Username: ");
                String name = br.readLine();
                System.out.println("\t\t\t----------------------------------");

                System.out.print("\n\n\n Press Enter to Continue..... ");
                s.nextLine();

                MainPage.clearScreen(); // Clear Screen

                // Find Account
                account = obj.findAccountByName(name);

                // If Account does not exist
                if (account == null)
                {
                    System.out.println("\n\n\t\t\t-----------------------------");
                    System.out.println("\n\t\t\t      User Not Found!");
                    System.out.println("\n\t\t\t-----------------------------");

                    System.out.print("\n\n\n Press Enter to Continue..... ");
                    s.nextLine();

                    MainPage.clearScreen(); // Clear Screen

                    continue;
                }

                // Remove Account
                account.removeFriend(Login.currentLoginAccount);

                System.out.println("\n\n\t\t\t----------------------------------");
                System.out.println("\n\t\t\t    Friend Request DELETED!");
                System.out.println("\n\t\t\t----------------------------------");

                System.out.print("\n\n\n Press Enter to Continue..... ");
                s.nextLine();

                MainPage.clearScreen(); // Clear Screen
            }

            else if(choice != 0)
            {
                MainPage.clearScreen(); // Clear Screen
                
                System.out.println("\n\n\t\t\t----------------------------------");
                System.out.println("\n\t\t\t          Wrong Choice!");
                System.out.println("\n\t\t\t----------------------------------");

                System.out.print("\n\n\n Press Enter to Continue..... ");
                s.nextLine();

                MainPage.clearScreen();
            }

        } while(choice != 0);

        System.out.print("\n\n\n Press Enter and Return..... ");
        s.nextLine();

        MainPage.clearScreen(); // Clear Screen
    }

}
