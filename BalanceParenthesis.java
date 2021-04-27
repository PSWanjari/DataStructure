package Problems;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BalanceParenthesis {

	public static boolean isbalance(String s,HashMap<String, String> map) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<s.length();i++)
		{
		  if(stack.isEmpty())
		  {
			  if(map.containsKey(s.charAt(i)+""))
			  {
				  stack.push(s.charAt(i));
			  }else {
				  return false;
			  }
		  }else {
			  
			  if(map.containsKey(s.charAt(i)+""))
			  {
				  stack.push(s.charAt(i));
			  }else {
				  String d= stack.pop()+"";
				  if(!map.get(d+"").equals(s.charAt(i)+""))
				     return false;  
			  }
		  }
		}
		
		if(stack.isEmpty())
		{
			return true;
		}else {
			return false;
		}
		
	}
	
	
	public static void main(String args[])
	{
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("[","]");
		map.put("(",")");
		map.put("{","}");
		map.put("<",">");
		
		System.out.println(isbalance(s, map)+"");
		
	}
}
