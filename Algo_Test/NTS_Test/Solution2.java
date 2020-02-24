import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		long input = sc.nextLong();
		System.out.println(solution(input));
	}

	private static int solution(long input) {
		int ans = 0;
		StringBuffer sb = new StringBuffer();
		sb.append(input);
		
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < sb.length(); i++) {
			set.add(sb.charAt(i) - '0');
		}
		
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			int div = iter.next();
			if(div == 0)
				continue;
			
			if(input % div == 0)
				ans++;
		}
		
		
		return ans;
	}
}
