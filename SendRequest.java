import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class SendRequest 
{
    Scanner s = new Scanner(System.in);

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Time Complexity - O(n)
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

    public Account sendRequest() throws IOException
    {
        MainPage.clearScreen(); // Clear Screen

        // Input Username of the account to send request
        System.out.println("\n\n\t\t\t----------------------------------");
        System.out.print("\t\t\t Enter Username: ");
        String name = br.readLine();
        System.out.println("\t\t\t----------------------------------");

        System.out.print("\n\n\n Press Enter to Continue..... ");

        s.nextLine();

        MainPage.clearScreen(); // Clear Screen

        Account account = findAccountByName(name);

        // If account does not exist
        if (account == null) 
        {
            System.out.println("\n\n\t\t\t-----------------------------");
            System.out.println("\n\t\t\t      User Not Found!");
            System.out.println("\n\t\t\t-----------------------------");

            System.out.print("\n\n\n Press Enter and Return..... ");

            s.nextLine();

            MainPage.clearScreen(); // Clear Screen

            return account;
        }

        System.out.println("\n\n\t\t\t----------------------------------");
        System.out.println("\t\t\t " + account.getName() + " Found");
        System.out.println("\t\t\t----------------------------------");

        System.out.print("\n\n\n Press Enter and Send Request to " + account.getName() + ".... ");

        s.nextLine();

        MainPage.clearScreen(); // Clear Screen

        Login.currentLoginAccount.addFriend(account);

        return account;
    }
}
