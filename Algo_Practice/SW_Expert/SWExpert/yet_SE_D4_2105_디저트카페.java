package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class yet_SE_D4_2105_디저트카페 {
	static List<Point> record;
	static int[][] table;
	static int[] dx = {1,-1,-1,1};
	static int[] dy = {1,1,-1,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			table = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 입력 끝
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					makeCircle(i,j,i,j,0);
				}
			}
		}
	}


	private static void makeCircle(int srt_y, int srt_x, int y, int x, int prev) {
		
	}


	static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
