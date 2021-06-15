import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

class CreateAccount 
{
    Scanner sc = new Scanner(System.in);
    Scanner s = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Create list of accounts
    public static List<Account> accounts = new ArrayList<>();

    // Create single account
    public Account account = null;

    // Function to Create Account
    // Time Complexity - O(n)
    public void createAccount() throws IOException, InterruptedException 
    {

        System.out.println("\n ===========================================");
        System.out.println(" SIGN UP");
        System.out.println(" It's quick and easy.");
        System.out.println(" ===========================================");

        // Local Variables
        String fname;
        String lname;
        String mob;
        String email;
        String userName;
        String password1;
        String password2;
        String dob;
        char gender = 'O';

        // Input First Name
        System.out.print("\n First Name: ");
        fname = br.readLine();

        // Input Last Name
        System.out.print("\n Last Name: ");
        lname = br.readLine();

        // Regex for mobile number matching
        String regex = "(0/91)?[7-9][0-9]{9}";

        // Input Mobile Number and check if it is valid or not
        do 
        {
            System.out.print("\n Mobile Number: ");
            mob = sc.next();

            if (!mob.matches(regex))
                System.out.println("\n       Invalid Mobile Number! Enter Again!");

        } while (!mob.matches(regex));

        // Regex for Email ID matching
        regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        boolean result;

        // Input Email ID and check if it is valid or not
        do
        {
            System.out.print("\n Email ID: ");
            email = sc.next();

            result = email.matches(regex);

            if(!result)
                System.out.println("\n       Email-id is not valid! Enter Again!");

        } while(!result);

        System.out.println("\n -------------------------------------------");

        // Regex to check valid username.
        regex = "^[a-z]\\w{3,29}$";

        // Compile the Regex
        Pattern p = Pattern.compile(regex);
        Matcher m;

        // Input Username and check if it is valid or not
        do {
            System.out.print("\n Username: ");
            userName = sc.next();

            m = p.matcher(userName);

            if (!m.matches())
                System.out.println("\n       Invalid Username! Enter Again!");

        } while (!m.matches());

        // Input New Password
        do
        {
            System.out.print("\n New Password: ");
            password1 = sc.next();

            System.out.print("\n Confirm Password: ");
            password2 = sc.next();

            // Check if New password and Confirmed password matches or not
            if(!password1.equals(password2))
            {
                System.out.println("\n        Password Does Not Match! Enter Again!");
            }
        
        } while(!password1.equals(password2));

        System.out.println("\n -------------------------------------------");
        
        // Regex to check valid DOB
        regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";

        // Creating a pattern object
        Pattern pattern = Pattern.compile(regex);

        boolean bool;

        // Input DOB and check if it is valid or not
        do {
            System.out.print("\n Date of Birth(MM/DD/YYYY): ");
            dob = sc.next();

            m = pattern.matcher(dob);
            bool = m.matches();

            if (!bool)
                System.err.println("\n       Invalid Date of Birth! Enter Again!");

        } while (!bool);

        System.out.println("\n -------------------------------------------");

        // Input Gender
        int ch;

        do {
            System.out.println("\n 1. Male\n 2. Female\n 3. Other");

            System.out.print("\n Select Gender: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    gender = 'M';
                    break;

                case 2:
                    gender = 'F';
                    break;

                case 3:
                    gender = 'O';
                    break;

                default:
                    System.out.println("\n       Invalid Selection! Select Again!");
            }

        } while (ch != 1 && ch != 2 && ch != 3);

    
        System.out.println(" -------------------------------------------");

        System.out.print("\n\n\n Press Enter to Continue..... ");

        s.nextLine();

        MainPage.clearScreen();

        // Confirm the Sign UP
        int opt;
        char ans = 'n';

        do
        {
            System.out.println("\n\t--------------------------------------------------------------");
            System.out.println("\n\tEnter 1 to Confirm SIGN UP\n\n");
            System.out.println("\t                                    Enter 0 to Cancel\n\n");

            System.out.print("\tEnter Here: ");
            opt = sc.nextInt();

            MainPage.clearScreen(); // Clear Screen

            if(opt != 1 && opt != 0)
            {
                System.out.println("\n\n\n\t\t\t------------------------");
                System.out.println("\n\t\t\t  Invalid! Enter Again!\n");
                System.out.println("\t\t\t------------------------");

                System.out.print("\n\n\n Press Enter to Continue..... ");

                s.nextLine();

                MainPage.clearScreen(); //Clear Screen

                continue;
            }

            if(opt == 1)
                break;

            if(opt == 0)
            {
                System.out.println("\n\n\n\n\t\t\t\tAll your information will get discarded!!!");
                System.out.print("\n\n\t\t\t\tDo you really want to cancel the sign up process? (y/n): ");
            }

            ans = sc.next().charAt(0);

            System.out.print("\n\n\n Press Enter to Continue..... ");

            s.nextLine();

            MainPage.clearScreen(); // Clear Screen

            if(ans == 'y' || ans == 'Y')
            {
                System.out.println("\n\n\n\t\t\t------------------------------------------");
                System.out.println("\t\t\t            SIGN UP Cancelled!");
                System.out.println("\t\t\t------------------------------------------");

                System.out.print("\n\n\n Press Enter and Return to the HOME PAGE..... ");

                s.nextLine();

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                return;
            }

        } while(ans == 'n' || ans == 'N');

        System.out.println("\n--------------------------------------------------------------");

        // Create Account
        account = new Account(fname, lname, mob, email, userName, password1, dob, gender);

        // Add account in the list
        accounts.add(account);

        MainPage.clearScreen(); // Clear Screen

        System.out.println("\n\n\n\n\t\t\t------------------------------------------\n");
        System.out.println("\t\t\t           SIGN UP COMPLETED!!!\n");
        System.out.println("\t\t\t------------------------------------------");

        System.out.print("\n\n\n Press Enter to Continue..... ");

        s.nextLine();

        MainPage.clearScreen(); // Clear Screen

        // Show Created Account Information
        System.out.println("\n\n\n\n\t\t\t------------------------------------------\n");
        System.out.println("\t\t\t       Account Created Successfully!\n");
        System.out.println("\t\t\t------------------------------------------");

        System.out.println("\n\t\t\t" + account.toString());

        System.out.println("\n\t\t\t------------------------------------------");

        System.out.print("\n\n\n Press Enter and Return to the HOME PAGE..... ");

        s.nextLine();

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
