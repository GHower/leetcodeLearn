package TEST.other.meituan;

import java.util.Scanner;

/**
 * @author ghower
 * @date 2022/3/12 15:55
 */
public class MeiTuan1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (in.hasNext()) {
            int num = in.nextInt();
            int oneCount = 0;
            // 条件1
            if (num % 11 == 0) {
                System.out.println("yes");
                continue;
            }
            // 条件2
            while (num > 0) {
                if (num % 10 == 1) {
                    ++oneCount;
                }
                num /= 10;
            }
            System.out.println(oneCount >= 2 ? "yes" : "no");
        }
    }
}
