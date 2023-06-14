// We stack glasses in a pyramid, where the first row has 1 glass, the second
// row has 2 glasses, and so on until the 100ᵗʰ row. Each glass holds one cup of
// champagne.
//
// Then, some champagne is poured into the first glass at the top. When the 
// topmost glass is full, any excess liquid poured will fall equally to the glass
// immediately to the left and right of it. When those glasses become full, any excess
// champagne will fall equally to the left and right of those glasses, and so on. (
// A glass at the bottom row has its excess champagne fall on the floor.)
//
// For example, after one cup of champagne is poured, the top most glass is 
// full. After two cups of champagne are poured, the two glasses on the second row are
// half full. After three cups of champagne are poured, those two cups become full
//- there are 3 full glasses total now. After four cups of champagne are poured, 
// the third row has the middle glass half full, and the two outside glasses are a
// quarter full, as pictured below.
//
// 
//
// Now after pouring some non-negative integer cups of champagne, return how 
// full the jᵗʰ glass in the iᵗʰ row is (both i and j are 0-indexed.)
//
// 
// Example 1: 
//
// 
// Input: poured = 1, query_row = 1, query_glass = 1
// Output: 0.00000
// Explanation: We poured 1 cup of champange to the top glass of the tower (
// which is indexed as (0, 0)). There will be no excess liquid so all the glasses under
// the top glass will remain empty.
// 
//
// Example 2: 
//
// 
// Input: poured = 2, query_row = 1, query_glass = 1
// Output: 0.50000
// Explanation: We poured 2 cups of champange to the top glass of the tower (
// which is indexed as (0, 0)). There is one cup of excess liquid. The glass indexed
// as (1, 0) and the glass indexed as (1, 1) will share the excess liquid equally,
// and each will get half cup of champange.
// 
//
// Example 3: 
//
// 
// Input: poured = 100000009, query_row = 33, query_glass = 17
// Output: 1.00000
// 
//
// 
// Constraints: 
//
// 
// 0 <= poured <= 10⁹ 
// 0 <= query_glass <= query_row < 100 
// 
//
// Related Topics 动态规划 👍 259 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;799
 * <p>
 * Name：Champagne Tower
 *
 * @author Yuri
 * @since 2023-06-14 18:49:18
 */


public class ChampagneTower {
    public static void main(String[] args) {
        Solution solution = new ChampagneTower().new Solution();
        solution.champagneTower(25, 6, 1);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // dp[i][j]表示i层j个杯子往下流的数量，i,j都是从1开始
        public double champagneTower(int poured, int query_row, int query_glass) {
            if (query_row == 0) return Math.min(poured, 1);
            double[][] dp = new double[query_row + 1][query_row + 2];
            dp[1][1] = poured > 1 ? poured - 1 : 0;
            for (int i = 2; i <= query_row; i++) {
                for (int j = 1; j <= i; j++) {
                    double v = (dp[i - 1][j - 1] + dp[i - 1][j]) / 2;
                    dp[i][j] = v > 1 ? v - 1 : 0;
                }
            }
            double res = dp[query_row][query_glass] / 2 + dp[query_row][query_glass + 1] / 2;
            return res > 1 ? 1 : res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
