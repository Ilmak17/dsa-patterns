package patterns.stack;

import java.util.Stack;

public class RVN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stackDigits = new Stack<>();
        for (String s : tokens) {
            if (isInteger(s)) {
                stackDigits.add(Integer.parseInt(s));
            } else {
                int secondValue = stackDigits.pop();
                int firstValue = stackDigits.pop();
                int res = 0;
                switch (s) {
                    case "/":
                        res = firstValue / secondValue;
                        break;
                    case "*":
                        res = firstValue * secondValue;
                        break;
                    case "+":
                        res = firstValue + secondValue;
                        break;
                    case "-":
                        res = firstValue - secondValue;
                        break;
                }
                stackDigits.push(res);
            }
        }

        return stackDigits.pop();
    }

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
