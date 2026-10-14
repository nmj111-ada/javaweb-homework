package shiyan6;

import java.util.Scanner;

// 接口定义
interface Depositable {
    void deposit(double amount, double cash);
}

interface Reportable {
    void showAccountInfo();
}

interface Withdrawable {
    void withdraw(double amount);
}

// 用户账户类
class UserAccount implements Reportable {
    private String userName;
    private double rmbAccount;     // 人民币账户
    private double usdAccount;     // 美元账户
    
    public UserAccount(String name) {
        this.userName = name;
        this.rmbAccount = 10000.0;  // 初始人民币余额
        this.usdAccount = 10000.0;  // 初始美元余额
    }
    
    @Override
    public void showAccountInfo() {
        System.out.println("Dear " + userName + ", here is your account balance:");
        System.out.println("RMB account: " + String.format("%.1f", rmbAccount));
        System.out.println("US dollar account: " + String.format("%.1f", usdAccount));
    }
    
    // Getter和Setter方法
    public double getRmbAccount() {
        return rmbAccount;
    }
    
    public void setRmbAccount(double rmbAccount) {
        this.rmbAccount = rmbAccount;
    }
    
    public double getUsdAccount() {
        return usdAccount;
    }
    
    public void setUsdAccount(double usdAccount) {
        this.usdAccount = usdAccount;
    }
    
    public String getUserName() {
        return userName;
    }
}

// 银行业务办理类
class BankTransaction implements Depositable, Withdrawable {
    private UserAccount account;
    private double cashOnHand;  // 用户携带的现金
    
    public BankTransaction(UserAccount account, double initialCash) {
        this.account = account;
        this.cashOnHand = initialCash;
    }
    
    @Override
    public void deposit(double amount, double cash) {
        if (amount <= 0) {
            System.out.println("存款金额必须大于0");
            return;
        }
        
        if (amount > 5000.0) {
            System.out.println("You don't have enough cash to deposit.");
            return;
        }
        
        if (cashOnHand < amount) {
            System.out.println("You don't have enough cash to deposit.");
            return;
        }
        
        // 执行存款
        double newBalance = account.getRmbAccount() + amount;
        account.setRmbAccount(newBalance);
        cashOnHand -= amount;
        
        System.out.println("Your RMB account balance is now " + String.format("%.1f", newBalance));
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("取款金额必须大于0");
            return;
        }
        
        double currentBalance = account.getRmbAccount();
        
        if (amount > currentBalance) {
            System.out.println("You don't have enough deposit for that.");
            return;
        }
        
        // 执行取款
        double newBalance = currentBalance - amount;
        account.setRmbAccount(newBalance);
        cashOnHand += amount;
        
        System.out.println("You have successfully withdraw " + 
                         String.format("%.1f", amount) + " from your RMB account.");
    }
    
    // 获取当前现金
    public double getCashOnHand() {
        return cashOnHand;
    }
}

// 主程序类
public class yinhang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 创建用户账户
        UserAccount account = new UserAccount("Jonathan");
        
        // 创建业务办理对象，用户携带10000.0现金
        BankTransaction transaction = new BankTransaction(account, 10000.0);
        
        System.out.println("Welcome to the Bank ATM!");
        
        // 主循环
        while (true) {
            displayMenu();
            System.out.print("Pls choose your transaction(0~3): ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 0: // 退出
                        System.out.println("Thank you for using.");
                        scanner.close();
                        return;
                        
                    case 1: // 查询余额
                        account.showAccountInfo();
                        break;
                        
                    case 2: // 存款
                        System.out.print("How much you'd like to deposit to your RMB account(maximum 5000.0):");
                        try {
                            double depositAmount = Double.parseDouble(scanner.nextLine());
                            transaction.deposit(depositAmount, transaction.getCashOnHand());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a valid number.");
                        }
                        break;
                        
                    case 3: // 取款
                        double currentBalance = account.getRmbAccount();
                        System.out.print("How much you'd like to withdraw from your RMB account(maximum " + 
                                       String.format("%.1f", currentBalance) + "):");
                        try {
                            double withdrawAmount = Double.parseDouble(scanner.nextLine());
                            transaction.withdraw(withdrawAmount);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a valid number.");
                        }
                        break;
                        
                    default:
                        System.out.println("Invalid choice! Please choose 0~3.");
                }
                
                System.out.println(); // 空行分隔
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number 0~3.");
            }
        }
    }
    
    // 显示菜单
    private static void displayMenu() {
        System.out.println("1: check balance    2: deposit    3: withdraw    0: exit");
    }
}