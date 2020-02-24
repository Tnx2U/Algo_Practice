package D4;

import java.util.Arrays;
import java.util.Scanner;

public class SE_D4_3124_최소스패닝트리 {
	static Edge[] edges;
	static int[] dj_set;
	static int V, E;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			long ans = 0;

			V = sc.nextInt();
			E = sc.nextInt();
			
			edges = new Edge[E];
			dj_set = new int[V+1];
			
			for (int i = 1; i <= V; i++) {
				dj_set[i] = i;
			}
			
			for (int i = 0; i < E; i++) {
				edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
			
			Arrays.sort(edges);
			
			int count = 0;
			
			for (Edge e : edges) {
				if(findSet(e.start) != findSet(e.end)) {
					ans += e.value;
					union(e.start,e.end);
					count++;
				}
				if(count == V-1)
					break;
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	private static void union(int start, int end) {
		int a = findSet(start);
		int b = findSet(end);
		
		if(a != b)
			dj_set[a] = b;
	}

	private static int findSet(int idx) {
		if(dj_set[idx] == idx)
			return idx;
		
		dj_set[idx] = findSet(dj_set[idx]);
		return dj_set[idx];
	}

	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int value;
		
		public Edge(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}

		@Override
		public int compareTo(Edge o) {
			return value - o.value;
		}
	}
}
