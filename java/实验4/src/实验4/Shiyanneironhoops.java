package 实验4;
import java.util.Scanner;
class Team {
	private String name;
	private int score;
	public Team(String name)
	{
		this.name = name;
		this.score = 0;
	}
	public void addScore(int points)
	{
		this.score += points;
	}
	public String getName()
	{
		return name;
	}
	public int getScore()
	{
		return score;
	}
}
public class Shiyanneironhoops 
{
	private Team hostTeam;   // 主队
    private Team guestTeam;  // 客队
    
    public static void main(String[] args) {
    	Shiyanneironhoops game = new Shiyanneironhoops();
        game.startGame();
    }
    
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        
        // 输入队名
        System.out.print("Input host team name: ");
        String hostName = scanner.nextLine();
        System.out.print("Input guest team name: ");
        String guestName = scanner.nextLine();
        
        // 初始化队伍
        hostTeam = new Team(hostName);
        guestTeam = new Team(guestName);
        
        // 显示比赛开始信息
        System.out.println(hostTeam.getName() + " vs " + guestTeam.getName() + "! Now, it is show time!");
        displayScore();
        
        // 比赛循环
        while (true) {
            System.out.print("请输入得分指令: ");
            String input = scanner.nextLine().trim();
            
            // 检查比赛结束
            if (input.equalsIgnoreCase("e")) {
                endGame();
                break;
            }
            
            // 处理得分指令
            if (processScoreInput(input)) {
                displayScore();
            } else {
                System.out.println("输入错误！请按格式输入：a1(主队得1分), b2(客队得2分), e(结束比赛)");
            }
        }      
        scanner.close();
    }
     // 处理得分输入
        private boolean processScoreInput(String input) {
            if (input.length() < 2) {
                return false;
            }
            
            char teamCode = input.charAt(0);
            String pointsStr = input.substring(1);
            
            try {
                int points = Integer.parseInt(pointsStr);
                
                if (teamCode == 'a' || teamCode == 'A') {
                    hostTeam.addScore(points);
                    System.out.println(hostTeam.getName() + " scores! " + 
                                     hostTeam.getScore() + ":" + guestTeam.getScore());
                    return true;
                } else if (teamCode == 'b' || teamCode == 'B') {
                    guestTeam.addScore(points);
                    System.out.println(guestTeam.getName() + " scores! " + 
                                     hostTeam.getScore() + ":" + guestTeam.getScore());
                    return true;
                }
            } catch (NumberFormatException e) {
                // 数字转换失败，输入格式错误
            }
            
            return false;
        }
        
        // 显示当前比分
        private void displayScore() {
            System.out.println(hostTeam.getScore() + ":" + guestTeam.getScore());
        }
        
        // 结束比赛
        private void endGame() {
            System.out.println("Game ends! Final score is: " + 
                             hostTeam.getScore() + ":" + guestTeam.getScore());
            
            int hostScore = hostTeam.getScore();
            int guestScore = guestTeam.getScore();
            
            if (hostScore > guestScore) {
                System.out.println(hostTeam.getName() + " wins!!!");
            } else if (guestScore > hostScore) {
                System.out.println(guestTeam.getName() + " wins!!!");
            } else {
                System.out.println("A draw");
            }
        }

}
