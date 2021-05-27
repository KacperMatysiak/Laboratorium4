package pl.lublin.wsei.java.cwiczenia.test;

import pl.lublin.wsei.java.cwiczenia.GusInfoGraphicList;
import pl.lublin.wsei.java.cwiczenia.infografika;

public class TestGusInfoGraphicList {
    public static void main(String[] args){
        GusInfoGraphicList list = new GusInfoGraphicList("gusInfoGraphic.xml");
        for(infografika ig: list.infografiki) ig.print();
    }
}