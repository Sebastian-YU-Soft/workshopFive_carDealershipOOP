package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership = new Dealership();
    private Scanner scanner = new Scanner(System.in);

    private void init(){
        // TODO: Load dealership details from a file
        dealership = DealershipFileManager.getDealership();
    }


    public UserInterface(){
        init();

    }

    public void display(){
        // TODO: Create your main menu (DO-While)

        System.out.println("Welcome to the dealership program");
        int mainMenuCommand;

        do {
            System.out.println("1. Get by price");
            System.out.println("2. Get by make/model");
            System.out.println("3. Get by year");
            System.out.println("4. Get by color");
            System.out.println("5. Get by mileage");
            System.out.println("6. Get by type");
            System.out.println("7. Get by all");
            System.out.println("8. Add vehcile");
            System.out.println("9. Remove vehicle");
            System.out.println("0. Exit");

            System.out.print("Command:");

            mainMenuCommand=scanner.nextInt();

            switch (mainMenuCommand){
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Command not found, try again");
            }
        }while (mainMenuCommand != 0);
    }

   private void processGetByPriceRequest(){
       // TODO: Ask the user for a starting price and ending price
       // ArrayList<Vehicle> filteredVehicles = dealership.getVehiclesByPrice(startingPrice, endingPrice);
       // Display vehicles with for loop
   }
   private void processGetByMakeModelRequest(){

   }
   private void processGetByYearRequest(){

    }
    private void processGetByColorRequest(){

    }
    private void processGetByMileageRequest (){

    }
    private void processGetByVehicleTypeRequest(){

    }
    private void processGetAllVehiclesRequest(){
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }
    private void processAddVehicleRequest(){
        System.out.print("VIN:");
        int vin = Integer.parseInt(scanner.nextLine());
        System.out.print("Year:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Make:");
        String make = scanner.nextLine();
        System.out.print("Model:");
        String model = scanner.nextLine();
        System.out.print("Type:");
        String type = scanner.nextLine();
        System.out.print("Color:");
        String color = scanner.nextLine();
        System.out.print("Odometer:");
        int odometer = Integer.parseInt(scanner.nextLine());
        System.out.print("Price:");
        double price = Double.parseDouble(scanner.nextLine());

        dealership.addVehicle(new Vehicle());
    }
    private void processRemoveVehicleRequest(){

    }
}
