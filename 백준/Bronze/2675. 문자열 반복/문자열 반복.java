import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int numOfString = sc.nextInt();
    	
    	String str[] = new String[numOfString];
    	int a[] = new int[numOfString];
    	Vector v[] = new Vector[numOfString];
    	for(int i=0; i<numOfString; i++) {
    		a[i] = sc.nextInt();
    		str[i] = sc.next();
    	}
    	for(int i=0; i<numOfString; i++) {
    		for(int j=0; j<str[i].length(); j++) {
    			for(int k=0; k<a[i]; k++) {
    				System.out.print(str[i].charAt(j));
    			}
    		}
    		System.out.println();
    	}
    	
    	
    }
}