package shiyan2;
public class shiyanneiron3
{
	public static void main (String[] args)
	{
		int count =0;
		int loopCount =0;
		System.out.println("满足条件的四位数：");
		for(int num =1000;num<=9999;num++)
		{
			loopCount++;
			int q=num/1000;
			int b=(num/100)%10;
			int s=(num/10)%10;
			int g=num%10;
			if (q==s*3 && num%2==1 && (q+b+s+g==27))
			{
				System.out.println(num);
				count++;
			}
			
		}
		System.out.println("共找到 " + count + " 个符合条件的数字");
        System.out.println("循环次数: " + loopCount);
	}
}
