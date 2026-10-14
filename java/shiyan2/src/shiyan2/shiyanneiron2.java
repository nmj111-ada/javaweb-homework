package shiyan2;
import java.util.Scanner;
 
public class shiyanneiron2
{
	public static void main (String[] args )
	{
		Scanner scanner = new Scanner(System.in);
		while (true)
		{
			System.out.print("请输入一个整数（输入0退出）：");
			int num = scanner.nextInt();
			if (num ==0)
			{
				System.out.print("程序结束！");
				break;
			}
			if (num<2 || num> 10000)
			{
				System.out.print("输入的数不在判断范围之内，请重新输入！");
				continue;
			}
			boolean isprime=true;
			if (num==2)
			{
				isprime=true;
			}
			else if (num%2==0)
			{
				isprime=false;
			}
			else
			{
				for (int i =3;i<=Math.sqrt(num);i+=2)
				{
					if(num %i ==0)
					{
						isprime=false;
						break;
					}
				}
			}
			if (isprime) 
			{
                System.out.println(num + " 是素数。");
            } 
			else 
            {
                System.out.println(num + " 不是素数。");
            }
            System.out.println(); 
        
		}
		scanner.close();
	}
}