import java.io.IOException;
import java.util.List;
import java.util.Scanner;

class ShowFriends 
{
    Scanner s = new Scanner(System.in);

    // Function to See Friends
    // Time Complexity - O(n^2)
    public void showFriends() throws InterruptedException, IOException 
    {
        List<Account> friends = Login.currentLoginAccount.getFriends();

        boolean flag = false;

        System.out.print("\n\n\n Press Enter to Continue..... ");

        s.nextLine();

        MainPage.clearScreen();
        
        System.out.println("\n\n\t\t\t---------------------------------------------");
        System.out.println("\t\t\t      ID of Current Account: " + Login.currentLoginAccount.hashCode());
        System.out.println("\t\t\t---------------------------------------------");

        System.out.print("\n\n\n Press Enter to See the Friend List..... ");
        
        s.nextLine();

        MainPage.clearScreen();

        if (friends.isEmpty()) 
        {
            System.out.println("\n\n\t\t\t\t--------------------------------------");
            System.out.println("\n\t\t\t\t       No Friends to Show!!!");
            System.out.println("\n\t\t\t\t--------------------------------------");

            System.out.print("\n\n\n Press Enter and Return..... ");
            s.nextLine();

            MainPage.clearScreen();

            return;
        }

        System.out.println("\n\n\t\t\t--------------------------------------------------");
        System.out.println("\t\t\t\t            Your Friends");
        System.out.println("\t\t\t--------------------------------------------------\n");

        for (Account a : Login.currentLoginAccount.getFriends()) 
        {

            if (a.getFriends() != null) 
            {
                for (Account b : a.getFriends()) 
                {
                    if (Login.currentLoginAccount.hashCode() == b.hashCode()) 
                    {
                        System.out.println("\t\t\t Friends\t\t" + a.getName());
                        flag = true;
                    }
                }

                if (!flag)
                {
                    System.out.println("\t\t\t Request Pending\t" + a.getName());
                }
            } 

            else 
            {
                System.out.println("\t\t\t Pending\t\t" + a.getName());
            }

            flag = false;

            System.out.println("\t\t\t--------------------------------------------------");
        }

        System.out.print("\n\n\n Press Enter and Return..... ");
        s.nextLine();

        MainPage.clearScreen();

    }
}
