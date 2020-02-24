package D4;

import java.awt.image.SampleModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class SE_D4_5643_키순서 {
	static boolean[] visit;
	static HashSet<Integer> set;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			int ans = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();

			Student[] students = new Student[N];
			for (int i = 0; i < students.length; i++) {
				students[i] = new Student(i + 1);
			}

			for (int i = 0; i < M; i++) {
				int small_stu = sc.nextInt() - 1;
				int tall_stu = sc.nextInt() - 1;

				students[small_stu].tall.add(students[tall_stu]);
				students[tall_stu].small.add(students[small_stu]);
			}

			for (int i = 0; i < students.length; i++) {
				set = new HashSet<>();
				int taller = set.size();
				set = new HashSet<>();
				int smaller = set.size();
				if (taller + smaller == N - 1) {
					ans++;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	static class Student {
		int id;
		List<Student> tall;
		List<Student> small;

		public Student(int id) {
			this.id = id;
			this.tall = new ArrayList<>();
			this.small = new ArrayList<>();
		}

		public void getTallsize() {
			if (!this.tall.isEmpty()) {
				for (Student stu : tall) {
					set.add(stu.id);
					stu.getTallsize();
				}
			}
		}

		public void getSmallsize() {
			if (!this.small.isEmpty()) {
				for (Student stu : small) {
					set.add(stu.id);
					stu.getSmallsize();
				}
			}
		}
	}
}
