package pl.lublin.wsei.java.cwiczenia.test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestFileRead {
    public static void main(String[] args) throws IOException {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("C:\\Users\\pulaw\\IdeaProjects\\Laboratorium4a\\src\\pl\\lublin\\wsei\\java\\cwiczenia\\gusInfoGraphic.xml")));
            System.out.println("Zawartość pliku.xml: ");
            System.out.println(contents);

        }

         catch (IOException e) {
            System.out.println("Błąd wczytywania pliku gusInfoGraphic.xml => "+ e.getLocalizedMessage());
            e.printStackTrace();
        }

    }
}
