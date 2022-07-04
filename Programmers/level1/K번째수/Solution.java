class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int tmp [] = new int [100];
         int[] answer = new int [commands.length];
        for(int i = 0; i<commands.length; i++){
            int tmpIdx = 0;
            int start = commands[i][0]; 
            int finish = commands[i][1];
            for(int j = start; j <= finish ; j++){
                tmp[tmpIdx] = array[j-1];
                tmpIdx++;
            }
            sort(tmp, finish-start+1);
            int k = commands[i][2];
            answer[i] = tmp[k-1];
        }   
        return answer;
    }
    
    public void sort(int tmp[],int n){
        for(int i = 0; i<n-1;i++){
            int min = i;
            for(int j = i+1; j < n; j++)
                if(tmp[j] < tmp[min])
                    min = j;
            swap(tmp,i,min);
        }
    }
    public void swap(int tmp[], int a, int b){
        int k = tmp[a];
        tmp[a] = tmp[b];
        tmp[b] = k;
    }
}
