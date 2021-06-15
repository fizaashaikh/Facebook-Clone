import java.util.Scanner;

class MutualFriends 
{
    Scanner s = new Scanner(System.in);
    
    public void mutualFriends(Account account) 
    {
        MainPage.clearScreen();

        boolean flag = false;

        System.out.print("\n\n\n Press Enter to See Mutual Friends..... ");

        s.nextLine();

        if(Login.currentLoginAccount.getFriends() == null)
        {
            System.out.println("\n\n\t\t\t\t--------------------------------------");
            System.out.println("\n\t\t\t\t  You Don't Have Any Friends!!!");
            System.out.println("\n\t\t\t\t--------------------------------------");

            System.out.print("\n\n\n Press Enter and Return..... ");
            s.nextLine();

            MainPage.clearScreen();

            return;
        }

        System.out.println("\n\n\t\t\t--------------------------------------------------");
        System.out.println("\t\t\t\t            Mutual Friends");
        System.out.println("\t\t\t--------------------------------------------------\n");

        for(Account a : Login.currentLoginAccount.getFriends())
        {
            if(a.getFriends().contains(Login.currentLoginAccount) && account.getFriends().contains(a) && a.getFriends().contains(account))
            {
                if (a == account)
                    continue;

                System.out.println("\t\t\t   " + a.getName());

                flag = true;

                System.out.println("\t\t\t--------------------------------------------------");
            }
        }

        if (!flag) 
        {
            System.out.println("\n\t\t\t\t    No Mutual Friends to show!!!\n");

            System.out.println("\t\t\t--------------------------------------------------");
        }

        System.out.print("\n\n\n Press Enter to Continue..... ");
        s.nextLine();

        MainPage.clearScreen(); // Clear Screen
    }
}
