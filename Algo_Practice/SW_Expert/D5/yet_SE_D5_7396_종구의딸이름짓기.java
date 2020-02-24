package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class yet_SE_D5_7396_종구의딸이름짓기 {
	static char[][] table;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			
			table = new char[N][M];
			
			for (int i = 0; i < N; i++) {
				table[i] = br.readLine().toCharArray();
			}
			
			int nowX = 0;
			int nowY = 0;
			StringBuilder ans = new StringBuilder();
			
			Queue<Position> que = new LinkedList<>();
			que.add(new Position(nowY, nowX));
			
			while(true){
				ans.append(table[nowY][nowX]);
				
				if(nowX == M-1 && nowY == N-1) {
					break;
				}
				
				if(nowY+1 < N)
					que.add(new Position(nowY+1, nowX));
				if(nowX+1 < M)
					que.add(new Position(nowY, nowX+1));
				
				while(!que.isEmpty()) {
					Position now = que.poll();
					//오른쪽 아래쪽 비교해서 더 빠른 알파벳으로 이동
					// 만약 같으면 그 알파벳의 오른쪽 아래쪽 의 후보들을 탐색
					// 
				}
				
				
			}
			
			System.out.println("#"+tc+" ");
		}
	}
	
	static class Position{
		int x,y;
		char value;
		public Position(int y, int x) {
			this.x = x;
			this.y = y;
			this.value = table[y][x];
		}
	}
}
