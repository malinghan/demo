package data.leetcode.c331;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    //case1: 空节点
    //case2: 非空节点
    //case3: 根节点
    public boolean isValidSerialization(String preorder) {
          //节点总数
          int n = preorder.length();
          //从i开始遍历
          int i = 0;
          //定义一个栈
          Deque<Integer> stack = new LinkedList<Integer>();
          //初始化根节点，计数为1，代表一个槽位
          stack.push(1);
          while(i < n) {
            //如果槽位不够，则序列不合法
            if (stack.isEmpty()) {
                return false;
            }
            //如果是分隔符，跳过
            if (preorder.charAt(i) == ',') {
                i++;
                //case1: 空节点 #表示为叶子节点
            } else if (preorder.charAt(i) == '#') {
                // 遇到叶子节点计数减1
                int top = stack.pop() - 1;
                if(top > 0) {
                    stack.push(top);
                }
                i++;
            } else {
                //读取一个数字
                //"9,3,4,#,#,1,#,#,2,#,6,#,#"
                //case2: 非空节点且不是根节点
                while(i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                //栈顶减1，后再压入2
                int top = stack.pop() -1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
          } 
          return stack.isEmpty();
    }

    public static void main(String[] args) {
        new Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }
}