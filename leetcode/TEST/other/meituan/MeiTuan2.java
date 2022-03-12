package TEST.other.meituan;

import java.util.Scanner;

/**
 * @author ghower
 * @date 2022/3/12 16:09
 */
public class MeiTuan2 {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] nums = new int[n];
            int i = 0;
            int res = 0;
            boolean[][] df = new boolean[n][n];

            while (i<n && in.hasNext()) {
                nums[i] = in.nextInt();
                df[i][i] = nums[i] == 1;
                if(df[i][i]){
                    res++;
                }
                i++;
            }
            // 1 1 -1 -1
            for (int x = 0; x < n; x++) {
                for (int y = x+1; y < n; y++) {
                    if(nums[y] == -1){
                        df[x][y] = !df[x][y-1];
                    }else{
                        df[x][y] = df[x][y-1];
                    }
                    if(df[x][y]){
                        res++;
                    }
                }
            }
            System.out.println(res);
        }
}
