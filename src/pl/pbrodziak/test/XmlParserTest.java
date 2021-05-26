package pl.pbrodziak.test;

import pl.pbrodziak.Cube;
import pl.pbrodziak.XmlParser;

import java.util.ArrayList;
import java.util.List;

public class XmlParserTest {

    public static void main(String[] args) {
        shouldParse();
    }
    static void shouldParse(){
        XmlParser xmlParser = new XmlParser();
        List<Cube> cubeList = new ArrayList<>();
        assert xmlParser.parse("eurofxref-daily.xml") == cubeList : "Bład";
    }
}
