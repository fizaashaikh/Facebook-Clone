class FindAccount 
{
    public Account findAccount(String username, String password) 
    {
        Account account = null;

        if (CreateAccount.accounts.isEmpty()) 
        {
            return null;
        }

        for (Account a : CreateAccount.accounts) 
        {
            if (a.userName().equals(username) && a.password().equals(password)) 
            {
                account = a;
                break;
            }
        }

        return account;
    }
}
