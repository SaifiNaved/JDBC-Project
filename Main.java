import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        System.out.println("------------- Welcome To Gstore --------------");

        Scanner sc = new Scanner(System.in);
        int choice = 0;


        System.out.println("To get all Games press: 1");
        System.out.println("To add new Game press: 2");
        System.out.println("To update Game press: 3");
        System.out.println("To sort Games press: 4");




        choice = sc.nextInt();
        switch (choice)
        {
            case 1 :{
                DbLayer.getAllGames();
                break;
            }
            case 2 :
            {
                BusinessLayer.insertGame();
                break;
            }
            case 4:{
                while (true) {
                    System.out.println("Choose sorting Order");
                    System.out.println("Press 1 to sort by Name");
                    System.out.println("Press 2 to sort by Price");
                    System.out.println("Press 3 to sort by Rating");
                    System.out.println("Press 0 to Exit");
                    int choose = sc.nextInt();
                    if (choose == 1) {
                        DbLayer.sortByName();

                    }
                    else if (choose == 2) {
                        DbLayer.sortByPrice();

                    }
                    else if (choose == 3) {
                        DbLayer.sortByRating();

                    }
                    else if (choose == 0) {
                        break;
                    }
                    else {
                        System.out.println("Invalid Input Choose again");
                    }
                }
            }
        }
    }
}