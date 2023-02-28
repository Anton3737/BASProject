package MainPage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static MainPage.NewsPars.SERVER_URL;

public class NewsPars {

    public static final String SERVER_URL = "https://newsdata.io/api/1/news?apikey=pub_1780495eeb2b735257337696a3435cbdad776&q=ukraine&language=uk&category=top";


    private String title;
    private String link;
    private String keywords;
    private String creator;
    private String video_url;
    private String description;
    private String content;
    private String pubDate;
    private String image_url;
    private String source_id;
    private String category;
    private String country;
    private String language;

    public NewsPars(String title, String link, String keywords, String creator, String video_url, String description, String content, String pubDate, String image_url, String source_id, String category, String country, String language) {
        this.title = title;
        this.link = link;
        this.keywords = keywords;
        this.creator = creator;
        this.video_url = video_url;
        this.description = description;
        this.content = content;
        this.pubDate = pubDate;
        this.image_url = image_url;
        this.source_id = source_id;
        this.category = category;
        this.country = country;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "NewsPars{" +
                "Заголовок " + title + '\n' +
                "Посилання '" + link + '\n' +
                "Ключові слова '" + keywords + '\n' +
                "Автор " + creator + '\n' +
                "Відео " + video_url + '\n' +
                "Опис " + description + '\n' +
                "Контекст " + content + '\n' +
                "Дата публікації " + pubDate + '\n' +
                "Зображення " + image_url + '\n' +
                "Ресурс '" + source_id + '\n' +
                "Категорія '" + category + '\n' +
                "Країна " + country + '\n' +
                "Мова " + language + '\n';
    }
}

class NewsParsing {
    public static void NewsParser(String url) throws IOException {

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.setPrettyPrinting();

        Gson gson = new Gson();

        JsonReader jsonReader = gson.newJsonReader(new InputStreamReader(new URL(url).openStream()));

        NewsPars[] newsPars = gson.fromJson(jsonReader, NewsPars[].class);

        for (NewsPars NewsPrint : newsPars) {
            System.out.println(NewsPrint);
        }

    }

    public static void main(String[] args) throws IOException {
        NewsParser(SERVER_URL);

    }
}


//https://newsdata.io/api/1/news?apikey=pub_1780495eeb2b735257337696a3435cbdad776&q=ukraine&language=uk&category=top


//"title":"Ситуація у Бахмуті важка - Зеленський",
//        "link":"https://ua.korrespondent.net/ukraine/4566528-sytuatsiia-u-bakhmuti-vazhka-zelenskyi",
//        "keywords":["Новини України"],
//        "creator":["1"],
//        "video_url":null,
//        "description":"Ворог знищує все, що можна використовувати для захисту наших позицій, для закріплення та оборони.",
//        "content":"Новини від Корреспондент.net в Telegram. Підписуйтесь на наш канал https://t.me/korrespondentnet",
//        "pubDate":"2023-02-27 23:15:00",
//        "image_url":null,
//        "source_id":"korrespondent",
//        "category":["top"],
//        "country":["ukraine"],
//        "language":"ukrainian"