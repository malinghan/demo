package data.leetcode.c225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-03
 */
public class MyStack1 {
    class MyStack {
        //如果是stack的话怎么存放？
        // bottom [1,2,3] peek()
        // 4 -> queue:bottom [1,2,3,4] peek() ->
        Queue<Integer> queue;//作为主要的数据存储

        public MyStack() {
            queue = new LinkedList<Integer>();
        }

        public void push(int x) {
            //入队2次即可
            int n = queue.size();
            queue.offer(x);
            while (n > 0) {
                queue.offer(queue.poll());
                n--;
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
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