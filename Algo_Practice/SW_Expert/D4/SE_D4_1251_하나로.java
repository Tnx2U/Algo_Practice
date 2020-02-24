package D4;

import java.util.Scanner;

public class SE_D4_1251_하나로 {
	static int[][] islands;
	static boolean[] visit;
	static int[] start;
	static int srt_idx;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			double ans = 0;
			int N = sc.nextInt();
			
			islands = new int[N][2];
			start = new int[N];
			visit = new boolean[N];
			srt_idx = 0;
			
			for (int i = 0; i < N; i++) {
				islands[i][0] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				islands[i][1] = sc.nextInt();
			}
			double E = sc.nextDouble();
			
			int count = 0;
			start[srt_idx++] = 0;
			visit[start[0]] = true;
			
			while(srt_idx != N) { 
				double min = Double.MAX_VALUE;
				int dst_idx = -1;
				for (int i = 0; i < srt_idx; i++) {// 이미 방문한 섬들을 출발점으로 반복
					for (int j = 0; j < N; j++) {//모든 섬들을 대상으로 검색
						if(visit[j]) // 이미 방문했으면 제외
							continue;
						if(getDistance(start[i],j) < min) {
							min = getDistance(start[i],j);
							dst_idx = j;
						}
					}
				}
				ans += Math.pow(min, 2);
				visit[dst_idx] = true;
				start[srt_idx++] = dst_idx;
			}
			
			System.out.println("#"+tc+" "+String.format("%.0f", E*ans));
		}
	}

	private static double getDistance(int i, int j) {
		double x = Math.pow(islands[i][0]-islands[j][0], 2);
		double y = Math.pow(islands[i][1]-islands[j][1], 2);
		
		return Math.sqrt(x+y);
	}
}
