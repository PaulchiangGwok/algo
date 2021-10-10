package com.company.old;

import java.util.LinkedList;
import java.util.Queue;

public class QueueAsStack {
    class MyStack {
        Queue<Integer> queue;
        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            shift();
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            shift();
            int res = queue.poll();
            queue.add(res);
            return res;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }

        private void shift(){
            int size = queue.size();
            for(int i=0 ;i < size -1;i++){
                queue.add(queue.poll());
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
}
