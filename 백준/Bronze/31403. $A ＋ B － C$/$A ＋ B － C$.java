import java.util.*;
public class Main {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String n1 = sc.next();
        String n2 = sc.next();
        String n3 = sc.next();

        System.out.println(Integer.parseInt(n1)+Integer.parseInt(n2)-Integer.parseInt(n3));

        String temp = n1+n2;
        int a = Integer.parseInt(temp);

        System.out.println(a-Integer.parseInt(n3));
    }
} 
