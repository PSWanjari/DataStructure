package Problems;

public class BalanceSet {

	static boolean DP[];
	public static void main(String args[])
	{
		int arr[] = {1,1,1,3};
		canPartition(arr);
		
	}
	public static boolean canPartition(int[] nums) {
        
        DP = new boolean[nums.length+1];
        System.out.println(recursion(nums, 0, 0, nums.length));
        System.out.println(DPMemo(nums, 0, 0, nums.length));
        return false;
    }
	public static boolean recursion(int[] arr,int sum1,int sum2,int n)
	{
		if(n==0 && sum1!=sum2 && sum1!=0 && sum2!=0)
		{
			return false;
		}
		if(n==0 && sum1==sum2 && sum1!=0 && sum2!=0)
		{
			return true;
		}
		if(n==0)
		{
			return false;
		}
		
		return recursion(arr, sum1+arr[n-1], sum2, n-1) || recursion(arr, sum1, sum2+arr[n-1], n-1);
		
	}
	
	public static boolean DPMemo(int[] arr,int sum1,int sum2,int n)
	{
		if(DP[n])
		{
			return DP[n];
		}
		if(n==0 && sum1!=sum2 && sum1!=0 && sum2!=0)
		{
			DP[n]=false;
			return DP[n];
		}
		if(n==0 && sum1==sum2 && sum1!=0 && sum2!=0)
		{
			DP[n]=true;
			return DP[n];
		}
		if(n==0)
		{
			DP[n]=false;
			return DP[n];
		}
		
		DP[n]= DPMemo(arr, sum1+arr[n-1], sum2, n-1) || DPMemo(arr, sum1, sum2+arr[n-1], n-1);
		return DP[n];
	}
}
