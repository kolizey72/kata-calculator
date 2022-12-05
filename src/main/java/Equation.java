public class Equation {

    private Number first;
    private Number last;
    private final Operation operation;

    public Equation(String equation) throws Exception {
        String[] elems = equation.split(" ");

        if (elems.length != 3) {
            throw new Exception();
        }

        try {
            this.first = Integer.valueOf(elems[0]);
            this.last = Integer.valueOf(elems[2]);
        } catch (NumberFormatException e) {
            this.first = new RomanNumber(elems[0]);
            this.last = new RomanNumber(elems[2]);
        }

        operation = Operation.of(elems[1]);
    }

    public String getResult() throws Exception {
        int result = 0;
        switch (operation) {
            case ADDITION -> result = first.intValue() + last.intValue();
            case SUBTRACTION -> result = first.intValue() - last.intValue();
            case MULTIPLICATION -> result = first.intValue() * last.intValue();
            case DIVISION -> result = first.intValue() / last.intValue();
        }

        if (first instanceof RomanNumber && last instanceof RomanNumber) {
            return new RomanNumber(result).toString();
        }

        return Integer.toString(result);
    }
}
