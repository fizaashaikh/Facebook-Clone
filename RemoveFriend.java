import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

class RemoveFriend 
{
    Scanner s = new Scanner(System.in);

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Account findAccountByName(String name) 
    {
        for (Account ac : CreateAccount.accounts) 
        {

            if (ac.userName().equals(name)) 
            {
                return ac;
            }

        }

        return null;
    }

    // Function to remove Friend
    // Time Complexity - O(n^2)
    public void removeFriend() throws InterruptedException, IOException
    {
        List<Account> friends = Login.currentLoginAccount.getFriends();

        System.out.print("\n\n\n Press Enter to Continue..... ");

        s.nextLine();

        MainPage.clearScreen();

        System.out.println("\n\n\t\t\t---------------------------------------------");
        System.out.println("\t\t\t      ID of Current Account: " + Login.currentLoginAccount.hashCode());
        System.out.println("\t\t\t---------------------------------------------");

        System.out.print("\n\n\n Press Enter to see the Friend List..... ");
        
        s.nextLine();

        MainPage.clearScreen();

        if (friends.isEmpty()) {
            System.out.println("\n\n\t\t\t\t--------------------------------------");
            System.out.println("\n\t\t\t\t       No Friends to Show!!!");
            System.out.println("\n\t\t\t\t--------------------------------------");

            System.out.print("\n\n\n Press Enter to Continue..... ");

            s.nextLine();

            MainPage.clearScreen();

            return;
        }

        System.out.println("\n\n\t\t\t--------------------------------------------------");
        System.out.println("\t\t\t\t            Your Friends");
        System.out.println("\t\t\t--------------------------------------------------\n");

        for (Account a : friends) 
        {
            if (a.getFriends() != null) 
            {
                for (Account b : a.getFriends()) 
                {
                    if (Login.currentLoginAccount.hashCode() == b.hashCode()) 
                    {
                        System.out.println("\t\t\t Friends\t\t" + a.getName());
                    }
                    
                }

            }

            System.out.println("\t\t\t--------------------------------------------------");
        }

        System.out.print("\n\n\n Press Enter to Continue..... ");

        s.nextLine();

        MainPage.clearScreen();

        System.out.println("\n\n\t\t\t-----------------------------");
        System.out.print("\t\t\t Enter Username: ");
        String name = br.readLine();
        System.out.println("\t\t\t-----------------------------");

        System.out.print("\n\n\n Press Enter to Continue..... ");

        s.nextLine();

        MainPage.clearScreen(); // Clear Screen

        Account account = findAccountByName(name);

        if (account == null) 
        {
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

        System.out.print("\n\n\n Press Enter to Remove " + account.getName() + ".... ");

        s.nextLine();

        MainPage.clearScreen(); // Clear Screen

        Login.currentLoginAccount.removeFriend(account);

        account.removeFriend(Login.currentLoginAccount);

        System.out.println("\n\n\t\t\t-----------------------------------------");
        System.out.println("\t\t\t " + account.getName() + " Removed Successfully!");
        System.out.println("\t\t\t-----------------------------------------");

        System.out.print("\n\n\n Press Enter to Continue..... ");

        s.nextLine();

        MainPage.clearScreen(); // Clear Screen
    }
}
