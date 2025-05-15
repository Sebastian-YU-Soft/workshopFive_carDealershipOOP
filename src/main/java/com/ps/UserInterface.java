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
       System.out.print("Enter minimum price:");
       double minPrice = Double.parseDouble(scanner.nextLine());
       System.out.print("Enter maximum price:");
       double maxPrice = Double.parseDouble(scanner.nextLine());
       List<Vehicle> vehicles = dealership.findVehicleByPrice(minPrice,maxPrice);
       displayVehicles(vehicles);
   }
   private void processGetByMakeModelRequest(){
        System.out.print("Enter make:");
        String make = scanner.nextLine();
        System.out.print("Enter model:");
        String model = scanner.nextLine();
        List<Vehicle> vehicles = dealership.findVehiclesByMakeModel(make,model);
        displayVehicles(vehicles);
   }
   private void processGetByYearRequest(){
        System.out.print("Enter minimum year:");
        int minYear = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter maximum year:");
        int maxYear = Integer.parseInt(scanner.nextLine());
        List<Vehicle> vehicles = dealership.findVehicleByYear(minYear, maxYear);
        displayVehicles(vehicles);
    }
    private void processGetByColorRequest(){
        System.out.print("Enter color:");
        String color = scanner.nextLine();
        List<Vehicle> vehicles = dealership.findVehicleByColor(color);
        displayVehicles(vehicles);
    }
    private void processGetByMileageRequest (){
        System.out.print("Enter minimum mileage:");
        int minMileage = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter maximum mileage:");
        int maxMileage = Integer.parseInt(scanner.nextLine());
        List<Vehicle> vehicles = dealership.findVehiclesByMileage(minMileage, maxMileage);
        displayVehicles(vehicles);
    }
    private void processGetByVehicleTypeRequest(){
        System.out.print("Enter vehicle type (car, trunk, SUV, van):");
        String vehicleType = scanner.nextLine();
        List<Vehicle> vehicles = dealership.findVehiclesByType(vehicleType);
        displayVehicles(vehicles);
    }
    private void processGetAllVehiclesRequest(){
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    private void displayVehicles(List<Vehicle> vehicles) {
      if (vehicles == null || vehicles.isEmpty()){
          System.out.println("No vehicles found.");
          return;
      }
      System.out.println("Vehicles");
      for (Vehicle vehicle : vehicles){
          System.out.println(vehicle);
      }
      System.out.println("End of list");
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
        System.out.print("Enter vin number of the vehicle to remove:");
        int vin = Integer.parseInt(scanner.nextLine());
        dealership.removeVehicle(vin);
        fileManager.saveDealership(dealership);
        System.out.println("Vehicle removed successfully");
    }
}
