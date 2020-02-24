package JungOl;

import java.util.Scanner;

public class JO_1103_경비원 {
	static int W,H,N;
	static int[][] loc;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		W = sc.nextInt();
		H = sc.nextInt();
		N = sc.nextInt();
		int ans = 0;
		
		loc = new int[N+1][2];
		
		for (int i = 0; i <= N; i++) {
			loc[i][0] = sc.nextInt();
			loc[i][1] = sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			int dis = 0;
			//동근과 상점이 같은 라인
			if(loc[N][0] == loc[i][0]) {
				ans += Math.abs(loc[N][1] - loc[i][1]);
			}else if((loc[N][0]+1)/2 == (loc[i][0]+1)/2) { //동근과 상점이 반대편 라인
				if((loc[N][0]+1)/2 == 1) { //상점이 북남쪽
					if(loc[N][1]+loc[i][1] >= W) { // 오른쪽으로 돌기
						ans += (W-loc[i][1])+(W-loc[N][1])+H;
					}else { // 왼쪽으로 돌기
						ans += loc[i][1]+loc[N][1]+H;
					}
				}else {//상점이 동서쪽
					if(loc[N][1]+loc[i][1] >= H) { // 아래쪽으로 돌기
						ans += (H-loc[i][1])+(H-loc[N][1])+W;
					}else { // 위쪽으로 돌기
						ans += loc[i][1]+loc[N][1]+W;
					}
				}
			}else { // 동근과 상점이 대각선 라인
				int dir = (int) Math.abs(Math.pow(loc[N][0], 2) - Math.pow(loc[i][0], 2));
				switch(dir) {
					case 15:
						ans += (W - (loc[N][0]==1?loc[N][1]:loc[i][1])) + (loc[N][0]==1?loc[i][1]:loc[N][1]);
						break;
					case 12:
						ans += (H - (loc[N][0]==4?loc[N][1]:loc[i][1])) + (W - (loc[N][0]==4?loc[i][1]:loc[N][1]));
						break;
					case 5:
						ans += (loc[N][0]==2?loc[N][1]:loc[i][1]) + (H - (loc[N][0]==2?loc[i][1]:loc[N][1]));
						break;
					case 8:
						ans += (loc[N][0]==3?loc[N][1]:loc[i][1]) + (loc[N][0]==3?loc[i][1]:loc[N][1]);
						break;
				}
			}
		}
		System.out.println(ans);
	}
}
