package MainPage;

import com.google.gson.stream.JsonWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Channel24 {

    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect("https://espreso.tv/news").get();
        Elements article = document.getElementsByAttributeValue("class", "ttx");
        Elements linkArticle = document.getElementsByAttributeValue("class", "js-lazy-load");
        Elements postTime = document.getElementsByAttributeValue("class", "main_time");


        System.out.println(article + " \n " + linkArticle + " \n " +  postTime + " \n ");



//
//        System.out.println(article);
//        System.out.println(linkArticle);
//        System.out.println(postTime);


//        System.out.println(document);


    }


}
