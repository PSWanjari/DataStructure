//Used Maxheap to create minimum spaning tree
package CodeChef;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;import java.util.List;
import java.util.PriorityQueue;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

	
	public static void main (String[] args) throws java.lang.Exception
	{
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0 ,0,0,8,0},  
                { 4, 0, 8, 0, 0 ,0,0,11,0},  
                { 0, 8, 0, 7, 0 ,0,0,0,2},  
                { 0, 0, 7,0, 9, 14,0,0,0},  
                { 0, 0, 0, 9, 0 ,10,0,0,0} ,
                { 0, 0, 4, 14, 10 ,0,2,0,0},
                { 0, 0, 0, 0, 0 ,2,0,1,6},
                { 8, 11, 0, 0, 0 ,0,1,0,7},
                { 0, 0, 2, 0, 0 ,0,6,7,0}};
		PrimsAlgo(graph, 9);
			
	}
	
	public static void PrimsAlgo(int[][] graph,int totalNodeNs)
	{
		PriorityQueue<NodeN> maxheap = new PriorityQueue<NodeN>(new Comparator<NodeN>() {

			@Override
			public int compare(NodeN o1, NodeN o2) {
				// TODO Auto-generated method stub
				return o1.getValue()-o2.getValue();
			}
		});
		Scanner sc = new Scanner(System.in);
		NodeN NodeN = new NodeN(0, 0);
		HashSet<Integer> visited = new HashSet<Integer>();
		maxheap.add(NodeN);
		int ans =0;
		int removed=0;
		while(removed<totalNodeNs) {
			
			NodeN n = maxheap.poll();
			if(visited.contains(n.getKey())){
				continue;
			}
			removed++;
			ans =ans+n.getValue();
			System.out.println(n.getKey()+"|"+n.getValue());
			sc.nextLine();
			visited.add(n.getKey());
			for(int i=0;i<totalNodeNs;i++)
			{
				if(graph[n.getKey()][i]!=0 && !visited.contains(i))
				{
					NodeN newNodeN = new NodeN(i, graph[n.getKey()][i]);
					maxheap.add(newNodeN);
				}
			}
		}
		System.out.println(ans);
	}
	
	
	
	
}
class NodeN{
	private int key;
	private int value;
	public NodeN(int key, int value) {
		super();
		this.key = key;
		this.value = value;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
