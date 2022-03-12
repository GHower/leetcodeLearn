package TEST.other.meituan;

import java.util.Scanner;

/**
 * @author ghower
 * @date 2022/3/12 16:09
 */
public class MeiTuan3 {
    static int res = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        boolean[] visited = new boolean[m+1];
        int[][] array = new int[n][2];

        int i=0;
        while (i<n && in.hasNext()){
            int a = in.nextInt();
            int b = in.nextInt();
            int[] ints = {a, b};
            array[i++] = ints;
        }
        // 回溯
        for (int first = 0; first < n; first++) {
            hs(array,visited,first,1);
        }
        System.out.println(res);
    }
    public static void hs(int[][] array,boolean[] visited,int i,int count){

        int[] num = array[i];
        int a = num[0],b = num[1];
        // 被前面的吃了
        if(visited[a] || visited[b]){return;}
        visited[b] = true;
        visited[a] = true;
        res = Math.max(res,count);
        for (int j = i+1; j < array.length; j++) {
            hs(array,visited,j,count+1);
        }
        visited[b] = false;
        visited[a] = false;

    }
}
