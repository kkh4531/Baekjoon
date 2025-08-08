import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int n2 = 2*n-1;
		
		for(int i=1; i<n2+1; i+=2) {
			for(int j=n2; j>i; j-=2) {
				System.out.print(" ");
			}
			for(int j=0; j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=n2-1; i>0; i-=2) {
			for(int j=n2; j>i; j-=2) {
				System.out.print(" ");
			}
			for(int j=1; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
