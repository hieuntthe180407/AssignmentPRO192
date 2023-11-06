import java.lang.*;
import java.util.*;

public class CarManager {

   

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      ArrayList<String> ops = new ArrayList<>();
        ops.add("1. List all brands");
        ops.add("2. Add a new brand");
        ops.add("3. Search a brand based on it’s ID");
        ops.add("4. Update a brand");
        ops.add("5. Save brands to the file, named brands.txt");
        ops.add("6. List all cars in ascending order of brand names");
        ops.add("7. List cars based on a part of an input brand name");
        ops.add("8. Add a car");
        ops.add("9. Remove a car based on its ID");
        ops.add("10. Update a car based on its ID");
        ops.add("11. Save cars to file");
        

        BrandList brandList = new BrandList();
        boolean loadedBrands = brandList.loadFromFile("brands.txt");

        CarList carList = new CarList(brandList);
        boolean loadedCars = carList.loadFromFile("cars.txt");

        if (!loadedBrands || !loadedCars) {
            System.out.println("Failed to load data from files.");
            return;
        }

        int choice;
        Menu<Integer> menu = new Menu<>();
        menu.setPrompt("Select an option:");

        for (String op : ops) {
            menu.addOption(op, ops.indexOf(op) + 1);
        }
             boolean checkSuccessful; 
        do {
            
            choice = menu.int_getChoice();
            switch (choice) {
                case 1:
                    brandList.listBrands();
                    break;
                case 2:
                    brandList.addBrand();
                    break;
                case 3:
                    brandList.searchID();
                    break;
                case 4:
                    brandList.updateBrand();;
                    break;
                case 5:
                    brandList.saveToFile("Brands.txt");
                    System.out.println("Brands are saved succesfully!");
                    break;
                case 6:
                    carList.listCars();
                    break;
                case 7:
                    carList.printBasedBrandName();
                    break;
                case 8:
                    addCar(carList, brandList);
                    break;
                case 9:
                    System.out.print("Enter car ID to remove: ");
                    String carID = sc.next();
                    if (carList.removeCar(carID)) {
                        System.out.println("Car removed successfully.");
                    };
                    break;
               case 10:
                    checkSuccessful = carList.updateCar();
                    if (checkSuccessful) {
                        System.out.println("Car updated successfully !");
                    } else {
                        System.out.println("Car updated unsuccessfully !");
                    }
                    break;
                case 11:
                    carList.saveToFile("Cars.txt");
                    System.out.println("Cars saved to Cars.txt");
                    break;
                
                    
            }
           
        } while (choice > 0 && choice <= ops.size());
    }

        private static void addCar(CarList carList, BrandList brandList) {
             boolean duplicated=false;
        String frameID, engineID, carID = null;
        Scanner scanner = new Scanner(System.in);
        
        String msg="Input carID: ";
          String regEx= "[cC][\\d]{2}";
          do{
              carID = Inputter.getPatternStr(msg, regEx);
              carID = carID.toUpperCase();
              duplicated= (carList.search(carID) !=null);
              if(duplicated) System.out.println("carID is duplicated");
          }
          while(duplicated);
        System.out.print("Enter Color: ");
        String color = scanner.nextLine();
       
          String msg1="Input frameID: ";
          String regEx1= "[fF][\\d]{5}";
          do{
              frameID = Inputter.getPatternStr(msg1, regEx1);
              frameID = frameID.toUpperCase();
              duplicated= (brandList.search(frameID) !=null);
              if(duplicated) System.out.println("frameID is duplicated");
          }
          while(duplicated);
          
          String msg2="Input engineID: ";
          String regEx2= "[eE][\\d]{5}";
          do{
              engineID = Inputter.getPatternStr(msg2, regEx2);
              engineID = engineID.toUpperCase();
              duplicated= (brandList.search(frameID) !=null);
              if(duplicated) System.out.println("engineID is duplicated");
          }
          while (duplicated);
           

        carList.addCar(carID, color, frameID, engineID); 
        System.out.println("Car added successfully!");
    }
        
    }
    
