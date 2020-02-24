package D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SE_D6_1263_사람네트워크2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] dist = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(dist[i][j] > dist[i][k]+dist[k][j])
							dist[i][j] = dist[i][k]+dist[k][j];
					}
				}
			}
			
			int[] cc = new int[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cc[i] += dist[i][j];
				}
			}
			
			Arrays.sort(cc);
			
			System.out.println("#"+tc+" "+cc[0]);
		}
	}
}
