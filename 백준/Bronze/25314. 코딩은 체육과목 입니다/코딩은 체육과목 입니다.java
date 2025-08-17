import java.util.*;
public class Main{
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	final int a = sc.nextInt();
    	
    	String str = "long ";
    	
    	for(int i=a; i>=4; i-=4) {
    		System.out.print(str);
    	}
    	System.out.println("int");
    }
}