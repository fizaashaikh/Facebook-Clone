import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class SendFriendRequest 
{
    Scanner s = new Scanner(System.in);
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Function to Send Request
    // Time Complexity - O(n)
    public void sendFriendRequest() throws IOException 
    {
        SendRequest obj = new SendRequest();

        Account account = obj.sendRequest();

        if(account == null)
            return;

        System.out.println("\n\n\t\t\t---------------------------------------------------");
        System.out.println("\n\t\t\t    Friend Request Sent to " + account.getName() + "!");
        System.out.println("\n\t\t\t---------------------------------------------------");

        System.out.print("\n\n\n Press Enter and Return..... ");

        s.nextLine();

        MainPage.clearScreen(); // Clear Screen
    }
}
