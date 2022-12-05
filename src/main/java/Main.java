public class Main {

    public static String calc(String input) throws Exception {
        Equation equation = new Equation(input);
        return equation.getResult();
    }
}
