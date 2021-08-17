//大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。 
//
// 你可以搭配 任意 两道餐品做一顿大餐。 
//
// 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大
//餐 的数量。结果需要对 109 + 7 取余。 
//
// 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。 
//
// 
//
// 示例 1： 
//
// 
//输入：deliciousness = [1,3,5,7,9]
//输出：4
//解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
//它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
// 
//
// 示例 2： 
//
// 
//输入：deliciousness = [1,1,1,3,3,3,7]
//输出：15
//解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。 
//
// 
//
// 提示： 
//
// 
// 1 <= deliciousness.length <= 105 
// 0 <= deliciousness[i] <= 220 
// 
// Related Topics 数组 哈希表 
// 👍 91 👎 0


/*
 * Id：1711
 * Name：大餐计数
 * Date：2021-07-07 17:26:37
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class CountGoodMeals {
    public static void main(String[] args) {
        Solution solution = new CountGoodMeals().new Solution();
        int k = (int) 1e9 + 7;
        long x = (9999900000L >> 1) % k;
        System.out.println(x);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPairs(int[] deliciousness) {
            long k = (long) (1e9 + 7);
            int size = Arrays.stream(deliciousness).max().getAsInt();
            int[] sums = new int[size * 2];
            for (int value : deliciousness) {
                sums[value] += 1;
            }

            int[] res = Arrays.stream(deliciousness).distinct().toArray();
            long ans = 0;
            for (int i = 0; i < res.length; i++) {
                long n = sums[res[i]];
                long r = res[i];
                if (((r * 2) & ((r * 2) - 1)) == 0 && r != 0 && n > 1) {
                    ans += n * (n - 1) / 2;
                    ans %= k;
                }
                for (int j = i + 1; j < res.length; j++) {
                    long num = res[i] + res[j];
                    if ((num & (num - 1)) == 0) {
                        ans += sums[res[i]] * sums[res[j]];
                        ans %= k;
                    }
                }
            }
            return (int) (ans % k);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
} 