//https://leetcode.com/problems/online-stock-span/submissions/1698659632/?envType=problem-list-v2&envId=stack
import java.util.*;

public class StockSpanner {
    Stack<int[]> stack; 

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});
        return span;
    }

    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        System.out.println("Stock Span Outputs:");
        for (int price : prices) {
            System.out.println("Price: " + price + " -> Span: " + spanner.next(price));
        }
    }
}
