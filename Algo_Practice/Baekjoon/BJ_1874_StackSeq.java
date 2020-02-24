import java.util.Scanner;
import java.util.Stack;

public class BJ_1874_StackSeq {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] num = new int[N];
		int[] input = new int[N];
		int num_idx = 0;
		int input_idx = 0;
		StringBuilder sb = new StringBuilder();
		boolean isCorrect = true;
		Stack<Integer> stk = new Stack<>();
		
		for (int i = 0; i < num.length; i++) {
			num[i] = i+1;
		}
		for (int i = 0; i < input.length; i++) {
			input[i] = scan.nextInt();
		}
		stk.push(num[num_idx++]);
		sb.append("+");
		
		while(input_idx < N) {
			if(!stk.isEmpty()) {
				if(input[input_idx] > stk.peek()) { // stk.peek 대신 idx?
					stk.push(num[num_idx++]);
					sb.append("+");
				}
				else if(input[input_idx] == stk.peek()) {
					stk.pop();
					input_idx++;
					sb.append("-");
				}else {
					isCorrect = false;
					break;
				}
			}else {
				stk.push(num[num_idx++]);
				sb.append("+");
			}
		}
		
		
		if(isCorrect) {
			for (int j = 0; j < sb.length(); j++) {
				System.out.println(sb.charAt(j));
			}
		}else {
			System.out.println("NO");
		}
	}
}
