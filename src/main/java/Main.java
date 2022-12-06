import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String input = reader.readLine();

            String output = calc(input);

            writer.write(output);
        }
    }

    public static String calc(String input) throws Exception {
        Equation equation = new Equation(input);
        return equation.getResult();
    }
}
