package D3;

import java.util.LinkedList;
import java.util.Scanner;

public class SE_D3_1228_PassWord1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<>();

		for (int t = 1; t <= 10; t++) {
			// 원본 입력
			int ori_len = scan.nextInt();
			for (int i = 0; i < ori_len; i++) {
				list.add(scan.nextInt());
			}

			int cmd_len = scan.nextInt();

			// 명령어 개수만큼 반복하며 수정
			for (int i = 0; i < cmd_len; i++) {
				scan.next(); // 작대기 날리기용 페이크코드
				int pos = scan.nextInt();
				int add_len = scan.nextInt();

				for (int j = 0; j < add_len; j++) { //리스트의 pos 위치에 덧붙일 내용을 불러와서 추가
					list.add(pos + j, scan.nextInt());//붙여야할 인덱스 위치가 1씩 늘어남에 주의
				}
			}

			System.out.print("#" + t);
			for (int i = 0; i < 10; i++) {// 출력~
				System.out.print(" " + list.get(i));
			}
			System.out.println();
			list.clear();//리스트 초기화, 이거 안했다가 강호한테 욕먹음
		}
	}
}
