package MainPage;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class LiveMapUAPars {

    public static void main(String[] args) throws IOException {

        LocalDateTime localDateTime = LocalDateTime.now();

        Connection connection = Jsoup.connect("https://liveuamap.com/uk");

        connection.userAgent("Mozilla/5.0");
        Document document = connection.get();

        Elements postName = document.getElementsByAttributeValue("class", "event cat2 sourcees");

        System.out.println(postName);

        
    }
    
}
