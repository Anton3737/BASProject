package MainPage;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.lang.model.util.Elements;
import java.io.IOException;

public class Wheather {

    public static void main(String[] args) throws IOException {

        Connection connection = Jsoup.connect("https://meteopost.com/city/29313/ua/");

        connection.userAgent("Mozilla/5.0");
        Document document = connection.get();

        System.out.println(document);
    }
}
