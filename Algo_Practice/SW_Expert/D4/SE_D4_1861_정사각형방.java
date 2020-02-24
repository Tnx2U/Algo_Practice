package D4;

import java.util.Scanner;

public class SE_D4_1861_정사각형방 {
	static int ans;
	static int depth;

	static int[][] table;
	static int[][] memo;
	static int N;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			ans = 0;
			N = sc.nextInt();
			int srt = -1;

			table = new int[N][N];
			memo = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					depth = 1;
					searchPath(i, j);
					memo[i][j] = depth;
					if (ans < depth) {
						ans = depth;
						srt = table[i][j];
					} else if (ans == depth) {
						if (srt > table[i][j])
							srt = table[i][j];
					}
				}
			}

			System.out.println("#" + tc + " " + srt + " " + ans);
		}
	}

	private static void searchPath(int i, int j) {
		for (int k = 0; k <= 3; k++) {
			int nextX = dx[k] + j;
			int nextY = dy[k] + i;
			
			if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
				if(table[nextY][nextX] == table[i][j]+1) {
					if(memo[nextY][nextX] != 0) {
						depth += memo[nextY][nextX];
						return;
					}
				
					depth++;
					searchPath(nextY, nextX);
					return;
				}
			}
		}
	}
}
