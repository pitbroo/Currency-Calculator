package pl.pbrodziak;

public class NumberRounder {
    public static Double roundedToXDecimalPlaces(double n, int x) {
        double number = n;
        number = number * (Math.pow(10, x));
        number = Math.round(number);
        number = number / (Math.pow(10, x));
        return number;
    }
}
