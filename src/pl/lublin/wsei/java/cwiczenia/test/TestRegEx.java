package pl.lublin.wsei.java.cwiczenia.test;

public class TestRegEx {
    public static void main(String[] args) {
        String exItem = "<item>" +
                    "<title><![CDATA[Infografika - Powszechny Spis Ludności 1921]]></title> " +
                    "<pubDate><![CDATA[Tue, 09 Mar 2021 11:49:00 +0100]]></pubDate> " +
                    "<link>https://stat.gov.pl/infografiki-widzety/infografiki/infografika-powszechny-spis-ludnosci-1921,101,1.html</link> " +
                    "<guid isPermaLink=\"false\">https://stat.gov.pl/infografiki-widzety/infografiki/infografika-powszechny-spis-ludnosci-1921,101,1.html</guid> " +
                    "<media:content url=\"https://stat.gov.pl/files/gfx/portalinformacyjny/pl/defaultaktualnosci/5866/101/1/1/spis_powszechny_1921.jpg\" type=\"image/jpeg\" width=\"4267\" height=\"8326\"> " +
                            "<media:description type=\"plain\"><![CDATA[]]></media:description> " +
                            "<media:thumbnail url=\"https://stat.gov.pl//gfx/portalinformacyjny/_thumbs/pl/defaultaktualnosci/5866/101/1/1/spis_powszechny_1921,k1uUwl-caFOE6tCTiHtf.jpg\" /> " +
                            "</media:content> " +
                            "<description><![CDATA[<div><img src=\"https://stat.gov.pl//gfx/portalinformacyjny/_thumbs/pl/defaultaktualnosci/5866/101/1/1/spis_powszechny_1921,k1uUwl-caFOE6tCTiHtf.jpg\" alt=\"\" width=\"280\" height=\"212\"/></div>]]></description> " +
                            "</item>";
    }
}
