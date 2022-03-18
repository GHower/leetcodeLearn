package TEST.other.meituan;

import java.util.Scanner;

/**
 * n = 3
 * m = 6
 * booms = [2,1,2,2,2,1]
 *          1 3 3 3 3 3    drop = 1
 * @author ghower
 * @date 2022/3/12 16:09
 */
public class MeiTuan4 {
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 房间数
        int m = in.nextInt(); // 秒数
        int[] booms = new int[m + 1];

        int i = 1;
        while (i <= m && in.hasNext()) {
            int a = in.nextInt();
            booms[i++] = a;
        }

        int curRoom = 1;
        drop(n, m, booms, curRoom, 2, 0);

        System.out.println(res);
    }

    public static void drop(int n, int m,int[] booms, int curRoom, int i, int count) {
        if(i>m){
            res = Math.min(res, count);
            return;
        }

        int boom = booms[i];
        if (boom == curRoom) {
            // 分支，选房间
            for (int j = 1; j <= n; j++) {
                if (j != boom) {
                    drop(n, m,booms, j, i + 1, count + 1);
                }
            }
        } else {
            drop(n, m,booms, curRoom, i + 1, count);
        }
    }
}
