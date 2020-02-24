import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_16236_아기상어 {
	static int N;
	static int[][] table;
	static boolean[][] visit;
	static List<Position> mealList;
	static int shark_x; 
	static int shark_y;
	static int shark_size;
	static int shark_exp;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		table = new int[N][N];
		shark_size = 2;
		shark_exp = 0;
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
				if(table[i][j] == 9) {
					shark_x = j;
					shark_y = i;
					table[i][j] = 0;
				}
			}
		}
		
		while(true) {
			//먹을 수 있는 물고기 있는지 탐색 물고기의 현재 위치 기준으로 BFS수행
			visit = new boolean[N][N];
			mealList = new ArrayList<>();
			findMeals(shark_x, shark_y);
			//리스트의 먹이 중 최적의 먹이를 찾아 이동
			if(mealList.isEmpty()) // 먹이 없으면 끝
				break;
			//먹이 있으면 이동하고 그만큼 시간 업
			mealList.sort(new Comparator<Position>() {
				public int compare(Position o1, Position o2) {
					if(o1.y != o2.y)
						return o1.y - o2.y;
					else
						return o1.x - o2.x;
				}
			});
			
			//골라낸 최적의 먹이의 위치로 이동하고 먹음
			Position target = mealList.get(0);
			shark_x = target.x;
			shark_y = target.y;
			ans += target.dis;
			shark_exp++;
			table[target.y][target.x] = 0;
			if(shark_exp == shark_size) { //레벨업 할 시간
				shark_exp = 0;
				shark_size++;
			}
		}
		
		System.out.println(ans);
	}
	
	private static void findMeals(int srt_x, int srt_y) {
		//targets.add(new Position(srt_x, srt_y));
		List<Position> targets = new ArrayList<>();
		List<Position> origin = new ArrayList<>();
		
		origin.add(new Position(srt_x, srt_y));
		visit[srt_y][srt_x] = true;
		
		int dis = 0;
		while(!origin.isEmpty()) {
			//큐의 원소중에 먹을 수 있는 물고기가 있는지 확인
			if(!mealList.isEmpty())
				break;
			
			for (Position now : origin) {
				for (int i = 0; i < dx.length; i++) {
					int nextX = now.x+dx[i];
					int nextY = now.y+dy[i];
					if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) { //범위 안
						if(table[nextY][nextX] <= shark_size && !visit[nextY][nextX]) { // 이동 가능
							if(table[nextY][nextX] >= 1 && table[nextY][nextX] < shark_size) {// 먹을 수 있음
								mealList.add(new Position(nextX, nextY, dis+1));
								targets.add(new Position(nextX, nextY));
								visit[nextY][nextX] = true;
							}else {
								targets.add(new Position(nextX, nextY));
								visit[nextY][nextX] = true;
							}
						}
					}
				}
			}
			
			origin.clear();
			for(Position p : targets)
				origin.add(p);
			targets.clear();
			
			dis++;
		}
		
	}
	
	static class Position{
		int x,y,dis;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Position(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}
}
