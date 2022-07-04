/*
완전탐색 문제.
순열알고리즘을 이용하여 풀 수 있다.

맨 앞에 "0"이 올때나 결과가 중복일 경우를 고려해야한다.
*/

import java.util.*;

class Solution {
    
    static int answer = 0;
    static Set<Integer>set = new HashSet<Integer>();
    
    public int solution(String numbers) {
        String num[] = numbers.split("");
        //numbers문자열을 쪼개서 String배열로 만든다
        
        for(int i = 1; i<= num.length; i++){
            perm(num, 0, num.length, i);
        }
        
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            if(isPrime(it.next())){
                answer++;
            }
        }
        
        return answer;
    }
    
     public static void perm(String[]arr, int depth, int n, int r){
            if(depth == r){
                //뽑은 수들을 합쳐서 해당 수가
                //소수인지 판별하여 소수일 경우 answer++
                int result = makeNum(arr,r);
                set.add(result);

            }
         
         else{
             for(int i = depth; i<n; i++){
                 swap(arr, i, depth);
                 perm(arr, depth+1, n, r);
                 swap(arr, i, depth);
             }
         }
        }
    
    public static void swap(String []arr, int i, int depth){
        String tmp = arr[i];
        arr[i] = arr[depth];
        arr[depth] = tmp;
    }
    
    public static boolean isPrime(int n){
        if(n < 2)
            return false;
        
        for(int i = 2; i<= (int)Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        } 
        return true;
    }
    
    public static int makeNum(String arr[], int r){
        String tmp = "";
        for(int i = 0; i<r; i++){
            if(i == 0 && arr[i] == "0")
                return 0;
            tmp += arr[i];
        } 
        int num = Integer.parseInt(tmp);
        return num;
    }
}
