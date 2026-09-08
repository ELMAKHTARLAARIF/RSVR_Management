package Controllers;

import Domains.UserDomain;
import Services.AuthService;
import java.util.Scanner;
import java.util.UUID;

public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public void register(Scanner scanner) {
        try {
            System.out.println("\n--- REGISTRATION ---");
            System.out.print("Full Name: ");
            String name = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Phone: ");
            String phone = scanner.nextLine();

            System.out.print("Password (min 8 chars): ");
            String password = scanner.nextLine();


            UUID userId = authService.registerUser(name, email, phone, password);
            System.out.println("Registration successful! Your ID is: " + userId + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }
    public void login(Scanner scanner){
            try {
                System.out.println("\n------Login--------");
                System.out.println("Email: ");
                String email = scanner.nextLine();

                System.out.println("Password: ");
                String password = scanner.nextLine();

                UserDomain user = authService.login( email, password);
                if (user == null) {
                    System.out.println("Invalid credentials,Try Again");
                }else{
                    System.out.println("Login Successfully");
                }

            }  catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            }
    }

}