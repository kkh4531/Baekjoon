import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int arr[][] = new int[9][9];
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int max = arr[0][0];
		int row = 0, column = 0;
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(arr[i][j]>max) {
					max = arr[i][j];
					row = i;
					column = j;
				}
			}
		}
		System.out.println(max);
		System.out.println((row+1)+" "+(column+1));
	}
}