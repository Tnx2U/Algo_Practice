package JungOl;

import java.util.Scanner;

public class JO_2283_RGB마을 {
	static int table[][];
	static int memory[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		table = new int[N][3];
		memory = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			table[i][0] = sc.nextInt();
			table[i][1] = sc.nextInt();
			table[i][2] = sc.nextInt();
		}
		
		memory[0][0] = table[0][0];
		memory[0][1] = table[0][1];
		memory[0][2] = table[0][2];
		
		for (int i = 1; i < N; i++) {
			memory[i][0] = Math.min(memory[i-1][1], memory[i-1][2])+table[i][0];
			memory[i][1] = Math.min(memory[i-1][0], memory[i-1][2])+table[i][1];
			memory[i][2] = Math.min(memory[i-1][0], memory[i-1][1])+table[i][2];
		}
		
		System.out.println(Math.min(memory[N-1][0], Math.min(memory[N-1][1], memory[N-1][2])));
	}
}
