import Controllers.AuthController;
import Controllers.RoomController;
import Domains.RoomDomain;
import Domains.UserDomain;
import Repositories.GenericRepository;
import Repositories.Implementation.IGenericRepository;
import Repositories.UserRepository;
import Services.AuthService;
import Services.RoomService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IGenericRepository<UserDomain> userRepo = new GenericRepository<>();
        UserRepository userR = new UserRepository();
/*        IGenericRepository<RoomDomain> roomRepo = new GenericRepository<>();*/
        AuthService authService = new AuthService(userRepo,userR);
        AuthController authController = new AuthController(authService);

//        RoomService roomService = new RoomService(roomRepo);
//        RoomController roomController = new RoomController(roomService);

        boolean running = true;
        boolean isLoggedIn = false;
        String currentUser = "";

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
                        isLoggedIn = true;
                        break;
                    case 2:
                        authController.login(scanner);
                        isLoggedIn = true;
//                        currentUser = "Alice Dupont";
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please enter a valid number.\n");break;
                }
            } else {
                System.out.println("================================");
//                System.out.println("Logged in as: " + Session.getCurrentUser().getName());
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
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
//                        System.out.println("\n--- Action " + choice + " executed for " + Session.getCurrentUser().getName() + " ---\n");
                        break;
                    case 9:
                        System.out.println("\nLogged out successfully.\n");
                        isLoggedIn = false;

                        break;
                    case 0:
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please enter a valid number.\n");
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