//https://leetcode.com/problems/implement-queue-using-stacks/submissions/1693346955/?envType=problem-list-v2&envId=stack
import java.util.Stack;

public class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek(); 
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(10);
        queue.push(20);
        System.out.println("Front element: " + queue.peek()); 
        System.out.println("Removed: " + queue.pop());       
        System.out.println("Is empty? " + queue.empty());     
        queue.pop(); 
        System.out.println("Is empty after second pop? " + queue.empty()); 
    }
}
