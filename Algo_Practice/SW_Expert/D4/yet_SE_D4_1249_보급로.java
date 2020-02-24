package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 1.탐색
 * 2.
 * */


public class yet_SE_D4_1249_보급로 {
	static int[][] table;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			int ans = 0;
			N = Integer.parseInt(br.readLine());
			
			table = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] input = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					table[i][j] = input[j] - '0';
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					gangHo(i,j);
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void gangHo(int i, int j) {
		
	}
}
