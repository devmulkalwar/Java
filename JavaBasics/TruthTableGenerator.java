import java.util.Scanner;

public class TruthTableGenerator {

    // Logical NOT
    public static boolean not(boolean value) {
        return !value;
    }

    // Logical AND
    public static boolean and(boolean a, boolean b) {
        return a && b;
    }

    // Logical OR
    public static boolean or(boolean a, boolean b) {
        return a || b;
    }

    // Logical IMPLIES (=>)
    public static boolean implies(boolean a, boolean b) {
        return !a || b; // a imp b is equivalent to ~a || b
    }

    // Logical DOUBLE IMPLICATION (<=>)
    public static boolean doubleImplies(boolean a, boolean b) {
        return a == b; // a dimp b is true when both a and b are equal
    }

    // Replace variables with boolean values in the expression
    public static String replaceVariables(String expression, String[] variables, boolean[] values) {
        String modifiedExpression = expression;
        for (int i = 0; i < variables.length; i++) {
            modifiedExpression = modifiedExpression.replace("~" + variables[i], String.valueOf(not(values[i])));
            modifiedExpression = modifiedExpression.replace(variables[i], String.valueOf(values[i]));
        }
        return modifiedExpression;
    }

    // Evaluate an expression with replaced boolean values
    public static boolean evaluateExpression(String expression) {
        // Handling logical operators, parentheses should already be removed before calling this method
        if (expression.contains("<=>")) {
            String[] parts = expression.split("<=>");
            boolean left = evaluateExpression(parts[0].trim());
            boolean right = evaluateExpression(parts[1].trim());
            return doubleImplies(left, right);
        }
        if (expression.contains("=>")) {
            String[] parts = expression.split("=>");
            boolean left = evaluateExpression(parts[0].trim());
            boolean right = evaluateExpression(parts[1].trim());
            return implies(left, right);
        }
        if (expression.contains("&&")) {
            String[] parts = expression.split("&&");
            return and(evaluateExpression(parts[0].trim()), evaluateExpression(parts[1].trim()));
        }
        if (expression.contains("||")) {
            String[] parts = expression.split("\\|\\|");
            return or(evaluateExpression(parts[0].trim()), evaluateExpression(parts[1].trim()));
        }
        // If the expression is just a boolean value, return it
        return Boolean.parseBoolean(expression.trim());
    }

    // Generate all combinations of truth values
    public static void generateTruthValues(int numVariables, boolean[][] combinations) {
        int rows = combinations.length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < numVariables; j++) {
                combinations[i][j] = (i / (1 << (numVariables - 1 - j))) % 2 == 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the logical expression (use ~ for NOT, && for AND, || for OR, => for IMPLIES, <=> for DOUBLE IMPLICATION):");
        String expression = scanner.nextLine();

        System.out.println("Enter the variables in the expression (e.g., p q r):");
        String[] variables = scanner.nextLine().split("\\s+");
        int numVariables = variables.length;

        int rows = (int) Math.pow(2, numVariables);
        boolean[][] combinations = new boolean[rows][numVariables];

        // Generate all truth value combinations
        generateTruthValues(numVariables, combinations);

        // Print the truth table header
        for (String variable : variables) {
            System.out.printf("%-6s", variable);
        }
        System.out.printf("%-10s%n", "Result");
        System.out.println("-".repeat(numVariables * 6 + 10));

        // Evaluate and print the truth table
        for (boolean[] combination : combinations) {
            // Print the truth values of each variable
            for (boolean value : combination) {
                System.out.printf("%-6s", value);
            }

            // Replace variables in the expression with the actual truth values
            String modifiedExpression = replaceVariables(expression, variables, combination);

            // Evaluate the modified expression and print the result
            boolean result = evaluateExpression(modifiedExpression);
            System.out.printf("%-10s%n", result);
        }

        scanner.close();
    }
}
