package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SE_D5_1256_K번째접미어 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			int k = Integer.parseInt(br.readLine());
			String[] arr;
			List<String> list = new ArrayList<>();
			
			StringBuilder sb = new StringBuilder();
			sb.append(br.readLine());
			
			for (int i = 0; i < sb.length(); i++) {
				list.add(sb.substring(i));
			}
			list.sort(null);
			
			
			
			System.out.println("#"+tc+" "+list.get(k-1));
		}
	}
}
