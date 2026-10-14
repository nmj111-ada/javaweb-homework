package shiyan5;
import java.util.Random;
import java.util.Scanner;

// 父类：战斗单元
abstract class CombatUnit {
    protected String name;
    protected int life;
    protected boolean isAlive;
    
    public CombatUnit(String name, int life) {
        this.name = name;
        this.life = life;
        this.isAlive = true;
    }
    
    // 损失生命值的通用方法
    protected void loseLife() {
        Random rand = new Random();
        int loss = rand.nextInt(21) + 10; // 损失10-30点生命值
        this.life -= loss;
        if (this.life <= 0) {
            this.life = 0;
            this.isAlive = false;
        }
    }
    
    // 抽象方法：处理冲锋损失
    public abstract void sufferChargingLoss();
    
    // 显示状态
    public abstract void displayStatus();
    
    // Getter方法
    public String getName() { return name; }
    public int getLife() { return life; }
    public boolean isAlive() { return isAlive; }
}

// 骑士类
class Cavalry extends CombatUnit {
    public Cavalry(String name) {
        super(name, 100);
    }
    
    @Override
    public void sufferChargingLoss() {
        if (isAlive) {
            loseLife();
        }
    }
    
    @Override
    public void displayStatus() {
        if (isAlive) {
            System.out.println("Cavalry " + name + " life remains: " + life);
        } else {
            System.out.println("Cavalry " + name + " lost.");
        }
    }
}

// 巫师类
class Sorcerer extends CombatUnit {
    private int magic;
    
    public Sorcerer(String name) {
        super(name, 60);
        this.magic = 100;
    }
    
    @Override
    public void sufferChargingLoss() {
        if (isAlive) {
            loseLife();
            // 损失魔法值
            Random rand = new Random();
            int magicLoss = rand.nextInt(10); // 损失0-9点魔法值
            this.magic -= magicLoss;
            if (this.magic < 0) this.magic = 0;
        }
    }
    
    @Override
    public void displayStatus() {
        if (isAlive) {
            System.out.println("Sorcerer " + name + " life remains: " + life + 
                             ", magic remains: " + magic);
        } else {
            System.out.println("Sorcerer " + name + " lost.");
        }
    }
}

// 弓箭手类
class Archer extends CombatUnit {
    private int arrows;
    
    public Archer(String name) {
        super(name, 80);
        this.arrows = 100;
    }
    
    @Override
    public void sufferChargingLoss() {
        if (isAlive) {
            loseLife();
            // 损失箭矢
            Random rand = new Random();
            int arrowLoss = rand.nextInt(15) + 1; // 损失1-15支箭
            this.arrows -= arrowLoss;
            if (this.arrows < 0) this.arrows = 0;
        }
    }
    
    @Override
    public void displayStatus() {
        if (isAlive) {
            System.out.println("Archer " + name + " life remains: " + life + 
                             ", arrow remains: " + arrows);
        } else {
            System.out.println("Archer " + name + " lost.");
        }
    }
}

// 战役管理类
public class zhihui {
    private CombatUnit[] army;
    private boolean battleOngoing;
    
    public static void main(String[] args) {
        zhihui battle = new zhihui();
        battle.startBattle();
    }
    
    public void startBattle() {
        // 初始化军队
        army = new CombatUnit[]{
            new Cavalry("Arthor"),
            new Sorcerer("Cecilia"), 
            new Archer("Blan")
        };
        
        battleOngoing = true;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("A 3-player simulated battle now begins. Give your command");
        displayAllStatus();
        
        // 命令循环
        while (battleOngoing) {
            System.out.print("请输入命令 (charging/withdraw): ");
            String command = scanner.nextLine().trim().toLowerCase();
            
            switch (command) {
                case "charging":
                    processCharging();
                    break;
                case "withdraw":
                    withdraw();
                    battleOngoing = false;
                    break;
                default:
                    System.out.println("无效命令！请输入 charging 或 withdraw");
                    continue;
            }
            
            // 检查是否所有角色都已阵亡
            if (allUnitsLost()) {
                System.out.println("All roles lost, game over.");
                battleOngoing = false;
            }
        }
        
        scanner.close();
    }
    
    // 处理冲锋命令
    private void processCharging() {
        // 所有存活单位承受损失
        for (CombatUnit unit : army) {
            unit.sufferChargingLoss();
        }
        
        // 显示冲锋后的状态
        displayAllStatus();
    }
    
    // 撤退命令
    private void withdraw() {
        System.out.println("Let's go home.");
    }
    
    // 显示所有单位状态
    private void displayAllStatus() {
        for (CombatUnit unit : army) {
            unit.displayStatus();
        }
    }
    
    // 检查是否所有单位都已阵亡
    private boolean allUnitsLost() {
        for (CombatUnit unit : army) {
            if (unit.isAlive()) {
                return false;
            }
        }
        return true;
    }
}
