package com.newcoder.huawei;

import java.util.Scanner;

/**
 * @author ghower
 * @date 2022/3/25 9:47
 */
public class HJ3MinMinDeSuiJiShu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[] visit = new boolean[1001];
        while(n-- > 0){
            int i = in.nextInt();
            visit[i] = true;
        }
        for (int i=0;i< visit.length;i++) {
            if (visit[i]) System.out.println(i);
        }


    }
}
