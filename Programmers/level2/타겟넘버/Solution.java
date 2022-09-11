/**
 * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
 * 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성.
 */

class Solution {
    static int count = 0; //방법의 수

    public int solution(int[] numbers, int target) {
        dfs(0, target, numbers, 0);
        return count;
    }

    private void dfs(int depth, int target, int[] numbers, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }

        dfs(depth + 1, target, numbers, sum + numbers[depth]);
        dfs(depth + 1, target, numbers, sum - numbers[depth]);
    }
}