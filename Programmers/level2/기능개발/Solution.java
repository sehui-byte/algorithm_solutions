/*
스택을 이용하여 문제를 풀었다.
어렵진 않았는데 자꾸 peek() 시에 empty() 확인해주는 것을 깜박해서 Exception이 발생했었다.
*/

import java.util.Stack;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] p, int[] s) {
        int[] count = new int[p.length];//작업일수 저장할 배열
        Stack<Integer> stack = new Stack<Integer>();
        
        //스택에 progresses 넣기
        for(int i = p.length-1; i>=0; i--){
            stack.push(p[i]);
        }
        
        //작업일수 구하기
        for(int i = 0; i< p.length; i++){
            while(p[i] < 100){
                p[i] += s[i];
                count[i]++;
            }
            stack.pop();
        }
        
        //작업일수 스택에 넣기
        Stack<Integer> stk = new Stack<Integer>();
        for(int i = count.length-1; i>=0; i--){
            stk.push(count[i]);
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        //작업일수를 이용하여 각 배포시 몇개의 기능이 배포되는지 구하기
        while(!stk.empty()){
            int c = 0;//각 배포시 배포되는 기능의 개수 저장
            int top = stk.pop();
            c++;
            if(!stk.empty()){
                int peek = stk.peek();
                
                while(top >= peek){
                    stk.pop();
                    c++;
                    if(!stk.empty()){
                        peek = stk.peek();
                    }
                    else{
                        break;
                    }
                }
            }
            ans.add(c);  
        }
        
        int answer[] = new int[ans.size()];
        int idx = 0;
        for(int tmp : ans){
            answer[idx] = tmp;
            idx++;
        }
        return answer;
    }
}
