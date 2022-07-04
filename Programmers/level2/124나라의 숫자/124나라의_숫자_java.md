



아래는 내가 처음에 생각한 풀이이다.

이렇게 하면 시간초과가 발생한다.

```java
import java.util.*;

class Solution {
    public String solution(int n) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("4");
        
        for(int i = 4; i<= n; i++){
            int r = i%3;
            switch(r) {
                case 0: 
                    r = 4; break;
                case 1:
                    r = 1; break;
                case 2: 
                    r = 2; break;
            }
            int q = i/3; 
            if(i%3 == 0) {
                q-=1;
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(q-1));
            sb.append(Integer.toString(r));
            list.add(sb.toString());
        }
        
        return list.get(n-1);
    }
}
```



아래는 시간초과를 통과한 코드이다.

```
import java.util.*;

class Solution {
    public String solution(int n) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("4");

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int r = n % 3;
            if (r == 0) {
                n -= 1;
            }
            n = n / 3;

            switch (r) {
                case 0:
                    r = 4;
                    break;
                case 1:
                    r = 1;
                    break;
                case 2:
                    r = 2;
                    break;
            }
            sb.insert(0, r);
        }

        return sb.toString();
    }
}
```



