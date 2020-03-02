package lv3;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
	public static void main(String[] args) {
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(6,edge));
	}
	
	public static int solution(int n, int[][] edge) {
		boolean[] visit = new boolean[n+1];
        int answer = 0;
        int[] lenArr = new int[n+1];
        boolean[][] has_edge = new boolean[n+1][n+1];
        
        for (int i = 0; i < edge.length; i++) {
			has_edge[edge[i][0]][edge[i][1]] = true;
			has_edge[edge[i][1]][edge[i][0]] = true;
		}
        
        for (int i = 0; i < lenArr.length; i++) {
			lenArr[i] = Integer.MAX_VALUE;
		}
        
        Queue<Integer> que = new LinkedList<>();
        int depth = 0;
        que.add(1);
        visit[1] = true;
        
        Queue<Integer> temp = new LinkedList<>();
        
        depth++;
        while(!que.isEmpty()) {
        	int srt = que.poll();
        	
        	for (int i = 1; i <= n; i++) {
				if(has_edge[srt][i] && !visit[i]) {
					lenArr[i] = depth;
					temp.add(i);
					visit[i] = true;
				}
			}
        }
        
        
        
        
        
        return answer;
    }
}
