package D4;

import java.util.Scanner;

public class SE_D4_3074_입국심사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			int ans = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] term = new int[N];
			for (int i = 0; i < N; i++) {
				term[i] = sc.nextInt();
			}
			// 입력끝
			
			int sec = 1;
			int remain = M-2;
			boolean change = false;
			
			
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
