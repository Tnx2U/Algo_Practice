package D5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SE_D5_4534_트리흑백색칠 {
	static final int MOD = 1000000007;
	static int N;
	static List<Integer>[] adj;
	static long[][] memo; //색상, 정점번호  => 해당 번호를 해당 색상으로 칠할때 경우의 수
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			long ans = 0;
			N = sc.nextInt();
			adj = new ArrayList[N+1];
			for (int i = 1; i <= N; i++)
				adj[i] = new ArrayList<>();
			memo = new long[2][N+1];
			for (int j = 1; j < N; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj[a].add(b);
				adj[b].add(a);
			}
			ans = (dfs(1, 0, -1) + dfs(1,1,-1)) %MOD;
			System.out.println("#"+tc+" "+ans);
		}
	}

	
	static long dfs(int v, int color, int parent) {
		//memo[color][v] 값이 존재하면 다시 계산하지 않고 알고 있던거 리턴
		if(memo[color][v] != 0) 
			return memo[color][v];
		
		long ret = 1;
		//color가 흑이면 0, 백이면 1
		//color 흑이면
		if(color == 0) {
			for(int i = 0; i < adj[v].size(); i++) {
				if (adj[v].get(i) != parent) {
					//자식 노드들을 백으로 칠한 경우의 경우의 수들 곱
					ret *= dfs(adj[v].get(i), 1, v);
					ret %= MOD;
				}
			}
		}
		
		
		//color가 백이면
		//자식 노드들을 흑으로 칠한 경우의 곱
		//자식 노드들을 백으로 칠한 경우의 곱
		//memo[color][v] 에 기록
		else if(color == 1) {
			for(int i = 0; i < adj[v].size(); i++) {
				if (adj[v].get(i) != parent) {
					//자식 노드들을 백으로 칠한 경우의 경우의 수들 곱
					ret *= (dfs(adj[v].get(i), 1, v) + dfs(adj[v].get(i), 0, v));
					ret %= MOD;
				}
			}
		}
		memo[color][v] = ret;
		return ret;
	}
}
