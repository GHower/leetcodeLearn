package TEST.other.futu;

/**
 * @author ghower
 * @date 2022/3/10 20:35
 */
public class FuTuDemo {
    public static void main(String[] args) {
//        neizhan(2, 0);
        yuefen1(10,3);
    }

    private static void neizhan(int a, int b) {
        int x = (a * (a - 1)) / 2;
        int y = ((a + b) * (a + b - 1)) / 2;
        int t = 1;
        int smaller = Math.min(x, y);
        for (int i = 1; i <= smaller; i++) {
            if (x % i == 0 && y % i == 0) {
                t = i;
            }
        }
        System.out.println("x=" + x / t + ",y=" + (x==0 ? 1: y / t));
    }
    private static int yuefen1(int a,int b){
        int x = a,y = b;
        int t;
        while(y != 0){
            t = x % y;
            x = y;
            y = t;
        }
        System.out.println(a/x+" "+ b/x);
        return a;
    }

}
