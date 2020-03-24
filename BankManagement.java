package sample;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Represents the terminal UI class for Bank Manager.
 * Holds all the accounts.
 * @see SavingsAccount
 * @see CurrentAccount
 */
public class BankManagement {
    /**
     * Main method
     * @param args Terminal arguments.
     */
    public static void main(String[] args){
        String accountHolder;
        long balance;
        long id, _amount;
        BankAccount tempAcc;
        /**
         * Scanner to read terminal input.
         */
        Scanner input = new Scanner(System.in);
        /**
         * Holds all the account.
         */
        HashMap<Long, BankAccount> allAccounts
                = new HashMap<>();
        while(true) {
            System.out.println("Choose operation:");
            System.out.println("1. Add a saving account");
            System.out.println("2. Add a current account");
            System.out.println("3. Set interest rate");
            System.out.println("4. Currently active account");
            System.out.println("5. Get Account Info");
            System.out.println("6. Deposit money");
            System.out.println("7. Withdraw money");
            System.out.println("8. Transfer money");
            System.out.println("9. Update Account");
            /**
             * Holds operation info
             */
            int operation = input.nextInt();

            switch (operation) {
                case 1:
                    System.out.print("Enter holder's name: ");
                    accountHolder = input.nextLine();
                    accountHolder = input.nextLine();
                    System.out.print("\n");
                    System.out.print("Enter initial ammount: ");
                    balance = input.nextInt();
                    System.out.print("\n");
                    tempAcc = new SavingsAccount(
                            accountHolder,
                            balance);
                    allAccounts.put(tempAcc.getAccountID(), tempAcc);
                    System.out.println("New Account Info:\t");
                    System.out.println(tempAcc.getAccountInfo());
                    break;

                case 2:
                    System.out.print("Enter holder's name: ");
                    accountHolder = input.nextLine();
                    accountHolder = input.nextLine();
                    System.out.print("\n");
                    System.out.print("Enter initial ammount: ");
                    balance = input.nextInt();
                    System.out.print("\n");
                    tempAcc = new CurrentAccount(
                            accountHolder,
                            balance);
                    allAccounts.put(tempAcc.getAccountID(), tempAcc);
                    System.out.println("New Account Info:\t");
                    System.out.println(tempAcc.getAccountInfo());
                    break;

                case 3:
                    System.out.println("Enter ID:");
                    id = input.nextInt();
                    System.out.print("Enter interest rate: ");
                    double rate = input.nextDouble();
                    System.out.print("\n");
                    if(allAccounts.containsKey(id)) {
                        if(allAccounts.get(id) instanceof SavingsAccount) {
                            ((SavingsAccount) allAccounts.get(id))
                                    .updateInterest(rate);
                            System.out.println("Interest Updated!");
                            break;
                        }
                        else System.out.println("Interest can't be updated!");
                    }
                    break;

                case 4:
                    System.out.print("Currently active account number:");
                    System.out.println(BankAccount.getTotalAccountNumber());
                    break;

                case 5:
                    System.out.print("Enter account id: ");
                    id = input.nextInt();
                    System.out.print("\n");
                    if(allAccounts.containsKey(id)) {
                        System.out.println(allAccounts.get(id).getAccountInfo());
                    }
                    else System.out.println("Account not found.");
                    break;

                case 6:
                    System.out.print("Enter account id: ");
                    id = input.nextInt();
                    System.out.print("\n");
                    System.out.print("Enter amount: ");
                    _amount = input.nextInt();
                    System.out.print("\n");
                    if(allAccounts.containsKey(id)) {
                        allAccounts.get(id).deposit(_amount);
                    }
                    else System.out.println("Account not found.");
                    break;

                case 7:
                    System.out.print("Enter account id: ");
                    id = input.nextInt();
                    System.out.print("\n");
                    System.out.print("Enter amount: ");
                    _amount = input.nextInt();
                    System.out.print("\n");
                    if(allAccounts.containsKey(id)) {
                        allAccounts.get(id).withdraw(_amount);
                    }
                    else System.out.println("Account not found.");
                    break;

                case 8:
                    System.out.print("Enter Transferers id: ");
                    long id1 = input.nextInt();
                    System.out.print("\n");
                    System.out.print("Enter Receivers id: ");
                    long id2 = input.nextInt();
                    System.out.print("\n");
                    System.out.print("Enter amount: ");
                    _amount = input.nextInt();
                    System.out.print("\n");
                    if(allAccounts.containsKey(id1)
                            && allAccounts.containsKey(id2)) {
                        allAccounts.get(id1).transfer(
                                allAccounts.get(id2),
                                _amount);
                    }

                    else System.out.println("Accounts not found.");
                    break;

                case 9:
                    System.out.println("Enter id: ");
                    id = input.nextInt();
                    System.out.print("\n");
                    if(allAccounts.containsKey(id)){
                        if(allAccounts.get(id) instanceof SavingsAccount) {
                            ((SavingsAccount) allAccounts.get(id)).updateBalance();
                            System.out.println("Update Done!");
                        }
                    }
                    else System.out.println("Could not update.");
                    break;

                default :
                    System.out.println("Invalid operation");
                    break;
            }

            /*
                Updates all savings account inside the loop given that a
                year has passed since creationDate.
             */
            for (HashMap.Entry<Long, BankAccount> entry : allAccounts.entrySet()) {
                if(entry.getValue() instanceof SavingsAccount) {
                    ((SavingsAccount) entry.getValue()).autoUpdateBalance();
                }
            }
        }
    }
}

