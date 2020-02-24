import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_16235_나무재테크 {
	static int N,M,K;
	static int[][] A;
	static int[] dx = {0,1,1,1,0,-1,-1,-1};
	static int[] dy = {-1,-1,0,1,1,1,0,-1};
	static Soil[][] soils;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N][N];
		soils = new Soil[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				soils[i][j] = new Soil(5);
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int old = Integer.parseInt(st.nextToken());
			
			soils[y][x].trees.add(old);
		}
		for (int k = 0; k < K; k++) {
			//봄 : 각 칸에 대하여 양분이 자기 나이보다 작으면 죽음, 아니면 나이 1업
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Soil now = soils[i][j];
					int size = now.trees.size();
					if(size > 0) { //나무가 존재하면
						for (int idx = size-1; idx >= 0 ; idx--) {
							if(now.trees.get(idx) <= now.life) { //레벨업
								soils[i][j].life -= now.trees.get(idx);
								soils[i][j].trees.set(idx, now.trees.get(idx)+1);
							}else { // 양분이 모자름
								soils[i][j].deadTrees.add(now.trees.get(idx));
								soils[i][j].trees.remove(idx);
							}
						}
					}
				}
			}
			// 여름 : 봄에 죽은 나무 나이/2 양분추가
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Soil now = soils[i][j];
					int size = now.deadTrees.size();
					if(size > 0) { 
						for (int idx = 0; idx < size ; idx++) {
							soils[i][j].life += now.deadTrees.get(idx)/2;
						}
					}
					soils[i][j].deadTrees.clear();
				}
			}
			//가을 : 나이 5의 배수 나무들의 8방에 나이1 나무생성
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Soil now = soils[i][j];
					int size = now.trees.size();
					if(size > 0) { //나무가 존재하면
						for (int idx = size-1; idx >= 0 ; idx--) {
							if(now.trees.get(idx)%5 == 0) { //나이가 5의 배수
								for (int l = 0; l < 8; l++) {
									int tx = j+dx[l];
									int ty = i+dy[l];
									if(tx >= 0 && tx < N && ty >= 0 && ty< N) {
										soils[ty][tx].trees.add(1);
									}
								}
							}
						}
					}
				}
			}
			//겨울 A[][]만큼 땅에 각각 양분추가
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					soils[i][j].life += A[i][j];
				}
			}
		}
		long result = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result += soils[i][j].trees.size();
			}
		}
		System.out.println(result);
	}
	
	static class Soil{
		List<Integer> trees;
		//PriorityQueue<Integer> trees;
		List<Integer> deadTrees;
		
		int life;
		public Soil(int life) {
			this.life = life;
			trees = new ArrayList<>();
			//trees = new PriorityQueue<>();
			deadTrees = new ArrayList<>();
		}
	}
}
