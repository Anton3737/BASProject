package MainPage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

public class NBUPars {


    private int r030;
    private String txt;
    private BigDecimal rate;
    private String cc;
    private String exchangedate;

    public NBUPars(int r030, String txt, BigDecimal rate, String cc, String exchangedate) {
        this.r030 = r030;
        this.txt = txt;
        this.rate = rate;
        this.cc = cc;
        this.exchangedate = exchangedate;
    }

    public int getR030() {
        return r030;
    }

    public void setR030(int r030) {
        this.r030 = r030;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getExchangedate() {
        return exchangedate;
    }

    public void setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
    }

    @Override
    public String toString() {
        return
                "порядковий номер: " + r030 + '\n' +
                "Найменування валюти: " + txt + '\n' +
                "Ціна на міжбанку: " + rate + '\n' +
                "Міжнародний код валюти: " + cc + '\n' +
                "Дата обміну: " + exchangedate + '\n';
    }
}

class NBUParsing{

    public static void NBUParser (String url) throws IOException {

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.setPrettyPrinting();

        Gson gson = new Gson();

        JsonReader jsonReader = new JsonReader(new InputStreamReader(new URL(url).openStream()));

        NBUPars [] nbuPars = gson.fromJson(jsonReader,NBUPars[].class);

        for (NBUPars NBUPrint : nbuPars) {
            System.out.println(NBUPrint);
        }

    }

    public static void main(String[] args) throws IOException {
        NBUParser("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");
    }

}

