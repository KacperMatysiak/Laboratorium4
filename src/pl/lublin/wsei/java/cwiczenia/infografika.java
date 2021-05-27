package pl.lublin.wsei.java.cwiczenia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class infografika {
    String tytul;
    String adresStrony;
    int szerokosc;
    int wysokosc;
    String adresGrafiki;
    String adresMiniaturki;

    public infografika(String tekst) {
        Pattern pat = Pattern.compile("<title><!\\[CDATA\\[(.*)\\]\\]");
        Matcher m = pat.matcher(tekst);
        if (m.find())
            tytul = m.group(1);
        else
            tytul = "";

        pat = Pattern.compile("<link>(.*)<\\/link>");
        m = pat.matcher(tekst);
        if (m.find())
            adresStrony = m.group(1);
        else
            adresStrony = "";


        pat = Pattern.compile("width=\"(.*)\"height");
        m = pat.matcher(tekst);
        if (m.find())
            szerokosc = Integer.parseInt(m.group(1));
        else
            szerokosc = 0;

        pat = Pattern.compile("height=\"(.*)\"\\/>");
        m = pat.matcher(tekst);
        if (m.find())
            wysokosc = Integer.parseInt(m.group(1));
        else
            wysokosc = 0;

        pat = Pattern.compile("<media:content url=\"(.*)\"");
        m = pat.matcher(tekst);
        if (m.find())
            adresGrafiki = m.group(1);
        else
            adresGrafiki = "";

        pat = Pattern.compile("<description><!\\[CDATA\\[<div><img src=\"(.*)\" a");
        m = pat.matcher(tekst);
        if (m.find())
            adresMiniaturki = m.group(1);
        else
            adresMiniaturki = "";


    }

    public void print() {
        System.out.print("infografika: "+
                "\n\t1.tytul: " + tytul+
                "\n\t2.adres grafiki: "+ adresGrafiki +
                "\n\t3.adres strony: "+adresStrony+
                "\n\t4.adres miniaturki: "+ adresMiniaturki +
                "\n\t5.rozmiar: "+wysokosc+"x"+szerokosc + "\n\n");
    }
}
