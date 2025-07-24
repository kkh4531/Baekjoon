import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int testCase = sc.nextInt();
    	
    	int changes[] = new int[testCase];
    	
    	for(int i=0; i<testCase; i++) {
    		changes[i] = sc.nextInt();
    	}
    	int quarter, dime, nikel, penny;
    	
    	for(int i=0; i<changes.length; i++) {
        	quarter = 0;
        	dime = 0;
        	nikel = 0;
        	penny = 0;
        	
        	while(changes[i]>0) {
        		if(changes[i]>=25) {
        			quarter++;
        			changes[i]-=25;
        		}
        		else if(changes[i]>=10) {
        			dime++;
        			changes[i]-=10;
        		}
        		else if(changes[i]>=5) {
        			nikel++;
        			changes[i]-=5;
        		}
        		else {
        			penny++;
        			changes[i]-=1;
        		}
        	}
        	System.out.println(quarter+" "+dime+" "+nikel+" "+penny);
    	}
    }
}