package sample;

import java.util.Date;
/**
 * Represents a savings account. Savings account
 * inherits abstract BankAccount.
 * @see BankAccount
 */

public class SavingsAccount extends BankAccount {
    /**
     * Constant that represents minimum balance for
     * a savings account.
     */
    private static final int minimumBalance = 100;
    /**
     * Holds the rate of interest for this particular
     * account.
     */
    private double interestRate;
    /**
     * Holds the java.util.Date when the account was
     * last updated.
     */
    private Date lastUpdated;

    /**
     * Constructor.
     * @deprecated
     */
    SavingsAccount() {
        super();
        interestRate = 1.25;
        lastUpdated = new Date();
        System.out.println("New Account Created: "
                + getAccountInfo());
    }

    /**
     * Constructor.
     * Sets balance to 0.
     * Sets interest to 1.25.
     * @param _accountHolder The name of the account holder.
     */
    SavingsAccount(String _accountHolder) {
        super( _accountHolder);
        interestRate = 1.25;
        lastUpdated = new Date();
        System.out.println("New Account Created: "
                + getAccountInfo());
    }

    /**
     * Constuctor. Sets interest to 1.25.
     * @param _accountHolder The name of the account holder.
     * @param _balance The initial balance for the account.
     */
    SavingsAccount(String _accountHolder, long _balance) {
        super( _accountHolder,  _balance);
        interestRate = 1.25;
        lastUpdated = new Date();
        System.out.println("New Account Created: "
                + getAccountInfo());
    }

    /**
     * Constuctor.
     * @param _accountHolder The name of the account holder.
     * @param _balance The initial balance for the account.
     * @param interest The rate of interest for this account.
     */
    SavingsAccount(String _accountHolder,
                   long _balance, double interest) {
        super( _accountHolder,  _balance);
        this.interestRate = interest;
        lastUpdated = new Date();
        System.out.println("New Account Created: "
                + getAccountInfo());
    }

    /**
     * Substracts amount from the balance.
     * @param _amount The amount of money to be substracted.
     */
    @Override
    public void withdraw(long _amount){
        if(_amount <= accountBalance - minimumBalance) {
            accountBalance -= _amount;
            System.out.println("Money Withdrawn.");
        }
        else System.out.println("Money can't be Withdrawn");
    }

    /**
     *  Transfers certain amount(second parameter) to the acount
     *  given in the first parameter.
     * @param _transferTo The acount to be transferred to.
     * @param _amount The amount of money to be transferred.
     */
    @Override
    public void transfer(BankAccount _transferTo,
                         long _amount) {
        if(_amount <= accountBalance - minimumBalance) {
            _transferTo.deposit(_amount);
            accountBalance -= _amount;
            System.out.println("Transfer Successful!");
        }
        else System.out.println("Transfer Unsuccessful!");
    }

    /**
     * Updates interest to a given rate. Also
     * updates balance and lastUpdate date.
     * @param _interestRate
     */
    public void updateInterest(double _interestRate){
        this.interestRate = _interestRate;
        updateBalance();
    }

    /**
     * Updates balance when manager calls for an update manually.
     */
    public void updateBalance(){
        Date currentDate = new Date();
        long count1 = currentDate.getTime();
        long count2 = lastUpdated.getTime();
        int yearPassed = (int)((double)(count1 - count2)
                / (3600.0 * 24.0 * 365));
        accountBalance = (int)(accountBalance * (1.0 + yearPassed
                * (interestRate / 100.0)));
        lastUpdated = currentDate;
    }

    /**
     * Automatically updates account to see if balance should be
     * updated according to interestRate after each year.
     */
    public void autoUpdateBalance(){
        Date currentDate = new Date();
        long count1 = currentDate.getTime();
        long count2 = lastUpdated.getTime();
        int yearPassed = (int)((double)(count1 - count2)
                / (3600.0 * 24.0 * 365));
        if(yearPassed < 1.00) return;

        accountBalance = (int)(accountBalance * (1.0 + yearPassed
                * (interestRate / 100.0)));
        lastUpdated = currentDate;
    }

    /**
     * Getter method to return String containing all info.
     * @return String.
     */
    @Override
    public String getAccountInfo() {
        String info = "Savings Account\t" +
                "Name: " + accountHolder + "\tID: "
                + accountID + "\tBalance: "+ accountBalance
                + "\t Created: " + accountCreated +
                "\tInterest rate: " + interestRate + "\n";
        return info;
    }

}
