package D4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SE_D4_7465_창용마을무리의개수 {
	static int[] dj_set;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			int ans = 0;
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			dj_set = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				dj_set[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				union(a,b);
			}
			
			Set<Integer> set = new HashSet<>();
			
			for (int i = 1; i <= N; i++) {
				set.add(dj_set[i]);
			}
			ans = set.size();
			
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	private static void union(int a, int b) {
		int p1 = findSet(a);
		int p2 = findSet(b);
		
		if(p1 != p2) {
			for (int i = 1; i < dj_set.length; i++) {
				if(findSet(i) == p2)
					dj_set[i] = p1;
			}
		}
	}
	private static int findSet(int a) {
		if(dj_set[a] == a)
			return a;
		dj_set[a] = findSet(dj_set[a]);
		return dj_set[a];
	}
}
