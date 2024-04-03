public abstract class Account implements IRate {
    // list common properties for savings and checking account
    private String name;
    private String sSN;
    private double balance;
    protected String accountNumber;
    protected double rate;
    private static int index = 10000;


    // constructor to set base properties and initialize the acct

    public Account(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        balance = initDeposit;
//        System.out.println("NAME: " + name + " SSN: " + sSN + " balance: " + balance);

        // set account number
        index++;
        this.accountNumber = setAccountNumber();

        setRate();
    }

    private String setAccountNumber() {
        String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    // compound interest
    public void compound(){
        double compoundInterest = balance * (rate/100);
        balance = balance + compoundInterest;
        System.out.println("Compound Interest: $" + compoundInterest);
        printBalance();
    }

    public abstract void setRate();

    //  list common methods - transactions
    public void deposit(double amount){
        balance = balance + amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }
    public void transfer(String toWhere, double amount){
        balance = balance - amount;
        System.out.println("Transfering $" + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance(){
        System.out.println("Your balance is $" + balance);
    }

    public void showInfo(){
        System.out.println(
                "NAME: " + name +
                "\nACCOUNT NO: " + accountNumber +
                "\nBALANCE: " + balance +
                "\nRATE: " + rate + "%"
                );
    }

}


