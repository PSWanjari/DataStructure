package YouTube;

public class SizeofanInfiniteArray {
    public static void main(String[] args) {
        int arr[] = new int[1010];
        System.out.println(sizeOfArray(arr));
    }
    public static int sizeOfArray(int arr[]){
        //handle edge case for null array
        try{
            int a = arr[0];
        }catch(Exception ex)
        {
            return 0;
        }
        int i=1;
        while(true)
        {
            try{
                int a =arr[i];
                i=i*2;
                //1 2 4 8 
            }catch(Exception ex)
            {
                break;
            }
        }
        return findSize(i/2,i,arr);
    }

    public static int findSize(int s,int e,int arr[])
    {
        while(s<=e)
        {
            int mid = (s+e)/2;
            //8 4 2 -----
            try{
                int a = arr[mid];
                s=mid+1;
            }catch(Exception ex)a
            {
                e=mid-1;    
            }
        }
        return s;
    }

    //log n base 2;
}
