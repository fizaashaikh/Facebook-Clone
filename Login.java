import java.io.IOException;
import java.util.*;

// Login class
class Login 
{
    // Create Current Login Account
    public static Account currentLoginAccount = null;

    Scanner sc = new Scanner(System.in);

    Scanner s = new Scanner(System.in);

    // Function to Login
    public void login() throws IOException, InterruptedException 
    {
        MainPage.clearScreen();

        // Object of FindAccount Class
        FindAccount obj1 = new FindAccount();

        // Object of SendFriendRequest Class
        SendFriendRequest obj2 = new SendFriendRequest();
        
        // Object of ShowFriends Class
        ShowFriends obj3 = new ShowFriends();

        // Object of ShowFriendRequests Class
        ShowFriendRequests obj4 = new ShowFriendRequests();

        // Object of RemoveFriend Class
        RemoveFriend obj5 = new RemoveFriend();

        // Object of SearchProfile Class
        SearchProfile obj6 = new SearchProfile();

        // Object of YourProfile Class
        YourProfile obj7 = new YourProfile();

        String userName, password;

        System.out.println("\n\n\t\t\t---------------------------------");
        System.out.println("\t\t\t         FACEBOOK LOGIN");
        System.out.println("\t\t\t---------------------------------\n");
        System.out.print("\t\t\t Username: ");
        userName = sc.next();

        System.out.print("\n\t\t\t Password: ");
        password = sc.next();
        System.out.println("\n\t\t\t---------------------------------");

        System.out.print("\n\n\n Press Enter to Login..... ");

        s.nextLine();

        // Find Current Login Account
        currentLoginAccount = obj1.findAccount(userName, password);

        if (currentLoginAccount == null) 
        {
            MainPage.clearScreen();

            System.out.println("\n\n\t\t\t----------------------");
            System.out.println("\n\t\t\t     Login failed!");
            System.out.println("\n\t\t\t----------------------");

            System.out.println("\n\n\t\t\tCheck Your Username Or Password Again!");

            System.out.print("\n\n\n Press Enter and Return to the HOME PAGE..... ");

            s.nextLine();

            MainPage.clearScreen();

            return;
        }

        MainPage.clearScreen();

        System.out.println("\n\n\t\t\t-----------------------");
        System.out.println("\n\t\t\t  Login Successful!!!");
        System.out.println("\n\t\t\t-----------------------");

        System.out.print("\n\n\n Press Enter to Continue..... ");

        s.nextLine();

        MainPage.clearScreen();

        int choice;

        do {
            System.out.println("\n\n\t\t\t-----------------------------------------------------------------------");
            System.out.println("\t\t\t\t                   What's on your mind?");
            System.out.println("\t\t\t-----------------------------------------------------------------------");

            System.out.println("\n\t\t\t\t\t1. Send Friend Request");

            System.out.println("\n\n\n\t\t\t\t\t\t\t\t  2. Show Friend List");

            System.out.println("\n\n\n\t\t\t 3. Show Pending Requests");

            System.out.println("\n\n\n\t\t\t\t\t\t\t\t 4. Remove Friend");

            System.out.println("\n\n\n\t\t\t    5. Search");

            System.out.println("\n\n\n\t\t\t\t\t\t6. Your Profile");

            System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t7. Logout");

            System.out.println("\n\t\t\t-----------------------------------------------------------------------");

            System.out.print("\n\n   Enter Here: ");
            choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    // Send Friend Request
                    obj2.sendFriendRequest();

                    break;

                case 2:
                    // Show Friend List
                    obj3.showFriends();

                    break;

                case 3:
                    // Show Pending Friend Requests 
                    obj4.showFriendRequests();

                    break;

                case 4:
                    // Remove Friend
                    obj5.removeFriend();

                    break;

                case 5:
                    // Search Profile
                    obj6.searchProfile();

                    break;

                case 6:
                    // Your Profile
                    obj7.yourProfile();

                    break;

                case 7:
                    // Logout
                    System.out.print("\n\n\n Press Enter to Logout..... ");

                    s.nextLine();

                    MainPage.clearScreen();

                    currentLoginAccount = null;

                    System.out.println("\n\n\t\t\t-----------------------");
                    System.out.println("\n\t\t\t Logout Successful!!!");
                    System.out.println("\n\t\t\t-----------------------");

                    System.out.print("\n\n\n Press Enter and Return to the HOME PAGE..... ");

                    s.nextLine();

                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    
                    break;

                default:
                    System.out.println("Select Correct Option!!!");
            }

        } while (choice != 7);
    }
}
