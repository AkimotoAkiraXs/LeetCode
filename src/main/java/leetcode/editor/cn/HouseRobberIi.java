//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 1084 👎 0


package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;213
 * <p>
 * Name：打家劫舍 II
 *
 * @author Yuri
 * @since 2022-07-06 15:51:32
 */
public class HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
        System.out.println();
    }

    /**
     * 当构成环后，如果偷窃了第一间房屋，则不能偷窃最后一间房屋，因此偷窃房屋的范围是第一间房屋到最后第二间房屋；
     * 如果偷窃了最后一间房屋，则不能偷窃第一间房屋，因此偷窃房屋的范围是第二间房屋到最后一间房屋
     * ∴对[0,n−2]和[1,n−1]进行两次动态规划计算取最大值即可
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) return nums[0];
            if (nums.length == 2) return Math.max(nums[0], nums[1]);
            int[] max1 = new int[nums.length];
            int[] max2 = new int[nums.length];
            max1[0] = nums[0];
            max1[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length - 1; i++) {
                max1[i] = Math.max(max1[i - 2] + nums[i], max1[i - 1]);
            }

            max2[1] = nums[1];
            max2[2] = Math.max(nums[1], nums[2]);
            for (int i = 3; i < nums.length; i++) {
                max2[i] = Math.max(max2[i - 2] + nums[i], max2[i - 1]);
            }
            return Math.max(max1[nums.length - 2], max2[nums.length - 1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}