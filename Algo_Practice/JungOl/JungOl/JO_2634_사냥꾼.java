package JungOl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//import java.util.Scanner;

public class JO_2634_사냥꾼 {
	static long[] spot;
	static Target[] targets;
	static long L;
	static int M,N;
	static int ans;
	static int srt;
	static int end;
	
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ans = 0;
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());
		srt = 0;
		
		spot = new long[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			spot[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(spot);
		
		targets = new Target[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			targets[i] = new Target(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		}
		
		Arrays.sort(targets);
		
		for (int i = 0; i < N; i++) {
			if(M == 1) {
				end = N-1;
			}else if(targets[i].x >= spot[1]) {
				if(i==0)
					end = 0;
				else
					end = i-1;
				break;
			}
		}
		
		for (int i = 0; i < M; i++) {
			shot(spot[i],i);
			for (int idx = srt; idx <= end; idx++) {
				if(targets[idx].x > spot[i]) {
					srt = idx;
					break;
				}
			}
			for (int idx = end; idx < N; idx++) {
				if(idx <= 0)
					idx = 0;
				if(i+2 >= M-1 || idx >= N-1) {
					end = N-1;
				}else if(targets[idx].x > spot[i+2]){
					end = idx-1;
					break;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	private static void shot(long x, int idx) {
		for (int i = srt; i <= end; i++) {
			if(targets[i].dead)
				continue;
			
			if(L >= Math.abs(x-targets[i].x) + targets[i].y) {
				targets[i].dead = true;
				ans++;
			}
		}
		
		if(idx == N-1 || srt >= M) {
			return;
		}
	}

	static class Target implements Comparable<Target>{
		long x;
		long y;
		boolean dead;
		
		public Target(long x, long y) {
			this.x = x;
			this.y = y;
			this.dead = false;
		}

		@Override
		public int compareTo(Target o) {
			return (int) (x - o.x);
		}
	}
}
