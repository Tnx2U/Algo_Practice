
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_17143_낚시왕 {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int[] reverse = {2,3,0,1};
	static int W,H,N;
	static ArrayList<Integer>[][] table;
	static Shark[] sharks;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ans = 0;
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		table = new ArrayList[H][W];
		sharks = new Shark[N];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				table[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int srt_y = Integer.parseInt(st.nextToken());
			int srt_x = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			
			sharks[i] = new Shark(i, speed, dir, size);
			table[srt_y-1][srt_x-1].add(i);
		}
		
		
		for (int fisher = 0; fisher < W; fisher++) {
			//1. 낚시꾼 이동(자동)
			//2. 상어 잡기
			for (int depth = 0; depth < H; depth++) { //낚시꾼 자리에서 찌를 내린다
				if(!table[depth][fisher].isEmpty()) { //처음으로 상어를 만나면
					ans += sharks[table[depth][fisher].get(0)].size; //사이즈 더하고
					table[depth][fisher].clear();// 상어는 제거
				}
			}
			
			//3. 상어 이동 및 동족상잔
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(!table[i][j].isEmpty()) {
						//이전에 이동한 상어와 겹치는 경우 어쩔건지
						Shark target = sharks[table[i][j].get(0)];
						int nextX,nextY;
						nextX = j + dx[target.dir]*target.speed;
						if(nextX < 0) {
							nextX *= -1;
						}else if(nextX >= W) {
							nextX = (W-1) - (nextX-(W-1));
						}
						
						nextY = j + dy[target.dir]*target.speed;
						if(nextY < 0) {
							nextY *= -1;
						}else if(nextY >= H) {
							nextY = (H-1) - (nextY-(H-1));
						}
						
						//이동
					}
				}
			}
			
			
			
		}
	}
	
	static class Shark{
		int id;
		int speed;
		int dir;
		int size;
		
		public Shark(int id,int speed, int dir, int size) {
			this.id = id;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}
}
