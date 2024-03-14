import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Account {
    // Attributes
    protected int accountNumber;
    protected double balance;
    // Constructor
    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    // Methods
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient funds.");
        }
    }
    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends Account {
    // Constructor
    public SavingsAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }
    // Method to calculate interest
    public void calculateInterest() {
        double interest = balance * 0.03; // 3% interest rate
        balance += interest;
    }
}

class CheckingAccount extends Account {
    // Constructor
    public CheckingAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }
    // Method to deduct monthly fee
    public void deductMonthlyFee() {
        balance -= 5; // Monthly fee of $5
    }
}

public class Adobe {
    public static void main(String[] args) {

        SavingsAccount savings = new SavingsAccount(1001, 1000);
        CheckingAccount checking = new CheckingAccount(2001, 500);
        savings.deposit(500);
        savings.withdraw(500);
        savings.calculateInterest();
        checking.deposit(200);
        checking.withdraw(500);
        checking.deductMonthlyFee();

        JFrame frame = new JFrame("Landbank");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE); 

        // Set custom icon for the JFrame
        ImageIcon icon = new ImageIcon("cat.png");
        frame.setIconImage(icon.getImage());

        JLabel imageLabel = new JLabel(new ImageIcon("cat.png")); 
        imageLabel.setBounds(20, 50, 500, 500); 
        frame.add(imageLabel);

        JLabel bankLabel = new JLabel("Landbank"); 
        bankLabel.setFont(new Font("Arial", Font.BOLD, 40));
        bankLabel.setBounds(550, 200, 200, 30); 
        bankLabel.setHorizontalAlignment(JLabel.CENTER);
        bankLabel.setForeground(Color.BLACK);
        frame.add(bankLabel);

        JButton savingsButton = new JButton("Savings");
        savingsButton.setBounds(600, 250, 100, 30); 
        Color customGreen = new Color(29, 178, 76);
        savingsButton.setBackground(customGreen);
        savingsButton.setForeground(Color.BLACK);
        frame.add(savingsButton);

        JButton checkingButton = new JButton("Balance");
        checkingButton.setBounds(600, 300, 100, 30); 
        checkingButton.setBackground(customGreen);
        checkingButton.setForeground(Color.BLACK);
        frame.add(checkingButton);

        savingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Savings Account Balance: Php" + savings.getBalance());
            }
        });

        checkingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Account Balance: Php" + checking.getBalance());
            }
        });

        frame.setVisible(true);
    }
}
