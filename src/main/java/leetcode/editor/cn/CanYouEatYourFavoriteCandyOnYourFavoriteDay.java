//给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount[i] 表示你拥有的第 i 类糖果的数目。同时给你一个二维数
//组 queries ，其中 queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。 
//
// 你按照如下规则进行一场游戏： 
//
// 
// 你从第 0 天开始吃糖果。 
// 你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。 
// 在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。 
// 
//
// 请你构建一个布尔型数组 answer ，用以给出 queries 中每一项的对应答案。此数组满足： 
//
// 
// answer.length == queries.length 。answer[i] 是 queries[i] 的答案。 
// answer[i] 为 true 的条件是：在每天吃 不超过 dailyCapi 颗糖果的前提下，你可以在第 favoriteDayi 天吃到第 favo
//riteTypei 类糖果；否则 answer[i] 为 false 。 
// 
//
// 注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。 
//
// 请你返回得到的数组 answer 。 
//
// 
//
// 示例 1： 
//
// 
//输入：candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
//输出：[true,false,true]
//提示：
//1- 在第 0 天吃 2 颗糖果(类型 0），第 1 天吃 2 颗糖果（类型 0），第 2 天你可以吃到类型 0 的糖果。
//2- 每天你最多吃 4 颗糖果。即使第 0 天吃 4 颗糖果（类型 0），第 1 天吃 4 颗糖果（类型 0 和类型 1），你也没办法在第 2 天吃到类型 
//4 的糖果。换言之，你没法在每天吃 4 颗糖果的限制下在第 2 天吃到第 4 类糖果。
//3- 如果你每天吃 1 颗糖果，你可以在第 13 天吃到类型 2 的糖果。
// 
//
// 示例 2： 
//
// 
//输入：candiesCount = [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,3
//0],[1,3,1]]
//输出：[false,true,true,false,false]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candiesCount.length <= 105 
// 1 <= candiesCount[i] <= 105 
// 1 <= queries.length <= 105 
// queries[i].length == 3 
// 0 <= favoriteTypei < candiesCount.length 
// 0 <= favoriteDayi <= 109 
// 1 <= dailyCapi <= 109 
// 
// Related Topics 数学 
// 👍 126 👎 0


/*
 * Id：1744
 * Name：你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 * Date：2021-06-22 15:35:41
 */
package leetcode.editor.cn;

public class CanYouEatYourFavoriteCandyOnYourFavoriteDay {
    public static void main(String[] args) {

        int[][] q = {{43, 1054, 49}};
        int[] c = {16, 38, 8, 41, 30, 31, 14, 45, 3, 2, 24, 23, 38, 30, 31, 17, 35, 4, 9, 42, 28, 18, 37, 18, 14, 46, 11, 13, 19, 3, 5, 39, 24, 48, 20, 29, 4, 19, 36, 11, 28, 49, 38, 16, 23, 24, 4, 22, 29, 35, 45, 38, 37, 40, 2, 37, 8, 41, 33, 8, 40, 27, 13, 4, 33, 5, 8, 14, 19, 35, 31, 8, 8};


        Solution solution = new CanYouEatYourFavoriteCandyOnYourFavoriteDay().new Solution();
        solution.canEat(c, q);
        System.out.println("Hello world");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //水题，但关键在于是第0天开始的
        public boolean[] canEat(int[] candiesCount, int[][] queries) {
            int n = candiesCount.length;
            int m = queries.length;
            boolean[] res = new boolean[m];
            long[] sum = new long[n + 1];
            sum[0] = 0;
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + candiesCount[i - 1];
            }
            for (int i = 0; i < m; i++) {
                int ft = queries[i][0];
                long fd = queries[i][1];
                long dc = queries[i][2];
                res[i] = (fd + 1) * dc > sum[ft] && fd + 1 <= sum[ft + 1];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}