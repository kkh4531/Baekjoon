import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a[] = new int[10];
		int b[] = new int[10];
		int cnt=0;
		for(int i=0; i<a.length; i++) {
			a[i] = sc.nextInt();
			b[i] = a[i]%42;
		}
		Arrays.sort(b);
		for(int i=0; i<a.length-1; i++) {
			if(b[i]!=b[i+1]) {
				cnt++;
			}
		}
		System.out.println((cnt)+1);
	}
}