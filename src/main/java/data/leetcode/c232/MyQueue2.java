package data.leetcode.c232;

import java.util.Stack;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-04
 */
class MyQueue2 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

   //top [1,2,3] bottom<- 4  []
    //[1,2,3] <- 4 [1]
    //[3] <- 4  [2,1]
    // [] <- 4  [3,2,1]
    //[]  [4,3,2,1]
    //[4]  [3,2,1]
    //[3,4]  [2,1]
    //[2,3,4]  [1]
    //[1,2,3,4]  []
    public void push(int x) {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.push(x);
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    //栈实现队列的出队操作效率低下：栈底元素（对应队首元素）无法直接删除，需要将上方所有元素出栈。
    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
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
