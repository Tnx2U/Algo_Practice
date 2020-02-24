import java.util.Scanner;

public class ans_BJ_6987_월드컵 {
	static int[][] games = { { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 },
			{ 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 } };
	static int[][] score;
	static int[][] result;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 4; tc++) {
			score = new int[6][3];

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					score[i][j] = sc.nextInt();
				}
			}

			result = new int[6][3];
			flag = false;
			worldcup(0);
			if (flag) {
				System.out.println("1 ");
			} else
				System.out.println("0 ");

		}
	}

	static void worldcup(int cnt) {
		if (cnt == 15) { //15번의 경기 승무패를 기록해서 만든 경우의 수가 입력받은 승무패와 일치하는지 체크하고 리턴
			boolean tmp = true;
			here: for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if (result[i][j] != score[i][j]) {
						tmp = false;
						break here;
					}
				}
			}
			flag = tmp;
			return;
		}

		int team1 = games[0][cnt];
		int team2 = games[1][cnt];
		
		//승 1번팀의 승수가 남았고 2번팀의 패로 기록하는 경우
		if(result[team1][0]+1 <= score[team1][0] && result[team2][2]+1 <= score[team2][2]) {
			result[team1][0]++;
			result[team2][2]++;
			worldcup(cnt+1);
			result[team1][0]--;
			result[team1][2]--;
		}
		//패 2번팀의 승수가 남았서 2번팀의 승리 1번팀 패로 기록하는 경우
		if(result[team1][2]+1 <= score[team1][2] && result[team2][0]+1 <= score[team2][0]) {
			result[team1][2]++;
			result[team2][0]++;
			worldcup(cnt+1);
			result[team1][2]--;
			result[team1][0]--;
		}
		//무
		if(result[team1][1]+1 <= score[team1][1] && result[team2][1]+1 <= score[team2][1]) {
			result[team1][1]++;
			result[team2][1]++;
			worldcup(cnt+1);
			result[team1][1]--;
			result[team1][1]--;
		}
	}
}
