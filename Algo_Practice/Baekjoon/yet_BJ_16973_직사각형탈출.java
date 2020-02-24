import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class yet_BJ_16973_직사각형탈출 {
	static int N,M,H,W;
	static int sr,sc,fr,fc;
	static int[][] table;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static boolean[][] visit;
	static int[][] value;
	static Queue<Point> que = new LinkedList<>();
	/*
	 * 1. 실제 배열과 문제 사이의 인덱스 차이 => -1해줌
	 * */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		table = new int[N][M];
		visit = new boolean[N][M];
		value = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				value[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		//table = new int[1000][1000]; 테스트 코드
		
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		sr = Integer.parseInt(st.nextToken())-1;
		sc = Integer.parseInt(st.nextToken())-1;
		fr = Integer.parseInt(st.nextToken())-1;
		fc = Integer.parseInt(st.nextToken())-1;
		
		
		value[sr][sc] = 0;
		que.add(new Point(sr, sc));
		
		while(!que.isEmpty()) {
			Point now = que.poll();
			int nowX = now.x;
			int nowY = now.y;
			visit[nowY][nowX] = true;
			for (int k = 0; k < 4; k++) {
				int nextX = nowX+dx[k];
				int nextY = nowY+dy[k];
				if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
					if(!visit[nextY][nextX] && table[nextY][nextX]==0) {
						if(canGo(nextY,nextX, nowY, nowX)) { // 그 방향으로 갈 수 있는지 여부
							value[nextY][nextX] = value[nowY][nowX]+1;
							// 가장 짧은 가중치로 갱신
							que.add(new Point(nextY, nextX));
						}
					}
				}
			}
		}
		
		
		if(value[fr][fc] == Integer.MAX_VALUE)
			ans = -1;
		else
			ans = value[fr][fc];
		System.out.println(ans);
	}
	
	private static boolean canGo(int nextY, int nextX, int nowY, int nowX) {
		// 1. 격자판 밖으로 튀어나가는지 점검
		if(nextX + W > M || nextY + H > N) // =점검
			return false;
		// 2. 해당 구역으로 들어갈 때 다른 벽과 겹치는 지 점검
		boolean hasblock = false;
		for (int i = nextY; i < nextY+H; i++) {
			for (int j = nextX; j < nextX+W; j++) {
				if(table[i][j] == 1) {
					hasblock = true;
					break;
				}
			}
			if(hasblock)
				break;
		}
		
		return !hasblock;
	}

	static class Point{
		int x,y;
		
		public Point(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
}
