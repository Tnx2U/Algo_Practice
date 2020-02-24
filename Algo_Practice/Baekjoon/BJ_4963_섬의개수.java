import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4963_섬의개수 {
	static int[] dx = {0,1,1,1,0,-1,-1,-1};
	static int[] dy = {-1,-1,0,1,1,1,0,-1};
	static int W,H;
	static int ans;
	static int[][] table;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			ans = 0;
			String[] WH = br.readLine().split(" ");
			W = Integer.parseInt(WH[0]);
			H = Integer.parseInt(WH[1]);
			
			if(W==0 && H==0)
				break;
			
			table = new int[H][W];
			visit = new boolean[H][W];
			
			for (int i = 0; i < H; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(!visit[i][j]&&table[i][j]==1) { //방문한 적 없고 땅이면
						doBFS(i,j);
					}
				}
			}
			System.out.println(ans);
			
		}
	}
	
	private static void doBFS(int y, int x) {
		ans++;
		Queue<Position> que = new LinkedList<>();
		que.add(new Position(y, x));
		
		while(!que.isEmpty()) {
			Position now = que.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int nextX = now.x+dx[i];
				int nextY = now.y+dy[i];
				if(nextX >=0 && nextX < W && nextY >=0 && nextY < H) {
					if(table[nextY][nextX]==1 && !visit[nextY][nextX]) {
						que.add(new Position(nextY, nextX));
						visit[nextY][nextX] = true;
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
}
