package Problems;

public class CharArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {-10,-3,-3,-1,-5,-4};
		System.out.println(MaxSumSubarray(arr));
		
	}
	
	public static int MaxSumSubarray(int arr[])
	{
		if(arr.length==0)
		{
			return 0;
		}
		int max=arr[0];
		int max_till_now =arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(max_till_now>(max_till_now+arr[i]))
			{
				max_till_now=arr[i];
			}else {
				max_till_now=max_till_now+arr[i];
			}
			if(max_till_now<arr[i])
			{
				max_till_now=arr[i];
			}
			if(max_till_now>max)
			{
				max=max_till_now;
			}
			
		}
		return max;
	}

}
