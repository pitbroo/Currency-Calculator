package pl.pbrodziak;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Cube> listOfCube = new ArrayList<>();
        try{
            File xmlFile = new File("eurofxref-daily.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(xmlFile);
            NodeList List = doc.getElementsByTagName("Cube");

            for (int i = 2; i < List.getLength(); i++) {
                Node node = List.item(i);
                System.out.print("Numer : " + (i-1) +", ");

                Element element = (Element) node;
                System.out.print("Waluta: "+ element.getAttribute("currency")+", ");
                System.out.println("Kurs: "+ element.getAttribute("rate"));
                listOfCube.add(new Cube(element.getAttribute("currency"), (float) Double.parseDouble(element.getAttribute("rate"))));

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        int code;
        double amount;

        Scanner scanner = new Scanner(System.in);

            System.out.println("Witam w aplikacji kalkulator walut!");

            System.out.println("Którą walutę chcesz przekonwertować. Podaj numer? ");
            code = scanner.nextInt();

            System.out.println("Ile pieniędzy chcesz wymienić? Podaj kwotę w EURO");
            amount = scanner.nextDouble();
//        for (Cube i:
//             listOfCube) {
//            System.out.println(i);
//        }

       // Cube cube = listOfCube.get(1);
        System.out.println("kurs: "+listOfCube.get(code-1).rate);
        System.out.println("waluta: "+listOfCube.get(code-1).currency);
        System.out.println(1 * listOfCube.get(code-1).rate );
    }
}
