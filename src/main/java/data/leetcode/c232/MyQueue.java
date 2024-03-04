package data.leetcode.c232;

import java.util.Stack;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-04
 * 为什么不是push时操作, 而是pop？
 */
class MyQueue {
    //top [1,2,3]  bottom <- 4
    // stack1  top [1,2,3] bottom <- 4
    // push: stack1   top [4, 3,2,1] bottom    stack2  top [] bottom
    // pop: 应该pop的元素是1 stack2.isEmpty() yes     stack1 -> stack2 =>
    //      stack1   top [] bottom    stack2  top [1,2,3,4] bottom return stack2.pop();
    // peek:   stack2.isEmpty() no => stack2.peek();
    //stack1   top [] bottom    stack2  top [2,3,4] bottom  return stack2.peek();
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }


    public void push(int x) {
        stack1.push(x);
    }

    //栈实现队列的出队操作效率低下：栈底元素（对应队首元素）无法直接删除，需要将上方所有元素出栈。
    public int pop() {
        int peek = peek();
        stack2.pop();
        return peek;
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        if (stack1.isEmpty()) {
            return -1;
        }
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
