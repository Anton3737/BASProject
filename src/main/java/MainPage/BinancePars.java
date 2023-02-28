package MainPage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

public class BinancePars {

    private String symbol;
    private BigDecimal bidPrice;
    private BigDecimal bidQty;
    private BigDecimal askPrice;
    private BigDecimal askQty;

    public BinancePars(String symbol, BigDecimal bidPrice, BigDecimal bidQty, BigDecimal askPrice, BigDecimal askQty) {
        this.symbol = symbol;
        this.bidPrice = bidPrice;
        this.bidQty = bidQty;
        this.askPrice = askPrice;
        this.askQty = askQty;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(BigDecimal bidPrice) {
        this.bidPrice = bidPrice;
    }

    public BigDecimal getBidQty() {
        return bidQty;
    }

    public void setBidQty(BigDecimal bidQty) {
        this.bidQty = bidQty;
    }

    public BigDecimal getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(BigDecimal askPrice) {
        this.askPrice = askPrice;
    }

    public BigDecimal getAskQty() {
        return askQty;
    }

    public void setAskQty(BigDecimal askQty) {
        this.askQty = askQty;
    }

    @Override
    public String toString() {
        return
                "Конвертація З - ДО: " + symbol + '\n' +
                "Ціна попиту: " + bidPrice + '\n' +
                "Заявлена кількість: " + bidQty + '\n' +
                "Ціна пропозиції: " + askPrice + '\n' +
                "Пропонована кількість: " + askQty + '\n' ;
    }
}

class BinanceParser{

    public static void BinParser(String url) throws IOException {

        GsonBuilder GsonBuilder = new GsonBuilder();

        GsonBuilder.setPrettyPrinting();

        Gson gson = new Gson();

        JsonReader jsonReader = new JsonReader(new InputStreamReader(new URL(url).openStream()));

        BinancePars[] binancePars = gson.fromJson(jsonReader,BinancePars[].class);

        for (BinancePars BinancePrint: binancePars) {
            System.out.println(BinancePrint);
        }
    }

    public static void main(String[] args) throws IOException {
        BinParser("https://www.binance.com/api/v1/ticker/allBookTickers");
    }
}

