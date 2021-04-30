package Problems;

import java.math.BigInteger;
import java.util.ArrayList;

public class Factorial {
	public static void main(String args[])
	{
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i=1;i<=100000;i++)
		{
			long m=6000;
			long count=0;
			long num = 5;
			while(i>=num)
			{
				count = count+(i/num);
				num=num*5;
			}
			if(count==m)
			{
				ans.add(i);
			}
		}
		System.out.println(ans.size());
		for (Integer integer : ans) {
			System.out.print(integer+" ");
		}
	}
}
