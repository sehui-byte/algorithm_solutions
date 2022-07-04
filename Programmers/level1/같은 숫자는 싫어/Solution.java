import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> answer2 = new ArrayList<Integer>();
        
        int size = 0;
        
        int tmp = arr[0];
        answer2.add(tmp);
        for(int i = 1; i<arr.length;i++){
            if(tmp != arr[i]){
                tmp = arr[i];
                answer2.add(tmp);
            }    
        }
        
        int answer[] = new int[answer2.size()];
        for(int temp: answer2)
            answer[size++] = temp;
        
        return answer;
    }
}
