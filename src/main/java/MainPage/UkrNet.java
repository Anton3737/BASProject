package MainPage;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class UkrNet {

    public static void main(String[] args) throws IOException {
        LocalDateTime localDateTime = LocalDateTime.now();

        Connection connection = Jsoup.connect("https://www.ukr.net/news/main.html");

        connection.userAgent("Mozilla/5.0");
        Document document = connection.get();

        Elements postName = document.getElementsByAttributeValue("class", "im-tl_a");

        System.out.println(postName.toString().replaceAll("<a href|=|class=|rel|target|</a>|im-tl_a|nofollow|data-count|\\d*,|_blank|>|\"", ""));
        File newsPaperFile = new File("/Users/macintosh/Downloads/BASProject/src/main/java/MainPage/SaveFile/NewsFile.txt");

        FileWriter fileWriter = new FileWriter("NewsFile.txt", StandardCharsets.UTF_8);
        fileWriter.write(localDateTime + "\n" + postName.toString().replaceAll("<a href|=|class=|rel|target|</a>|im-tl_a|nofollow|data-count|\\d+,|_blank|>|\"", ""));
        fileWriter.close();
    }
}
