package com.newcoder.huawei;

import java.util.Scanner;

/**
 * @author ghower
 * @date 2022/3/25 9:19
 */
public class HJ1ZiFuChuanZuiHouYiGeDanCiDeChangDu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        int i=0,j=1;
        int res = 0;
        while(s.length() >= j){
            if(s.charAt(j-1) == ' ' )
                i = j;
            if(j == s.length()){
                res = j-i;
            }
            j++;
        }
        System.out.println(res);
    }
}
