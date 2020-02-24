package JungOl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1733_오목 {
	static int[] dx = { 1, 0, 1, 1 };
	static int[] dy = { 0, 1, -1, 1 };
	static int[][] table = new int[19][19];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 끝

		int ans_x = -1;
		int ans_y = -1;
		// 탐색 시작
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (table[i][j] != 0) {// 빈공간이 아니면 검사시작
					if (hasWinner(i, j)) {
						ans_x = j;
						ans_y = i;
						break;
					}
				}
			}

			if (ans_x != -1) {
				break;
			}
		}

		if (ans_x == -1) { // 승부결정안남
			System.out.println(0);
		} else {
			System.out.println(table[ans_y][ans_x]);
			System.out.println((ans_y + 1) + " " + (ans_x + 1));
		}

	}

	private static boolean hasWinner(int y, int x) {
		int owner = table[y][x];

		for (int dir = 0; dir <= 3; dir++) {
			int nowX = x;
			int nowY = y;
			boolean isOK = true;

			for (int i = 0; i <= 4; i++) {
				int nextX = nowX + dx[dir];
				int nextY = nowY + dy[dir];

				if (nextX < 0 || nextY < 0 || nextX >= 19 || nextY >= 19) {
					if (i == 4)
						break;
					else {
						isOK = false;
						break;
					}
				}

				if (table[nextY][nextX] != owner) {
					if (i == 4) {
						break;
					}
					isOK = false;
					break;
				}

				if (i == 4) {
					isOK = false;
				}
				nowX = nextX;
				nowY = nextY;
			}

			if (isOK) {
				int nextX = x - dx[dir];
				int nextY = y - dy[dir];
				if(nextX >= 0 && nextY >= 0 && nextX < 19 && nextY < 19) {
					if(table[nextY][nextX] == owner)
						return false;
				}
				return true;
			}
			
		}
		return false;
	}
}
