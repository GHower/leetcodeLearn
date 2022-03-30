package com.newcoder.course;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ghower
 * @date 2022/3/30 23:15
 */
public class XuanZhuanCi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        String ns = in.nextLine();
        String ms = in.nextLine();
        if (n != m) {
            System.out.println("NO");
        } else {
            System.out.println(isRotation(ns, ms) ? "YES" : "NO");
        }
    }
    private static boolean isRotation(String ns, String ms) {
        String ms2 = ms + ms;
        return getIndexOf(ns, ms2) != -1;
    }
    // KMP算法获取Index
    private static int getIndexOf(String ns, String ms2) {
        char[] ms2List = ms2.toCharArray();
        char[] nsList = ns.toCharArray();
        int[] next = getNextArray(nsList);
        System.out.println(Arrays.toString(next));
        // kmp匹配
        for (int i = 0, j = 0; i < ms2List.length; i++) {
            while (j > 0 && ms2List[i] != nsList[j]) {
                j = next[j - 1];
            }
            if (ms2List[i] == nsList[j]) {
                j++;
            }
            if (j == nsList.length) {
                return i - nsList.length + 1;
            }
        }
        return -1;
    }
    // 计算next数组
    private static int[] getNextArray(char[] msList) {
        if (msList.length == 1) return new int[]{-1};
        int[] next = new int[msList.length];
        for (int i = 1, j = 0; i < next.length; i++) {
            // 向前找到相等的，不然就是0
            while (j > 0 && msList[i] != msList[j]) {
                j = next[j - 1];
            }
            if (msList[i] == msList[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
