public enum Operation {
    ADDITION,
    SUBTRACTION,
    MULTIPLICATION,
    DIVISION;

    public static Operation of(String operator) throws Exception {
        return switch (operator) {
            case "+" -> ADDITION;
            case "-" -> SUBTRACTION;
            case "*" -> MULTIPLICATION;
            case "/" -> DIVISION;
            default -> throw new Exception();
        };
    }
}
