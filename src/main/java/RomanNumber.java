import java.util.stream.IntStream;

public final class RomanNumber extends Number {

    private final String[] UNITS = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private final String[] TENS = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private final String[] HUNDREDS = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private final String[] THOUSANDS = {"M", "MM", "MMM"};

    private final int value;
    private final String stringValue;

    public RomanNumber(String number) throws Exception {
        this.value = parseNumber(number);
        this.stringValue = number;
    }

    public RomanNumber(int number) throws Exception {
        this.value = number;
        this.stringValue = parseNumber(number);
    }

    private int parseNumber(String number) throws Exception {
        int value = IntStream.range(0, UNITS.length)
                .filter(i -> number.equals(UNITS[i]))
                .findAny()
                .orElse(-1)
                + 1;

        if (value <= 0 && number.equals("X"))
            value = 10;

        if (value <= 0)
            throw new Exception();

        return value;
    }

    private String parseNumber(int number) throws Exception {
        if (number > 3999 || number < 1) {
            throw new Exception();
        }

        StringBuilder value = new StringBuilder();

        if (number >= 1000) {
            value.append(THOUSANDS[number / 1000 - 1]);
        }
        if (number >= 100) {
            int digit = number % 1000 / 100;
            if (digit > 0) {
                value.append(HUNDREDS[digit - 1]);
            }
        }
        if (number >= 10) {
            int digit = number % 100 / 10;
            if (digit > 0) {
                value.append(TENS[digit - 1]);
            }
        }
        int digit = number % 10;
        if (digit > 0) {
            value.append(UNITS[digit - 1]);
        }

        return value.toString();
    }

    @Override
    public String toString() {
        return stringValue;
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return (float)value;
    }

    @Override
    public double doubleValue() {
        return value;
    }
}
