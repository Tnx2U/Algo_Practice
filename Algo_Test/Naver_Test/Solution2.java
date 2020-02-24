
public class Solution2 {
	public static void main(String[] args) {
		//String[] drum = {"######",">#*###","####*#","#<#>>#",">#*#*<","######"};
		String[] drum = {"######",">#*###","####*#","#<#>>#",">#*#*<","######"};
		
		char[][] table = new char[drum.length][drum[0].length()];
		for (int i = 0; i < drum.length; i++) {
			table[i] = drum[i].toCharArray();
		}
		int answer = 0;
		
		for (int i = 0; i < table[0].length; i++) {
			int X = i;
			int Y = 0;
			boolean stuck = false;
			
			while(true) {
				if(Y >= table.length) {
					answer++;
					break;
				}
				
				if(table[Y][X] =='>') {
					X++;
				}else if(table[Y][X] =='<') {
					X--;
				}else if(table[Y][X] =='#') {
					Y++;
				}else if(table[Y][X] =='*') {
					if(stuck)
						break;
					else {
						Y++;
						stuck = true;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
