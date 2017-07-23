package aufgabe_6_upn;

import java.util.Stack;
import java.util.StringTokenizer;


public class UPN {
    private Stack<String> stack = new Stack<>();
    private String upn;


    public UPN(String upn) {
        this.upn = upn;
    }

 
    public int calc() {
        StringTokenizer st = new StringTokenizer(upn);
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            if(isNumber(str)) {
                stack.push(str);
            } else {
                int right = Integer.parseInt(stack.pop());
                int left = Integer.parseInt(stack.pop());
                int result = 0;
                switch (str) {
                    case "+":
                        result = left + right;
                        break;
                    case "-":
                        result = left - right;
                        break;
                    case "*":
                        result = left * right;
                        break;
                    case "/":
                        result = left / right;
                        break;
                    default:
                        System.out.println("Fehler!");
                }
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }


    private boolean isNumber(String str) {
        try {
            int number = Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
