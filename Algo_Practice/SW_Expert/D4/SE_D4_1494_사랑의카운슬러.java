package D4;

import java.util.Arrays;
import java.util.Scanner;

public class SE_D4_1494_사랑의카운슬러 {
	static int N;
	static Point[] worms;
	static boolean[] visit;
	static long ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			ans=Long.MAX_VALUE;
			N = sc.nextInt();
			worms = new Point[N];
			visit = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				worms[i] = new Point(sc.nextInt(), sc.nextInt());
			}
			combination(N/2, 0);
			
			System.out.println("#"+tc+" "+ans);
		}
	}

	
	private static void combination(int pick, int target) {
		if(pick == 0) {
			ans = Math.min(ans, getVector());
		}else if(target == N) {
			return;
		}else {
			visit[target] = true;
			combination(pick-1, target+1);
			visit[target] = false;
			combination(pick, target+1);
		}
	}

	private static void swap(int depth, int i) {
		Point temp = worms[depth];
		worms[depth] = worms[i];
		worms[i] = temp;
	}

	private static long getVector() {
		long totalX = 0;
		long totalY = 0;
		
		for (int i = 0; i < N; i++) {
			if(visit[i]) {
				totalX += worms[i].x;
				totalY += worms[i].y;
			}else {
				totalX -= worms[i].x;
				totalY -= worms[i].y; 
			}
		}
		
		long result = totalX * totalX + totalY * totalY;
		return result;
	}

	static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
