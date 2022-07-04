class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 2; i<=n ; i++){
          if(isPrime(i))
              answer++;   
        }
        return answer;
    }
    
    public boolean isPrime(int n){
        boolean isPrime = true;
        int m = (int)Math.sqrt(n);
        for(int j = 2; j<= m; j++){
            if(n%j == 0){
                isPrime = false;
                break; 
            }
         }
        return isPrime;
    }
}
