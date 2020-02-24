
public class Solution {
	public static void main(String[] args) {
		
		String[] emails = {"d@co@m.com", "a@abc.com", "b@def.com", "c@ghi.net"};
		int ans = 0;
		
		
		for (int i = 0; i < emails.length; i++) {
			if(emails[i].length() < 7)
				continue;
			
			StringBuilder sb = new StringBuilder();
			sb.append(emails[i]);
			
			//1
			String top = sb.substring(sb.length()-4);
			if(!top.equals(".com") && !top.equals(".net") &&!top.equals(".org")){
				
			}
			sb.delete(sb.length()-4, sb.length());
			System.out.println(sb.toString());
			
			//2	
			int cnt = 0;
			int par_idx = 0;
			for (int idx = 0; idx < sb.length(); idx++) {
				if(sb.charAt(idx) == '@') {
					cnt++;
					par_idx = idx;
				}
			}
			
			if(cnt != 1) 
				System.out.println("continue");
			
			//3
			StringBuilder left = new StringBuilder();
			left.append(sb.substring(0, par_idx));
			StringBuilder right = new StringBuilder();
			right.append(sb.substring(par_idx+1, sb.length()));
			
			System.out.println(left.toString());
			System.out.println(right.toString());
			
			//4
			boolean hasError = false;
			for (int j = 0; j < left.length(); j++) {
				char target = left.charAt(j);
				if(target < 'a' || target > 'z') {
					if(target != '.') {
						hasError = true;
						break;
					}
				}
			}
			
			for (int j = 0; j < right.length(); j++) {
				char target = right.charAt(j);
				if(target < 'a' || target > 'z') {
					hasError = true;
					break;
				}
			}
			
			if(hasError) {
				continue;
			}
			ans++;
		}
		System.out.println(ans);
	}
}
