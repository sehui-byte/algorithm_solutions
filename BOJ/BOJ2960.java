import java.util.*;

public class BOJ2960 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		boolean arr[] = new boolean[n+1];
		int count = 0;

		for(int i = 2; i<= n; i++) {
			if(!arr[i]) {
				int p = i;
				for(int j = p; j<= n; j++) {
					if(!arr[j] && j%p == 0) {
						arr[j] = true;
						count++;
						if(count == k) {
							System.out.println(j); 
							return;
						}
					}
				}
			}
		}
	}
}
