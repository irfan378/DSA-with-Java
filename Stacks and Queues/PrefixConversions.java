import java.util.Stack;

public class PrefixConversions {

    public static void prefixConversion(String exp) {
        Stack<Integer> value = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int v1 = value.pop();
                int v2 = value.pop();
                int val = operation(v1, v2, ch);
                value.push(val);

                String infixv1 = infix.pop();
                String infixv2 = infix.pop();
                String infixval = "(" + infixv1 + ch + infixv2 + ")";
                infix.push(infixval);

                String postfixv1 = postfix.pop();
                String postfixv2 = postfix.pop();
                String postfixval = postfixv1 + postfixv2 + ch;
                postfix.push(postfixval);
            } else {
                value.push(ch - '0');
                infix.push(ch + "");
                postfix.push(ch + "");
            }
        }
        System.out.println(value.pop());
        System.out.println(infix.pop());
        System.out.println(postfix.pop());
    }

    public static int operation(int v1, int v2, char op) {
        if (op == '+') {
            return v1 + v2;
        } else if (op == '-') {
            return v1 - v2;
        } else if (op == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }

    public static void main(String[] args) {

    }

}