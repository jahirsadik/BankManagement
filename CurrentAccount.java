package sample;

import java.util.Date;

/**
 * Represents a current account. Current account
 * inherits abstract BankAccount.
 * @see BankAccount
 */
public class CurrentAccount extends BankAccount {
    /**
     * Constructor.
     * @deprecated
     */
    CurrentAccount(){
        super();
        System.out.println("New Account Created: "
                + getAccountInfo());
    }

    /**
     * Constructor. Sets balance to 0.
     */
    CurrentAccount(String _accountHolder) {
        super(_accountHolder);
        System.out.println("New Account Created: "
                + getAccountInfo());
    }

    /**
     * Constructor.
     * @param _accountHolder Name of the account holder.
     * @param _balance The initial balance.
     */
    CurrentAccount(String _accountHolder, long _balance) {
        super(_accountHolder, _balance);
        System.out.println("New Account Created: "
                + getAccountInfo());
    }

    /**
     * Overriden withdraw method to substract centain amount
     * from balance.
     * @param _amount The amount of money to be substracted.
     */
    @Override
    public void withdraw(long _amount) {
        if(_amount <= accountBalance) {
            accountBalance -= _amount;
            System.out.println("Money Withdrawn.");
        }
        else System.out.println("Withdraw unsuccessful!");
    }

    /**
     *  Overriden method to return info as a string.
     * @return String
     */
    @Override
    public String getAccountInfo() {
        String info = "Current Account\t" +
                "Name: " + accountHolder + "\tID: "
                + accountID + "\tBalance: "+ accountBalance
                + "\t Created: " + accountCreated + "\n";
        return info;
    }
}
