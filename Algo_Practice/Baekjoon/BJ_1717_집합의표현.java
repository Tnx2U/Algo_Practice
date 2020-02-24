

import java.util.Scanner;

public class BJ_1717_집합의표현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N+1];
		
		for (int i = 0; i <= N; i++) {
			arr[i] = i;
		}
		
		
		for (int i = 0; i < M; i++) {
			int cmd = sc.nextInt();
			
			if(cmd == 0) {
				union(arr, sc.nextInt(), sc.nextInt());
			}else if(cmd == 1) {
				sameSet(arr, sc.nextInt(), sc.nextInt());
			}
		}
	}

	private static void sameSet(int[] arr, int a, int b) {
		int p1 = find(arr, a);
		int p2 = find(arr, b);
		
		if(p1 != p2) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}
	}

	private static int find(int[] arr, int a) {
		if(arr[a] == a) {
			return a;
		}else {
			int parent = find(arr, arr[a]);
			arr[a] = parent;
			return parent;
		}
	}

	private static void union(int[] arr, int a, int b) {
		int p1 = find(arr, a);
		int p2 = find(arr, b);
		
		if(p1 != p2) {
			arr[p2] = p1;
		}
	}
}
