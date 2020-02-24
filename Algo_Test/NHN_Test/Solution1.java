import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		
		// map에 할당
		while(st.hasMoreTokens()) {
			String input = st.nextToken();
			if(map.containsKey(input)) {
				map.put(input, map.get(input)+1);
			}else {
				map.put(input, 1);
			}
		}
		
		// 하나가 모자라거나 다 같은지 판별
		
		boolean hasdiffer = false;
		Set<Integer> set = new HashSet<>();
		int total = 0;
		
		
		for(Integer value : map.values()) {
			total += value;
			set.add(value);
		}
		
		if(set.size() == 1) { //모두 동일
			System.out.println("Y");
			System.out.println(total);
			System.out.println(map.size());
		}else if(set.size() == 2) { //val종류가 2개
			int[] vals = new int[2];
			int cnt = 0;
			for(Integer value : set) {
				vals[cnt++] = value;
			}
			
			//큰값 작은값 1 차이 나는지 확인
			Arrays.sort(vals);
			//System.out.println(vals[0]+" "+vals[1]);
			if(vals[1]-vals[0] == 1) {//작은 값을 가지는 건 1종류 뿐인지 확인
				cnt = 0;
				for(Integer value : map.values()) {
					if(value == vals[0]) {
						cnt++;
					}
				}
				if(cnt == 1) {
					printResult("Y",total+1,map.size());
				}else {
					printResult("N",total,map.size());
				}
			}else {
				printResult("N",total,map.size());
			}
		}else{//여러개가 다름 -> 불가
			printResult("N",total,map.size());
		}
	}

	private static void printResult(String result, int total, int kind) {
		System.out.println(result);
		System.out.println(total);
		System.out.println(kind);
	}
}
