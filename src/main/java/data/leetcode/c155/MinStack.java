package data.leetcode.c155;

import java.util.Stack;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-04
 *
 * 核心：
 * 1. 不需要while循环
 * 2. minStack中存储的数据量与stack一致
 * 3. 使用相同最小元素来占位
 * 4. pop逻辑: 不变 弹出逻辑不变，因为minStack已经改造成需要的样子
 * 5. push逻辑: 比较val和minStack.peek()， 将较小值存入
 */
class MinStack {
    // [-2, 0]  <- -3 <- 4
    // 维护一个单调栈 or 单调队列
    //[0]
    //[-2]
    //[-3.-2, 0]

    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        //维护minStack
        // while(!minStack.isEmpty() && minStack.peek() < val) {
        //     minStack.pop();
        // }
        if (!minStack.isEmpty() && minStack.peek() < val) {
            minStack.push(minStack.peek());
        } else {
            minStack.push(val);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        // while(!minStack.isEmpty() && minStack.peek() >= val) {
        //     minStack.pop();
        // }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
