/*
조합(combination)에 대한 수학 지식을 알아야 풀 수 있는 문제이다.
처음에 그냥 조합 알고리즘을 이용해서 풀자 케이스1은 시간초과로 에러가 났었다.
*/

import java.util.HashMap;

class Solution {
    int answer = 1;
    public int solution(String[][] clothes) {
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        for(int i = 0; i<clothes.length; i++){
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1],0)+1);
        }
    
        for(String i : hm.keySet()){
            answer *= (hm.get(i) + 1);
        }
        
        answer-=1;
       
        return answer;
    }
}
