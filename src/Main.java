import Controllers.AuthController;
import Controllers.RoomController;
import Domains.UserDomain;
import Repositories.RoomRepository;
import Repositories.UserRepository;
import Services.AuthService;
import Services.RoomService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserRepository userRepo = new UserRepository();
        AuthService authService = new AuthService(userRepo);
        AuthController authController = new AuthController(authService);

        RoomRepository roomsRepo = new RoomRepository();
        RoomService roomService = new RoomService(roomsRepo);
        RoomController roomController = new RoomController(roomService);

        boolean running = true;
        boolean isLoggedIn = false;

        while (running) {
            if (!isLoggedIn) {
                System.out.println("========================");
                System.out.println("HOTEL BOOKING");
                System.out.println("========================");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("0. Exit");
                System.out.print("Choice: ");

                int choice = readSafeInt(scanner);

                switch (choice) {
                    case 1:
                        authController.register(scanner);
                        break;
                    case 2:
                        UserDomain loggedInUser = authController.login(scanner);
                        if (loggedInUser != null) {
                            isLoggedIn = true;
                            System.out.println("\nLogged in successfully!\n");
                        }
                        break;
                    case 0:
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please enter a valid number.\n");
                }
            } else {
                System.out.println("================================");
                System.out.println("MAIN MENU");
                System.out.println("================================");
                System.out.println("1. Search available rooms");
                System.out.println("2. View all rooms");
                System.out.println("3. Create reservation");
                System.out.println("4. My reservations");
                System.out.println("5. Update reservation");
                System.out.println("6. Cancel reservation");
                System.out.println("7. Update profile");
                System.out.println("8. Change password");
                System.out.println("9. Logout");
                System.out.println("0. Exit");
                System.out.print("Choice: ");

                int choice = readSafeInt(scanner);

                switch (choice) {

                    case 2:
                        roomController.viewAllRooms();
                        break;
                    case 9:
                        isLoggedIn = false;
                        System.out.println("\nLogged out successfully.\n");
                        break;
                    case 0:
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("\n--- Action " + choice + " executed ---\n");
                }
            }
        }
        scanner.close();
    }

    private static int readSafeInt(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}