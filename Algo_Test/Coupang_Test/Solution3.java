import java.util.LinkedList;
import java.util.List;

public class Solution3 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	static int answer;
	static int[][] del;
	
	public static void main(String[] args) {
		int r = 3;
		int[][] delivery = {{1, 5},{8, 3},{4, 2},{2, 3},{3, 1},{3, 2},{4, 2},{5, 2},{4, 1}};
		
		System.out.println(solution(r,delivery));
	}
	
	public static int solution(int r, int[][] delivery) {
	 	answer = 0;
	 	int limit = 16;
	 	for (int i = 0; i < delivery.length; i++) {
			limit = Math.max(limit, delivery[i][0]);
		}
	 	del = delivery;
	 	boolean[] getTip = new boolean[delivery.length];
	 	search(getTip, r,0,0,0,0, limit);
	 	
	 	return answer;
	}

	private static void search(boolean[] getTip, int r, int i, int j, int time, int money, int limit) {
		int add = 0;
		if(del[i*r+j][0] >= time) {
			add = del[i*r+j][1];
			
			getTip[i*r+j] = true;
			List<Integer> list = new LinkedList<Integer>();
			for (int k = 0; k < getTip.length; k++) {
				if(!getTip[i*r+j]) {
					list.add(del[i*r+j][0]);
				}
			}
			list.sort(null);
			
			System.out.println("리스트 : ");
			for (Integer n : list) {
				System.out.print(n+" ");
			}
			if(!list.isEmpty()) {
				limit = list.get(list.size()-1);				
			}
		}
		
		System.out.println(limit);
		
		int nextX, nextY;
		for (int k = 0; k < 4; k++) {
			nextX = j+dx[k];
			nextY = i+dy[k];
			
			if(nextX >= 0 && nextY >=0 && nextX < r && nextY < r) {
				search(getTip, r, nextY, nextX, time+1, money+add, limit);
			}
		}
		
		//종료조건	
		if(time == limit) {
			if(money > answer)
				answer = money;
			return;
		}
	}
}
