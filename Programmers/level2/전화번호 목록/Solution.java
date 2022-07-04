/*
indexOf()를 이용해서 풀었다.
*/

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for(int i = 0; i<phone_book.length; i++){
            for(int j = 0; j<phone_book.length; j++){
                if(i == j)
                    continue;
                if(phone_book[i].indexOf(phone_book[j])==0)
                    return false;
            }
        }
        return true;
    }
}
