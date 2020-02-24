package 모의;

import java.util.Scanner;

public class SE_모의_1104_활주로건설2 {
	static int[][] table;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int N,X,ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			X = sc.nextInt();
			ans = 0;
			table = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			//입력 끝
			for (int i = 0; i < N; i++) {
				makeRoad(1,i);
			}
			for (int i = 0; i < N; i++) {
				makeRoad(2,i);
			}
			
			System.out.println("#"+tc+" "+ans);
		}
		
	}
	private static void makeRoad(int di, int srt) {
		if(di == 1) {
			int x = 0;
			int y = srt;
		}else {
			int x = srt;
			int y = 0;
		}
		
		
	}
}
