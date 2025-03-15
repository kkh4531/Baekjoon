import java.util.*;
public class Main {       //68
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int cnt=1;
		int a1 = a/10; // 26 2
		int a2 = a%10; // 26 6
		int a3 = a1+a2; //26 2+6=8
		if(a3>=10) {
			a3 = a3%10; // 14 4
		}
		int num = (a2*10) + a3; // 26 6 + 8 68
		//26 2+6=8 68 6+8=14 84 8+4=12 42 4+2=6 26
		int a4=0;
		int a5;
		while(a!=num) {
			a1 = num; // 
			a2 = a1/10;
			a3 = a1%10;
			a4 = a2+a3;
			if(a4>9) {
				a4 = a4%10;
			}
			num = (a3*10)+a4;
			cnt++;
		}
		System.out.println(cnt);
	}
}