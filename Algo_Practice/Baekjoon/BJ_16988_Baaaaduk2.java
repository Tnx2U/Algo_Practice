import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_16988_Baaaaduk2 {
	static int N,M;
	static boolean[] visit;
	static int[][] table;
	static List<Point> candidate = new ArrayList<>();
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		ans = 0;
		
		table = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				table[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(table[i][j] == 0 && nearWhite(i,j).size() > 0)
					candidate.add(new Point(i, j));
			}
		}
		visit = new boolean[candidate.size()];
		
		doCombination(0,0);
		
	}
	
	private static void doCombination(int count, int target) {
		if(count == 2) {
			doSetNSearch();
			return;
		}
		if(target == candidate.size())
			return;
		
		visit[target] = true;
		doCombination(count+1, target+1);
		visit[target] = false;
		doCombination(count, target+1);
	}

	private static void doSetNSearch() {
		int[][] set_black = new int[2][2];
		int idx=0;
		
		for (int i = 0; i < visit.length; i++) {
			if(visit[i] == true) {
				set_black[idx][0] = candidate.get(i).y;
				set_black[idx++][1] = candidate.get(i).x;
				
				table[candidate.get(i).y][candidate.get(i).x] = 1;
			}
		}
		
		// newrWhite사용해서 dfs 하자...
		for (int i = 0; i < 2; i++) {
			List<Point> list = nearWhite(set_black[i][0],set_black[i][1]);
			//for(Point p : list)
		}
		
		
	}

	private static List<Point> nearWhite(int i, int j) {
		List<Point> result = new ArrayList<>();
		
		for (int k = 0; k <= 3; k++) {
			int nextX = j+dx[k];
			int nextY = i+dy[k];
			
			if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && table[nextY][nextX] == 2)
				result.add(new Point(nextY, nextX));
		}
		return result;
	}

	static class Point{
		int x,y;

		public Point(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
}
