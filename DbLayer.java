import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Date;
import java.util.Collections;
import java.util.stream.Stream;



public class DbLayer {

    static Scanner sc = new Scanner(System.in);
    static Connection con;


    static String url="jdbc:mysql://localhost:3306/Gstore";
    static String username="root";
    static String password="root";

    public static boolean getCon()
    {
        try {
            con = DriverManager.getConnection(url ,username ,password);
            return true;
        }
        catch(SQLException e)
        {
            return false;
        }
    }

    public static void closeConnection()
    {
        try {
            if (con != null)
                con.close();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void printGames(List<Game> games)
    {
        for (Game gg: games )
        {
            System.out.println(gg.toString());
            System.out.println("-----------------------------------------------------------------------");
        }
    }
    public static void getAllGames()
    {
        ArrayList<Game> games = BusinessLayer.getAllGames();
        printGames(games);
    }
    public static void sortByName()
    {
        ArrayList<Game> games =BusinessLayer.getAllGames();
        Comparator<Game> sort=(e1 ,e2)->e1.getTitle().compareTo(e2.getTitle());
        Collections.sort(games ,sort);
        printGames(games);

    }
    public static void sortByPrice()
    {
        ArrayList<Game> games =BusinessLayer.getAllGames();
        Comparator<Game> sort=(e1 ,e2)->  {
            if (e1.getPrice() > e2.getPrice())
                return 1;
            else if (e1.getPrice() < e2.getPrice())
                return -1;
            else
                return 0;
        };
        Collections.sort(games ,sort);
        printGames(games);

    }
    public static void sortByRating()
    {
        {
            ArrayList<Game> games =BusinessLayer.getAllGames();
            Comparator<Game> sort=(e1 ,e2)->  {
                if (e1.getRating() > e2.getRating())
                    return -1;
                else if (e1.getPrice() < e2.getPrice())
                    return 1;
                else
                    return 0;
            };
            Collections.sort(games ,sort);
            printGames(games);

        }
    }


    public static Game getInputs()
    {
        Game game=new Game();
        String sdate;

        System.out.println("Enter Game Title");
        game.setTitle(sc.nextLine());
        System.out.println("Enter Description");
        game.setGameDiscription(sc.nextLine());

        System.out.println("Enter Release Date (yyyy-mm-dd)");
        //sdate=sc.nextLine();
        while (true) {
            //System.out.println("Enter Release Date (yyyy-mm-dd)");
            sdate=sc.nextLine();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
            try {
                Date date1 = format.parse(sdate);

                game.setReleaseDate(new java.sql.Date(date1.getTime()));
                break;
            } catch (Exception e) {
                System.out.println("Enter date in valid format");
            }
        }

        System.out.println("Enter Platform");
        game.setPlatform(sc.nextLine());
        System.out.println("Enter Publisher");
        game.setPublisher(sc.nextLine());
        System.out.println("Enter Genera");
        game.setGener(sc.nextLine());
        System.out.println("Enter Price");
        game.setPrice(sc.nextFloat());
        System.out.println("Enter Rating");
        game.setRating(sc.nextFloat());


        return game;
    }

}
