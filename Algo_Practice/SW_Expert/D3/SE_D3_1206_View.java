package D3;

import java.util.Scanner;

public class SE_D3_1206_View {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int ans=0;
			
			int N =sc.nextInt();
			
			int[] input = new int[N];
			for (int i = 0; i < N; i++) {
				input[i] = sc.nextInt();
			}
			
			for (int i = 2; i < input.length-2; i++) {
				int highest = Math.max(Math.max(input[i-2], input[i-1]),Math.max(input[i+1], input[i+2]));
				if(input[i] > highest) {
					ans += input[i] - highest;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
