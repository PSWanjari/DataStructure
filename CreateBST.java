package Problems;

public class CreateBST {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,5,7,8,9,10};
		Node root = MakeBST(arr, 0, arr.length-1);
		inorder(root);
	}
	
	public static void inorder(Node root)
	{
		if(root==null)
		{
			return;
		}
		inorder(root.left);
		System.out.print(root.val+" ");
		inorder(root.Right);
	}
	public static Node MakeBST(int arr[],int left,int right)
	{
	
		
		if(right<left)
		{
			return null;
		}
		int mid = ((right+left)/2);
		int val = arr[mid];
		Node newnode = new Node(val);
		newnode.left=MakeBST(arr, left, mid-1);
		newnode.Right=MakeBST(arr, mid+1, right);
		return newnode;
	}
}
class Node{
	int val;
	Node left = null;
	Node Right= null;
	public Node(int val) {
		this.val = val;
		
	}
	
}
