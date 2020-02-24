import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		System.out.println(solution(input));
	}

	private static boolean solution(String input) {
		boolean ans = true;
		Map<Character, Integer> val = new HashMap<Character, Integer>();
		val.put('(', 1);
		val.put('{', 2);
		val.put('[', 3);
		Map<Character, Character> pair = new HashMap<Character, Character>();
		pair.put('(', ')');
		pair.put('{', '}');
		pair.put('[', ']');
		Stack<Character> stk = new Stack<Character>();
		
		for (int i = 0; i < input.length(); i++) {
			char now = input.charAt(i);
			
			if(now == '[' || now == '(' || now == '{') {
				if(!stk.isEmpty() && val.get(stk.peek())<= val.get(now)) {
					ans = false;
					break;
				}else {
					stk.push(now);
				}
			}else if(now == ']' || now == ')' || now == '}') {
				if(stk.isEmpty()) {
					ans = false;
					break;
				}else if(pair.get(stk.pop()) != now) {
					ans = false;
					break;
				}
			}
		}
		
		if(!stk.isEmpty()) {
			ans = false;
		}
		
		return ans;
	}
}
