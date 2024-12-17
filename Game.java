import java.sql.Date;
import java.util.Scanner;

public class Game {

    private String title;
    private String genera;
    private String platform;
    private String publisher;
    private float price;
    private float rating;
    private int gameId;
    private String gameDiscription;
    private Date releaseDate;

    static Scanner sc = new Scanner(System.in);

    public String getTitle()
    {
        return title;
    }

    public String getGenera() {
        return genera;
    }

    public String getPlatform() {
        return platform;
    }

    public String getPublisher() {
        return publisher;
    }

    public float getPrice() {
        return price;
    }

    public float getRating() {
        return rating;
    }

    public int getGameId() {
        return gameId;
    }

    public String getGameDiscription() {
        return gameDiscription;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setGener(String genera) {
        this.genera= genera;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public void setGameDiscription(String gameDiscription) {
        this.gameDiscription = gameDiscription;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String toString()
    {
        return "Game Name: " + title + "\n" +
                "Discription: " + gameDiscription + "\n" +
                "Release Date: " + releaseDate + "\n" +
                "Publisher: " + publisher + "\n" +
                "Platform: " + platform + "\n" +
                "Genera: " + genera + "\n" +
                "Price :" + price + "\n" +
                "Rating:" + rating + "\n" +
                "Game ID: " + gameId ;
    }


}
