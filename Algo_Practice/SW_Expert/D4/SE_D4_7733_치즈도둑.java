package D4;

import java.util.Scanner;

public class SE_D4_7733_치즈도둑 {
	static boolean[][] visit;
	static int table[][];
	static int result;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			int ans = 0;
			N = sc.nextInt();
			
			table = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			
			for (int day = 0; day <= 100; day++) {
				result = 0;
				visit = new boolean[N][N];
				boolean isAll = false;

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(table[i][j] <= day) {
							visit[i][j] = true;
						}
					}
				}
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(!visit[i][j]) {
							result++;
							dfs(i,j);
						}
					}
				}
				
				
				ans = Math.max(ans, result);
			}
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void dfs(int i, int j) {
		visit[i][j] = true;
		for (int k = 0; k < 4; k++) {
			if(i+dy[k] < N && i+dy[k] >= 0 && j+dx[k] < N && j+dx[k] >= 0) {
				int x_next = j+dx[k];
				int y_next = i+dy[k];
				if(!visit[y_next][x_next]) {
					dfs(y_next, x_next);
				}
			}
		}
	}
}
