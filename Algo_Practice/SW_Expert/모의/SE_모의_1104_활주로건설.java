package 모의;

import java.util.Scanner;

public class SE_모의_1104_활주로건설 {
	static int[][] table;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			table = new int[N][N];
			int ans=0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			//입력 끝
			for (int i = 0; i < N; i++) {
				// i 행이 활주로가 되는지 체크 시작
				boolean isOK = true;
				boolean[] used = new boolean[N]; // 경사로 설치한 위치에 표시해두기
				for (int j = 0; j < N; j++) { 
					if(table[i][j] == table[i][j-1]) {
						continue;
					}else if(table[i][j-1]+1 == table[i][j] && (j-X)>=0 && !used[j-X]) { // 오르막인 경우
						for (int tj = j-X; tj < j; tj++) { //경사로 가로길이만큼 앞으로 가서 경사로 설치가능 확인
							if(table[i][j-1] != table[i][tj])
								isOK = false;
							used[tj] = true;
						}
					}else if(table[i][j-1]-1 == table[i][j] && (j+X)<=N ) {
						for (int tj = j; tj < j+X; tj++) { //경사로 가로길이만큼 앞으로 가서 경사로 설치가능 확인
							if(table[i][j] != table[i][tj])
								isOK = false;
							used[tj] = true;
						}
					}else { // 평지도, 한칸 오르막도, 한칸 내리막도 아니면 활주로 불가
						isOK = false;
						break;
					}
				}
				// 활주로 갯수++ 할지말지 판단.
				if(isOK)
					ans++;
			}
			// 세로 활주로 갯수 체크
			
			
		}
		
	}
}
