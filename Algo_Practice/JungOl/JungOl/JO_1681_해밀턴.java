package JungOl;

import java.util.Scanner;

public class JO_1681_해밀턴 {
	static int[][] map;
	static boolean[] visit;
	static int N, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <=N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(1,1,0);
	}
	
	static void dfs(int now, int cnt, int dist) {
		if(cnt==N) { // 출발지 포함해서 N개의 정점을 다 밟았다! 출발지로 돌아갈 차례다!
			if(map[now][1]>0 && ans > dist+map[now][1]) {
				ans = dist+map[now][1];
			}
			return;
		}
		
		if(dist >= ans) {
			return;
		}
		
		for (int i = 2; i <= N; i++) { // 출발지 1번은 출발 할때랑 도착할 때 아니면 방문 안하니까
			if(map[now][i]>0 && !visit[i]) {
				visit[i] = true;
				dfs(i,cnt+1,dist+map[now][i]);
				visit[i] = false;
			}
		}
	}
}
