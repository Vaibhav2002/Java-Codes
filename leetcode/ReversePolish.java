package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ReversePolish {
    enum Operation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY
    }

    public int evalRPN(String[] tokens) {
        HashMap<String, Operation> operators = new HashMap<>();
        operators.put("+", Operation.ADD);
        operators.put("-", Operation.SUBTRACT);
        operators.put("/", Operation.DIVIDE);
        operators.put("*", Operation.MULTIPLY);
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            Operation operation = operators.get(token);
            if (operation == null)
                st.push(Integer.parseInt(token));
            else {
                int y = st.pop(), x = st.pop();
                int ans = operate(x, y, operation);
                st.push(ans);
            }
        }
        return st.pop();
    }

    public int operate(int a, int b, Operation operation) {
        int ans = 0;
        switch (operation) {
            case ADD:
                ans = a + b;
                break;
            case SUBTRACT:
                ans = a - b;
                break;
            case DIVIDE:
                ans = a / b;
                break;
            case MULTIPLY:
                ans = a * b;
                break;
        }
        return ans;
    }
}
