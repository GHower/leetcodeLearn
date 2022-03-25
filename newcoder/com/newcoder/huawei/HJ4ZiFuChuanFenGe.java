package com.newcoder.huawei;

import java.util.Scanner;

/**
 * @author ghower
 * @date 2022/3/25 9:54
 */
public class HJ4ZiFuChuanFenGe {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        while (in.hasNext()) {
            String s = in.nextLine();
            int length = s.length();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s);
            if(length % 8 != 0 ){
                stringBuilder.append("0");
                length++;
            }
            s = stringBuilder.toString();
            while (s.length() > 0){
                System.out.println(s.substring(0,8));
                s = s.substring(8);
            }
        }
    }
}
