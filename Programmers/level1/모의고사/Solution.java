import java.util.ArrayList;
class Solution {
     ArrayList<Integer> answer1 = new ArrayList<>();
    
        public int max(int oc, int tc, int thc){ //맞춘 개수 최댓값 반환
            int m = oc;
            if(m <= tc)
                m = tc;
            if(m <= thc)
                m = thc;
            
            return m;
        }
    
    public int[] solution(int[] answers) {
        int one[] = {1,2,3,4,5};
        int two[] = {2,1,2,3,2,4,2,5};
        int three[] = {3,3,1,1,2,2,4,4,5,5};
        
        int oc = 0 ;int tc = 0; int thc = 0; //수포자 맞춘 개수
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == one[i%5]) oc++;
            if(answers[i] == two[i%8]) tc++;
            if(answers[i] == three[i%10]) thc++;
        }
        
            int [] m = {oc, tc, thc}; //수포자들이 문제 맞춘 개수 저장하는 배열
            int max = max(oc,tc,thc);
            for(int j = 0; j<3; j++){
                if(m[j] == max)
                    answer1.add(j+1);  
            }
        //List->Array 변환//
        int answer[] = new int[answer1.size()];
        int size = 0;
        for(int temp: answer1)
            answer[size++] = temp;
        
        return answer;
    }
}
