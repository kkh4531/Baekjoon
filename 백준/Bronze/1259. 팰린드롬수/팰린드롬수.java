import java.util.Scanner;
// 어떤 단어를 뒤에서부터 읽어도 똑같다면 그 단어를 팰린드롬이라고 한다. 'radar', 'sees'는 팰린드롬이다.

// 수도 팰린드롬으로 취급할 수 있다. 수의 숫자들을 뒤에서부터 읽어도 같다면 그 수는 팰린드롬수다. 
// 121, 12421 등은 팰린드롬수다. 123, 1231은 뒤에서부터 읽으면 다르므로 팰린드롬수가 아니다. 
// 또한 10도 팰린드롬수가 아닌데, 앞에 무의미한 0이 올 수 있다면 010이 되어 팰린드롬수로 취급할 수도 있지만, 
// 특별히 이번 문제에서는 무의미한 0이 앞에 올 수 없다고 하자.
// 121
// 1231
// 12421
// 0
public class Main {
    public static boolean isEqual(String stringNo, String tempString){
        for(int i=0; i<stringNo.length(); i++){
            if(stringNo.charAt(i) == tempString.charAt(i)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            
            int n = sc.nextInt();
            if(n == 0){
                break;
            }
            String stringNo = Integer.toString(n);
            if(stringNo.charAt(0) == '0'){
                System.out.println("0이 맨 앞에 올 수 없습니다.");
                continue;
            }
            String tempString = "";

            for(int i=stringNo.length()-1; i>=0; i--){
                tempString += stringNo.charAt(i);
            }
            if(isEqual(stringNo, tempString)){
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }    
    }
}
