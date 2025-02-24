import java.util.Scanner;

public class Main {

	private static boolean check(String str) {
		boolean[] bool = new boolean[26];
		
		char previousChar = 0;
		
		for(char c: str.toCharArray()) {
			if(c!=previousChar) {
				if(bool[c-'a']) {
					return false;
				}
				bool[c-'a']=true;
			}
			previousChar = c;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int cnt=0;
		
		
		int n = sc.nextInt();
		String[] str = new String[n];
		
		for(int i=0; i<str.length; i++) {
			str[i] =  sc.next();
			if(check(str[i])) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}
