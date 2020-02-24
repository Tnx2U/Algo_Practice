import java.util.Scanner;

public class Solution1 {
	static int ans = 0;
	static int[] inputs;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int budget = sc.nextInt();
		inputs = new int[2];
		inputs[0] = a;
		inputs[1] = b;
		
		System.out.println(solution(a,b,budget));
	}

	private static int solution(int a, int b, int budget) {
		comb(0, budget,0);
		return ans;
	}

	private static void comb(int idx, int budget, int total) {
		if(total > budget)
			return;
		else if(total == budget) {
			ans++;
			return;
		}else if(idx == 2)
			return;
		
		total += inputs[idx];
		comb(idx, budget, total);
		total -= inputs[idx];
		comb(idx+1, budget, total);
	}
}
