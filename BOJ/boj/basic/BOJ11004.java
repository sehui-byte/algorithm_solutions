package boj.basic;

import java.util.Scanner;

/**
 * @문제명 K번째 수
 * @분류 정렬, 퀵소트
 * @풀이 퀵소트
 *      N의 최대가 5,000,000이고 시간제한은 2초
 *      퀵소트의 시간복잡도는 O(NlogN)
 */
public class BOJ11004 {
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.nextLine();

        quickSort(0, arr.length - 1);
        System.out.println(arr[k - 1]);
    }

    private static void quickSort(int start, int end) {
        //정렬된 오른쪽 영역의 인덱스 리턴
        int right = partition(start, end);
        // 왼쪽영역에 값이 1개보다 많을때 왼쪽영역 정렬
        if (start < right - 1) {
            quickSort(start, right - 1);
        }

        //오른쪽영역에 값이 1개 이상일때 오른쪽 영역 정렬
        if (right < end) {
            quickSort(right, end);
        }

    }

    private static int partition(int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end) {
            // pivot값보다 작으면 계속 이동
            while (arr[start] < pivot) start++;
            //pivot값보다 크면 계속 이동
            while (arr[end] > pivot) end--;
            // start가 pivot보다 크고 end가 pivot보다 작은 경우 (반복문 빠져나오면)
            if (start <= end) {
                swap(start, end);
                start++;
                end--;
            }
        }
        // 오른쪽 영역의 시작점
        return start;
    }

    private static void swap(int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
