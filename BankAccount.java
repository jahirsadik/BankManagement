/**
 *  Abstract class that represents an account in the Bank.
 *  Holds the name, accountID, creationDate, balance
 *  & Number of total accounts.
 */

package sample;

import java.util.Date;

public abstract class BankAccount {
    /**
     * The identity(name) of the accountHolder.
     */
    protected String accountHolder;
    /**
     * The unique account ID for the account.
     */
    protected long accountID;
    /**
     *  The remaining balance in the account.
     */
    protected long accountBalance;
    /**
     * The constant value from where the ID numbers start
     */
    protected final long firstAccount = 100000;
    /**
     *  Holds the number of total accounts created.
     */
    private static int totalAccounts = 0;
    /**
     * Saves the date on which the account was created.
     */
    protected Date accountCreated;

    /**
     * Constructor.
     * @deprecated This constructor is replaced
     *              by one with a Name parameter.
     */
    protected BankAccount() {
        this.accountBalance = 0;
        this.accountHolder = "None";
        totalAccounts++;
        this.accountID = firstAccount + totalAccounts;
        this.accountCreated = new Date();
    }

    /**
     * Constructor.
     * @param _accountHolder The name of the account holder.
     */
    protected BankAccount(String _accountHolder) {
        this.accountBalance = 0;
        this.accountHolder = _accountHolder;
        totalAccounts++;
        this.accountID = firstAccount + totalAccounts;
        this.accountCreated = new Date();
    }

    /**
     * Constructor.
     * @param _accountHolder The name of the account holder.
     * @param _balance The initial balance amount.
     */

    protected BankAccount(String _accountHolder,
                          long _balance) {
        this.accountBalance = _balance;
        this.accountHolder = _accountHolder;
        totalAccounts++;
        this.accountID = firstAccount + totalAccounts;
        this.accountCreated = new Date();
    }

    /**
     *  Adds deposited amount to the balance.
     * @param depositAmount The amount of money to be deposited
     *                      to the account.
     */
    public void deposit(long depositAmount) {
        this.accountBalance += depositAmount;
        System.out.println("Deposit amount: " + depositAmount);
    }

    /**
     *  Transfers certain amount(second parameter) to the acount
     *  given in the first parameter.
     * @param _transferTo The acount to be transferred to.
     * @param _amount The amount of money to be transferred.
     */
    public void transfer(BankAccount _transferTo, long _amount) {
        if(_amount <= this.accountBalance) {
            _transferTo.deposit(_amount);
            this.accountBalance -= _amount;
            System.out.println("Transfer Successful!");
        }
        else System.out.println("Transfer Unsuccessful!");
    }

    /**
     * Abstract method that substracts certain amount of
     * money from the acount. To be implemented differently
     * in child classes.
     * @param _amount The amount of money to be substracted.
     */
    public abstract void withdraw(long _amount);

    /**
     * Getter method to return total number of accounts.
     * @return The total number of accounts.
     */
    public static long getTotalAccountNumber(){
        return totalAccounts;
    }

    /**
     * Getter method to return string containing account info.
     * @return String.
     */
    public String getAccountInfo() {
        String info = "Name:" + accountHolder + "\tID:"
                + accountID + "\tBalance"+ accountBalance
                + "\t Created:" + accountCreated + "\n";
        return info;
    }

    /**
     * Getter method to return the name of accountHolder.
     * @return String
     */
    public String getAccountHolder() {
        return this.accountHolder;
    }

    /**
     * Getter method to return acount's ID.
     * @return Long
     */
    public long getAccountID() {
        return this.accountID;
    }

    /**
     * Getter method to return accounts balance.
     * @return Long
     */
    public long getBalance() {
        return this.accountBalance;
    }

    /**
     * Getter method to return the Date of account creation.
     * @return java.util.Date
     */
    public Date getCreationDate() {
        return this.accountCreated;
    }

    /**
     * Setter method to change account balance.
     * Depricated because it's better to use the deposit method.
     * @param _accountBalance The amount that'll replace current
     *                        amount.
     * @deprecated
     */
    public void setAccountBalance(long _accountBalance) {
        this.accountBalance = _accountBalance;
    }

    /**
     * Setter method to change acountHolders Name.
     * @param _accountHolder
     */
    public void setAccountHolder(String _accountHolder) {
        this.accountHolder = _accountHolder;
    }
}
