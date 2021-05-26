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

public class XmlParser {
    public List<Cube> parse(String xmlFileName) {
        List<Cube> listOfCube = new ArrayList<>();
        try{
            File xmlFile = new File(xmlFileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(xmlFile);
            NodeList List = doc.getElementsByTagName("Cube");
            for (int i = 2; i < List.getLength(); i++) {
                Node node = List.item(i);

                Element element = (Element) node;
                listOfCube.add(new Cube(element.getAttribute("currency"), (float) Double.parseDouble(element.getAttribute("rate"))));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  listOfCube;
    }
}
