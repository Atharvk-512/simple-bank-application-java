import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();

        String file = "C:\\Users\\ATHARV\\IdeaProjects\\Bank_Application\\NewBankAccounts.csv";

        // read csv file abd then create accounts based on data
        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for(String[] accountHolder : newAccountHolders){
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);

            if(accountType.equals("Savings")){
                accounts.add(new Savings(name, sSN, initDeposit));
            }
            else if(accountType.equals("Checking")){
                accounts.add(new Checking(name, sSN, initDeposit));
            }
            else{
                System.out.println("ACCOUNT TYPE CANNOT BE IDENTIFIED!!!");
            }
        }

        //display accounts
        for(Account acct : accounts){
            acct.showInfo();
            System.out.println("-----------------");
        }
    }
}
