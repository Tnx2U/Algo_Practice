package D3;

import java.util.Scanner;

public class SE_D3_8338_계산기 {
	static int ans;
	static int total;
	static int N;
	static int[] input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			ans = 0;
			
			N = sc.nextInt();
			input = new int[N];
			
			for (int i = 0; i < N; i++) {
				input[i] = sc.nextInt();
			}
			total = input[0];
			
			
			ans = input[0];
			for (int i = 1; i < N; i++) {
				if(ans == 0 || input[i] == 0)
					ans += input[i];
				else if(ans == 1 || input[i] == 1) {
					ans += input[i];
				}else {
					ans *= input[i];
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}

}
