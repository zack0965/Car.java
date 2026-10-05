package practice;

public class Car {

    private String plateNumber;
    private String carModel;
    private double dailyRate;
    private boolean rent;

    // Static members
    public static String companyName = "JUST Rentals";
    public static int totalCars = 0;


    public Car() {
        this.plateNumber = "Unknown";
        this.carModel = "Unknown";
        this.dailyRate = 0.0;
        this.rent = false;
        totalCars++;
    }


    public Car(String plateNumber, String model, double dailyRate) {
        this.plateNumber = plateNumber;
        this.carModel = model;
        if (dailyRate >= 0) {
            this.dailyRate = dailyRate;
        } else {
            System.out.println("Invalid daily rate! Rate set to 0.");
            this.dailyRate = 0.0;
        }
        this.rent = false;
        totalCars++;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getModel() {
        return carModel;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public boolean isRented() {
        return rent;
    }


    public void setDailyRate(double rate) {
        if (rate >= 0) {
            this.dailyRate = rate;
            System.out.println("Daily rate of " + plateNumber + " changed to $" + rate);
        } else {
            System.out.println("Error: daily rate cannot be negative. Rate not changed.");
        }
    }


    public void rent() {
        if (rent) {
            System.out.println("Sorry, car " + plateNumber + " is already rented.");
        } else {
            rent = true;
            System.out.println("Car " + plateNumber + " has been rented successfully.");
        }
    }


    public void returnCar() {
        rent = false;
        System.out.println("Car " + plateNumber + " has been returned and is now available.");
    }


    public void displayInfo() {
        System.out.println("Plate Number : " + plateNumber);
        System.out.println("Model        : " + carModel);
        System.out.println("Daily Rate   : $" + dailyRate);
        System.out.println("Status       : " + (rent ? "Rented" : "Available"));
        System.out.println("---------------------------");
    }


    public static void displayCompanyName() {
        System.out.println("Company: " + companyName);
    }

    public static void displayTotalCars() {
        System.out.println("Total Cars Created: " + totalCars);
    }
}

class TestCar {
    public static void main(String[] args) {


        System.out.println("=== Creating Cars ===");
        Car car1 = new Car("A123", "Toyota", 50);
        Car car2 = new Car();
        Car car3 = new Car("C789", "Honda", -20); // invalid rate -> validation


        System.out.println("\n=== Company Name ===");
        Car.displayCompanyName();


        System.out.println("\n=== Car Information ===");
        car1.displayInfo();
        car2.displayInfo();
        car3.displayInfo();


        System.out.println("=== Renting a Car ===");
        car1.rent();
        car1.displayInfo();


        System.out.println("=== Renting an Already Rented Car ===");
        car1.rent();


        System.out.println("\n=== Returning a Car ===");
        car1.returnCar();
        car1.displayInfo();


        System.out.println("=== Changing Daily Rate ===");
        car1.setDailyRate(65);
        car1.setDailyRate(-10);
        System.out.println("New rate: $" + car1.getDailyRate());


        System.out.println("\n=== Using Getters ===");
        System.out.println("Plate: " + car1.getPlateNumber()
                + ", Model: " + car1.getModel()
                + ", Rented? " + car1.isRented());


        System.out.println("\n=== Total Cars ===");
        Car.displayTotalCars();
    }
}