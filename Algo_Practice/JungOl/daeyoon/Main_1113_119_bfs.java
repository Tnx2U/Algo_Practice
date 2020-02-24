package daeyoon;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1113_119_bfs {
	static int[][] memo, map;
	static PriorityQueue<Point> pq;
	static int X, Y, sx, sy;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();
		sx = sc.nextInt();
		sy = sc.nextInt();

		memo = new int[X][Y];
		map = new int[X][Y];
		pq = new PriorityQueue<>();
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				map[i][j] = sc.nextInt();
				memo[i][j] = Integer.MAX_VALUE;
			}
		}
		bfs();
		System.out.println(ans);
	}

	public static void bfs() {
		memo[0][0] = 0;
		for (int d = 0; d < 4; d++) {
			int nx = 0 + dx[d];
			int ny = 0 + dy[d];
			if (nx >= 0 && nx < X && ny >= 0 && ny < Y) {
				if (map[nx][ny] == 1) {
					pq.add(new Point(nx, ny, d, 0));
					memo[nx][ny] = 0;
				}
			}
		}
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			if (ans < p.dript)
				continue;
			if (sx == p.x && sy == p.y) {
				ans = Math.min(ans, p.dript); 
			}
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				if (nx >= 0 && nx < X && ny >= 0 && ny < Y&&map[nx][ny]==1) {
					int tmp = p.dript;
					if (p.drec != d)
						tmp += 1;
					if (memo[nx][ny] > tmp) {
						pq.add(new Point(nx, ny, d, tmp));
						memo[nx][ny] = tmp;
					}
				}
			}
		}
	}

	public static class Point implements Comparable<Point> {
		int x;
		int y;
		int drec;
		int dript;

		public Point(int x, int y, int drec, int dript) {
			this.x = x;
			this.y = y;
			this.drec = drec;
			this.dript = dript;
		}

		@Override
		public int compareTo(Point o) {
			return this.dript - o.dript;
		}

	}
}
