import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression: ");
        String line = sc.nextLine();

        try {
            double result = evaluate(line);
            System.out.println("Result = " + result);
        } catch (Exception e) {
            System.out.println("Invalid expression!");
        }

        sc.close();
    }

    public static double evaluate(String input) {
        String[] tokens = input.trim().split("(?<=[-+*/x×÷])|(?=[-+*/x×÷])");

        double result = Double.parseDouble(tokens[0].trim());

        for (int i = 1; i < tokens.length - 1; i += 2) {
            String operator = tokens[i].trim();
            double nextNumber = Double.parseDouble(tokens[i + 1].trim());
            result = applyOperator(result, operator, nextNumber);
        }

        return result;
    }

    public static double applyOperator(double a, String op, double b) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": case "x": case "×": return a * b;
            case "/": case "÷":
                if (b == 0) {
                    System.out.println("Cannot divide by zero!");
                    return a; // keep old result
                }
                return a / b;
            default:
                System.out.println("Unknown operator: " + op);
                return a;
        }
    }
}
