/*
큐를 이용하여 푸는 문제이다.
*/
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] p, int location) {
        int answer = 0; //location에 해당하는 문서가 몇번째로 출력되는지 저장
        Queue<Integer> printer = new LinkedList<Integer>();
        
        //중요도 순서대로 저장한 배열
        int num[] = p.clone();
        Arrays.sort(num);
        
        //문서를 ABCD...이런식으로 저장한 배열
        Queue<Character> alp = new LinkedList<Character>();
        char a = (char)('A' + location);
        
        for(int i = 0; i<p.length; i++){
            printer.add(p[i]);
            alp.add((char)('A' + i));
        }
        
        int len = p.length;
        int max = num.length-1;
        while(true){
            if(printer.peek() >= num[max]){
                //우선순위가 가장 높은 문서일때 출력
                if(alp.peek() == a){ //location에 해당하는 문서를 출력할 때
                    printer.remove();
                    alp.remove();
                    max--;
                    answer++;
                    break;
                }
                printer.remove();
                alp.remove();
                max--;
                answer++;
            }
            
            else{//우선순위가 더 높은 다른 문서가 있을 때
                //문서를 꺼내가지고 큐 맨뒤에 다시 넣어준다
                printer.add(printer.peek());
                alp.add(alp.peek());
                printer.remove();
                alp.remove();
            }
        }
        return answer;
    }
}
