//[1220]统计元音字母序列的数目

//给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串： 
//
// 
// 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'） 
// 每个元音 'a' 后面都只能跟着 'e' 
// 每个元音 'e' 后面只能跟着 'a' 或者是 'i' 
// 每个元音 'i' 后面 不能 再跟着另一个 'i' 
// 每个元音 'o' 后面只能跟着 'i' 或者是 'u' 
// 每个元音 'u' 后面只能跟着 'a' 
// 
//
// 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：n = 1
//输出：5
//解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
// 
//
// 示例 2： 
//
// 输入：n = 2
//输出：10
//解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
// 
//
// 示例 3： 
//
// 输入：n = 5
//输出：68 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10^4 
// 
// Related Topics 动态规划 
// 👍 110 👎 0

package editor.cn;

public class CountVowelsPermutation {
    public static void main(String[] args) {
        Solution solution = new CountVowelsPermutation().new Solution();
        System.out.println(solution.countVowelPermutation(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countVowelPermutation(int n) {
            return matrix(n);
        }

        // 解法1： 动态规划
        public int dg(int n) {
            int MOD = 1000000007;
            /**
             * 映射关系
             * a -> 0
             * e -> 1
             * i -> 2
             * o -> 3
             * u -> 4
             */
            long[] odp = new long[5];
            long[] ndp = new long[5];
            for (int i = 0; i < 5; i++) {
                odp[i] = 1;
            }
            for (int i = 2; i <= n; i++) {
                ndp[0] = (odp[1] + odp[2] + odp[4]) % MOD;
                ndp[1] = (odp[0] + odp[2]) % MOD;
                ndp[2] = (odp[1] + odp[3]) % MOD;
                ndp[3] = (odp[2]) % MOD;
                ndp[4] = (odp[3] + odp[2]) % MOD;
                System.arraycopy(ndp,0,odp,0,5);
            }
            long ans = 0;
            for (int i = 0; i < 5; i++) {
                ans = (ans + odp[i]) % MOD;
            }
            return (int) ans;
        }

        /**
         * 解法2：矩阵快速幂
         */
        public int matrix(int n){
            long mod = 1_000_000_007;

            long[][] factor =
            {
                    {0, 1, 0, 0, 0},
                    {1, 0, 1, 0, 0},
                    {1, 1, 0, 1, 1},
                    {0, 0, 1, 0, 1},
                    {1, 0, 0, 0, 0}
            };
            // 快速幂
            long[][] res = fastPow(factor, n - 1, mod);
            long ans = 0;
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < 5; ++j) {
                    ans = (ans + res[i][j]) % mod;
                }
            }
            return (int)ans;

        }

        private long[][] fastPow(long[][] matrix, int n, long mod) {
            int m = matrix.length;
            long[][] res = new long[m][m];
            long[][] curr = matrix;
            for (int i = 0; i < m; i++) {
                res[i][i]=1;
            }
            for (int i=n;i!=0;i>>=1){
                if ((i%2)==1) {
                    res = multiply(curr,res,mod);
                }
                // 矩阵自乘
                curr = multiply(curr,curr,mod);
            }
            return res;
        }
        // 矩阵相乘
        private long[][] multiply(long[][] matrixA, long[][] matrixB, long mod) {
            int m = matrixA.length;
            int n = matrixB[0].length;
            long[][] res = new long[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res[i][j] = 0;
                    for (int k =0;k<matrixA[i].length; ++k){
                        res[i][j] = (res[i][j] + matrixA[i][k] * matrixB[k][j]) % mod;
                    }
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
