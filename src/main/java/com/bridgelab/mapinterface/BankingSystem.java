import java.util.*;

public class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>(); // Account number -> balance
    private TreeMap<Double, List<String>> accountsByBalance = new TreeMap<>(Comparator.reverseOrder());
    private Queue<String> withdrawalQueue = new LinkedList<>();

    // Create account
    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        accountsByBalance.computeIfAbsent(initialBalance, k -> new ArrayList<>()).add(accountNumber);
    }

    // Request withdrawal
    public void requestWithdrawal(String accountNumber, double amount) {
        withdrawalQueue.add(accountNumber + ":" + amount);
    }

    // Process next withdrawal
    public void processNextWithdrawal() {
        if (withdrawalQueue.isEmpty()) {
            System.out.println("No withdrawals to process");
            return;
        }
        
        String request = withdrawalQueue.poll();
        String[] parts = request.split(":");
        String account = parts[0];
        double amount = Double.parseDouble(parts[1]);
        
        if (accounts.getOrDefault(account, 0.0) >= amount) {
            double oldBalance = accounts.get(account);
            double newBalance = oldBalance - amount;
            accounts.put(account, newBalance);
            
            // Update accountsByBalance map
            accountsByBalance.get(oldBalance).remove(account);
            if (accountsByBalance.get(oldBalance).isEmpty()) {
                accountsByBalance.remove(oldBalance);
            }
            accountsByBalance.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(account);
            
            System.out.printf("Processed withdrawal of $%.2f from %s\n", amount, account);
        } else {
            System.out.printf("Insufficient funds for withdrawal of $%.2f from %s\n", amount, account);
        }
    }

    // Display accounts by balance (highest first)
    public void displayAccountsByBalance() {
        for (Map.Entry<Double, List<String>> entry : accountsByBalance.entrySet()) {
            System.out.printf("$%.2f: %s\n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        
        // Create accounts
        bank.createAccount("A1001", 5000.0);
        bank.createAccount("A1002", 2500.0);
        bank.createAccount("A1003", 10000.0);
        
        // Request withdrawals
        bank.requestWithdrawal("A1001", 1000.0);
        bank.requestWithdrawal("A1002", 3000.0);
        bank.requestWithdrawal("A1003", 500.0);
        
        // Process withdrawals
        bank.processNextWithdrawal();
        bank.processNextWithdrawal();
        bank.processNextWithdrawal();
        
        System.out.println("\nAccounts by balance:");
        bank.displayAccountsByBalance();
    }
}