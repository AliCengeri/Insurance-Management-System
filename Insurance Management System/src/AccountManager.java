import java.util.ArrayList;
import java.util.TreeSet;

public class AccountManager {
    private static ArrayList<Account> accountList = new ArrayList<>();

    public static void addAccount(Account account) {
        accountList.add(account);
    }

    public static void removeAccount(Account account) {
        accountList.remove(account);
    }

    public static Account login(String email, String password) {
        for (Account account : accountList) {
            try {
                account.login(email, password);
                if (account.getAuthenticationStatus() == Account.AuthenticationStatus.SUCCESS) {
                    return account;
                }
            } catch (InvalidAuthenticationException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
