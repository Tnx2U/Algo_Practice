import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ans_BJ_3055_탈출 {
	static char map[][];
	static int R,C;
	static boolean[][] visitW, visitB;
	static int ans;
	static Queue<Point> queueW, queueB;
	static int[] di = {1,-1,0,0};
	static int[] dj = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] RC = br.readLine().split(" ");
		
		R = Integer.parseInt(RC[0]);
		C = Integer.parseInt(RC[1]);
		
		map = new char[R][C];
		visitW = new boolean[R][C];
		visitB = new boolean[R][C];
		
		queueW = new LinkedList<>();
		queueB = new LinkedList<>();
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; i<C; j++) {
				if(map[i][j] == 'S') {
					queueB.add(new Point(i,j,0));
					visitB[i][j] = true;
				}else if(map[i][j]=='*') {
					queueW.add(new Point(i,j,0));
					visitW[i][j]=true;
				}
			}
		}
		
		bfs(); // 1초마다 비버가 상하좌우 한칸 이동 가능하고, 물이 사방으로 번짐.
		
		if(ans == 0) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(ans);
		}
	}
	
	static void bfs() {
		while(!queueB.isEmpty()) { //비버가 이동 가능한 좌표가 남아 있다면 계속 반복할 것임.
			// 일단 물이 번질 예정인 곳에 비버 못가니까 비버 이동시키기 전에 그냥 물 번짐 처리 해버리면 됨.
			int waterCnt = queueW.size();
			for(int w=0; w<waterCnt; w++) { // 큐의 사이즈가 늘어나도 상관없이 맨처음 들어있는 좌표들만 꺼냄
				Point water = queueW.poll();
				
				for (int d = 0; d < 4; d++) {
					int ni = water.i +di[d];
					int nj = water.j +dj[d];
					
					if(ni>=0 && ni<R && nj>=0 && nj<C &&
							map[ni][nj]!='D' && map[ni][nj]!='X' && !visitW[ni][nj]) {
						queueW.add(new Point(ni, nj, 0)); // 다음 초에 물번짐을 위해 큐에 들어감.
						visitW[ni][nj] = true; //물 번졌음
						map[ni][nj] = '*';
					}
				}
			}
			/// 물 번짐 한턴 진행됨. 이제 비버가 움직여보자 BFS. 이미 물이 번진 곳은 못감.
			int moveCnt = queueB.size();
			for(int m=0; m<moveCnt; m++) { //
				Point beaver = queueB.poll();
				
				if(map[beaver.i][beaver.j]=='D') {
					ans = beaver.dist;
					return;
				}
				
				for (int d = 0; d < 4; d++) {
					int ni = beaver.i + di[d];
					int nj = beaver.j + dj[d];
					
					// 이동 가능 여부 판단. 'D' 또는 '.'으로만 이동 가능하고 방문했던 곳은 제외함
					if(ni>=0 && ni<R && nj>=0 && nj<C && 
							(map[ni][nj]=='D' || map[ni][nj]=='.') && !visitB[ni][nj]) {
						queueB.add(new Point(ni, nj, beaver.dist+1));
						visitB[ni][nj] = true;
					}
				}
			}
		}
	}
	
	static class Point{
		int i,j,dist;
		
		Point(int i, int j, int dist){
			this.i = i;
			this.j = j;
			this.dist = dist;
		}
	}
}
