import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account 
{
    Scanner s = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    private String fname;
    private String lname;
    private String mob;
    private String email;
    private String userName;
    private String password;
    private String dob;
    private String gender;
    private String status = "NA";

    private List<Account> friends = null; // This is for Adjacency List

    // Return First name 
    private String getFName() 
    {
        return fname;
    }
    
    // Return Last name 
    private String getLname() 
    {
        return lname;
    }

    // Return Username 
    private String getUserName() 
    {
        return userName;
    }

    // Return First Name + Last Name
    public String getName() 
    {
        return this.getFName() + " " + this.getLname();
    }

    // Return Mobile Number 
    private String getMob() 
    {
        return mob;
    }

    // Return Password
    private String getPassword() 
    {
        return password;
    }

    // Return Email ID
    private String getEmail()
    {
        return email;
    }

    // Return Date of Birth
    private String getDob() 
    {
        return dob;
    }

    private String getGender() 
    {
        return gender;
    }

    // Parameterized Constructor
    public Account(String fname, String lname, String mob, String email, String userName, String password, String dob, char gender) 
    {
        super();

        this.fname = fname;
        this.lname = lname;
        this.mob = mob;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.dob = dob;

        if(gender == 'M')
            this.gender = "Male";
        else if(gender == 'F')
            this.gender = "Female";
        else
            this.gender = "Other";

        this.friends = new ArrayList<>();
    }

    // Parameterized Constructor
    public Account(String fname, String lname, String mob, String email, String userName, String password, String dob,
            char gender, String status) {
        super();

        this.fname = fname;
        this.lname = lname;
        this.mob = mob;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.dob = dob;

        if (gender == 'M')
            this.gender = "Male";
        else if (gender == 'F')
            this.gender = "Female";
        else
            this.gender = "Other";

        this.status = status;

        this.friends = new ArrayList<>();
    }

    @Override
    public String toString() 
    {
        return "  Name: " + this.getFName() + " " + this.getLname() + "\n\n" + "\t\t\t  Username: " + this.getUserName() 
                +"\n\n" + "\t\t\t  Mobile Number: " + this.getMob() + "\n\n" + "\t\t\t  Email ID: " + this.getEmail();
    }

    public String showProfile()
    {
        String res =  this.toString() + "\n\n\n" + "\t\t\t  Date Of Birth: " + this.getDob()  + "\t\t Gender: " + this.getGender();

        String stat = "\n\n\n\t\t\t  Status: " + this.status;

        if(!this.status.equals("NA"))
            res += stat;

        return res;
    }

    // Return Username
    public String userName()
    {
        return this.getUserName();
    }

    // Return Password
    public String password() 
    {
        return this.getPassword();
    }

    // Return friends list
    public List<Account> getFriends() 
    {
        return this.friends;
    }
    
    // Add an account to the friends list
    public void addFriend(Account a) 
    {
        this.friends.add(a);
    }

    // Remove an account from friends list
    public void removeFriend(Account a)
    {
        this.friends.remove(a);
    }

    // Edit name
    public void setName() throws IOException
    {
        MainPage.clearScreen(); // Clear Screen

        System.out.println("\n\n\n\t\t\t-------------------------------------------");

        // Input First Name
        System.out.print("\n\t\t\t First Name: ");
        this.fname = br.readLine();

        // Input Last Name
        System.out.print("\n\t\t\t Last Name: ");
        this.lname = br.readLine();

        System.out.println("\n\t\t\t-------------------------------------------");

        System.out.print("\n\n\n Press Enter to Edit Name..... ");
        s.nextLine();

        MainPage.clearScreen(); // Clear Screen

        System.out.println("\n\n\n\n\t\t\t------------------------------------------\n");
        System.out.println("\t\t\t       Name Changed Successfully!\n");
        System.out.println("\t\t\t------------------------------------------");

        System.out.print("\n\n\n Press Enter and Return..... ");
        s.nextLine();

    }

    // Edit Username
    public void setUserName()
    {
        String UserName;
        int opt = 1;

        // Regex to check valid username.
        String regex = "^[a-z]\\w{3,29}$";

        // Compile the Regex
        Pattern p = Pattern.compile(regex);
        Matcher m;

        // Input Username and check if it is valid or not
        do 
        {
            MainPage.clearScreen(); // Clear Screen
            
            System.out.println("\n\n\n\t\t\t-------------------------------------------");

            System.out.print("\n\t\t\t New Username: ");
            UserName = s.next();

            m = p.matcher(userName);

            if (!m.matches())
                System.out.println("\n\t\t\t       Invalid Username! Enter Again!");

            // Exit Condition
            System.out.println("\n\n\t\t\tEnter 0 to Cancel\t\t\tEnter 1 to Continue");
            System.out.print("\n\tEnter Here: ");
            opt = s.nextInt();

            if (opt == 0)
                return;

        } while (!m.matches());

        this.userName = UserName;

        System.out.println("\n\t\t\t-------------------------------------------");

        System.out.print("\n\n\n Press Enter to Change Username..... ");
        s.nextLine();

        MainPage.clearScreen(); // Clear Screen

        System.out.println("\n\n\n\n\t\t\t------------------------------------------\n");
        System.out.println("\t\t\t       Username Changed Successfully!\n");
        System.out.println("\t\t\t------------------------------------------");

        System.out.print("\n\n\n Press Enter and Return..... ");
        s.nextLine();
    }

    // Edit Mobile Number
    public void setMob() 
    {
        // Regex for mobile number matching
        String regex = "(0/91)?[7-9][0-9]{9}";
        String mobile;
        int opt = 1;

        // Input Mobile Number and check if it is valid or not
        do 
        {
            MainPage.clearScreen(); // Clear Screen

            System.out.println("\n\n\n\t\t\t-------------------------------------------");

            System.out.print("\n\t\t\t New Mobile Number: ");
            mobile = s.next();

            if (!mobile.matches(regex))
                System.out.println("\n\t\t\t       Invalid Mobile Number! Enter Again!");

            // Exit Condition
            System.out.println("\n\n\t\t\tEnter 0 to Cancel\t\t\tEnter 1 to Continue");
            System.out.print("\n\tEnter Here: ");
            opt = s.nextInt();

            if (opt == 0)
                return;

        } while (!mobile.matches(regex));

        this.mob = mobile;

        System.out.println("\n\t\t\t-------------------------------------------");

        System.out.print("\n\n\n Press Enter to Change Mobile Number..... ");
        s.nextLine();

        MainPage.clearScreen(); // Clear Screen

        System.out.println("\n\n\n\n\t\t\t------------------------------------------\n");
        System.out.println("\t\t\t    Mobile Number Changed Successfully!\n");
        System.out.println("\t\t\t------------------------------------------");

        System.out.print("\n\n\n Press Enter and Return..... ");
        s.nextLine();
    }

    // Edit Email ID
    public void setEmail() 
    {
        // Regex for Email ID matching
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        boolean result;
        String emailId;
        int opt = 1;

        // Input Email ID and check if it is valid or not
        do 
        {
            MainPage.clearScreen(); // Clear Screen

            System.out.println("\n\n\n\t\t\t-------------------------------------------");

            System.out.print("\n\t\t\t New Email ID: ");
            emailId = s.next();

            result = emailId.matches(regex);

            if (!result)
                System.out.println("\n\t\t\t       Email-id is not valid! Enter Again!");

            // Exit Condition
            System.out.println("\n\n\t\t\tEnter 0 to Cancel\t\t\tEnter 1 to Continue");
            System.out.print("\n\tEnter Here: ");
            opt = s.nextInt();

            if (opt == 0)
                return;

        } while (!result);

        this.email = emailId;

        System.out.println("\n\t\t\t-------------------------------------------");

        System.out.print("\n\n\n Press Enter to Change Email ID..... ");
        s.nextLine();

        MainPage.clearScreen(); // Clear Screen

        System.out.println("\n\n\n\n\t\t\t------------------------------------------\n");
        System.out.println("\t\t\t       Email ID Changed Successfully!\n");
        System.out.println("\t\t\t------------------------------------------");

        System.out.print("\n\n\n Press Enter and Return..... ");
        s.nextLine();
    }

    // Edit DOB
    public void setDOB() 
    {
        // Regex to check valid DOB
        String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
        String birth;
        int opt = 1;

        // Creating a pattern object
        Pattern pattern = Pattern.compile(regex);

        boolean bool;

        // Input DOB and check if it is valid or not
        do {
            MainPage.clearScreen(); // Clear Screen

            System.out.println("\n\n\n\t\t\t-------------------------------------------");

            System.out.print("\n\t\t\t Date of Birth(MM/DD/YYYY): ");
            birth = s.next();

            Matcher m = pattern.matcher(birth);
            bool = m.matches();

            if (!bool)
                System.err.println("\n\t\t\t       Invalid Date of Birth! Enter Again!");

            // Exit Condition
            System.out.println("\n\n\t\t\tEnter 0 to Cancel\t\t\tEnter 1 to Continue");
            System.out.print("\n\tEnter Here: ");
            opt = s.nextInt();

            if (opt == 0)
                return;

        } while (!bool);

        this.dob = birth;

        System.out.println("\n\t\t\t-------------------------------------------");

        System.out.print("\n\n\n Press Enter to Change Date of Birth..... ");
        s.nextLine();

        MainPage.clearScreen(); // Clear Screen

        System.out.println("\n\n\n\n\t\t\t------------------------------------------\n");
        System.out.println("\t\t\t   Date of Birth Changed Successfully!\n");
        System.out.println("\t\t\t------------------------------------------");

        System.out.print("\n\n\n Press Enter and Return..... ");
        s.nextLine();
    }

    // Reset Password
    public void resetPassword() 
    {
        String passWord;
        String password1;
        String password2;
        int opt = 1;

        do 
        {
            MainPage.clearScreen();

            System.out.println("\n\n\n\t\t\t-------------------------------------------");

            // Input Current Password
            System.out.print("\n\t\t\t Current Password: ");
            passWord = s.next();

            if (!passWord.equals(this.password))
                System.out.println("\n\n\t\t\t Please Enter Correct Password!");

            // Exit Condition
            System.out.println("\n\n\t\t\tEnter 0 to Cancel\t\t\tEnter 1 to Continue");
            System.out.print("\n\tEnter Here: ");
            opt = s.nextInt();

            if (opt == 0)
                return;

        } while (!passWord.equals(this.password));

        System.out.println("\n\t\t\t-------------------------------------------");

        // Input New Password
        do 
        {
            MainPage.clearScreen();

            System.out.println("\n\n\n\t\t\t-------------------------------------------");

            System.out.print("\n\t\t\t New Password: ");
            password1 = s.next();

            System.out.print("\n\t\t\t Confirm Password: ");
            password2 = s.next();

            // Check if New password and Confirmed password matches or not
            if (!password1.equals(password2)) 
                System.out.println("\n\n\t\t\t\tPassword Does Not Match! Enter Again!");
            

        } while (!password1.equals(password2));

        this.password = password1;

        System.out.println("\n\t\t\t-------------------------------------------");

        System.out.print("\n\n\n Press Enter to Change Password..... ");
        s.nextLine();

        MainPage.clearScreen(); // Clear Screen

        System.out.println("\n\n\n\n\t\t\t------------------------------------------\n");
        System.out.println("\t\t\t      Password Changed Successfully!\n");
        System.out.println("\t\t\t------------------------------------------");

        System.out.print("\n\n\n Press Enter and Return..... ");
        s.nextLine();
    }
} 