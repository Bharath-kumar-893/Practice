import java.util.Stack;

public class FormulaFixer {
    public int fixTheFormula(String input1) {
        StringBuilder numBuilder = new StringBuilder();
        StringBuilder opBuilder = new StringBuilder();

        for (char c : input1.toCharArray()) {
            if (Character.isDigit(c)) {
                numBuilder.append(c);
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                opBuilder.append(c);
            }
        }

        String[] nums = numBuilder.toString().split("");
        String[] ops = opBuilder.toString().split("");

        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.parseInt(nums[0]));

        for (int i = 0; i < ops.length; i++) {
            int num = Integer.parseInt(nums[i + 1]);
            char op = ops[i].charAt(0);

            if (op == '+') {
                stack.push(stack.pop() + num);
            } else if (op == '-') {
                stack.push(stack.pop() - num);
            } else if (op == '*') {
                stack.push(stack.pop() * num);
            } else if (op == '/') {
                stack.push(stack.pop() / num);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        FormulaFixer fixer = new FormulaFixer();


        String input2 = "we8+you2-7to/*32";
        int result2 = fixer.fixTheFormula(input2);
        System.out.println("Input: " + input2 + ", Output: " + result2);

        String input3 = "i*-t5s-t8h1e4birds";
        int result3 = fixer.fixTheFormula(input3);
        System.out.println("Input: " + input3 + ", Output: " + result3);
    }
}