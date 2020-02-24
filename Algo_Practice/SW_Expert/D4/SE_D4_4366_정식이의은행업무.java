package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SE_D4_4366_정식이의은행업무 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			long ans = -1;
			List<Long> list = new ArrayList<>();
			
			StringBuilder bin = new StringBuilder(br.readLine());
			StringBuilder tri = new StringBuilder(br.readLine());
			
			// 2진수 수정해서 후보들 리스트에 추가
			for (int i = 0; i < bin.length(); i++) {
				if(bin.charAt(i) == '0') {
					StringBuilder temp = new StringBuilder(bin.toString());
					temp.replace(i, i+1, "1");
					list.add(Long.parseLong(temp.toString(), 2));
				}else {
					StringBuilder temp = new StringBuilder(bin.toString());
					temp.replace(i, i+1, "0");
					list.add(Long.parseLong(temp.toString(), 2));				
				}
			}
			
			// 3진수 수정해서 리스트의 후보들이랑 비교
			for (int i = 0; i < tri.length(); i++) {
				for (int j = 0; j < 3; j++) {
					StringBuilder temp = new StringBuilder(tri.toString());
					temp.replace(i, i+1, Integer.toString(j)); // 수정
					if(!temp.toString().equals(tri.toString())) {//기존이랑 다르면
						for (int k = 0; k < list.size(); k++) {
							if(list.get(k) == Long.parseLong(temp.toString(),3)) { 
								// 10진수로 변환해서 리스트의 후보랑 비교
								ans = list.get(k);
								break;
							}
						}
					}
					if(ans != -1)
						break;
				}
				if(ans != -1)
					break;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
