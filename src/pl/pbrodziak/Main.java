package pl.pbrodziak;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String xmlFileName = "eurofxref-daily.xml";
        Boolean isContinue = true;
        XmlParser parser = new XmlParser();
        List<Cube> listOfCube = parser.parse(xmlFileName);
        TableDisplay tableDisplay = new TableDisplay();
        tableDisplay.displeyCurrencyTable(listOfCube);
        ProgramFinisher programFinisher = new ProgramFinisher();

        int code;
        double amount;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Witam w aplikacji kalkulator walut!");
        while (isContinue) {
            System.out.println("Którą walutę chcesz przekonwertować. Podaj numer? ");
            try {

                code = scanner.nextInt();
                System.out.print("kurs: " + NumberRounder.roundedToXDecimalPlaces((listOfCube.get(code - 1).rate), 4));
                System.out.println(", waluta: " + listOfCube.get(code - 1).currency);
                System.out.println("Ile pieniędzy chcesz wymienić? Podaj kwotę w EURO");
                amount = scanner.nextDouble();
                double result = (amount * listOfCube.get(code - 1).rate);

                System.out.println("EUR :" + amount + ", " + listOfCube.get(code - 1).currency + ": " + NumberRounder.roundedToXDecimalPlaces(result, 2));

            } catch (InputMismatchException n) {
                System.out.println("------------------------------------------------------");
                System.out.println("BŁAD: Nieprawidłowy format!!!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("------------------------------------------------------");
                System.out.println("BŁAD: Nie ma waluty o tym numerze na liście!!!");

            } finally {
                isContinue = programFinisher.finishProgram(listOfCube, scanner);
            }


        }

    }

}
