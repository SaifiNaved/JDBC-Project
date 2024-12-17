import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class BusinessLayer {

    static Statement st;
    static PreparedStatement statement;
    static String query;
    static ResultSet result;
    //static Scanner sc =new Scanner(System.in);


    public static void insertGame() {
        Game game = DbLayer.getInputs();


        if (DbLayer.getCon()) {
            try {
                query = "INSERT INTO Gstore.games (Title,genera,Discription,Platform,Publisher,Price ,Rating,ReleaseDate)" +
                        " VALUES(?,?,?,?,?,?,?,?)";
                statement = DbLayer.con.prepareStatement(query);
                statement.setString(1, game.getTitle());
                statement.setString(2, game.getGenera());
                statement.setString(3, game.getGameDiscription());
                statement.setString(4, game.getPlatform());
                statement.setString(5, game.getPublisher());
                statement.setFloat(6, game.getPrice());
                statement.setFloat(7, game.getRating());
                statement.setDate(8, game.getReleaseDate());
                int success = statement.executeUpdate();
                if (success > 0)
                    System.out.println("Game added sucessfully");
                else
                    System.out.println("Enter valid Data");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DbLayer.closeConnection();
            }

        }

    }

    public static ArrayList<Game> getAllGames() {
        ArrayList<Game> games = new ArrayList<>();
        query = "SELECT * FROM games";

        if (DbLayer.getCon()) {
            try {
                st = DbLayer.con.createStatement();
                result = st.executeQuery(query);
                while (result.next()) {
                    Game game = new Game();
                    game.setTitle(result.getString("Title"));
                    game.setGener(result.getString("genera"));
                    game.setGameDiscription(result.getString("Discription"));
                    game.setPlatform(result.getString("Platform"));
                    game.setPublisher(result.getString("Publisher"));
                    game.setPrice((float) result.getDouble("Price"));
                    game.setRating((float) result.getDouble("Rating"));
                    game.setGameId(result.getInt("GameId"));

                    games.add(game);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return games;
    }


    public static int takeId() {
        Scanner sc = new Scanner(System.in);

        int id = -1;
        while (true) { // Keep asking until we get a valid ID
            System.out.println("Enter the game ID of the Game:");
            id = sc.nextInt(); // Take user input

            String query = "SELECT * FROM games WHERE gameId = " + id;

            try {
                st = DbLayer.con.createStatement(); // Create a new statement
                result = st.executeQuery(query);   // Execute the query

                if (result.next()) { // Check if the result exists
                    break; // Exit the loop if the ID is valid
                } else {
                    System.out.println("Invalid ID, please enter a valid ID.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return id;
        }
        return id;
    }
        public static void updateGame ()
        {
            if (DbLayer.getCon()) {

                int gameId = takeId();
                Game game = DbLayer.getInputs();

                try {
                    query = "UPDATE Gstore.games \n" +
                            "SET Title = ?, genera = ?, Discription = ?, Platform = ?, Publisher = ?, Price = ?, Rating = ?, ReleaseDate = ? \n" +
                            "WHERE id = ?;";
                    statement = DbLayer.con.prepareStatement(query);
                    statement.setString(1, game.getTitle());
                    statement.setString(2, game.getGenera());
                    statement.setString(3, game.getGameDiscription());
                    statement.setString(4, game.getPlatform());
                    statement.setString(5, game.getPublisher());
                    statement.setFloat(6, game.getPrice());
                    statement.setFloat(7, game.getRating());
                    statement.setDate(8, game.getReleaseDate());
                    statement.setInt(9,game.getGameId());
                    int success = statement.executeUpdate();
                    if (success > 0)
                        System.out.println("Game Updated sucessfully");
                    else
                        System.out.println("Enter valid Data");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    /*
    public static boolean deleteGame()
    {}
    */


    }
