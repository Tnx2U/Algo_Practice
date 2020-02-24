package D4;

import java.util.Scanner;

public class SE_D4_7699_수지여행_ANS {
	static int TC, R, C;
	static char[][] map;
	static int ans;
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	static boolean[] alphabet;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			R = sc.nextInt();
			C = sc.nextInt();
			
			map = new char[R][];
			alphabet = new boolean[26];
			
			for (int i = 0; i < R; i++) {
				map[i] = sc.next().toCharArray();
			}
			
			ans = 0;
			alphabet[map[0][0]-'A'] = true; // 수지가 출발하는 칸
			
			dfs(0,0,1);
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void dfs(int i, int j, int cnt) {
		if(ans < cnt)
			ans = cnt;
		
		if(cnt == 26) // 성능향상
			return;
		
		alphabet[map[i][j] - 'A'] = true;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(ni>=0 && ni<R && nj>=0 && nj<C & !alphabet[map[ni][nj]-'A']) //값이 있고 갈 수 있는 곳이면
				dfs(ni, nj, cnt+1);
		}
		
		alphabet[map[i][j] - 'A'] = false;
	}
}
