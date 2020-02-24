import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class yet_BJ_17472_다리만들기2 {
	static int N,M;
	static int[][] table;
	static boolean[][] visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int id_cnt = 0;
	static List<Bridge> bridges = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		
		table = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 끝
		
		//1.테이블상의 섬들에 섬id 기록하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(table[i][j]==1 && !visit[i][j]) {
					id_cnt++;
					bfs(i,j);
				}
			}
		}
		
		//2.생성 가능한 다리를 모두 찾아서 리스트에 추가
		//가로 브릿지 탐색
		for (int i = 0; i < N; i++) {
			boolean inland = false;
			Position src = null;
			for (int j = 0; j < M; j++) {
				if(table[i][j]!=0) {
					int startLand=table[i][j], startJ=j, dist=0;
					while(j<M) {
						if(table[i][j]==0)
							dist++;
						else if(table[i][j]!=startLand) {
							bridges.add(new Bridge(startLand, table[i][j], dist));
							startLand = table[i][j];
						}else if(startLand==table[i][j] && startJ!=j) {
							dist=0;
						}
						j++;
					}
				}
			}
		}
		//세로 브릿지 탐색
		for (int i = 0; i < M; i++) {
			boolean inland = false;
			Position src = null;
			for (int j = 0; j < N; j++) {
				if(table[j][i]!=0) {
					int startLand=table[j][i], startI=i, dist=0;
					while(i<N) {
						if(table[j][i]==0)
							dist++;
						else if(table[j][i]!=startLand) {
							bridges.add(new Bridge(startLand, table[j][i], dist));
							startLand = table[j][i];
						}else if(startLand==table[j][i] && startI!=i) {
							dist=0;
						}
						i++;
					}
				}
			}
		}
		
		//3. bridges를 완탐하여 최적의 해 찾기
		//mst
		
	}

	private static void bfs(int y, int x) {
		Queue<Position> que = new LinkedList<>();
		que.add(new Position(y, x));
		
		while(!que.isEmpty()) {
			Position now = que.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int nextX = now.x+dx[i];
				int nextY = now.y+dy[i];
				
				if(nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {
					if(!visit[nextY][nextX] && table[nextY][nextX] == 1) { //방문한 적 없는 땅
						table[nextY][nextX] = id_cnt;
						visit[nextY][nextX] = true;
						que.add(new Position(nextY, nextX));
					}
				}
			}
		}
	}
	
	static class Position{
		int x,y;

		public Position(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Bridge implements Comparable<Bridge>{
		int src;
		int dst;
		int length;
		
		public Bridge(int src, int dst, int length) {
			this.src = src;
			this.dst = dst;
			this.length = length;
		}

		public int compareTo(Bridge o) {
			
			return 0;
		}
	}
}
