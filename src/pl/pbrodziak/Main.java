package pl.pbrodziak;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        final String XMLDoc = "eurofxref-daily.xml";
        List<Cube> listOfCube = new ArrayList<>();
        boolean isContinue = true;

            try{
                File xmlFile = new File(XMLDoc);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
                Document doc = documentBuilder.parse(xmlFile);
                NodeList List = doc.getElementsByTagName("Cube");
                for (int i = 2; i < List.getLength(); i++) {
                    Node node = List.item(i);

                    Element element = (Element) node;
                    listOfCube.add(new Cube(element.getAttribute("currency"), (float) Double.parseDouble(element.getAttribute("rate"))));
                }
                showCurrencyTable(listOfCube);

            }
            catch (Exception e){
                e.printStackTrace();
            }

            int code;
            double amount;

            Scanner scanner = new Scanner(System.in);

            System.out.println("Witam w aplikacji kalkulator walut!");
        while(isContinue){
            code = 1;
            amount = 1.0;
            System.out.println("Którą walutę chcesz przekonwertować. Podaj numer? ");
            try {

                code = scanner.nextInt();
                System.out.print("kurs: "+roundedToXDecimalPlaces((listOfCube.get(code-1).rate), 4.0));
                System.out.println(", waluta: "+listOfCube.get(code-1).currency);
                System.out.println("Ile pieniędzy chcesz wymienić? Podaj kwotę w EURO");
                amount = scanner.nextDouble();
                double resoult = (amount * listOfCube.get(code-1).rate);

                System.out.println("EUR :" +amount+", "+listOfCube.get(code-1).currency+": "+roundedToXDecimalPlaces(resoult, 2.0));


            }
            catch (InputMismatchException n){
                System.out.println("------------------------------------------------------");
                System.out.println("BŁAD: Nieprawidłowy format!!!");
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("------------------------------------------------------");
                System.out.println("BŁAD: Nie ma waluty o tym numerze na liście!!!");

            }
            finally {
                System.out.println("------------------------------------------------------");
                System.out.println("Wpisz 'c' lub cokolwiek by kontynować, 'e' by zamknąć, 'p' by pokazać tablice kursów ");
                String e = scanner.next();

                if (e.equals("e")) {
                    isContinue = false;
                    System.out.println("----------------------------------------");
                    System.out.println("Dziękuje za skorzystanie, do zobaczenia!");
                }
                if (e.equals("p")){
                    showCurrencyTable(listOfCube);
                }

            }


        }

    }
    public static Double roundedToXDecimalPlaces(double n, double x){
        double number = n;
        number = number * (Math.pow(10, x));
        number = Math.round(number);
        number = number / (Math.pow(10, x));
        return number;
    }
    public static void showCurrencyTable(List<Cube> cubeList){
        System.out.println("######################TABLICA KURSÓW###################");
        System.out.println("*******************************************************");
        for (int i = 0; i < cubeList.size(); i++) {
            if (i % 3 == 0) { System.out.println();}else{ System.out.print("       "); }
            System.out.print("Numer : " + (i+1) +", ");
            System.out.print("kurs: "+roundedToXDecimalPlaces(cubeList.get(i).rate, 4.0));
            System.out.print(", waluta: "+cubeList.get(i).currency);
        }
        System.out.println();
        System.out.println("*******************************************************");

    }
}
