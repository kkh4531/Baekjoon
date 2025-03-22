import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String str = sc.next();
    
    	char c[] = str.toCharArray();
    	int cnt = 0;
    		
		for(int i=0; i<c.length; i++) {
			if(c[i]=='c') {
				if(i<str.length()-1) {
					if(c[i+1]=='=') {
					
						i=i+1;
					}
					else if(c[i+1]=='-') {
						i=i+1;
					}
				}	
			}
			else if(c[i]=='d') {
				if(i<str.length()-1) {
					if(c[i+1]=='z') {
						if(i<str.length()-2) {
							if(c[i+2]=='=') {
							
								i=i+2;
							}
						}
					}
					else if(c[i+1]=='-') {
						
						i=i+1;
					}
					
				}
			}
			else if(c[i]=='l') {
				if(i<str.length()-1) {
					if(c[i+1]=='j') {
						i=i+1;
					}
					
				}
				
			}
			else if(c[i]=='n') {
				if(i<str.length()-1) {
					if(c[i+1]=='j') {
						
						i=i+1;
					}
					
				}
				
			}
			else if(c[i]=='s') {
				if(i<str.length()-1) {
					if(c[i+1]=='=') {
						
						i=i+1;
					}
					
				}
				
			}
			else if(c[i]=='z') {
				if(i<str.length()-1) {
					if(c[i+1]=='=') {
					
						i=i+1;
					}
					
				}
			}
			cnt++;
		}
		System.out.println(cnt);
    }
}