package Stack.LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q150EvaluateReversePolishNotation {
    static void main(String[] args) {
        String tokes[] = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        int ans = evalRPN(tokes);
        System.out.println("Ans : = " + ans);
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack  = new ArrayDeque<>();

        for (String token : tokens)
        {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;

                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}

