package Problems;

import java.util.ArrayList;
import java.util.HashMap;

public class AllPossiblePattern {

	static HashMap<Integer, char[]> map ;
	public static void main(String[] args) {
	map = new HashMap<Integer, char[]>();
	char[] two = {'A','B','C'};
	char[] three = {'D','E','F'};
	char[] four = {'G','H','I'};
	char[] five = {'J','K','L'};
	char[] six = {'M','N','O'};
	char[] seven = {'P','Q','R','S'};
	char[] eight = {'T','U','V'};
	char[] nine = {'W','X','Y','Z'};
	map.put(2, two);
	map.put(3, three);
	map.put(4, four);
	map.put(5, five);
	map.put(6, six);
	map.put(7, seven);
	map.put(8, eight);
	map.put(9, nine);
	int[] arr= {2};
	ArrayList<String> temp = AllPattern(arr,0);
	for (String string : temp) {
		System.out.print(string+" ");
	}
	}
	
	public static ArrayList<String> AllPattern(int arr[],int index)
	{
		ArrayList<String> result = new ArrayList<String>();
		if(index>=arr.length)
		{
			result.add("");
			return result;
		}
		
		ArrayList<String> ans = AllPattern(arr,index+1);
		
		char[] characters = map.get(arr[index]);
		for (String str : ans) {
			for (char c : characters) {
				result.add(c+str);
			}
		}
		return result;
	}

}
