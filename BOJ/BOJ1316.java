import java.util.Scanner;
public class BOJ1316
{
	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), chk = n;
       
        while(n-->0){
            String word = sc.next();
            boolean alp[] = new boolean[26]; // 알파벳 배열 a-z (97-122)
            for(int i = 1; i<word.length(); i++){
                if(word.charAt(i) != word.charAt(i-1)){
                    if(alp[word.charAt(i)-97] == true) {
                    chk--;
                    break;
                    }
                 alp[word.charAt(i-1)-97] = true;
                }
            }
        }  
        System.out.println(chk);
	}
}
