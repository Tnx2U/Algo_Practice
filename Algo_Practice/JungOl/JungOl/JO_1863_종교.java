package JungOl;

import java.util.HashSet;
import java.util.Scanner;

public class JO_1863_종교 {
	static int N,M;
	static int[] joint;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		
		joint = new int[N+1];
		
		for (int i = 0; i <= N; i++) {
			joint[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			union(sc.nextInt(), sc.nextInt());
		}
		
		for (int i = 1; i <= N; i++) {
			set.add(joint[i]);
		}
		
		System.out.println(set.size());
	}
	private static void union(int a, int b) {
		int p1 = find(a);
		int p2 = find(b);
		
		
		joint[p2] = p1;
		joint[find(b)] = find(a);
		
//		if(p1 != p2) {
//			for (int i = 1; i <= N; i++) {
//				if(find(i) == p2)
//					joint[i] = p1;
//			}
//		}
	}
	private static int find(int a) {
		if(joint[a] == a) {
			return a;
		}
		joint[a] = find(joint[a]);
		return joint[a];
	}
}
