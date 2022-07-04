import java.util.*;

public class BOJ2630 {
    static int white = 0;
    static int blue = 0;
    static int arr[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        quad(n, 0, 0);

        System.out.println(white);
        System.out.println(blue);
    }

    static void quad(int n, int row, int column) {

        // 1. 전체가 같은 색이면 컬러 체크
        if (n == 1 || isAllColorSame(n, row, column)) {
            checkColor(arr[row][column]);
            return;
        }

        // 2. 같은 색이 아니라면 1/4로 쪼갠다
        int divide = n / 2;

        quad(divide, row, column);
        quad(divide, row + divide, column);
        quad(divide, row, column + divide);
        quad(divide, row + divide, column + divide);
    }


    //전체가 같은 색인지 체크
    static boolean isAllColorSame(int n, int row, int column) {
        int color = arr[row][column];

        for (int i = row; i < n + row; i++) {
            for (int j = column; j < n + column; j++) {
                if (color != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void checkColor(int color) {
        if (color == 0) {
            white++;
        } else {
            blue++;
        }
    }
}
