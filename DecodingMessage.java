package Problems;

public class DecodingMessage {

	public static int DP[]=new int[10005];
	public static void main(String[] args) {
		System.out.println(CountWays("123"));

	}
	
	public static int CountWays(String str)
    {
		for(int i=0;i<10004;i++)
		{
			DP[i]=-1;
		}
		return Ways(str, 0, str.length());
    }
	public static int Ways(String str,int index,int len)
	{
		if(DP[index]!=-1)
		{
			return DP[index];
		}
		if(index>=len)
		{
			DP[index]=0;
			return DP[index];
		}
		if(index==(len-1))
		{
			DP[index]=1;
			return DP[index];
		}
		int num = Integer.parseInt(str.charAt(index)+"");
		int num2=Integer.parseInt(index+1+"");
		num2=num*10+num2;
		int res=0;
		res=res+Ways(str, index+1, len);
		if(num2<=26)
		{
			res=Ways(str, index+2, len);
		}
		
		DP[index]=res;
		return DP[index];
	}
}
