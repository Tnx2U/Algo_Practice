package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SE_D5_1247_최적경로 {
	static int[] cor = new int[2];
	static int[] home = new int[2];
	static int[][] loc;
	static int N;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			ans = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			loc = new int[N][2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			cor[0] = Integer.parseInt(st.nextToken());
			cor[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < loc.length; i++) {
				loc[i][0] = Integer.parseInt(st.nextToken());
				loc[i][1] = Integer.parseInt(st.nextToken());
			} 
			
			perm(0);
			
			
			System.out.println("#"+t+" "+ans);
		}
	}
	
	private static void perm(int d) {
		if(d == N) {
			ans = Math.min(ans, cal());
			return;
		}
		for (int i = d; i < loc.length; i++) {
			swap(i, d);
			perm(d+1);
			swap(i, d);
		}
	}

	private static void swap(int i, int j) {
		int[] tmp = loc[i];
		loc[i] = loc[j];
		loc[j] = tmp;
	}

	private static int cal() {
		int dst = getDistance(cor[0],cor[1],loc[0][0], loc[0][1]);
		for (int i = 0; i < loc.length-1; i++) {
			dst += getDistance(loc[i][0],loc[i][1],loc[i+1][0],loc[i+1][1]);
		}
		dst += getDistance(loc[loc.length-1][0],loc[loc.length-1][1],home[0],home[1]);
				
		return dst;
	}

	public static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
}
