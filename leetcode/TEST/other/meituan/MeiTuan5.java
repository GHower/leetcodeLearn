package TEST.other.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 *
 * 6
 * 1 0 1 1 0 0
 * 0 1 2 1 4 4
 *
 * @author ghower
 * @date 2022/3/12 16:09
 */
public class MeiTuan5 {
    static int resW = 0; // 白
    static int resB = 0; //黑

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 房间数
        // false: 白色，true:黑色
        boolean[] colors = new boolean[n];
        int[] parents = new int[n];

        int i = 0;
        while (i < n && in.hasNext()) {
            int a = in.nextInt();
            colors[i++] = a == 1;
        }
        i=0;
        while (i < n && in.hasNext()) {
            parents[i++] = in.nextInt();
        }
        List<Integer>[] children = new List[n];
        for (int j = 0; j < n; j++) {
            children[j] = new ArrayList<>();
        }

        for (int j = 0; j < n; j++) {
            int p = parents[j];
            if(p!=0){
                children[p-1].add(j);
            }
        }
        for (int j = 0; j < n; j++) {
            List<Integer> childs = children[j];
            boolean color = colors[j];
            if(color){
                // 黑色
                if(childs.size() == 0){
                    resB++;
                }else{
                    boolean flag = true;
                    for (Integer child : childs) {
                        // 要求均为白
                        if(colors[child]){
                           flag = false;
                        }
                    }
                    if(flag){
                        resB++;
                    }
                }
            }else{
                // 白色
                if(childs.size() == 0){
                    resW++;
                }else{
                    for (Integer child : childs) {
                        // 有黑色
                        if(colors[child]){
                            resW++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(resW + " " + resB);
    }

}
