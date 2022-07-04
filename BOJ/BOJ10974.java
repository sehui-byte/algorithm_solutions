/*
순열 알고리즘을 안다면 쉽게 풀 수 있는 문제입니다.
다만 문제에서 "사전순으로" 출력하라고 하여 한번 정렬을 해줘야 했습니다.
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class BOJ10974
{
    public static ArrayList<String> sArr = new ArrayList<String>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
	    int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = i+1;
        }
	    int depth = 0;
	    int r = n; //뽑을 수의 개수
	    perm(arr, depth, n, r);
	    Collections.sort(sArr);
	    Iterator it = sArr.iterator();
	    
	   while(it.hasNext()){
	       System.out.println(it.next());
	   }
	}
	
	//nPr
	public static void perm(int[]arr, int depth, int n, int r){
	    if(depth == r){//모두 다 뽑으면
	        print(arr,r);//출력
	        return;
	    }
	    
	    else{
	        for(int i = depth; i<n; i++){
    	        swap(arr, i, depth);
    	        perm(arr, depth+1, n, r);
    	        swap(arr, i, depth);
	        }
	    }
	}
	
	public static void print(int[]arr, int r){
	    
	    String s = "";
	    for(int i = 0; i<r; i++){
	        s +=  arr[i] + " ";
	    }
	    sArr.add(s);
	}
	
	public static void swap(int []arr, int i, int depth){
	    int tmp = arr[i];
	    arr[i] = arr[depth];
	    arr[depth] = tmp;
	}
	
}
