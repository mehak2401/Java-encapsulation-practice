class PiggyBank {
    private final String piggyBankId;
    private double savings;

    public PiggyBank(String piggyBankId) {
        this.piggyBankId = piggyBankId;
        this.savings = 0.0;
    }

    public String getPiggyBankId() {
        return piggyBankId;
    }

    public double getSavings() {
        return savings;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: Amount must be greater than 0");
            return;
        }
        this.savings += amount;
        System.out.println("Deposited Rs " + amount + " -> savings = " + this.savings);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: Amount must be greater than 0");
            return;
        }
        if (amount > this.savings) {
            System.out.println("Withdrawal rejected: Insufficient savings, stays " + this.savings);
            return;
        }
        this.savings -= amount;
        System.out.println("Withdrew Rs " + amount + " -> savings = " + this.savings);
    }
}

public class PiggyBankDemo {

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
        System.out.println("Final Savings: " + pb.getSavings());
    }
}