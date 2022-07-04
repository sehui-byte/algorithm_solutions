import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ1874 {
	static int arr[]; //만들 수열 (입력받는 수열)
	static Stack<Integer> s = new Stack<Integer>(); //값들을 넣었다가 빼는 스택
	static Stack<String> result = new Stack<String>(); //+,-출력하는 결과 스택
	static int max; //스택에 push한 정수 중 가장 큰 정수

	static boolean isPossible(int n) {
		int index = 0; //완성하려는 수열 index, index=0이면 arr[0]과 같이 만드려는 것
		//일단 스택에 1을 넣는다 (초기화)
		s.push(1);
		result.push("+");
		max = 1;
		
		while(true) {
			if(index == n)
				break;
	
			if(max > arr[index] && s.peek() != arr[index] && !s.isEmpty()) {
				result.clear();
				System.out.println("NO");
				return false;
			}

			if(arr[index] > max) {
				for(int i = max+1; i<= arr[index]; i++) {
					s.push(i);
					result.push("+");
					max = i;
				}
			}
			if(arr[index] == s.peek() && !s.isEmpty()) {
				s.pop();
				result.push("-");
				index++; //목표값을 다음 arr[index]로 설정
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		arr = new int[n];

		for(int i = 0; i<n; i++) 
			arr[i] = Integer.parseInt(br.readLine());

		isPossible(n);

		//결과 출력
		Iterator<String> it = result.iterator();
		if(!result.isEmpty()) {
			while(it.hasNext()) {
				bw.write(it.next() + "\n"); 
			}	
		}
		bw.close();
	}
}
