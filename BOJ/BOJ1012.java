import java.util.*;

 class CabbageField {
    int count; //배추 개수
    int cabbageMap[][]; //배추 위치 좌표
    boolean visited[][]; 
    int width;
    int height;
    int result;
    
    private int dx[] = {1,-1,0,0};
    private int dy[] = {0,0,1,-1};
   
    
    public CabbageField(int w, int h, int c) {
        this.width = w;
        this.height = h;
        this.count = c;
        this.cabbageMap = new int[w][h];
        this.visited = new boolean[w][h];
    }   
 
    
    public void dfs(int x, int y) {
        this.visited[x][y] = true;
        checkAdjacent(x,y);
    }
    
    private void checkAdjacent(int x, int y) {
        //상하좌우 4군데 체크
        for(int i = 0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= width || nx < 0 || ny >= height || ny < 0) {
                continue;
            }
            
            //재귀
            if(visited[nx][ny] == false && cabbageMap[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
        
    }
}




public class BOJ1012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int total = sc.nextInt(); // case 개수
        CabbageField[] cabbageFields = new CabbageField[total];
        for(int i = 0; i<total; i++) {
            cabbageFields[i] = new CabbageField(sc.nextInt(), sc.nextInt(), sc.nextInt());
            
            //배추 좌표 입력
            for(int j = 0; j<cabbageFields[i].count; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                cabbageFields[i].cabbageMap[x][y] = 1;
            }
            
            for(int w = 0; w<cabbageFields[i].width; w++) {
                for(int h = 0; h<cabbageFields[i].height; h++) {
                    if(cabbageFields[i].cabbageMap[w][h] == 1 
                        && cabbageFields[i].visited[w][h] == false) {
                            cabbageFields[i].dfs(w,h);
                            cabbageFields[i].result++;
                        }
                }
            }
            
           
            System.out.println(cabbageFields[i].result);
            
        }
       
    }
}
