package data.leetcode.c225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-03
 */
class MyStack {
    //如果是stack的话怎么存放？
    // bottom [1,2,3] peek()
    // 4 -> queue:bottom [1,2,3,4] peek() ->
    Queue<Integer> queue1;//作为主要的数据存储
    Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        //先把x放 queue2, 再清空queue1, 出队顺序，3，2，1
        //此时：queue2【1,2,3,4】满足要求
        // 将queue2 指向queue1，queue2 清空
        queue2.offer(x);
        while(!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */