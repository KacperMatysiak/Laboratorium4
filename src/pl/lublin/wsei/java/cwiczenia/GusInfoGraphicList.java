package pl.lublin.wsei.java.cwiczenia;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;

public class GusInfoGraphicList {
    public ArrayList<infografika> infografiki;

    public GusInfoGraphicList(String gusFileName){
        infografiki = new ArrayList<>();
        String contents;

        try{
            contents = new String(Files.readAllBytes(Paths.get(gusFileName)));
        }
        catch(IOException e){
            System.out.println("Błąd wczytywania pliku gusInfoGraphic.xml=> "+ e.getLocalizedMessage());
            e.printStackTrace();
            contents = "";
        }
        String[] items = contents.split("<item>");
        for(int i =1; i < items.length; i++){
            infografiki.add(new infografika(items[i]));
        }
    }
}