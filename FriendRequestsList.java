import java.util.Scanner;

class FriendRequestsList 
{
    Scanner s = new Scanner(System.in);

    Account account = null;

    // To check whether already friends or not
    public boolean isMyFriend(Account a) {
        // If list is empty
        if (Login.currentLoginAccount.getFriends() == null)
            return false;

        for (Account b : Login.currentLoginAccount.getFriends()) {
            if (a.hashCode() == b.hashCode())
                return true;
        }

        return false;
    }

    public void friendRequestsList() 
    {
        MainPage.clearScreen(); // Clear Screen

        boolean flag = false;

        System.out.print("\n\n\n Press Enter to See the Pending List..... ");
        s.nextLine();

        MainPage.clearScreen(); // Clear Screen

        System.out.println("\n\n\t\t\t---------------------------------------------");
        System.out.println("\t\t\t            Pending Friend Requests");
        System.out.println("\t\t\t---------------------------------------------");

        for (Account a : CreateAccount.accounts) {
            if (a.hashCode() == Login.currentLoginAccount.hashCode()) {
                continue;
            }

            if (!isMyFriend(a)) 
            {
                // If list is empty
                if (a.getFriends() == null)
                    break;

                for (Account b : a.getFriends()) {
                    if (b.hashCode() == Login.currentLoginAccount.hashCode()) 
                    {
                        System.out.println("\n\t\t\t Request Pending\t" + a.getName());

                        flag = true;

                        System.out.println("\t\t\t---------------------------------------------");
                    }
                }
            }
        }

        if (!flag) 
        {
            System.out.println("\n\t\t\t\t    No Requests to show!!!\n");

            System.out.println("\t\t\t---------------------------------------------");

            System.out.print("\n\n\n Press Enter to Continue..... ");
            s.nextLine();

            // MainPage.clearScreen(); // Clear Screen
        }
    }
}
