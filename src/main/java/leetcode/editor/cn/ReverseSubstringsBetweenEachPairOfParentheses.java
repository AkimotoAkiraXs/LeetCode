//给出一个字符串 s（仅含有小写英文字母和括号）。 
//
// 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。 
//
// 注意，您的结果中 不应 包含任何括号。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "(abcd)"
//输出："dcba"
// 
//
// 示例 2： 
//
// 
//输入：s = "(u(love)i)"
//输出："iloveu"
//解释：先反转子字符串 "love" ，然后反转整个字符串。 
//
// 示例 3： 
//
// 
//输入：s = "(ed(et(oc))el)"
//输出："leetcode"
//解释：先反转子字符串 "oc" ，接着反转 "etco" ，然后反转整个字符串。 
//
// 示例 4： 
//
// 
//输入：s = "a(bcdefghijkl(mno)p)q"
//输出："apmnolkjihgfedcbq"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 2000 
// s 中只有小写英文字母和括号 
// 题目测试用例确保所有括号都是成对出现的 
// 
// Related Topics 栈 
// 👍 182 👎 0


/*
 * Id：1190
 * Name：反转每对括号间的子串
 * Date：2021-06-22 15:30:00
 */
package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseSubstringsBetweenEachPairOfParentheses {
    public static void main(String[] args) {
        Solution solution = new ReverseSubstringsBetweenEachPairOfParentheses().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 字符串处理
         * 模拟
         */
        //官方题解 预处理括号
        public String reverseParentheses(String s) {
            int n = s.length();
            int[] num = new int[n];
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0, j; i < n; i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else if (s.charAt(i) == ')') {
                    j = stack.pop();
                    num[i] = j;
                    num[j] = i;
                }
            }
            int index = 0, k = 1;
            StringBuilder sb = new StringBuilder();
            while (index < n) {
                if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                    index = num[index];
                    k = -k;
                } else {
                    sb.append(s.charAt(index));
                }
                index += k;
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 