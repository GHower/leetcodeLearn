package TEST.other.aftership;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ghower
 * @date 2022/3/8 15:58
 */
public class AfterShipDemo {
    // 一个数字字符串
    // 位数和 作为权重，找出权重差最小的两个数，组成[权重，下标，数值]的二维数组
    public static void main(String[] args) {
        String str = "4440 6645 65879 13548 65746 165789 156486";
        String[] nums = str.split(" ");
        int[][] all = new int[nums.length][3];
        for (int i = 0; i < nums.length; i++) {
            String numS = nums[i];
            int numD = Integer.parseInt(numS);
            int weight = 0;
            while (numD > 0) {
                weight += numD % 10;
                numD /= 10;
            }

            all[i] = new int[]{weight, i, Integer.parseInt(numS)};
        }
//        List<int[]> list = Arrays.stream(all).sorted(Comparator.comparingInt(e -> e[0])).collect(Collectors.toList());
//        for (int[] ints : list) {
//            System.out.println(Arrays.toString(ints));
//        }
//        int[][] res =  new int[][]{list.get(0),list.get(1)};
        System.out.println(Arrays.deepToString(all));
    }
}
