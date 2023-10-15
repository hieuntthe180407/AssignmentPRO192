
import java.util.*;
import java.lang.*;

public class Menu {

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1.  List all brands");
            System.out.println("2.  Add a new brand");
            System.out.println("3.  Search a brand based on its ID");
            System.out.println("4.  Update a brand");
            System.out.println("5.  Save brands to the file, named brands.txt ");
            System.out.println("6.  List all cars in ascending order of brand names");
            System.out.println("7.  List cars based on a part of an input brand name");
            System.out.println("8.  Add a car");
            System.out.println("9.  Remove a car based on its ID ");
            System.out.println("10. Update a car based on its ID");
            System.out.println("11. Save cars to file, named cars.txt");
            System.out.println("12. exit");
            System.out.print("input your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:

                    //call the addItem method at here
                    break;
                case 2:

                    //call the addItem method at here
                    break;
                case 3:

                    //call the addItem method at here
                    break;
                case 4:
                    //call the displayAll method at here
                    break;
                case 5:
                    //call the findItems method at here
                    break;
                case 6:
                    //call the updateItem method at here
                    break;
                case 7:
                    //call the removeItem method at here
                    break;
                case 8:
                    //call the displayItemByType method at here
                    break;
                case 9:
                    //call the sortItems() method at here
                    break;
                case 10:
                    //call the sortItems() method at here
                    break;
                case 11:
                    //call the sortItems() method at here
                    break;

            }

        } while (choice <= 11);
    }
}
